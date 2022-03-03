<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DaoImpl.AlumnoDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Alumno" %>
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Docente" %>
<%@page import="Entidad.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Alumnos a cursado</title>
<link rel="Stylesheet" href="Css/ListadoAlumno.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<% 
ArrayList<Alumno> listaAlumnos = null;
ArrayList<Alumno> listaAlumnosCursado = null;
if(request.getAttribute("listaAlumnos")!=null)
{
	listaAlumnos = (ArrayList<Alumno>) request.getAttribute("listaAlumnos");
}
if(session.getAttribute("listaAlumnosACursado")!=null)
{
	listaAlumnosCursado = (ArrayList<Alumno>) session.getAttribute("listaAlumnosACursado");
}
 %>

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

	<h1><p aling ="Center";"  ><b> Listado de Alumnos</b></p> 
</h1>
		<table border=1> 
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
			<%-- <th>Carrera </th> --%>
			<th>Agregar</th>
		</tr>
		<%  if(listaAlumnos!=null)
		for(Alumno alumno : listaAlumnos) 
		{
			%>	
		<tr>
			<form name="formulario" action="ServletCursos" method="post">
					<td><%= alumno.getLegajo()%> <input type="hidden" name="idAlumno" value="<%=alumno.getLegajo()%>"> </td>
					<td><%= alumno.getDni()%></td>
					<td><%= alumno.getNombre()%></td>
					<td><%= alumno.getApellido()%></td>
					<td><%= alumno.getFechanacimiento()%></td>
					<td><%= alumno.getDireccion()%></td>
					<td><%= alumno.getNacionalidad()%></td>
					<td><%= alumno.getProvincia()%></td>
					<td><%= alumno.getLocalidad()%></td>
					<td><%= alumno.getEmail()%></td>
					<td><%= alumno.getTelefono()%></td>
					<%--<td><%= alumno.getIdCarrera()%></td>--%>
					<td><input type="submit" name="btnAgregar" value="Agregar"></td>
			</form>
				</tr>
			<%  } %>
	</table>
	<h3>Lista a Agregar al curso</h3>
	<form name="formularioLista" action="ServletCursos" method="post">
	<ul> <% int index = 0;
		if(listaAlumnosCursado != null && listaAlumnosCursado.size() > 0){
		
		for(Alumno alumno : listaAlumnosCursado){%>
		<li><%=alumno.getNombre() %> <input type="text" name="index" value="<%=index %>" hidden/><input type="submit" name="eliminarAlumnoDeLista" value="X"></input> </li>
		<% 
		index++;} %>
	</ul>
	<input type="submit" name="btnCargarLista" value="Cargar Lista"/><% } %>
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>