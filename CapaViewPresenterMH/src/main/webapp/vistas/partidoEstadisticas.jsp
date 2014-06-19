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
		<s:actionerror />
		<script>	
			$(function () {
				var urlObjetivo = "http://localhost:8080/CapaServicioMH/torneos";
				$.ajax({
					url: urlObjetivo,
					dataType: 'json',
					success: function(response){
						var torneos = [];
						var conteo = 1;
						$.each(response, function(key, value){														
							torneos.push({
								recid: conteo,
								id: value.id,
								nombre: value.nombre, 
								tipo: value.tipoSelecciones,															
							});
							conteo++;							
						});											
						$('#torneos').w2grid({ 
							name: 'torneos',
							show: { selectColumn: true },
							multiSelect: false,
							columns: 
							[				
								{ field: 'nombre', caption: 'Nombre', size: '30%'},
								{ field: 'id', caption: 'id', size: '30%', hidden: true},
								{ field: 'tipo', caption: 'tipo', size: '30%', hidden: true}								
							],
							records: torneos,			
						});																
						w2ui.torneos.on('select', function(event){
							event.onComplete = function(){
								var filaSeleccionado = w2ui.torneos.getSelection();							
								var torneoSeleccionado = w2ui.torneos.get(filaSeleccionado);								
								document.getElementById("nombreTorneoSeleccionado").value = torneoSeleccionado.nombre;
								document.getElementById("idTorneoSeleccionado").value = torneoSeleccionado.id;
								document.getElementById("tipoTorneoSeleccionado").value = torneoSeleccionado.tipo;
							};
						});
						w2ui.torneos.on('unselect', function(event){
							event.onComplete = function(){
								document.getElementById("tipoTorneoSeleccionado").value = "";
								document.getElementById("nombreTorneoSeleccionado").value = "";
								document.getElementById("idTorneoSeleccionado").value = "";
							};
						});
					}				
				});								
			});
			
			
			
			function cargarJugadoresPorEquipo(){
				var idEquipo1 = document.getElementById("equipo1").value;
				var idEquipo2 = document.getElementById("equipo2").value;
				var torneoTipoSelecciones = document.getElementById("tipoTorneoConfigurado").value;
				var urlEquipo1 = "http://localhost:8080/CapaServicioMH/jugadores/club?idClub="+idEquipo1;
				var urlEquipo2 = "http://localhost:8080/CapaServicioMH/jugadores/club?idClub="+idEquipo2;
				if(torneoTipoSelecciones == "true"){					
					urlEquipo1 = "http://localhost:8080/CapaServicioMH/jugadores/seleccion?idSeleccion="+idEquipo1;
					urlEquipo2 = "http://localhost:8080/CapaServicioMH/jugadores/seleccion?idSeleccion="+idEquipo2;
				}						
				$.ajax({
					url: urlEquipo1,
					dataType: 'json',
					success: function(response){
						var jugadores1 = [];
						var conteo = 1;
						$.each(response, function(key, value){
							jugadores1.push({
								recid: conteo,
								nombre: value.nombre,								
								pasaporteJugador: value.pasaporte,								
								minutosJugados: 0, 
								golesAnotados: 0, 
								tirosMarco: 0, 
								asistencias: 0, 
								balonesRecuperados: 0,
								tarjetasAmarillas: 0, 
								tarjetasRojas: 0, 
								penalesDetenidos: 0, 
								penalesCometidos: 0, 
								rematesSalvados: 0,			
							});
							conteo++;
						});
						w2ui['gridJugadoresEquipo1'].records = jugadores1;
						w2ui['gridJugadoresEquipo1'].refresh();
					}
				});
				$.ajax({
					url: urlEquipo2,
					dataType: 'json',
					success: function(response){
						var jugadores2 = [];
						var conteo = 1;
						$.each(response, function(key, value){
							jugadores2.push({
								recid: conteo,
								nombre: value.nombre,								
								pasaporteJugador: value.pasaporte,								
								minutosJugados: 0, 
								golesAnotados: 0, 
								tirosMarco: 0, 
								asistencias: 0, 
								balonesRecuperados: 0,
								tarjetasAmarillas: 0, 
								tarjetasRojas: 0, 
								penalesDetenidos: 0, 
								penalesCometidos: 0, 
								rematesSalvados: 0,
							});
							conteo++;
						});
						w2ui['gridJugadoresEquipo2'].records = jugadores2;
						w2ui['gridJugadoresEquipo2'].refresh();
					}
				});
			}
			
		</script>
		<s:form action="cargarEquiposLinkPartidos">
			<s:textfield id = "idTorneoSeleccionado" name = "idTorneoSeleccionado" type="hidden"></s:textfield>
			<s:textfield id = "tipoTorneoSeleccionado" name = "tipoTorneoSeleccionado" type="hidden"></s:textfield>
			<s:textfield id = "nombreTorneoSeleccionado" name = "nombreTorneoSeleccionado" type="hidden"></s:textfield>
			<s:submit value = "Cargar Equipos"/>
		</s:form>
	</div>
	
	<div id = "contenedorPartido" class = "rightFloat">
		<div id = "detallesPartido" class = "">
			<s:form action="registrarPartidoLinkPartidos">
				<h3>Partido</h3>
				<s:property value = "nombreTorneoConfigurado" /> <br>					
				<s:textfield name = "idTorneoConfigurado" type="hidden"></s:textfield>
				<s:textfield id = "estadisticasEquipo1" name = "estadisticasEquipo1" type="hidden"></s:textfield>
				<s:textfield id = "estadisticasEquipo2" name = "estadisticasEquipo2" type="hidden"></s:textfield>
				<s:textfield id = "tipoTorneoConfigurado" name = "tipoTorneoConfigurado" type="hidden"></s:textfield>
				Equipos: <s:select id = "equipo1" name = "idEquipo1" theme="simple" list="listaEquipos" listKey="id_Equipo" listValue="nombre"></s:select>
				<s:select id = "equipo2" name = "idEquipo2" theme="simple" list="listaEquipos" listKey="id_Equipo" listValue="nombre"></s:select><br>
				
				Marcador: <s:textfield type = "number" name="golesEquipo1" size="3" theme="simple" pattern="[0-9]+" min = "0" max = "99"/>
				<s:textfield type = "number" name="golesEquipo2" size="3" pattern="[0-9]+" theme="simple" min = "0" max = "99"/>
				<br>
				Fecha (dd-mm-aaaa)": <s:textfield  name="fechaPartido" theme="simple"/>
				<br><input type = "button" onclick="cargarJugadoresPorEquipo();" value="Cargar Jugadores">
				<s:submit id = "registrar" value="registrar" align = "center" theme = "simple" />
			</s:form>
		</div>
		
		<div id="gridJugadoresEquipo1" class = "estadisticas"></div>
		<script>	
			$(function () {						
				$('#gridJugadoresEquipo1').w2grid({ 
					name: 'gridJugadoresEquipo1',					
					multiSelect: false,
					columns: 
					[						
						{ field: 'nombre', caption: 'Nombre', size: '30%'},
						{ field: 'pasaporteJugador', caption: 'Pasaporte', size: '15%'},
						{ field: 'minutosJugados', caption: 'Mins', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=3'}},
						{ field: 'golesAnotados', caption: 'Goles', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'tirosMarco', caption: 'T.M.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'asistencias', caption: 'Asis', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'balonesRecuperados', caption: 'R.B.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'tarjetasAmarillas', caption: 'T.A', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=1'}},
						{ field: 'tarjetasRojas', caption: 'T.R.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=1'}},
						{ field: 'penalesDetenidos', caption: 'P.D.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'penalesCometidos', caption: 'P.C.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'rematesSalvados', caption: 'R.S', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}}
					]						
				});	
				$("#registrar").click(function(){				
					
					var estadisticasJugadores1 = w2ui['gridJugadoresEquipo1'].getChanges();					
					w2ui['gridJugadoresEquipo1'].mergeChanges();
					var resultadorEstadisticas1 = "";					
					var index = 0;
					while(index < estadisticasJugadores1.length){														
						var fila = estadisticasJugadores1[index].recid;
						var estats = w2ui['gridJugadoresEquipo1'].get(fila);
						var stringEstats = JSON.stringify(estats);
						resultadorEstadisticas1 = resultadorEstadisticas1 + stringEstats + "-";
						index++;
					}
					
					document.getElementById("estadisticasEquipo1").value = resultadorEstadisticas1.substring(0, resultadorEstadisticas1.length-1);
					
					var estadisticasJugadores2 = w2ui['gridJugadoresEquipo2'].getChanges();					
					w2ui['gridJugadoresEquipo2'].mergeChanges();
					var resultadoFinal = "";					
					var conteo = 0;
					while(conteo < estadisticasJugadores2.length){						
						var fila2 = estadisticasJugadores2[conteo].recid;
						var estadistica2 = w2ui['gridJugadoresEquipo2'].get(fila2);
						var stringEstadistica = JSON.stringify(estadistica2);						
						resultadoFinal = resultadoFinal + stringEstadistica + "-";
						conteo++;
					}					
					document.getElementById("estadisticasEquipo2").value = resultadoFinal.substring(0, resultadoFinal.length-1);
				});
			});
		</script>
		
		<div id="gridJugadoresEquipo2" class = "estadisticas"></div>
		<script>	
			$(function () {						
				$('#gridJugadoresEquipo2').w2grid({ 
					name: 'gridJugadoresEquipo2',					
					multiSelect: false,
					columns: 
					[						 	
						{ field: 'nombre', caption: 'Nombre', size: '30%'},
						{ field: 'pasaporteJugador', caption: 'Pasaporte', size: '15%'},
						{ field: 'minutosJugados', caption: 'Mins', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=3'}},
						{ field: 'golesAnotados', caption: 'Goles', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'tirosMarco', caption: 'T.M.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'asistencias', caption: 'Asis', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'balonesRecuperados', caption: 'R.B.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'tarjetasAmarillas', caption: 'T.A', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=1'}},
						{ field: 'tarjetasRojas', caption: 'T.R.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=1'}},
						{ field: 'penalesDetenidos', caption: 'P.D.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'penalesCometidos', caption: 'P.C.', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}},
						{ field: 'rematesSalvados', caption: 'R.S', size: '5%', editable: {type: 'int', style: 'text-align: center', inTag: 'maxlength=2'}}
					]
				});						
			});
		</script>	
	</div>
</div>