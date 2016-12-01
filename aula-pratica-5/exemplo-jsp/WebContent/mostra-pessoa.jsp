<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="br.edu.usj.lpii.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pessoa</title>
</head>
<body>
<%
	Pessoa p = new Pessoa();
	p.setNome("Osmar");
	p.setEmail("osmarcf.usj@gmail.com");
	out.print(p.getNome() + " - " + p.getEmail());
%>
</body>
</html>