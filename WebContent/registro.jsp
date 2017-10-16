<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banco Jones - Registro de usuarios</title>
<style type="text/css">
	input {
		margin-top:5px;
	}
</style>
</head>
<body>
<script type="text/javascript">
function hideOrShowPassword(){ 
    checkbox = document.getElementById("checkbox");
    passField = document.getElementById("password");
    if(checkbox.checked == true) {
        passField.type = "text";
    } else {
        passField.type = "password"
    }
}
</script>


	<%@ include file="menu.html"%>
	<div>
		<form action="RegisterServlet" method="POST">
			Nombre: <input type="text" placeholder="Introduce tu nombre" name="nameReg"><br>
			Apellidos: <input type="text" placeholder="Introduce tus apellidos" name="surnameReg"><br>
			DNI: <input type="text" placeholder="Introduce tu DNI" name="dniReg"><br>
			Contraseña: <input type="text" id="password" placeholder="Introduce tu contraseña" name="passReg"><br>
			<!-- Mostrar contraseña:  --><!-- <input type="checkbox" id="checkbox" value="Car" onclick="hideOrShowPassword()"><br> -->
			Fecha de nacimiento: <input type="text" placeholder="Introduce tu fecha de nacimiento" name="birthdayReg"><br>
			Sexo: <input type="text" placeholder="h = hombre, m = mujer" name="sexReg"><br> 
			Dirección: <input type="text" placeholder="Introduce tu dirección" name="addressReg"><br>
			Telefono: <input type="text" placeholder="Introduce tu telefono" name="phoneReg"><br>			
			<input type="submit" value="Registrarse">
		</form>
	</div>
</body>
</html>



<!-- Confirma tu contraseña: <input type="password" placeholder="Introduce de nuevo tu contraseña" name="pass2Reg"><br> -->
