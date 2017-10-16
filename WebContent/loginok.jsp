<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Cliente" %>
<%
Cliente c = null;
String user = null;
String dni = null;
if (session.getAttribute("clientSession") == null) {
	response.sendRedirect("jones.jsp");
} else {
	c = (Cliente)session.getAttribute("clientSession");
	user = c.getNombre();
	dni = c.getDni();
}
%>
<h3>hola <%=user %>, con dni <%=dni %></h3>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	ok, eres un grande de la programacion
	
</body>
</html>