<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="javax.xml.ws.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>

	


	<h1>회원등록</h1>
	<form action="../testmember/tadd" method="post">
	이름: <input type='text' name='name'><br/>
	이메일: <input type='text' name='email'><br/>
	암호: <input type='password' name='password'><br/>
	<input type='submit' value='추가'>
	<input type='reset' value='취소'>
	<input type='reset' value='뒤로가기' onclick='<%response.sendRedirect("./index.jsp");%>'>
	</form>
	
	
	
</body>
</html>