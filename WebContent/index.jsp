<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'es'}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/language"/>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banco Jones</title>
</head>
<body>
	<%@ include file="menu.html" %>
	<h1>Ejemplo multi-idioma</h1>
	<h2><fmt:message key="welcome"/></h2>
	<form>
		<select  id="language" name="language" onchange="submit()">
			<option value="ca" ${language == 'ca' ? 'selected': '' }>Català</option>
			<option value="es" ${language == 'es' ? 'selected': '' }>Castellano</option>
		</select>
	</form>	
</body>
</html>