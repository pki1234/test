<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="com.tg.member.MemberDto"%>    
<%@page import="java.util.Date"%>

<%!

	void del(){
	
	
	
	}



%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	

	<%
		MemberDto memberList = (MemberDto)request.getAttribute("memberList");
	
	%>

	<h1>회원 정보 수정</h1>
	<form action="./update" method="post">
<%-- 	번호: <input type='text' name='mNo' value=<%=%>><br/> --%>
	번호: <input type='text' name='mNo' value=<%=memberList.getNo()%> readonly/><br/>
	이름: <input type='text' name='name' value=<%=memberList.getName()%>><br/>
	이메일: <input type='text' name='email' value=<%=memberList.getEmail()%>><br/>
	가입일:<%=memberList.getCreateDate()%><br/>
	<input type='submit' value='변경'>
	<input type='reset' value='취소'>
	<a href='./delete?mNo=<%=memberList.getNo()%>'>[삭제]</a>
	<input type='reset' value='뒤로가기' onclick='location.href=\"./list\"'>
	</form>
	
</body>
</html>