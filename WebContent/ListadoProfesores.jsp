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
	<h1><p aling ="Center";"  ><b> Listar Profesor</b></p> </h1>
	
		<table border=1 ,style="text-align: center"> 
			<nav class= "table">
				<thead>
		
					<tr>
						<th>Legajo</th>
						<th>Documento</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Fecha de Nacimiento</th>
						<th>Direccion</th>
						<th>Nacionalidad</th>
						<th>Provincia</th>
						<th>Localidad</th>
						
						<th>Email</th>
						<th>Telefono</th>
						<th>ELIMINAR</th>
				</tr>
			</thead>
			<tbody>
		
				<tr>
<%  if(listaDocentes!=null)
		for(Docente docente : listaDocentes) 
		{
	%>
					<form name="formulario" action="ServletDocente?idDocente=<%=docente.getId()%>" method="get">
						<td><%= docente.getLegajo()%>   <input type="hidden" name="idDocente" value="<%=docente.getId()%>"> </td>
						<td><%= docente.getDni()%></td>
						<td><%= docente.getNombre()%></td>
						<td><%= docente.getApellido()%></td>
						<td><%= docente.getFechanacimiento()%>c</td>
						<td><%= docente.getDireccion()%></td>
						<td><%= docente.getNacionalidad()%></td>
						<td><%= docente.getProvincia()%></td>
						<td><%= docente.getLocalidad()%></td>
						<td><%= docente.getEmail()%></td>
						<td><%= docente.getTelefono()%></td>
						<td><input type="submit" name="btnEliminar" value="Eliminar"></td>
					</form> 
				</tr>
				<%  } %>
		
			</tbody>
		</nav>
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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>