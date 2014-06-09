<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
 
<link rel="stylesheet" type="text/css" href="<s:url value='/css/estilos.css'/>" />
<link rel="stylesheet" type="text/css" href="<s:url value='/scripts/w2ui-1.3.2.min.css'/>" />
<script src="<s:url value='/scripts/jquery-2.1.1.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/scripts/w2ui-1.3.2.min.js'/>"></script>
 
 
<div class = "cuerpo floatRight">
	<div class = "center">
		<div id="equipos" style="width: 30%; height: 200px; margin: 10px;" class = "leftFloat"></div>		
		<script>	
		$(function () {						
			$.ajax({
				url: 'http://localhost:8080/CapaServicioMH/torneos',
				dataType: 'json',
				success: function(response){
					
					var torneos = [];
					
					$.each(response, function(key, value){
						var total = value.length;
						for(var conteo = 0; conteo < total; conteo++){
							torneos.push({
								recid: conteo,
								nombre: value[conteo].nombre, 								
							});							
						}						
					});					
					
					$('#equipos').w2grid({ 
						name: 'equipos',						
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
			<h2>Nuevo Equipo</h2>		
			<s:form action = "">
				<s:textfield name = "equipo.nombre" label = "Nombre"/>			
				<s:textfield name = "equipo.pais" label = "País"/>				
				<s:submit align = "center"></s:submit>
			</s:form>
		</div>
	</div>
</div>