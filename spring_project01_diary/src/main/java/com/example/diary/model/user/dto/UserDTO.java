package com.example.diary.model.user.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDTO extends User { //스프링 시큐리티 내장객체 , 사용자 상세정보를 담음					
	
	private String userid; // userid 변수 선언
	
	//UserDTO의 생성자 ( 자동생성 기능 사용 )
	//자동생성한 생성자 파라미터에 userid 추가
	public UserDTO(String username, String password, 
			boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, 
			boolean accountNonLocked, 
			Collection<? extends GrantedAuthority> authorities,
			String userid) { //파라미터에 userid 추가
		super(username, password, enabled, accountNonExpired
				, credentialsNonExpired, accountNonLocked
				, authorities);
		
		this.userid = userid;

	}
	
	//getter/setter/toString
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + "]";
	}

}