<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>


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
						var torneos = [];						
						$.each(response, function(key, value){
							var total = value.length;
							for(var conteo = 0; conteo < total; conteo++){
								torneos.push({
									recid: conteo,
									nombre: value[conteo].nombre, 
									tipo: value[conteo].tipo,
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
								{ field: 'tipo', caption: 'Nombre', size: '30%', hidden: true},
								{ field: 'sede', caption: 'Nombre', size: '30%', hidden: true},
								{ field: 'copa', caption: 'Tipo', size: '30%', hidden: true}
							],
							records: torneos,
						});						
						w2ui.torneosEdicion.on('select', function(event){
							event.onComplete = function(){									
							};
						});
						w2ui.torneosEdicion.on('unselect', function(event){
							event.onComplete = function(){																						
							};
						});
					}				
				});						
			});
		</script>	
		<input type = "text">
		
		<div id="estadisticas" style="width: 60%; height: 200px; margin: 10px;" class = "leftFloat"></div>
		<script>	
			$(function () {						
				$('#estadisticas').w2grid({ 
					name: 'estadisticas',
					show: { selectColumn: true },
					multiSelect: false,
					columns: 
					[				
						{ field: 'nombre', caption: 'Nombre', size: '30%'},
						{ field: 'pasaporte', caption: 'Pasaporte', size: '15%'},
						{ field: 'minutos', caption: 'Mins', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=3'}},
						{ field: 'golesAnotados', caption: 'Goles', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'tirosMarco', caption: 'T.M.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'asistencias', caption: 'Asis', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'recuperacionesBalon', caption: 'R.B.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'tarjetasAmarillas', caption: 'T.A', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=1'}},
						{ field: 'tarjetasRojas', caption: 'T.R.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=1'}},
						{ field: 'penalesDetenidos', caption: 'P.D.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'penalesCometidos', caption: 'P.C.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'rematesSalvados', caption: 'R.S', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}}
					],	
					records: [
						{ recid: 1, pasaporte: 'passport', nombre: 'mauricio', minutos: 0, golesAnotados: 0, tirosMarco: 0, asistencias: 0, recuperacionesBalon: 0,
							tarjetasAmarillas: 0, tarjetasRojas: 0, penalesDetenidos: 0, penalesCometidos: 0, rematesSalvados: 0}
					]
				});						
			});
		</script>	
	</div>
</div>