package com.acorn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acorn.domain.LoginDTO;
import com.acorn.domain.UserVO;
import com.acorn.service.UserService;

import lombok.extern.log4j.Log4j;


@Log4j
@RequestMapping("/user/*")
@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("login")		/* RequestURI: /user/login.jsp   */
	public void loginGet(@ModelAttribute("dto") LoginDTO dto) 
		throws Exception {
		log.info("UserController::loginGet() invoked.");
		
	} // loginGet
	
	//-----------------------------------------//
	
	@PostMapping("loginPost")
	public void loginPost(LoginDTO dto, Model model) 
		throws Exception {
		log.info("UserController::loginPost() invoked.");
		
		// 비지니스 로직 : 로그인 처리
		UserVO vo = service.checkLogin(dto);
		if(vo == null) { // 로그인 실패
			return;
		} // if
		
		// 로그인에 성공했다면, 찾아낸 사용자 정보를 View로 전달
		model.addAttribute("userVO", vo);
		
		// 로그인에 성공시, 어디로 화면을 이동시킬까!!!
	} // loginPost
	
	
	@GetMapping("/main")
	public void main() {
		;; // 메인 화면으로 GoGo!!
	} // main
	

} // end class
