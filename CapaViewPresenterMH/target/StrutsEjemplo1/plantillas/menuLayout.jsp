<%@taglib uri="/struts-tags" prefix="s"%>

<link rel="stylesheet" type="text/css" href="css/estilos.css" />

<div id="menu">
	<ul>
		<li><a href="<s:url action=""/>">Perfil</a></li>
		<li>Torneos			
			<ul>
				<li><a href="<s:url action="vistaRegistrarTorneoLinkTorneos"/>">Registar Torneo</a></li>
				<li><a href="<s:url action="vistaEdicionTorneoLinkTorneos"/>">Editar Torneo</a></li>
			</ul>
		</li>		
		<li>Equipos			
			<ul>
				<li>Registrar Equipo</li>
				<li>Editar Equipo</li>
			</ul>
		</li>
		
		<li>Jugadores			
			<ul>
				<li>Registrar Jugador</li>
				<li>Editar Jugador</li>
			</ul>
		</li>
		
		<li><a href="<s:url action="vistaRegistrarPartidoLinkPartidos"/>">Registrar Partido</a></li>
		
	</ul>	

</div>