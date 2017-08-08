<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagsAkira"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tagsAkira:verificaUsuario />
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Usuarios central</title>
</head>
<body>


	<form action="BairroController" method="get">
		<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="bairro_id" value="${bairroBuscado.bairro_id}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Descricao</td>
					<td><input type="text" name="bairro_descricao" value="${bairroBuscado.bairro_descricao}" autofocus=""></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="acao" value="salvar"></td>
				</tr>
		</table>
	</form>


</body>
</html>