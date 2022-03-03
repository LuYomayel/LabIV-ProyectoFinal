<%@page import="Entidad.Docente" %>
<%@page import="DaoImpl.PaisDaoImpl" %>
<%@page import="DaoImpl.ProvinciaDaoImpl" %>
<%@page import="DaoImpl.LocalidadDaoImpl" %>
<%@page import="Entidad.Pais" %>
<%@page import="Entidad.Provincia" %>
<%@page import="Entidad.Localidad" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import ="java.util.*" %>
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Docente" %>
<%@page import="Entidad.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Profesores</title>
<link rel="Stylesheet" href="Css/ModificarAlumno.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<% 
	ArrayList<Docente> listaDocentes = null;
	if(request.getAttribute("listaD")!=null)
	{
		listaDocentes = (ArrayList<Docente>) request.getAttribute("listaD");
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

	<h1><p aling ="Center";"  ><b> Modificar Profesores</b></p> 
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
		<%  if(listaDocentes!=null)
		for(Docente docente : listaDocentes) 
		{
			%>	
		<tr>
					<form name="formulario" action="ServletDocente" method="post">
					<td><%= docente.getLegajo()%> <input type="hidden" name="idDocente" value="<%=docente.getLegajo()%>"> </td>
					<td><input type ="text" name ="dniDocente" value= "<%=docente.getDni() %>"> </td>
					<td><input type ="text" name ="NombreDocente" value= "<%=docente.getNombre() %>"></td>
					<td><input type ="text" name ="ApellidoDocente" value= "<%=docente.getApellido() %>"></td>
					<td><input type ="text" name ="NacDocente" value= "<%=docente.getFechanacimiento() %>"></td>
					<td><input type ="text" name ="DireccionDocente" value= "<%=docente.getDireccion() %>"></td>
					<td>
							<select id ="Nacionalidad" name="Nacionalidad" style="width: 148px ; ">  
							
							<option value=<%= paisDao.getId(docente.getNacionalidad()) %> selected><%= docente.getNacionalidad() %></option>
							<% if (list!= null)
							for(Pais t : list){
							%>	
							<option value=<%= t.getIdPais() %> ><%= t.getDescripcionPais()%> </option>
							<%} %>
							</select>
					</td>
					
					<td>
							<select name="Provincia" style="width: 148px; " > 
							
							<option value=<%= provinciaDao.getId(docente.getProvincia()) %> selected><%= docente.getProvincia() %></option>
							<% if(listprov!=null)
								for(Provincia t : listprov){
								 
							 %>
							<option value=<%= t.getIdProvincia() %>><%=t.getDescripcionProv()%></option>
							
							<%} %>
							</select>
							</td>   
					<td>
							<select select name="Localidad" style="width: 148px; " >	
							
							<option value=<%= localidadDao.getId(docente.getLocalidad()) %> selected><%= docente.getLocalidad() %></option>
							<% if(listLocalidad!=null)
							for(Localidad t : listLocalidad){
							%>
							   
							<option value=<%= t.getIdLocalidad() %>><%=t.getDescripcion()%></option>
							
							<%} %>
							
							</select>
					</td>
					<td><input type ="text" name ="EmailDocente" value= "<%=docente.getEmail() %>"></td>
					<td><input type ="text" name ="TelefonoDocente" value= "<%=docente.getTelefono() %>"></td>
					<td><input type="submit" name="btnModificar" value="Modificar"></td>
					</form>
				</tr>

			<%  } %>
	</table>

	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>