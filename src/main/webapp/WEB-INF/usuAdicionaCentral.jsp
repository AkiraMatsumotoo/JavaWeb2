<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adiciona</title>
</head>
<body>
	<form action="UsuarioController" method="get">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="0" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome" autofocus=""></td>
			</tr>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login"></td>
			</tr>
			<tr>
				<td>Senha</td>
				<td><input type="text" name="senha"></td>
			</tr>
			<tr>
				<td>Nivel</td>
				<td><input type="text" name="nivel"></td>
			</tr>
			<tr>
				<td><input type="submit" name="acao" value="salvar"></td>
				<td><a href="${pageContext.request.contextPath}/UsuarioController">Cancelar</a></td>
			</tr>
		</table>
	</form>
</body>
</html>