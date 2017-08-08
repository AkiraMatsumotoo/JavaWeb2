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
<title>Lista de Bairros</title>

</head>
<body>
	<form action="BairroController" method="get">
		<table>
			<tr>

				<!-- Adiciona um novo Bairro-->
				<td><a href="BairroController?acao=adiciona">Adicionar Bairro</a></td>

				<!-- Busca um Bairro -->
				<td>Descricao :<input type="text" name="like" /> 
				<input type="submit" value="buscar" name="acao" /></td>

			</tr>
		</table>
	</form>
	<table>
		<!-- 		descricao da lista -->
		<tr>
			<th><a href="BairroController?orderBy=bairro_id&like=${param.like}">Bairro ID</a></th>
			<th><a href="BairroController?orderBy=bairro_descricao&like=${param.like}">Descricao</a></th>
			<th>ACAO</th>
		</tr>

		<!-- 		lista de Bairro -->
		<c:forEach items="${listaBairro}" var="bairro">
			<tr>
				<td>${bairro.bairro_id}</td>
				<td>${bairro.bairro_descricao}</td>
				<td><a href="BairroController?acao=editar&bairro_id=${bairro.bairro_id}">Editar</a>||
					<a href="BairroController?acao=excluir&bairro_id=${bairro.bairro_id}" onclick="return confirm('Deseja Excluir ${bairro.bairro_descricao}?')">Excluir</a>
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
								<a href="BairroController?orderBy=bairro_id&like=${param.like}&numPagina=${i}">${i}</a>
							</c:forEach>
						</div>
					</c:when>
					<c:otherwise>
						<div style="letter-spacing: 3px;">
							<!-- 	mostra a paginacao embaixo da tabela -->
							<c:forEach begin="1" end="${paginacao}" var="i">
								<a href="BairroController?orderBy=${param.order}&like=${param.like}&numPagina=${i}">${i}</a>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose></td>
		</tr>

	</table>


</body>
</html>