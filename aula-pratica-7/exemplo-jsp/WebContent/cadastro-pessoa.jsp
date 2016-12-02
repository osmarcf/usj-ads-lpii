<%@ page import="br.edu.usj.lpii.*" %>
<%
	Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><% if (pessoa == null) out.print("Cadastra"); else out.print("Edita"); %> Pessoa</title>
</head>
<body>
<h1>Cadastro</h1>
<form action="pessoa" method="post">
<input type="hidden" name="acao" value="<% if (pessoa == null) out.print("cadastrar"); else out.print("atualizar"); %>" />
<input type="hidden" name="idPessoa" value="${pessoa.id}" />
Nome: <input type="text" id="nome" name="nome" value="${pessoa.nome}" /><br/>
E-mail: <input type="text" id="email" name="email" value="${pessoa.email}" /><br/>
<input type="submit"/>
</form>
</body>
</html>