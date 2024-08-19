package com.example.spring_security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.spring_security.config.UserInfoUserDetails;
import com.example.spring_security.entity.UserInfo;
import com.example.spring_security.repository.UserInfoRepository;
@Component
public class UserInfoUSerDetailsService implements UserDetailsService {
@Autowired
	private UserInfoRepository userInfoRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo>userInfo=userInfoRepository.findByName(username);
	return userInfo.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("username not found"+username));
		
	}

}
