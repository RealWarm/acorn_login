package com.acorn.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.acorn.domain.LoginDTO;
import com.acorn.domain.UserVO;

import lombok.extern.log4j.Log4j;


@Log4j
@Repository
public class UserDAOImpl 
	implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String namespace = "com.acorn.mapper.UserMapper";
	private final String sqlId = "login";

	
	@Override
	public UserVO login(LoginDTO dto) 
		throws Exception {
		
		log.info("UserDAO::login(dto) invoked.");
		log.info("\t+ sqlSession: "+sqlSession);
		
		UserVO vo = sqlSession.<UserVO>selectOne(
						namespace+"."+sqlId, dto
					);
				
		return vo;
	} // login

} // end class



