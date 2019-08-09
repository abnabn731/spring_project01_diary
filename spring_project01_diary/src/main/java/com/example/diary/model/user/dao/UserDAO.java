package com.example.diary.model.user.dao;

import java.util.Map;

public interface UserDAO {
	//회원가입 처리
	public int insertUser(Map<String,String> map);
	//로그인 처리
	public Map<String,Object> selectUser(String userid);
}