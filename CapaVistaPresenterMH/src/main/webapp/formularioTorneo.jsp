<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h3>Formulario nuevo Torneo</h3>		
		<s:form action = "registrarTorneo">
			<s:textfield name = "torneo.nombre" label = "Nombre del torneo"/>
			<!-- <s:textfield name = "torneo.tipo" label = "tipo del torneo"/> -->
			<s:textfield name = "torneo.sede" label = "sede del torneo"/>
			<s:select name = "torneo.tipo" label = "tipo del torneo" list="{'Java Lang','Mauricio'}"></s:select>
			<s:submit align = "center"></s:submit>
		</s:form>
	
	</body>
</html>