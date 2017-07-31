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
<title>Lista de Usuarios</title>
</head>
<body>
	<form action="UsuarioController" method="get">
		<table>
			<tr>

				<!-- Adiciona um novo Usuario -->
				<td><a href="UsuarioController?acao=adiciona">Adicionar
						Usuario</a></td>

				<!-- Busca um usuario -->
				<td>Nome :<input type="text" name="like" /> 
				<input type="submit" value="buscar" name="acao" /></td>

				<!-- Usando Select option para buscar -->
<!-- 				<td>Buscar Por: -->
<!-- 					<select name="campo" id="campo"> -->
<!-- 						<option value="id">ID</option> -->
<!-- 						<option value="nome" selected="selected">Nome</option> -->
<!-- 						<option value="login">Login</option> -->
<!-- 						<option value="senha">Senha</option> -->
<!-- 						<option value="nivel">Nivel</option> -->
<!-- 					</select> -->
<!-- 					<input type="text" name="like" />  -->
<!-- 					<input type="submit" value="buscar" name="acao"/> -->
<!-- 				</td> -->
			</tr>
		</table>
	</form>
	<table>
		<!-- 		descricao da lista -->
		<tr>
			<th><a href="UsuarioController?order=id&like=${param.like}">ID</a></th>
			<th><a href="UsuarioController?order=nome&like=${param.like}">NOME</a></th>
			<th><a href="UsuarioController?order=login&like=${param.like}">LOGIN</a></th>
			<th><a href="UsuarioController?order=senha&like=${param.like}">SENHA</a></th>
			<th><a href="UsuarioController?order=nivel&like=${param.like}">NIVEL</a></th>
			<th>ACAO</th>
		</tr>

		<!-- 		lista de Usuario -->
		<c:forEach items="${listaUsuario}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.login}</td>
				<td>${usuario.senha}</td>
				<td>${usuario.nivel}</td>
				<td><a href="UsuarioController?acao=excluir&id=${usuario.id}">Excluir</a>||
					<a href="UsuarioController?acao=editar&id=${usuario.id}">Editar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<!-- Quando a Ordenação for vazio -->
			<!-- Ordene por nome -->
			<!-- Caso contrario  -->
			<!-- Ordene pelo parametro setado -->
			<td><c:choose>
					<c:when test="${empty param.order}">
						<div style="letter-spacing: 3px;">
							<!-- 	mostra a paginacao embaixo da tabela -->
							<c:forEach begin="1" end="${paginacao}" var="i">
								<a
									href="UsuarioController?order=id&like=${param.like}&numPagina=${i}">${i}</a>
							</c:forEach>
						</div>
					</c:when>
					<c:otherwise>
						<div style="letter-spacing: 3px;">
							<!-- 	mostra a paginacao embaixo da tabela -->
							<c:forEach begin="1" end="${paginacao}" var="i">
								<a href="UsuarioController?order=${param.order}&like=${param.like}&numPagina=${i}">${i}</a>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose></td>
		</tr>

	</table>


</body>
</html>