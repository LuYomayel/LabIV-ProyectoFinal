<%@page import="Entidad.Alumno" %>
<%@page import="DaoImpl.PaisDaoImpl" %>
<%@page import="DaoImpl.ProvinciaDaoImpl" %>
<%@page import="DaoImpl.LocalidadDaoImpl" %>
<%@page import="Entidad.Pais" %>
<%@page import="Entidad.Provincia" %>
<%@page import="Entidad.Localidad" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import ="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="Entidad.Alumno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifcar alumnos</title>
<link rel="Stylesheet" href="Css/ModificarAlumno.css" />
</head>
<body>	

	<% 
	ArrayList<Alumno> listaAlumnos = null;
	if(request.getAttribute("listaA")!=null || request.getAttribute("Modificar")!= null)
	{
		listaAlumnos = (ArrayList<Alumno>) request.getAttribute("listaA");
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

	<h1><p aling ="Center";"  ><b> Modificar Alumno</b></p> 
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
			<th>MODIFICAR</th>
		</tr>
			<% PaisDaoImpl paisDao = new PaisDaoImpl();
				ProvinciaDaoImpl provinciaDao = new ProvinciaDaoImpl();
				LocalidadDaoImpl localidadDao = new LocalidadDaoImpl();
   		ArrayList<Pais> list = null;
   		if (request.getAttribute("ListarPais")!=null)
   		{
 			list = (ArrayList<Pais>) request.getAttribute("ListarPais");
   		}
     %>
   	<%
   		ArrayList<Provincia> listprov = null;
     	if(request.getAttribute("ListarProvincia")!=null){
    		listprov= (ArrayList<Provincia>) request.getAttribute("ListarProvincia");}
     %>
  			<%				
		   		ArrayList<Localidad> listLocalidad = null;
		
		     if(request.getAttribute("ListarLocalidad")!=null){
		    	 listLocalidad = (ArrayList<Localidad>) request.getAttribute("ListarLocalidad");}
		     %>
		<%  if(listaAlumnos!=null)
		for(Alumno alumno : listaAlumnos) 
		{
			%>	
		<tr>
					<form name="formulario" action="ServletAlumno" method="post">
					<td><%= alumno.getLegajo()%> <input type="hidden" name="idAlumno" value="<%=alumno.getLegajo()%>"> </td>
					<td><input type ="text" name ="dniAlumno" value= "<%=alumno.getDni() %>"> </td>
					<td><input type ="text" name ="NombreAlumno" value= "<%=alumno.getNombre() %>"></td>
					<td><input type ="text" name ="ApellidoAlumno" value= "<%=alumno.getApellido() %>"></td>
					<td><input type ="text" name ="NacAlumno" value= "<%=alumno.getFechanacimiento() %>"></td>
					<td><input type ="text" name ="DireccionAlumno" value= "<%=alumno.getDireccion() %>"></td>
					<td>
							<select id ="Nacionalidad" name="Nacionalidad" style="width: 148px ; ">  
							
							<option value=<%= paisDao.getId(alumno.getNacionalidad()) %> selected><%= alumno.getNacionalidad() %></option>
							<% if (list!= null)
							for(Pais t : list){
							%>	
							<option value=<%= t.getIdPais() %> ><%= t.getDescripcionPais()%> </option>
							<%} %>
							</select>
					</td>
					
					<td>
							<select name="Provincia" style="width: 148px; " > 
							
							<option value=<%= provinciaDao.getId(alumno.getProvincia()) %> selected><%= alumno.getProvincia() %></option>
							<% if(listprov!=null)
								for(Provincia t : listprov){
								 
							 %>
							<option value=<%= t.getIdProvincia() %>><%=t.getDescripcionProv()%></option>
							
							<%} %>
							</select>
							</td>   
					<td>
							<select select name="Localidad" style="width: 148px; " >	
							
							<option value=<%= localidadDao.getId(alumno.getLocalidad()) %> selected><%= alumno.getLocalidad() %></option>
							<% if(listLocalidad!=null)
							for(Localidad t : listLocalidad){
							%>
							   
							<option value=<%= t.getIdLocalidad() %>><%=t.getDescripcion()%></option>
							
							<%} %>
							
							</select>
					</td>
					<td><input type ="text" name ="EmailAlumno" value= "<%=alumno.getEmail() %>"></td>
					<td><input type ="text" name ="TelefonoAlumno" value= "<%=alumno.getTelefono() %>"></td>
					<td><input type="submit" name="btnModificar" value="Modificar"></td>
					</form>
				</tr>

			<%  } %>
	</table>

	</form>
</body>

</html>