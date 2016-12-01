<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.usj.lpii.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Pessoas</title>
</head>
<body>
<%
List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");

for (Pessoa p : pessoas) {
	out.print(p.getNome() + " - ");
	out.print(p.getEmail());
	out.println("<br/>");
}
%>
</body>
</html>