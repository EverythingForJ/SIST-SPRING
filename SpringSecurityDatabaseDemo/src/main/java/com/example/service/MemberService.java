package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.vo.UserRolesVO;
import com.example.vo.UserVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Setter
@Slf4j
public class MemberService implements UserDetailsService {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRolesService userRolesService;

	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		UserVO userVo = this.userService.getUserByID(userid);
		if (userVo == null)
			throw new UsernameNotFoundException("No user found with username " + userVo.getUserid());
		List<UserRolesVO> list = this.userRolesService.selectRoles(userid);
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		for(UserRolesVO userRolesVo : list)
			roles.add(new SimpleGrantedAuthority(userRolesVo.getRole()));
		UserDetails user = new User(userid, userVo.getPasswd(), roles);
		return user;
	}
}
