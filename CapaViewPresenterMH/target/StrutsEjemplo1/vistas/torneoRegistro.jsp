<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
 
<div id = "formularioTorneo" class = "cuerpo floatRight">
	<h2>Nuevo Torneo</h2>		
	<s:form action = "registrarTorneo">
		<s:textfield name = "torneo.nombre" label = "Nombre del torneo"/>			
		<s:textfield name = "torneo.sede" label = "sede del torneo"/>
		<s:select name = "torneo.tipo" label = "tipo de torneo" list="{'selecciones','clubes'}"></s:select>
		<s:radio name = "esCopaTorneo" label = "Es de copa?" list="{'si','no'}"></s:radio>
		<s:submit align = "center"></s:submit>
	</s:form>
</div>