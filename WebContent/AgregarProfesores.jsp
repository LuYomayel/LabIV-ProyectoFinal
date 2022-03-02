<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Pais" %>
<%@page import="Entidad.Provincia" %>
<%@page import="Entidad.Localidad" %>
<%@page import="Entidad.Docente" %>
<%@page import="DaoImpl.PaisDaoImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="Css/MenuAgregarProfesor.css" />
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
	int legajo=1000;
	if(request.getAttribute("legajo")!=null)
		{
		legajo = (int)request.getAttribute("legajo");
		}

 	%>
	
	<h1><p align="center";" ><b>Agregar Docente </b> </p></h1>
	
		<form action="ServletDocente" method="post" class ="contenedor">
			<table>
	
				<tr>
					<td>Legajo</td><td><input type="text" name="Legajo" class="menu2" value="<%=legajo%>" readonly="true"></td>
				</tr>
				<tr>
					<td>Documento</td><td><input type="text" name="txtDni"></td>
				</tr>
				<tr>
					<td>Nombre</td><td><input type="text" name="txtNombre"></td>
				</tr>
				<tr>
					<td>Apellido</td><td><input type="text" name="txtApellido"></td>
				</tr>
				<tr>
					<td>Fecha de Nacimiento</td><td><input type="text" name="txtFecha"></td>
				</tr>
		
				<%
		   		ArrayList<Pais> list = null;
		   		if (request.getAttribute("ListarPais")!=null)
		   		{
		 			list = (ArrayList<Pais>) request.getAttribute("ListarPais");
		   		}
		     	%>
		     	<%
		   		ArrayList<Provincia> listprov = null;
		     	if(request.getAttribute("ListarProvincia")!=null)
		     	{
		    		listprov= (ArrayList<Provincia>) request.getAttribute("ListarProvincia");
	    		}
		     	%>
		     	<%				
	   			ArrayList<Localidad> listLocalidad = null;
		     	if(request.getAttribute("ListarLocalidad")!=null)
		     	{
				    	 listLocalidad = (ArrayList<Localidad>) request.getAttribute("ListarLocalidad");
				}
			     %>
	     		<tr>
					<td> Nacionalidad</td>
					<td>
						<select id ="Nacionalidad" name="Nacionalidad" style="width: 148px ; ">  
							<option value=null selected disabled hidden>Elegir un Pais</option>
						     	<% 
						     	if (list!= null)
					     		for(Pais t : list){
					    	 	%>	
								<option value=<%= t.getIdPais() %> ><%= t.getDescripcionPais()%> </option>
								<% } %>
						</select>
					</td>
				</tr>
				<tr>
					<td>Provincia</td>
					<td>
						<select name="Provincia" style="width: 148px; " > 

     						<option value=null selected disabled hidden>Elegir una Provincia</option>
   							<% 
   							if(listprov!=null)
     						for(Provincia t : listprov){
     	 
    	 					%>
							<option value=<%= t.getIdProvincia() %>><%=t.getDescripcionProv()%></option>
		
							<%} %>
						</select>
					</td>
							
				</tr>
				<tr>
					<td>Localidad</td>
					<td>
						<select select name="Localidad" style="width: 148px; " >	

		     				<option value=null selected disabled hidden>Elegir una Localidad</option>
	     					<% if(listLocalidad!=null)
		     				for(Localidad t : listLocalidad){
		    	 			%>
		     
							<option value=<%= t.getIdLocalidad() %>><%=t.getDescripcion()%></option>
				
							<%} %>

						</select>
					</td>
						
						
				</tr>
				<tr>
					<td>Direccion</td><td><input type="text" name="txtDireccion"required></td>
				</tr>
				<tr>
					<td>Email</td><td><input type="text" name="txtEmail"></td>
				</tr>
				
				<tr>
					<td>Contraseña</td><td><input type="password" name="txtContraseña"></td>
				</tr>
				
				<tr>
					<td>Telefono</td><td><input type="text" name="txtTelefono"></td>
				</tr>
				<tr>
					<td><input type="Submit" name="btnAgregar" value="AGREGAR" style="color: #000000"></td>
				</tr>
		
		</table>
	</form>
	<%
	int filas=0;
	if(request.getAttribute("fila") != null)
	filas = (int)request.getAttribute("fila");
	%>
	<% if(filas == 1){ %>
	<b>¡Alumno agregado con exito! </b>
	<%}%>
</body>
</html>