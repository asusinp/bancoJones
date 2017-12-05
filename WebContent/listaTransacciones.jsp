<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Cliente"%>
<%@ page import="beans.Account"%>
<%@ page import="beans.Transaccion"%>
<%@ page import="DAO.TransaccionesDAO"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String iban = (String) request.getParameter("account");	
	List<Transaccion> listTransactions = TransaccionesDAO.listaTransacciones(iban);
	System.out.println(listTransactions.size());
	String spageid=request.getParameter("page")==null?"1":request.getParameter("page");
	int size = 10;
	int pagina = Integer.parseInt(spageid);	
	int ini = pagina==1?pagina-1:(pagina-1)*size;;
	int fin = pagina*size;
	List<Transaccion> sublist = null;	
	int maxPage = listTransactions.size()/size;
	if (listTransactions.size()%size != 0) {
		maxPage++;
	}
	if (pagina != maxPage) {
		sublist = listTransactions.subList(ini, fin);	
	} else {		
		sublist = listTransactions.subList(ini, listTransactions.size());
	}
			
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Transacciones</h2>
	<div>		
	<table><thead><tr><th>ID</th><th>Fecha</th><th>Cantidad</th><th>Origen</th><th>Destino</th></tr></thead>
	<%
		for (Transaccion t : sublist) {
			long id = t.getId();
			String date = t.getDate();
			double amount = t.getAmount();
			String origin = t.getOrigin();
			String destination = t.getDestination();			
			%> <tbody><tr><td><%=id %> </td><td><%=date %></td><td><%=amount %></td><td><%=origin %></td><td><%=destination %></td></tr></tbody> <%
		}
	%>
	</table>
	</div>
	<form method="POST" action="insertarTransaccion.jsp">
		<input type="submit" value="Nueva transacción">
	</form>
	<%
		for (int i = 1; i <= maxPage; i++) {
	        %>
	        	<a href="listaTransacciones.jsp?account=<%=iban %>&page=<%=i%>"><%=i%></a>
	        <%
		}
	%>
</body>
</html>