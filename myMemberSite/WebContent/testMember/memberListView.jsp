<%@page import="java.util.ArrayList"%>
<%@page import="com.tg.member.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Go To DMC</title>
</head>
<body>

	<h1>아프리카 원주민의 쓰라린 추위</h1>
	<div>
		<a href="../testmember/tadd">신규 회원</a>
	</div>
	<br/>
	<%
		ArrayList<MemberDto> memberList = 
								//전 화면의 req에서 setAttribute한 데이터
			(ArrayList<MemberDto>)request.getAttribute("memberList");
	
							//memberList의 크기반영
		for(MemberDto memberDto : memberList){
	
	%>
	
	<%=memberDto.getNo()%>,
	<a href='./update?no=<%=memberDto.getNo()%>'><%=memberDto.getName()%></a>,
	<%=memberDto.getEmail()%>,
	<%=memberDto.getPassword()%>,
	<%=memberDto.getCreateDate()%>
	
	<a href='./delete?no=<%=memberDto.getNo()%>'>[삭제]</a>
	<br>
	
	<%
		}
	%>
	

</body>
</html>