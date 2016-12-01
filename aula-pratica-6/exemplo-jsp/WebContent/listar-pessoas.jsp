<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.usj.lpii.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pessoas</title>
</head>
<body>
<h1>Cadastro</h1>
<a href="formulario.html">Cadastrar nova pessoa</a>
<br/>
<h1>Lista</h1>
<%
List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");

for (Pessoa p : pessoas) {
	out.print(p.getId() + " - ");
	out.print(p.getNome() + " - ");
	out.print(p.getEmail());
	out.print(" <a href=\"pessoa?acao=editar&idPessoa=" + p.getId() + "\">Editar</a> | ");
	out.print(" <a href=\"pessoa?acao=remover&idPessoa=" + p.getId() + "\" onclick=\"return confirm('Você deseja remover?');\">Remover</a>");
	out.println("<br/>");
}
%>
</body>
</html>