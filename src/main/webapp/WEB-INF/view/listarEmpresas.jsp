<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	
//List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
//empresas.sort(Comparator.comparing(Empresa::getCnpj));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	
	<br>
	<c:if test="${not empty empresa }">
			Empresa ${ empresa.nome } <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> cadastrada
	</c:if>
	<c:import url="logout-parcial.jsp" />
	<br />
	usuario logado:  ${usuarioLogado.login }
	<br />
	Empresas
	
	<ul>
		<a href="entrada?acao=NovaEmpresaForm">Adicionar empresa</a>
		<br />
		
		<br />
		<c:forEach items="${empresas}" var="empresa">
			
			<li>
			 ${empresa.nome } 
			 <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			 <a href="entrada?acao=MostraEmpresa&id=${empresa.id}">
			 	editar
			 </a>
			 <a href="entrada?acao=RemoveEmpresa&id=${empresa.id}">excluir</a>
			</li>
		</c:forEach>
	</ul>
	
	
	
</body>
</html>