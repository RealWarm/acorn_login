<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>로그인 하세요!!!</title>
</head>
<body>
	<!-- if context path exists, 
	     action must include context-path -->
	<form method="post" action="/user/loginPost">
		1. 아이디: <input type="text" name="uid" placeholder="아이디입력"><br>
		2. 암호: <input type="password" name="upw"><br>
		3. Remember-me: <input type="checkbox" name="useCookie"><br>
		
		<hr/>
		
		<button type="submit">로그인</button>
		<button type="submit">회원가입</button>		
	</form>
</body>
</html>