package com.example.diary.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.diary.model.user.dao.UserDAO;
import com.example.diary.service.security.ShaEncoder;

@Controller 
public class UserController {

	@Inject
	ShaEncoder shaEncoder; 
	//service.security에 만든 암호화 클래스 빈
	
	@Inject
	UserDAO userDao; 
	
	@RequestMapping("/") //시작 페이지 (로그인 사용자로 접근제한 -> 시작페이지는 로그인 페이지("user/login")인 셈)
	public String home(Model model) {
		return "home"; //home.jsp로 이동
	}
	
	//로그인 페이지로 이동
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";
	}
	//회원가입 페이지로 이동
	@RequestMapping("/user/join.do")
	public String join() {
		return "user/join";
	}
	//회원가입 처리 	
	@RequestMapping("/user/insertUser.do")
	public String insertUser(@RequestParam String userid, 
			@RequestParam String passwd,
			@RequestParam String name, 
			@RequestParam String authority) {
		//비밀번호 암호화
		String dbpw=shaEncoder.saltEncoding(passwd, userid);
		Map<String,String> map=new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", dbpw);
		map.put("name", name);
		map.put("authority", authority);
		userDao.insertUser(map);
		return "user/login"; // login.jsp로 이동
	}
	//관리자 영역 페이지	
	@RequestMapping("/admin/")
	public String admin() {
		return "admin/main";
	}
	
	//로그아웃
	@RequestMapping("/user/logout.do") //로그아웃 처리
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}