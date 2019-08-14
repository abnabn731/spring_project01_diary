package com.example.diary.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.diary.model.board.dto.BoardDTO;
import com.example.diary.service.board.BoardService;
import com.example.diary.service.board.Pager;

@Controller
// servlet-context에서 view resolver 
// /WEB-INF/views/ ~ .jsp 설정하고 bean 등록해놓음
@RequestMapping("board/*")
public class BoardController {

	
	@Inject BoardService boardService;
	
	//글쓰기 폼으로 포워딩 
	//글 등록 (dao : 글 삽입 )
	//글 읽기 (dao : 글 하나 불러오기)
	//글 수정 (dao : 글 하나 불러오기)
	//글 삭제 (dao : 삭제 )
	//글 목록  (dao : 리스트)
	
	//이미지 첨부는 나중에
	
	//글쓰기 폼으로 포워딩 
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}
	

	
	
	//글 등록 (dao : 글 삽입 )
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardDTO dto, HttpSession session)
		throws Exception {
		// 시큐리티컨텍스트홀더 객체에서 사용자아이디를 가져옴★
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		
		String id = userDetails.getUsername();

		dto.setId(id); 
		//레코드 저장
		boardService.create(dto);
		//게시물 목록으로 이동
		return "redirect:/board/list.do";
	}	
	
	//글 목록  (dao : 리스트)
	@RequestMapping("list.do") 
	public ModelAndView list(
		@RequestParam(defaultValue="") String search_option,
		@RequestParam(defaultValue="") String keyword,
		@RequestParam(defaultValue="1") int curPage) throws Exception{
		//레코드 개수
		int count= boardService.countArticle(search_option,keyword);
		//페이지 관련 설정
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<BoardDTO> list= //게시물 목록 가져오기
		boardService.listAll(search_option,keyword,start,end); 
		ModelAndView mav=new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); //map에 자료 저장
		map.put("count", count);
		map.put("pager", pager); //페이지 네비게이션을 위한 변수
		map.put("search_option", search_option);
		map.put("keyword",keyword); 
		mav.setViewName("board/list"); //포워딩할 뷰의 이름
		mav.addObject("map", map); //ModelAndView에 map을 저장
		return mav; // board/list.jsp로 이동
	}
	
	//글 읽기
	@RequestMapping("view.do")
	public ModelAndView view(int bno)
		throws Exception {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("dto", boardService.read(bno)); 
		
		return mav; //  views/board/view.jsp로 넘어가서 출력
		
	} 
	
	
	//글수정 폼으로 포워딩 
	@RequestMapping("rewrite.do")
	public ModelAndView rewrite(int bno)
		throws Exception {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/rewrite");
		mav.addObject("dto", boardService.read(bno)); 
		
		return mav; 
		
	} 
	
	
	//글 수정
	@RequestMapping("update.do")
	public String update(BoardDTO dto) throws Exception {

		System.out.println("dto:"+dto);
		if(dto != null) {
			boardService.update(dto); //레코드 수정
		}
		return "redirect:/board/view.do?bno="+dto.getBno();
	}
		
		
	//글 삭제 (dao : 삭제 )
	@RequestMapping("delete.do")
	public String delete(int bno) throws Exception {
		
		boardService.delete(bno); //삭제 처리
		return "redirect:/board/list.do"; //목록으로 이동
	
	}
	
}
