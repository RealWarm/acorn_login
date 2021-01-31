package com.acorn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

/****************************************************
 * 컨트롤러 메소드 수행전에, 로그인 여부를 체크
 *
 * 제작자: Yoseph
 * 최종작성일: 2019.09.20                  
 * 
 */
@Log4j
public class AuthInterceptor 
	implements HandlerInterceptor {
	
	private final String loginKey = "login";
	private final String origRequestURIKey = "origDest";

	
	private void saveOriginalRequestURI(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString();
		
		if(queryString == null || queryString.equals("null")) {
			// 쿼리문자열이 없는 경우
			queryString = "";
		} else {
			// 쿼리문자열이 있는 경우
			queryString = "?" + queryString;
		} // if-else
		
		// 최종적인 원래의 Request URI 저장
		String originalRequestURI = 
				requestURI + queryString;
				
		HttpSession session = request.getSession();
		session.setAttribute(
					origRequestURIKey, 
					originalRequestURI
				);
	} // saveOriginalRequestURI
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
		throws Exception { // 컨트롤러 메소드 호출전에 수행
		log.info("AuthInterceptor::preHandle() invoked.");
				
		// 1. 세션 객체를 얻어냄
		HttpSession session = request.getSession();
		
		// 2. loginKey로 세션 영역에 사용자객체(UserVO)가
		//    존재하는지 체크 수행
		if(session.getAttribute(loginKey) == null) {
			log.info("*** Current User NOT logged in ***");
			
			// 2-1. Original Request URI를 보관
			saveOriginalRequestURI(request);
			
			// 3. 리다이렉트를 통해서, 로그인 화면으로 이동시킴
			response.sendRedirect("/user/login");
			
			// 4. 리다이렉트 이후에, 원래 다음 이동을 막아야 함
			return false; 
		} // if : 아직까지 로그인 하지 않았다면.
		
		// 이미 로그인 했다면.....
		
		
		return true;		// Next 이동
	} // preHandle

	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) 
		throws Exception {
		
	} // postHandle

	@Override
	public void afterCompletion(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, Exception ex)
		throws Exception {
		
	} // afterCompletion

	
} // end class
