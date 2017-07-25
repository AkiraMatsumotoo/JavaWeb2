<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Login</title>
</head>
<body>
	<div align="center">
		<form action="usuValidaLogin" method="post">
			<table>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" autofocus="" required="" /></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="text" name="senha" required="" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Entrar" /></td>
					<td><c:if test="${messagem!=null}">
						${messagem}
					</c:if></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>