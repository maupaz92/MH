<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href = "<s:url value='/css/estilos.css'/>" />
		<title>Log-in</title>
	</head>
	
	<body>
		<div id = "header">
			<img src="<s:url value='/recursos/fifa-logo.png'/>" id = "logo" class = "leftFloat">
			<h1>MyHistory</h1>	
		</div>
		
		<div id = "loginTile" class = "center">	
			<h2>Log in</h2>
			<s:actionerror />
			<s:form action = "perfilLinkRegistro">
				<s:textfield name = "usuario" key = "label.username" size = "30"/>
				<s:textfield name = "password" key = "label.password" size = "30" />
				<s:submit align = "center"></s:submit>
			</s:form>
		</div>		
				
	</body>

</html>