<%@ page import="br.edu.usj.lpii.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastra Pessoa</title>
</head>
<body>
<%
	Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
%>
<form action="pessoa" method="post">
<input type="hidden" name="acao" value="atualizar" />
<input type="hidden" name="idPessoa" value="<%= pessoa.getId() %>" />
Nome: <input type="text" id="nome" name="nome" value="<%= pessoa.getNome() %>" /><br/>
E-mail: <input type="text" id="email" name="email" value="<%= pessoa.getEmail() %>" /><br/>
<input type="submit"/>
</form>

</body>
</html>