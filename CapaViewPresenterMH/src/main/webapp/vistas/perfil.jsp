<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="css/.css" />    
<div id = "perfil" class = "cuerpo floatRight">
	<h1>Hello!</h1>
	<!-- 
	la propiedad es de la clases Action, en este caso de LoginAction. Debido a que este vista 
	es llamada desde la accion LoginAction, se puede acceder a las propiedas de la clase. 
	-->
	<s:property value = "usuario"/>			
</div>
