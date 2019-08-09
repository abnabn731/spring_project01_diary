package com.example.diary.service.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.diary.model.user.dto.UserDTO;
//로그인 처리 클래스
@Service
public class UserAuthenticationService implements UserDetailsService { //스프링 시큐리티 내장클래스 상속

	private SqlSessionTemplate sqlSession;
	public UserAuthenticationService() { 	}
	public UserAuthenticationService(
			SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	//비밀번호 체크는 코드로 보이지 않아도 
	//이 메서드가 실행될 때 스프링 시큐리티에서 알아서 처리함
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		//사용자 아이디 확인
		Map<String,Object> user=sqlSession.selectOne(
				"user.selectUser", userid);//파라미터로 넘어온 값
		
		//아이디가 없으면 예외 발생시킴 (throw)
		if(user==null) throw new UsernameNotFoundException(userid);

		//사용권한 목록
		List<GrantedAuthority> authority=new ArrayList<>();
		
		//Oracle DB의 경우 자바코드에서 테이블 필드명을 쓸 땐 대문자로 써야하는데 MySQL은 가져온 case 그대로 써야하는것 같다.
		//case 신경안쓰면 에러남
		authority.add(new SimpleGrantedAuthority(
				user.get("authority").toString())); 
		
		return new UserDTO(user.get("username").toString(),
				user.get("password").toString(),		
				(Integer)Integer.valueOf(user.get("enabled").toString())==1,
				true,true,true,authority,
				user.get("username").toString()); 
	}

}
