<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletNovaEmpresa" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<form action="${linkServletNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome" />
		
		cnpj: <input type="text" name="cnpj" />
		
		data abertura: <input type="text" name="dataAbertura" />
		<input type="hidden" value="NovaEmpresa" name="acao" readonly="readonly">
		<input type="submit" />
		
	</form>
	
</body>
</html>