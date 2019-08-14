package com.example.diary.model.board.dao;

import java.util.List;

import com.example.diary.model.board.dto.BoardDTO;

public interface BoardDAO {
		
	public void create(BoardDTO dto) throws Exception; //글쓰기 
	public int countArticle(
			String search_option, String keyword) throws Exception;
	public List<BoardDTO> listAll(
			String search_option, String keyword,int start, int end) throws Exception;
	public BoardDTO read(int bno) throws Exception;
	public void update(BoardDTO dto) throws Exception; //글수정
	public void delete(int bno) throws Exception; //글삭제
	
}
