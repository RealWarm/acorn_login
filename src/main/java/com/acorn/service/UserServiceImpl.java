package com.acorn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.domain.LoginDTO;
import com.acorn.domain.UserVO;
import com.acorn.persistence.UserDAO;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class UserServiceImpl 
	implements UserService {
	
	@Autowired
	private UserDAO dao;
	
	
	@Override
	public UserVO checkLogin(LoginDTO dto) 
		throws Exception {
		log.info("UserService::checkLogin(dto) invoked.");
		log.info("\t+ dao: " + dao);
		
		// 비지니스로 로직 : 사용자 로그인 성공여부 확인
		UserVO vo = dao.login(dto);
		
		if(vo != null) {  // 로그인 성공
			log.info("\t+ Found user: "+vo);
		} else {
			log.info("\t+ No user found.");
		} // if-else
		
		return vo;
	} // checkLogin

} // end class
