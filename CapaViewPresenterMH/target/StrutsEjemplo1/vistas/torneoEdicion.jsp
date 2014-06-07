<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>


<link rel="stylesheet" type="text/css" href="../scripts/w2ui-1.3.2.min.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/w2ui-1.3.2.min.js"></script>

<div class = "cuerpo floatRight">
	<div id="equipo1" style="width: 15%; height: 200px; overflow: hidden;"></div>		
	<script type="text/javascript">	
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
								nombre: value[conteo].nombre , 
								tipo: value[conteo].tipo
							});							
						}						
					});					
					
					$('#equipo1').w2grid({ 
						name: 'equipo1',
						show: { selectColumn: true },
						multiSelect: false,
						columns: 
						[				
							{ field: 'nombre', caption: 'Nombre', size: '30%'},
							{ field: 'tipo', caption: 'Tipo', size: '30%', hidden: true}
						],
						records: torneos,										
					});
					w2ui.equipo1.on('select', function(event){
						event.onComplete = function(){
							var filaSeleccionada = w2ui['equipo1'].getSelection();
							var elemento = w2ui['equipo1'].get(filaSeleccionada);
							document.getElementById("cambiosEquipo1").value = elemento.nombre;
							document.getElementById("cambiosEquipo2").value = elemento.tipo;
						};
					});
					w2ui.equipo1.on('unselect', function(event){
						event.onComplete = function(){														
							document.getElementById("cambiosEquipo1").value = "";							
						};
					});
				}				
			});						
		});	
	</script>
	<s:form action = "" onclick = "">			
		<s:submit id = "boton" ></s:submit>
		<s:textfield id = "cambiosEquipo1" name = "cambiosEquipo1" value = ""></s:textfield>
		<s:textfield id = "cambiosEquipo2" name = "cambiosEquipo2" value = ""></s:textfield>
	</s:form>
</div>
