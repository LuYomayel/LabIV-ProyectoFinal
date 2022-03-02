<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Materia" %>
<%@page import="Entidad.Docente" %>
<%@page import="Entidad.Alumno" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" href="Css/MenuAgregarProfesor.css" />
<title>Agregar cursado</title>
</head>
<header>
   	 <nav class="menu">
               <ul><% if((int)session.getAttribute("sesion") == 2){ %>
                       <li style="width: 276px; "><a href="#"><p align="left">Profesores</p></a>
                       <ul id="desple">
                               <li><a href="ServletDocente?Agregar=1"><p align="left">Agregado de Profesor</p></a></li>
                               <li><a href="ServletDocente?Param=1"><p align="left">Listado de Profesores</p></a></li>
                               <li><a href="ServletDocente?Modificar=1"><p aling="left"> Modificar Profesores</p> </a> </li>
                           </ul>
                           
                           </li><li style="width: 292px; "><a href="#"><p align="left">Alumnos</p></a>
                       <ul id="desple">
                               <li><a href="ServletAlumno?Agregar=1"><p align="left">Agregado de Alumno</p></a></li>
                               <li><a href="ServletAlumno?Param=1"><p align="left">Listado de alumnos</p></a></li>
                               <li><a href="ServletAlumno?Modificar=1"><p aling="left"> Modificar Alumnos</p> </a> </li>
                           </ul>
                           </li>
                       <% } %>
                       <li style="width: 335px; "><a href="ServletCursos?Listar=1"><p align="left">Cursos</p></a>
                       <ul id="desple">
                       <% if((int)session.getAttribute("sesion") == 2){ %>
                               <li><a href="ServletCursos?Agregar=1"><p align="left">Agregado de cursado</p></a></li>
                               <li><a href="#"><p align="left">Agregar Alumnos a cursado</p></a></li>
                           <% } %></ul>
                           </li>
                       <li><a href="#"><p align="left" style="width: 286px; ">Cerrar Sesion</p></a></li>
               </ul>
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
	<form method="post" action="ServletCursos">
						<h1>Cargar Curso</h1>
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
								<option value=<%= t.getId() %> ><%= t.getNombre() + " " + t.getApellido() + t.getId()%> </option>
								<% } %>
						</select>		
						<a href="ServletCursos?AgregarAlumnos=1">Agregar alumnos a cursado</a>
						<br>
						<input type="submit" value="Cargar Curso" name="btnCargarCurso"/>
	</form>
</body>
</html>