<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<c:if test="${not empty empresa }">
			Empresa ${ empresa.nome } <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> cadastrada
		</c:if>
		<c:if test="${empty empresa }">
			Nenhuma empresa cadastrada
		</c:if>
		<br />
		<br />
		<c:forEach var="i" begin="1" end="10" step="2">
			${i} <br />
		</c:forEach>
	</body>
</html>