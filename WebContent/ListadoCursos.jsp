<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.AlumnoDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Curso" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de cursos</title>
<link rel="Stylesheet" href="Css/ListadoAlumno.css" />
</head>
<body>
	<% 
	ArrayList<Curso> listaCursos = null;
	if(request.getAttribute("listaC")!=null)
	{
		listaCursos = (ArrayList<Curso>) request.getAttribute("listaC");
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

	<h1><p aling ="Center";"  ><b> Listado de Cursos</b></p> 
</h1>
		<table border=1> 
		<tr>
			<th>Materia</th>
			<th>Semestre</th>
			<th>Año</th>
			<th>Cantidad de alumnos</th>
		</tr>
		<%  if(listaCursos!=null)
		for(Curso curso : listaCursos) 
		{
			%>	
		<tr>
			<form name="formulario" action="ServletCursos" method="post">
					<td><%= curso.getMateria().getNombreMateria()%> <input type="hidden" name="idCurso" value="<%=curso.getId()%>"> </td>
					<td><%= curso.getSemestre()%></td>
					<td><%= curso.getAño()%></td>
					<td><%= curso.getAlumno().size() %></td>
					<%--<td><%= alumno.getIdCarrera()%></td>--%>
					<td><input type="submit" name="btnVerCurso" value="Ver Curso"></td>
			</form>
				</tr>
			<%  } %>
	</table>

	</form>
</body>
</html>