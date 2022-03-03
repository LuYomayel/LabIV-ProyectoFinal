<%@page import="Entidad.Docente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.DocenteDaoImpl"%>
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Docente" %>
<%@page import="Entidad.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Profesores</title>
<link rel="Stylesheet" href="Css/ListadoProfesores.css" />

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready( function () {
	    $('#tablaDocentes').DataTable();
	} );
	
</script>
</head>
<body>
	<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary position-relative">
			 <div class="container-fluid">
				   <div class="collapse navbar-collapse" id="navbarScroll">
				   
				     <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
				     <% if((int)session.getAttribute("sesion") == 2){ %>
				        
				        <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            Profesores
				          </a>
				          <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				            <li><a href="ServletDocente?Agregar=1" class="dropdown-item">Agregar Profesor</a></li>
				            <li><a href="ServletDocente?Param=1" class="dropdown-item">Listado de Profesores</a></li>
				            <li><a href="ServletDocente?Modificar=1" class="dropdown-item">Modificar Profesores</a></li>
				          </ul>
				        </li>
				        <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            Alumnos
				          </a>
				          <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				            <li><a href="ServletAlumno?Agregar=1" class="dropdown-item">Agregado de Alumno</a></li>
				            <li><a href="ServletAlumno?Param=1" class="dropdown-item">Listado de alumnos</a></li>
				            <li><a href="ServletAlumno?Modificar=1" class="dropdown-item">Modificar Alumnos</a></li>
				          </ul>
				        </li>
				        <% } %>
				         <% if ((int)session.getAttribute("sesion") == 1){ %>
					         <li class="nav-item">
					          <a class="nav-link active" aria-current="page" href="ServletCursos?Listar=1">Cursos</a>
				        	</li>
				         <% } else{%>
				        <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            Cursos
				          </a>
				          
				          <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				            <li><a href="ServletCursos?Agregar=1" class="dropdown-item">Agregar cursado</a></li>
				            <li><a href="#" class="dropdown-item">Agregar alumnos a cursado</a></li>
				            
				          </ul>
				        </li>
				        <% } %>
				        	
				        <% if(session.getAttribute("docente")!=null){ 
				        	Docente docente = (Docente)session.getAttribute("docente"); %>
				        <li class="nav-item dropdown position-absolute end-0">
				        	<a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            <%=docente.getNombre() + " " + docente.getApellido()%>
				          </a>
				        <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				        	<li class="nav-item ">
				        	 	<a href="ServletLogin?CerrarSesion=1" class="dropdown-item"> Cerrar Sesion</a>
				        	</li>
				        
				        </ul>
				        </li>
				        <% } 
				        if(session.getAttribute("admin")!=null){
				        Usuario usuario = (Usuario) session.getAttribute("admin");
				        %>
				        <li class="nav-item dropdown position-absolute end-0">
				        	<a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            <%=usuario.getUsuario()%>
				          </a>
				        <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				        	<li class="nav-item ">
				        	 	<a href="ServletLogin?CerrarSesion=1" class="dropdown-item"> Cerrar Sesion</a>
				        	</li>
				        
				        </ul>
				        </li>
				        <% } %>
				      </ul>
				    </div>
			  </div>
		</nav>
    	 
            
	</header>
	<% if((int)session.getAttribute("sesion") == 2){
	ArrayList<Entidad.Docente> listaDocentes = null;
	if(request.getAttribute("listaD")!=null)
	{
		listaDocentes = (ArrayList<Entidad.Docente>) request.getAttribute("listaD");
	}

 %>
 <div class="container">
	<h1 class="text-center"> Listado de Profesores </h1>
	
		<table class="w-100 table table-primary" id="tablaDocentes"> 
			
				<thead>
		
					<tr class="table-primary">
						<th class="table-primary">Legajo</th>
						<th class="table-primary">Documento</th>
						<th class="table-primary">Nombre</th>
						<th class="table-primary">Apellido</th>
						<th class="table-primary">Fecha de Nacimiento</th>
						<th class="table-primary">Direccion</th>
						<th class="table-primary">Nacionalidad</th>
						<th class="table-primary">Provincia</th>
						<th class="table-primary">Localidad</th>
						
						<th class="table-primary">Email</th>
						<th class="table-primary">Telefono</th>
						<th class="table-primary">ELIMINAR</th>
				</tr>
			</thead>
			<tbody>
		
				<tr>
<%  if(listaDocentes!=null)
		for(Docente docente : listaDocentes) 
		{
	%>
					<form name="formulario" action="ServletDocente?idDocente=<%=docente.getId()%>" method="get">
						<td class="table-primary"><%= docente.getLegajo()%>   <input type="hidden" name="idDocente" value="<%=docente.getId()%>"> </td>
						<td class="table-light"><%= docente.getDni()%></td>
						<td class="table-light"><%= docente.getNombre()%></td>
						<td class="table-light"><%= docente.getApellido()%></td>
						<td class="table-light"><%= docente.getFechanacimiento()%>c</td>
						<td class="table-light"><%= docente.getDireccion()%></td>
						<td class="table-light"><%= docente.getNacionalidad()%></td>
						<td class="table-light"><%= docente.getProvincia()%></td>
						<td class="table-light"><%= docente.getLocalidad()%></td>
						<td class="table-light"><%= docente.getEmail()%></td>
						<td class="table-light"><%= docente.getTelefono()%></td>
						<td class="table-light"><input type="submit" name="btnEliminar" value="X" class="btn btn-danger"></td>
					</form> 
				</tr>
				<%  } %>
		
			</tbody>
		
	</table>
	
	
	<% }else {%> <h1>Debes ser Admin.</h1> <% } %>
	<%
			int estado=0;
			if(request.getAttribute("estadoModificar") != null)
				estado = (int)request.getAttribute("estadoModificar");
		%>
		<% if(estado == 1){ %>
			<b>¡Profesor modificado con exito! </b>
			<%} if(estado==-1){ %>
			<b>¡No se pudo modificar el profesor, debe completar todos los campos! </b>
			<%}%>
			
	<%
			
			if(request.getAttribute("estadoEliminar") != null)
				estado = (int)request.getAttribute("estadoEliminar");
		%>
		<% if(estado >= 1){ %>
			<b>¡Profesor eliminado con exito! </b>
			<%} if(estado==-1){ %>
			<b>¡No se pudo eliminar el profesor! </b>
			<%}%>
			</div>
			
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	
</body>
</html>