<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.AlumnoDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Alumno" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de alumnos</title>
<link rel="Stylesheet" href="Css/ListadoAlumno.css" />
</head>
<body>
	<% 
	Curso curso = null;
	if(request.getAttribute("Curso")!=null)
	{
		
		curso = (Curso)request.getAttribute("Curso");
		System.out.println(curso.getId());
	}

	 %>

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

	<h1><p aling ="Center";"  ><b> Listar Alumno</b></p> 
</h1>
		<table border=1> 
		<tr>
			<th>Legajo</th>
			<th>Nombre y Apellido</th>
			<th>Nota 1</th>
			<th>Nota 2</th>
			<th>Recuperatorio 1</th>
			<th>Recuperatorio 2</th>
			<th>Estado</th>
		</tr>
		<%  if(curso.getAlumno() !=null)
		for(Alumno alumno : curso.getAlumno()) 
		{
			%>	
		<tr>
			<form name="formulario" action="ServletAlumno?idAlumno=<%=alumno.getLegajo()%>" method="post">
					<td><%= alumno.getLegajo()%> <input type="hidden" name="idAlumno" value="<%=alumno.getLegajo()%>"> </td>
					<td><%= alumno.getNombre() + " " + alumno.getApellido()%></td>
					<td>10</td>
					<td>7</td>
					<td>0</td>
					<td>0</td>
					<th>Estado</th>
					
					<td><input type="submit" name="btnEliminar" value="Eliminar"></td>
			</form>
				</tr>
			<%  } %>
	</table>

	</form>
</body>
</html>