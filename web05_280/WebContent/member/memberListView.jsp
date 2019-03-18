<%@page import="java.util.ArrayList"%>
<%@page import="com.tg.member.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<jsp:include page="/header.jsp"/>
	<h1>회원목록</h1>
	<div>
		<a href="./add">신규 회원</a>
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
	<a href='./update?mNo=<%=memberDto.getNo()%>'><%=memberDto.getName()%></a>,
	<%=memberDto.getEmail()%>,
	<%=memberDto.getCreateDate()%>
	<a href='./delete?mNo=<%=memberDto.getNo()%>'>[삭제]</a>
	<br>
	
	<%
		}
	%>
	
	<jsp:include page="/Tail.jsp"/>
	

</body>
</html>