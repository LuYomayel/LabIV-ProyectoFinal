<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Materia" %>
<%@page import="Entidad.Docente" %>
<%@page import="Entidad.Alumno" %>
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Docente" %>
<%@page import="Entidad.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" href="Css/MenuAgregarProfesor.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Agregar cursado</title>
</head>
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
<body>
	<%
		ArrayList<Materia> list = null;
		if (request.getAttribute("listaMaterias")!=null)
		{
		list = (ArrayList<Materia>) request.getAttribute("listaMaterias");
		}
		ArrayList<Docente> listaDocente = null;
		if (request.getAttribute("listaDocente")!=null)
		{
			listaDocente = (ArrayList<Docente>) request.getAttribute("listaDocente");
		}
	%>
	<div class="container">
	<h1 class="text-center">Cargar Curso</h1>
	<form method="post" action="ServletCursos" class="">
						
						<label>Materias: </label>
						<select id ="Materias" name="Materias" style="width: 148px ; ">  
							<option value=null selected disabled hidden>Elegir una Materia</option>
						     	<% 
						     	if (list!= null)
					     		for(Materia t : list){
					    	 	%>	
								<option value=<%= t.getIdMateria() %> name="idMateria"><%= t.getNombreMateria()%> </option>
								<% } %>
						</select>
						<br>
						<label>Semestre</label>
						<select id ="Semestre" name="semestre" style="width: 148px ; ">
							<option value=1 >1er Semestre </option>
							<option value=2 >2do Semestre </option>
						</select>
						<br>
						<label>Año:</label>
						<input type="number" placeholder="Año" name="anio"/>
						<br>
						<label>Docentes: </label>
						<select id ="Docentes" name="Docentes" style="width: 148px ; ">  
							<option value=null selected disabled hidden>Elegir Docente</option>
						     	<% 
						     	if (listaDocente!= null)
					     		for(Docente t : listaDocente){
					    	 	%>	
								<option value=<%= t.getId() %> name="idDocente"><%= t.getNombre() + " " + t.getApellido()%> </option>
								<% } %>
						</select>
						<br>
						<label>Lista de Alumnos: </label>	
						<select id ="Alumnos" name="Alumnos" style="width: 148px ; ">  
							
						     	<% 
						     	ArrayList<Alumno> listaAlumnosCursado = new ArrayList<Alumno>();
						     	if(session.getAttribute("listaAlumnosACursado") != null){
						     		
						     		listaAlumnosCursado = (ArrayList<Alumno>) session.getAttribute("listaAlumnosACursado");
						     	}
						     	if (listaAlumnosCursado!= null)
					     		for(Alumno t : listaAlumnosCursado){
					    	 	%>	
								<option value=<%= t.getId() %> ><%= t.getNombre() + " " + t.getApellido()%> </option>
								<% } %>
						</select>		
						<a href="ServletCursos?AgregarAlumnos=1">Agregar alumnos a cursado</a>
						<br>
						<input type="submit" value="Cargar Curso" name="btnCargarCurso"/>
	</form>
	<%
			int estado=0;
			if(request.getAttribute("estadoAgregar") != null)
				estado = (int)request.getAttribute("estadoAgregar");
		%>
		<% if(estado == 1){ %>
			<b>¡Curso agregado con exito! </b>
			<%} if(estado==-1){ %>
			<b>¡No se pudo agregar el curso, debe completar todos los campos! </b>
			<%}%>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>