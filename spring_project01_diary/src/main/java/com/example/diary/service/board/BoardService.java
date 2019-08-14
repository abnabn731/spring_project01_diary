package com.example.diary.service.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.diary.model.board.dto.BoardDTO;


public interface BoardService {

	public void create(BoardDTO dto) throws Exception; //글 쓰기
	public BoardDTO read(int bno) throws Exception; //글 읽기
	public void update(BoardDTO dto) throws Exception; //글 수정
	public void delete(int bno) throws Exception; //글 삭제
	public List<BoardDTO> listAll( // 글 목록
		String search_option, String keyword,int start, int end) throws Exception;	
	public int countArticle( //게시물 개수
		String search_option, String keyword) throws Exception;
	
	
	
	public void deleteFile(String fullName);
	public List<String> getAttach(int bno);
}
