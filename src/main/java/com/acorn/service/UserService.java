package com.acorn.service;

import com.acorn.domain.LoginDTO;
import com.acorn.domain.UserVO;



public interface UserService {
	
	public abstract UserVO checkLogin(LoginDTO dto) throws Exception;

} // end class
