<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insertar transacción</title>
<style type="text/css">
	input {
		margin-top:5px;
	}
</style>
</head>
<body>
	<%@ include file="menu.html"%>
	<div>
		<form action="InsertTransactionServlet" method="POST">
			Origen: <input type="text" name="ibanOrig"><br>
			Destino: <input type="text" name="ibanDest"><br>
			Cantidad: <input type="text" name="cantidad"><br>
			<input type="submit" value="Insertar nueva transacción">
		</form>
	</div>
</body>
</html>