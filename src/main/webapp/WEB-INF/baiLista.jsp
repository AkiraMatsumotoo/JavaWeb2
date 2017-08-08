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

<body>
	<div id="todoSite" align="center">

		<div id="header">
			<jsp:include page="Cabecalho.jsp" />
		</div>

		<div id="nav">
			<jsp:include page="Menu.jsp" />
		</div>

		<div id="central">
			<jsp:include page="baiListaCentral.jsp" />
		</div>

		<div id="footer">
			<jsp:include page="Rodape.jsp" />
		</div>
	</div>
</body>




</html>