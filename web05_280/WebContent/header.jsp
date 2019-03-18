<%@page import="com.tg.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    
    MemberDto memberDto = (MemberDto)session.getAttribute("member");
    
    %>
    
    
<div style="background-color: #f0fff0; height: 20px; padding: 5px; margin-top: 10px;">
	
	 JYP(Jin-Young Park)의 신규 아티스트를 모집합니다.
	<span style="float:right;">
		<%=memberDto.getName()%>
		<a href="<%=request.getContextPath() %>/auth/Logout" style="color:red;">
		
		로그아웃
		</a>
	
	
	</span>



  
    
    
    </div>