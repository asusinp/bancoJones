<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Cliente"%>
<%@ page import="beans.Account"%>
<%@ page import="java.util.List"%>
<%
	Cliente c = null;
	String sessionID = null;
	List<Account> accounts = null;
	//String address = null;
	if (session.getAttribute("clientSession") == null) {
		response.sendRedirect("jones.jsp");
	} else {
		c = (Cliente) session.getAttribute("clientSession");
		accounts = c.getAccounts();
	}
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("JSESSIONID")) {
				sessionID = cookie.getValue();
			}
		}
	} else {
		sessionID = "No hay cookies";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${accounts}" var="item">
    	document.write(item.)
	</c:forEach>
	<div class="container" id="accounts">
		<h2>
			Cuentas del usuario
			<%=c.getNombre() %></h2>
		<table class="table">
			<thead>
				<tr>
					<th>IBAN</th>
					<th>Saldo</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=c.getAccounts().get(0).iban %></td>
					<td><%=c.getAccounts().get(0).balance %></td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td><%=c.getAccounts().get(1).iban %></td>
					<td><%=c.getAccounts().get(1).balance %></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>