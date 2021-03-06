package com.example.diary.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.diary.model.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject SqlSession sqlSession;
	
	@Override
	public void create(BoardDTO dto) throws Exception {
		
		sqlSession.insert("board.insert", dto); 

	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("board.countArticle",map);
	
	}

	@Override
	public List<BoardDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {

		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		// mapper에는 2개 이상의 값을 전달할 수 없으므로 map 사용	
		return sqlSession.selectList("board.listAll",map);
		
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		
		return sqlSession.selectOne("board.read", bno);
	
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		
		sqlSession.update("board.update", dto);
	
	}

	@Override
	public void delete(int bno) throws Exception {
		
		sqlSession.delete("board.delete", bno); 
		
	}

}
