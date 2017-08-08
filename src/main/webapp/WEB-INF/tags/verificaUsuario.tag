<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${usuarioSessao==null}">
	<% 
		response.sendRedirect("login.jsp");
	%>
</c:if>