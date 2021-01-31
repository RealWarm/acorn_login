package com.acorn.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.acorn.domain.LoginDTO;
import com.acorn.domain.UserVO;

import lombok.extern.log4j.Log4j;


@Log4j
@RunWith(SpringRunner.class)
@ContextConfiguration(
	locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"	
	}
)
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	
	
	@Before
	public void setup() {
		log.info("UserServiceTest::setup() invoked.");
		
		;;
	} // setup
	
	@After
	public void tearDown() {
		log.info("UserServiceTest::tearDown() invoked.");
		
		;;
	} // tearDown
	
	@Test 
	public void testUserService() 
		throws Exception {
		log.info("UserServiceTest::testUserService() invoked.");
		log.info("\t+ service: "+ service);
		
		// UserService Test 수행
		LoginDTO dto = new LoginDTO("user00", "user00", false);
		
		UserVO vo = service.checkLogin(dto); 
		if(vo != null) {  // 로그인 성공
			log.info("\t+ Found user: "+vo);
		} else {
			log.info("\t+ No user found.");
		} // if-else
		
	} // testUserDAO

} // end class
