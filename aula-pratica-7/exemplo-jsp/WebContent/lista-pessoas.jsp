<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pessoas</title>
</head>
<body>
<h1>Cadastro</h1>
<a href="cadastro-pessoa.jsp">Cadastrar nova pessoa</a>
<h1>Pesquisa</h1>
<form action="pessoa" method="post">
<input type="hidden" name="acao" value="pesquisar" />
Nome: <input type="text" id="nome" name="nome"/><br/>
E-mail: <input type="text" id="email" name="email"/><br/>
<input type="submit"/>
</form>
<h1>Lista</h1>
<jsp:useBean id="pessoas" class="br.edu.usj.lpii.PessoasDAO"/>
<c:forEach var="pessoa" items="${pessoas.lista}">
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