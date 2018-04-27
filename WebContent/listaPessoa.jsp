<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de pessoas</title>
</head>
<body>
	
	<h1>Lista de pessoas</h1>
	
	<table>
		<tr>
			<td>Nome</td>
			<td>Sobrenome</td>
			<td>Data Nascimento</td>
		</tr>
	
		<c:forEach items="${listaPessoas}" var="pessoa">
			<tr>
				<td><c:out value="${pessoa.nome }" /></td>
				<td><c:out value="${pessoa.sobrenome }" /></td>
				<td>${pessoa.dataNascimento}</td>
			</tr>
		
		</c:forEach>
	</table>

</body>
</html>