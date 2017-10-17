<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.html"%>
	<div>
		<form action="UpdateServlet" method="POST">
			Nombre: <input type="text" placeholder="Introduce tu nombre" name="nameUpd"><br>
			Apellidos: <input type="text" placeholder="Introduce tus apellidos" name="surnameUpd"><br>
			DNI: <input type="text" placeholder="Introduce tu DNI" name="dniUpd"><br>
			Contraseña: <input type="text" id="password" placeholder="Introduce tu contraseña" name="passUpd"><br>
			<!-- Mostrar contraseña:  --><!-- <input type="checkbox" id="checkbox" value="Car" onclick="hideOrShowPassword()"><br> -->
			Fecha de nacimiento: <input type="text" placeholder="Introduce tu fecha de nacimiento" name="birthdayUpd"><br>
			Sexo: <input type="text" placeholder="h = hombre, m = mujer" name="sexUpd"><br> 
			Dirección: <input type="text" placeholder="Introduce tu dirección" name="addressUpd"><br>
			Telefono: <input type="text" placeholder="Introduce tu telefono" name="phoneUpd"><br>		
			<input type="submit" value="Modificar datos">
		</form>
	</div>
</body>
</html>