<%@page import="java.util.*"%>
<html>
<%
ArrayList<Integer> numeros = new ArrayList<Integer>();
for (int i = 0; i < 6; i++) {
	int numero = (int) (Math.random() * 100) % 60 ;
	numeros.add(numero);
}

out.print("numeros: ");
for (int i = 0; i < 6; i++) {
	out.println(numeros.get(i));
}
%>
</html>