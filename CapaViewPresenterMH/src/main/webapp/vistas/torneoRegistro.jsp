<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
 
<link rel="stylesheet" type="text/css" href="<s:url value='/css/estilos.css'/>" />
<link rel="stylesheet" type="text/css" href="<s:url value='/scripts/w2ui-1.3.2.min.css'/>" />
<script src="<s:url value='/scripts/jquery-2.1.1.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/scripts/w2ui-1.3.2.min.js'/>"></script>
 
 
<div class = "cuerpo floatRight">
	<div class = "center">
		<div id="torneosEdicion" style="width: 30%; height: 200px; margin: 10px;" class = "leftFloat"></div>		
		<script>	
		$(function () {						
			$.ajax({
				url: 'http://localhost:8080/CapaServicioMH/torneos',
				dataType: 'json',
				success: function(response){
					//se define el arreglo de torneos
					var torneos = [];
					//inicio de los recid para la lista de torneos
					var conteo = 1;					
					//por cada elementos en la respuesta
					$.each(response, function(key, value){						
						torneos.push({
							recid: conteo,
							nombre: value.nombre,					
						});
						conteo++;
					});					
					
					$('#torneosEdicion').w2grid({ 
						name: 'torneosEdicion',						
						multiSelect: false,
						columns: 
						[				
							{ field: 'nombre', caption: 'Nombre', size: '30%'}							
						],
						records: torneos,										
					});										
				}				
			});						
		});
		</script>	
		<div>
			<h2>Nuevo Torneo</h2>		
			<s:form action = "registrarTorneoLinkTorneos">
				<s:textfield name = "torneo.nombre" label = "Nombre del torneo"/>			
				<s:textfield name = "torneo.sede" label = "sede del torneo"/>
				<s:select name = "tipoSelecciones" label = "es de Selecciones?" list="{'si','no'}"></s:select>
				<s:select name = "esCopaTorneo" label = "es de Copa?" list="{'si','no'}"></s:select>
				<s:submit align = "center"></s:submit>
			</s:form>
		</div>
	</div>
</div>