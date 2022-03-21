<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServlet"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<form action="${linkServlet}" method="post">
		<input type="hidden" value="${empresa.id}" name="id" readonly="readonly">
		<input type="hidden" value="AlteraEmpresa" name="acao" readonly="readonly">
			Nome <input type="text" value="${empresa.nome}" name="nome">
			CNPJ <input type="text" value="${empresa.cnpj}" name="cnpj">
    		data abertura <input name="dataAbertura" type="text" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
    	<input type="submit" />
	</form>
</body>
</html>