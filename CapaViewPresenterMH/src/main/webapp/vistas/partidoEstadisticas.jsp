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
			
			function algo(){
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
								pasaporte: value.pasaporte,								
								minutos: 0, 
								golesAnotados: 0, 
								tirosMarco: 0, 
								asistencias: 0, 
								recuperacionesBalon: 0,
								tarjetasAmarillas: 0, 
								tarjetasRojas: 0, 
								penalesDetenidos: 0, 
								penalesCometidos: 0, 
								rematesSalvados: 0,					
							});
						});
						w2ui['estadisticas1'].records = jugadores1;
						w2ui['estadisticas1'].refresh();
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
								pasaporte: value.pasaporte,								
								minutos: 0, 
								golesAnotados: 0, 
								tirosMarco: 0, 
								asistencias: 0, 
								recuperacionesBalon: 0,
								tarjetasAmarillas: 0, 
								tarjetasRojas: 0, 
								penalesDetenidos: 0, 
								penalesCometidos: 0, 
								rematesSalvados: 0,					
							});
						});
						w2ui['estadisticas2'].records = jugadores2;
						w2ui['estadisticas2'].refresh();
					}
				});
			}
			
		</script>
		<s:form action="cargarEquiposLinkPartidos">
			<s:textfield id = "idTorneoSeleccionado" name = "idTorneoSeleccionado"></s:textfield>
			<s:textfield id = "tipoTorneoSeleccionado" name = "tipoTorneoSeleccionado"></s:textfield>
			<s:textfield id = "nombreTorneoSeleccionado" name = "nombreTorneoSeleccionado"></s:textfield>
			<s:submit value = "Cargar Equipos"/>
		</s:form>
	</div>
	
	<div id = "contenedorPartido" class = "rightFloat">
		<div id = "detallesPartido" class = "">
			<s:form>
				<h3>Partido</h3>
				<s:property value = "nombreTorneoConfigurado" /> <br>					
				<s:textfield name = "idTorneoConfigurado"></s:textfield>
				<s:textfield id = "tipoTorneoConfigurado" name = "tipoTorneoConfigurado"></s:textfield>
				Equipos: <s:select id = "equipo1" name = "equipo1" theme="simple" list="listaEquipos" listKey="id_Equipo" listValue="nombre"></s:select>
				<s:select id = "equipo2" name = "equipo2" theme="simple" list="listaEquipos" listKey="id_Equipo" listValue="nombre"></s:select><br>
				
				Marcador: <s:textfield type = "number" name="marcador1" size="3" theme="simple" pattern="[0-9]+" min = "0" max = "99"/>
				<s:textfield type = "number" name="marcador2" size="3" pattern="[0-9]+" theme="simple" min = "0" max = "99"/>
				<br>
				Fecha (dd-mm-aaaa)": <s:textfield  name="fecha" theme="simple"/>
				<br><input type = "button" onclick="algo();" value="Cargar Jugadores">
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