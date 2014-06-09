<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<link rel="stylesheet" type="text/css" href="<s:url value='/css/estilos.css'/>" />

<div class = "center">
	<div class = "center">
		<h2>Log in</h2>
		<s:actionerror />
		<s:form action = "perfilLinkRegistro">
			<s:textfield name = "usuario" key = "label.username" size = "30"/>
			<s:textfield name = "password" key = "label.password" size = "30" />
			<s:submit align = "center"></s:submit>
		</s:form>
	</div>
</div>