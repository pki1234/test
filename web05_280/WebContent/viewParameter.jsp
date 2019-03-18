<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>    
<%@ page import="java.util.Map"%>
 
<%
	request.setCharacterEncoding("utf-8");
%> 
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과값 받아오기</title>
</head>
<body>
<b>reqest.getParameter()메서드 사용</b><br>

name 파라미터 =<%=request.getParameter("name") %><br>
address 파라미터 =<%=request.getParameter("address") %><br>
<p>
<b>reqest.getParameterValues()메서드 사용</b><br>
<%
	String[] values = request.getParameterValues("pet");
	if(values!=null){
		for(int i=0; i<values.length; i++){
%>

<%= values[i]%>
<%
	}
	}
%>

<p>
<b>reqest.getParameterNames()메서드 사용</b><br>
	<%
	Enumeration paramEnem= request.getParameterNames();
	while(paramEnem.hasMoreElements()){
		String name = (String)paramEnem.nextElement();
	%>
	<%=name %>
	<%
		}
	%>
<p>
<b>reqest.getParameterMap()메서드 사용</b><br>
	<%
		Map paramterMap = request.getParameterMap();
		String[] nameParan=(String[])paramterMap.get("name");
		if(nameParan !=null){
	%>
	name=<%= nameParan[0] %>
	<%
		}
	%>

</body>
</html>