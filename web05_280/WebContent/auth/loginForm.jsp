<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">



function loginSubmitFnc() {
	var formObj = document.getElementById('loginForm');
	formObj.submit();
}




</script>


<title>로그인</title>
</head>
<body>
	<h2>사용자 로그인</h2>
	<form action = "./login" id="loginForm" method="post">
		이메일 : <input type ="text" name ="email"><br>
		암호 : <input type ="text" name ="password"><br>
		  <input type ="button" value ="로그인" onclick="loginSubmitFnc()"><br>
	</form>
</body>
</html>