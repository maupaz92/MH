<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<link rel="stylesheet" type="text/css" href="<s:url value='/css/estilos.css'/>" />
<link rel="stylesheet" type="text/css" href="<s:url value='/scripts/w2ui-1.3.2.min.css'/>" />
<script src="<s:url value='/scripts/jquery-2.1.1.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/scripts/w2ui-1.3.2.min.js'/>"></script>

</head>

<body>

<div class = "cuerpo floatRight">
	<div class = "center">
		<div id="torneosEdicion" style="width: 30%; height: 200px; margin: 10px;" class = "leftFloat"></div>		
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
								tipoSelecciones: value[conteo].tipoSelecciones,
								sede: value[conteo].sede,
								copa: value[conteo].copa,
								
							});							
						}						
					});					
					
					$('#torneosEdicion').w2grid({ 
						name: 'torneosEdicion',
						show: { selectColumn: true },
						multiSelect: false,
						columns: 
						[				
							{ field: 'nombre', caption: 'Nombre', size: '30%'},
							{ field: 'tipoSelecciones', caption: 'Nombre', size: '30%', hidden: true},
							{ field: 'sede', caption: 'Nombre', size: '30%', hidden: true},
							{ field: 'copa', caption: 'Tipo', size: '30%', hidden: true}
						],
						records: torneos,										
					});
					
					w2ui.torneosEdicion.on('select', function(event){
						event.onComplete = function(){
							var filaSeleccionada = w2ui['torneosEdicion'].getSelection();
							var elemento = w2ui['torneosEdicion'].get(filaSeleccionada);
							document.getElementById("torneo.nombre").value = elemento.nombre;
							document.getElementById("torneo.sede").value = elemento.sede;
							
							var esTipoSelecciones = elemento.tipoSelecciones;					
							if(esTipoSelecciones){
								document.getElementById("tipoSelecciones").value = "si";
							}else{
								document.getElementById("tipoSelecciones").value = "no";
							}
														
							var esDeCopa = elemento.copa;
							if(esDeCopa){
								document.getElementById("esCopaTorneo").value = "si";
							}else{
								document.getElementById("esCopaTorneo").value = "no";
							}
								
								
						};
					});
					w2ui.torneosEdicion.on('unselect', function(event){
						event.onComplete = function(){														
							document.getElementById("torneo.nombre").value = "";	
							document.getElementById("torneo.sede").value = "";
							document.getElementById("tipoSelecciones").value = "";
							document.getElementById("esCopaTorneo").value = "";
						};
					});
				}				
			});						
		});
		</script>	
		
		<div>
			<h2>Torneo</h2>		
			<s:form action = "actualizarTorneoLinkTorneos">
				<s:textfield id = "torneo.nombre" name = "torneo.nombre"  label = "Nombre del torneo"/>			
				<s:textfield id = "torneo.sede" name = "torneo.sede" label = "sede del torneo"/>
				<s:select id = "tipoSelecciones" name = "tipoSelecciones"  label = "tipo selecciones" list="{'si','no'}"></s:select>
				<s:select id = "esCopaTorneo" name = "esCopaTorneo"  label = "es de Copa?" list="{'si','no'}"></s:select>
				<s:submit align = "center"></s:submit>
			</s:form>
		</div>
	</div>
</div>

</body>

</html>

