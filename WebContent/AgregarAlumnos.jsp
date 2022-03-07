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
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Docente" %>
<%@page import="Entidad.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Alumnos</title>

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
				            
				            
				          </ul>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link " href="ServletMaterias?Materias=1" id="navbarScrollingDropdown" role="button">
				            Materias
				          </a>
				          
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
	<% 
	
	int legajo=1000;
	if(request.getAttribute("legajo")!=null)
	{
		legajo = (int)request.getAttribute("legajo");
	}

 	%>
 	<%
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
	<div class="container">
	<h1 class=""><p align="center";"><b>Agregar Alumnos </b> </p></h1>
	
	<form action="ServletAlumno" method="post" class="w-25" name="ejemplo2" id="form">
		<div class="mb-3">
		   <label  class="form-label" >Legajo</label>
		   <input type="text" class="form-control" value="<%=legajo%>" readonly="true" name="Legajo">
		 </div>
		 
		 <div class="mb-3">
		   <label  class="form-label">Documento</label>
		   <input type="number" class="form-control" name="txtDni">
		 </div>
		 
		 <div class="mb-3">
		   <label  class="form-label">Nombre</label>
		   <input type="text" class="form-control" name="txtNombre">
		 </div>
		 
		 <div class="mb-3">
		   <label  class="form-label">Apellido</label>
		   <input type="text" class="form-control" name="txtApellido">
		 </div>
		 
		 <div class="mb-3">
		   <label  class="form-label">Fecha de Nacimiento</label>
		   <input type="text" class="form-control" name="txtFecha">
		   <div  class="form-text">dd/mm/aaaa</div>
		 </div>
		 
		 <div class="mb-3">
		 <label name="txtNacionalidad" class="form-label">Nacionalidad</label>
		 <select class="form-select" name="Nacionalidad">
		  <option value=null selected>Elegir un pais</option>
		  	<% if (list!= null)
     		for(Pais t : list){
    	 	%>	
			<option value=<%= t.getIdPais() %> ><%= t.getDescripcionPais()%> </option>
			<%} %>
		</select>
		</div>
		<% if(listprov != null){ %>
		<div class="mb-3">
		 <label name="txtProvincia" class="form-label">Provincia</label>
		 <select class="form-select" name="Provincia">
		  <option value=null selected disabled hidden>Elegir una Provincia</option>
     		<% if(listprov!=null)
     		for(Provincia t : listprov){
    	 	%>
			<option value=<%= t.getIdProvincia() %>><%=t.getDescripcionProv()%></option>
			<%} %>
			</select>
			</div>
		<% } %>
		<% if(listLocalidad!=null){ %>
		<div class="mb-3">
		 <label name=txtLocalidad class="form-label">Localidad</label>
		 <select class="form-select" name="Localidad">
		  <option value=null selected disabled hidden>Elegir una Localidad</option>
		     <% if(listLocalidad!=null)
	     	for(Localidad t : listLocalidad){ %>
			<option value=<%= t.getIdLocalidad() %>><%=t.getDescripcion()%></option>
			<%} %>
		</select>
		</div>
		<% } %>
		 <div class="mb-3">
		   <label  class="form-label">Direccion</label>
		   <input type="text" class="form-control" name="txtDireccion">
		 </div>
		 
		 <div class="mb-3">
		   <label  class="form-label">Email</label>
		   <input type="email" class="form-control" name="txtEmail">
		 </div>
		 
		 <div class="mb-3">
		   <label  class="form-label">Telefono</label>
		   <input type="number" class="form-control" name="txtTelefono">
		 </div>
		 
		 <button type="submit" class="btn btn-primary mb-3" name="btnAgregar">Agregar</button>
		 </form>
	
	
	
		<%
			int estado=0;
			if(request.getAttribute("estado") != null)
				estado = (int)request.getAttribute("estado");
		%>
		<% if(estado == 1){ %>
			<b>¡Alumno agregado con exito! </b>
			<%} if(estado==-1){ %>
			<b>¡No se pudo agregar el alumno, debe completar todos los campos! </b>
			<%}%>
			</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="./Scripts/scripts.js"></script>
	<script src="./Scripts/javascript.js"></script>
</body>
</html>