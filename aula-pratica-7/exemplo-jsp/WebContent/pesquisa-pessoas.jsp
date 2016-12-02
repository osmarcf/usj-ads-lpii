<%@ page import="java.util.*,br.edu.usj.lpii.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pesquisa Pessoa</title>
</head>
<body>
<%
	List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
%>
<h1>Pesquisa</h1>
<c:forEach var="pessoa" items="${pessoas}">
<c:url var="urlPessoaEditar" value="/pessoa" >
    <c:param name="acao" value="editar" />
    <c:param name="idPessoa" value="${pessoa.id}" />
</c:url>
<c:url var="urlPessoaRemover" value="/pessoa" >
    <c:param name="acao" value="remover" />
    <c:param name="idPessoa" value="${pessoa.id}" />
</c:url>
${pessoa.nome} - ${pessoa.email} <a href="${urlPessoaEditar}">Editar</a> | <a href="${urlPessoaRemover}" onclick="return confirm('Você deseja remover?');">Remover</a><br/>
</c:forEach>
</body>
</html>