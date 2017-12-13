<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 .loser {
	position: relative;
	margin-top: 10px;
}

input {
	margin-top: 5px;
}
</style>
</head>
<body>
	<%@ include file="menu.html"%>
	<div class="loser">
<!-- 		<form action="LoginServlet" method="POST">
			DNI: <input type="text" placeholder="Introduce tu DNI" name="dni"><br> 
			Password: <input type="password" placeholder="Introduce tu contraseña" name="pass"><br> 
			<input type="submit" value="Validar">
		</form> -->
 		<form action="ControllerServlet" method="POST">
			<input type="hidden" name="action" value="login">
			DNI: <input type="text" placeholder="Introduce tu DNI" name="dni"><br> 
			Password: <input type="password" placeholder="Introduce tu contraseña" name="pass"><br>
			<input type="submit" value="Validar">
		</form>
	</div>	
</body>
</html>