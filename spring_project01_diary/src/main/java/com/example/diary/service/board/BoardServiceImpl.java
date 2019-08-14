package com.example.diary.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.diary.model.board.dao.BoardDAO;
import com.example.diary.model.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject BoardDAO boardDao;
	
	@Override
	public void create(BoardDTO dto) throws Exception {
		boardDao.create(dto); 	
	}
	
	@Override
	public int countArticle(String search_option, String keyword) throws Exception {

		return boardDao.countArticle(search_option,keyword); 
		
	}
	
	@Override
	public List<BoardDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		
		return boardDao.listAll(search_option,keyword,start,end);
	
	}
	
	@Override
	public BoardDTO read(int bno) throws Exception {
		
		return boardDao.read(bno);
	}
	

	@Override
	public void update(BoardDTO dto) throws Exception {
		
		boardDao.update(dto); //board 테이블 수정
		
	}

	@Override
	public void delete(int bno) throws Exception {
		
		boardDao.delete(bno); 
	}




	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public List<String> getAttach(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

}
