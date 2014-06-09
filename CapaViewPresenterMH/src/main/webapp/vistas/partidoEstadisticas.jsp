<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<link rel="stylesheet" type="text/css" href="<s:url value='/css/estilos.css'/>" />
<link rel="stylesheet" type="text/css" href="<s:url value='/css/partidoEstadisticas.css'/>" />
<link rel="stylesheet" type="text/css" href="<s:url value='/scripts/w2ui-1.3.2.min.css'/>" />
<script src="<s:url value='/scripts/jquery-2.1.1.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/scripts/w2ui-1.3.2.min.js'/>"></script>

<div id = "contenedorGeneral" class = "cuerpo floatRight">
	
	<div id = "contenedorTorneos" class = "leftFloat">
		<h3>Torneos</h3>
		<div id="torneos" style="width: 80%; height: 400px; margin: 10px;"></div>
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
						$('#torneos').w2grid({ 
							name: 'torneos',
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
						w2ui.torneos.on('select', function(event){
							event.onComplete = function(){									
							};
						});
						w2ui.torneos.on('unselect', function(event){
							event.onComplete = function(){																						
							};
						});
					}				
				});						
			});
		</script>
		<input type="button" value = "Cargar Equipos">
	</div>
	
	<div id = "contenedorPartido" class = "rightFloat">
		<div id = "detallesPartido" class = "">
			<s:form>
				<h3>Partido</h3>
				Equipos: <s:select name = "equipo1" label = "Equipo" theme="simple" list="{'selecciones','clubes'}"></s:select>
				<s:select name = "equipo2" label = "Equipo" theme="simple" list="{'selecciones','clubes'}"></s:select><br>
				Marcador: <s:textfield type = "number" name="marcador1" label = "Marcador" theme="simple" pattern="[0-9]+" min = "0" max = "99"/>
				<s:textfield type = "number" name="marcador2" pattern="[0-9]+" theme="simple" min = "0" max = "99"/>
				<br>
				Día:<s:textfield type = "number" name="day"  key="label.day" theme="simple" pattern="[0-9]+" min = "1" max = "31"/>
				Mes:<s:textfield type = "number" name="month" key="label.month" theme="simple" pattern="[0-9]+" min = "1" max = "12"/>
				Año:<s:textfield type = "number" name="year" key="label.year" theme="simple" pattern="[0-9]+" min = "1950" max = "2999"/>
				<br><input type = "button" onclick="" value="Cargar Jugadores">
				<s:submit value="registrar" align = "center" theme = "simple" />
			</s:form>
		</div>
		
		<div id="estadisticas1" class = "estadisticas"></div>
		<script>	
			$(function () {						
				$('#estadisticas1').w2grid({ 
					name: 'estadisticas1',					
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
		
		<div id="estadisticas2" class = "estadisticas"></div>
		<script>	
			$(function () {						
				$('#estadisticas2').w2grid({ 
					name: 'estadisticas2',					
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