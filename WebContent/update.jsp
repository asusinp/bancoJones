<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="beans.Cliente"%>
<%
Cliente c = null;
String name = null;
String dni = null;
String surname = null;
// String password = null;
String sex = null;
String address = null;
String phone = null;
String sessionID = null;
String birthday = null;
if (session.getAttribute("clientSession") == null) {
	response.sendRedirect("jones.jsp");
} else {
	c = (Cliente)session.getAttribute("clientSession");
	name = c.getNombre();
	dni = c.getDni();
	surname = c.getApellidos();
// 	password = c.getContraseña();
	sex = c.getSexo();
	address = c.getDireccion();
	System.out.println(surname + " <<<< apellido");
	phone = c.getTelefono();
	birthday = c.getFechaNacimiento();
}
/* Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("JSESSIONID") ) {
			sessionID = cookie.getValue();
		}
	}
} else {
	sessionID = "No hay cookies";
} */
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {
		margin-top:5px;
	}
</style>
</head>
<!-- <script type="text/javascript"> -->
<!--  function hideOrShowPassword(){  -->
<!--      checkbox = document.getElementById("checkbox"); -->
<!--      passField = document.getElementById("password"); -->
<!--      if(checkbox.checked == true) { -->
<!--          passField.type = "text"; -->
<!--      } else { -->
<!--          passField.type = "password" -->
<!--      } -->
<!--  } -->
<!-- </script> -->
<body>
	<%@ include file="menu.html"%>
	<div>
		<form action="UpdateServlet" method="POST">
			Nombre: <input type="text" placeholder="Introduce tu nombre" name="nameUpd" value='<%=name%>'><br>
			Apellidos: <input type="text" placeholder="Introduce tus apellidos" name="surnameUpd" value='<%=c.getApellidos()%>'><br>
			DNI: <input type="text" placeholder="Introduce tu DNI" name="dniUpd" value='<%= dni %>'><br>
<%-- 			Contraseña: <input type="text" id="password" placeholder="Introduce tu contraseña" name="passUpd" value='<%=password%>'><br> --%>
<!-- 			Mostrar contraseña: <input type="checkbox" id="checkbox" value="Car" onclick="hideOrShowPassword()"><br> -->
			Fecha de nacimiento: <input type="text" placeholder="Introduce tu fecha de nacimiento" name="birthdayUpd" value='<%=birthday%>'><br>
			Sexo: <input type="text" placeholder="h = hombre, m = mujer" name="sexUpd" value='<%=sex%>'><br>
			Dirección: <input type="text" placeholder="Introduce tu dirección" name="addressUpd" value='<%=address%>'><br>
			Telefono: <input type="text" placeholder="Introduce tu telefono" name="phoneUpd" value='<%=phone%>'><br>
			<input type="submit" value="Modificar datos">
		</form>
	</div>
</body>
</html>