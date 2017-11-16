<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Cliente"%>
<%@ page import="beans.Account"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<%-- <script type="text/javascript">
	accounts = "<table class='table'><thead><tr><th>IBAN</th><th>Saldo</th></tr></thead>";
	<%
	String str = "";
	String str2 = "";
	for (Account account : accounts) {
		str = account.getIban();
		str2 = String.valueOf(account.getBalance());
		%>
		iban = <%=str %>;
		 balance = <%=str2 %>;
		accounts += "<tbody><tr><td>" + ${account.getIban()} + "</td><td>" + balance + "</td></tr></tbody>";
		<%
	}
	%>
	accounts += "</table>";
	document.getElementById("accounts").innerHTML = accounts;
</script> --%>
		<h2> Cuentas del usuario <%=c.getNombre() %></h2>
	
	<div class="container" id="accounts">		
	<table class='table'><thead><tr><th>IBAN</th><th>Saldo</th><th></th><th></th></tr></thead>
	<%
		for (Account account : accounts) {
			String iban = account.getIban();
			double balance = account.getBalance();
			%> <tbody><tr><td> <%=iban %> </td><td> <%=balance %></td><td><button onclick="location.href='DeleteAccountsServlet?iban=<%=iban %>'">Eliminar</button><button onclick="location.href='DeleteAccountsServlet?ibanTrans=<%=iban %>'">Transacciones</button></td></tr></tbody> <%
		}
	%>
<%-- 		<c:forEach items="${list}" var="account">	
			<tbody><tr><td> ${account.getIban()} </td><td> ${account.getBalance()}</td></tr></tbody>
		</c:forEach> --%>
	</table>
	</div>
	<form method="POST" action="insertarCuenta.jsp">
		<input type="submit" value="Nueva cuenta">
	</form>
</body>
</html>