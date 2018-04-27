<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de pessoa</title>
</head>
<body>
	
	<h1>Cadastro de pessoa</h1>
	
	<form action="PessoaServlet" method="post">
		
		<div>
			<label>Nome: </label>
			<input name="nome">
		</div>
		
		<div>
			<label>Sobrenome: </label>
			<input name="sobrenome">
		</div>
		
		<div>
			<label>Nascimento: </label>
			<input name="dataNascimento" type="date">
		</div>
		
		<div>
			<button type="submit">Salvar</button>
		</div>
	
	</form>

</body>
</html>