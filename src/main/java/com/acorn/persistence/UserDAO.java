package com.acorn.persistence;

import com.acorn.domain.LoginDTO;
import com.acorn.domain.UserVO;


public interface UserDAO {
	
	public abstract UserVO login(LoginDTO dto) throws Exception;

} // end interface
