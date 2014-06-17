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
				url: 'http://localhost:8080/CapaServicioMH/equipos',
				dataType: 'json',
				success: function(response){
					
					var torneos = [];
					var conteo = 1;
					$.each(response, function(key, value){												
						torneos.push({
							recid: conteo,
							nombre: value.nombre, 
							pais: value.pais.nombre,
						});							
						conteo++;					
					});					
					
					$('#equipos').w2grid({ 
						name: 'equipos',						
						multiSelect: false,
						columns: 
						[				
							{ field: 'nombre', caption: 'Nombre', size: '30%'},
							{ field: 'pais', caption: 'Pais', size: '30%'},
						],
						records: torneos,										
					});										
				}				
			});						
		});
		</script>	
		<div>
			<h2>Nuevo Equipo</h2>
			<s:actionerror />
			<s:form action = "registrarEquipoLinkEquipos">
				<s:textfield name = "equipo.nombre" label = "Nombre"/>
				<s:select name = "esClub" label = "es Club?" list="{'si','no'}"></s:select>							
				<s:select name = "paisDeEquipo" label="Pais" list="listaPaises" 
					listKey="id_Pais" listValue="nombre"></s:select>		
				<s:submit align = "center"></s:submit>
			</s:form>
		</div>
	</div>
</div>