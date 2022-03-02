<%@page import="Entidad.Docente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.DocenteDaoImpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Profesores</title>
<link rel="Stylesheet" href="Css/ListadoProfesores.css" />
</head>
<body>
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
	
</body>
</html>