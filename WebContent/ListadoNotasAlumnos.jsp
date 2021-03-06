<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.AlumnoDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Alumno" %>
<%@page import="Entidad.Alumnoxcurso" %>
<%@page import="Entidad.Curso" %>
<%@page import="Entidad.Docente" %>
<%@page import="Entidad.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de alumnos</title>
<link rel="Stylesheet" href="Css/ListadoAlumno.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready( function () {
	    $('#tabla_id').DataTable();
	} );
	
</script>

</head>
<body>
	<% 
	Curso curso = null;
	if(request.getAttribute("Curso")!=null)
	{
		
		curso = (Curso)request.getAttribute("Curso");
		//System.out.println(curso.getId());
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
	<div class="container">
	<h1 class="text-center"><p aling ="Center";"  ><b> <%=curso.getMateria().getNombreMateria() %></b></p></h1>
		<table class="table table-primary display" id="tabla_id" > 
		<thead>
		<tr class="table-primary">
			<th class="table-primary">Legajo</th>
			<th class="table-primary">Nombre y Apellido</th>
			<th class="table-primary">Nota 1</th>
			<th class="table-primary">Nota 2</th>
			<th class="table-primary">Recuperatorio 1</th>
			<th class="table-primary">Recuperatorio 2</th>
			<th class="table-primary">Estado</th>
			<th class="table-primary"> Cargar</th>
		</tr>
		</thead>
		<tbody>	
		<%  if(curso.getListaAlumnosCurso() !=null) {
			AlumnoDaoImpl alumnoDao = new AlumnoDaoImpl();
		for(Alumnoxcurso alumno : curso.getListaAlumnosCurso()) 
		{ 
			
			Alumno alu = alumnoDao.getAlumnoId(alumno.getIdAlumno());
			
			if(alu != null){
			%>
			
		<tr class="table-primary">
			<form name="formulario" action="ServletCursos" method="post">
					<td><%= alu.getLegajo()%> <input type="hidden" name="idAlumno" value="<%=alu.getId()%>"> </td>
					<td><%= alu.getNombre() + " " + alu.getApellido()%></td>
					<td><input type="number" placeholder="nota1" name="notaParcial1" value="<%= alumno.getParcial1() %>"></td>
					<td><input type="number" placeholder="nota1" name="notaParcial2" value="<%= alumno.getParcial2() %>"></td>
					<td><input type="number" placeholder="nota1" name="notaRecuperatorio1" value="<%= alumno.getRecupera1() %>"></td>
					<td><input type="number" placeholder="nota1" name="notaRecuperatorio2" value="<%= alumno.getRecupera2() %>"></td>
					<th><%=alumno.getEstado() %></th>
					<input type="hidden" name="idCurso" value="<%=curso.getId()%>"> </td>
					 <td><input type="submit" name="btnCargarNotas" value="Cargar" class="btn btn-primary"></td>
			</form>
				</tr>
			<%  }}} else{System.out.println("alu es null");} %>
			</tbody>
	</table>

	</form>
	<hr>
	<h1 class="text-center">Agregar Nota a todos</h1>
	<form action="ServletCursos" method="post" class="w-25" name="ejemplo2" id="form">
	<div class="mb-3">
		   <label  class="form-label" >Nota 1</label>
		   <input type="number" class="form-control"    name="nGlobal1"> 
		 </div>
		 <div class="mb-3">
		   <label  class="form-label" >Nota 2</label>
		   <input type="number" class="form-control"   name="nGlobal2">
		 </div>
		 <div class="mb-3">
		   <label  class="form-label" >Recuperatorio 1</label>
		   <input type="number" class="form-control"    name="rGlobal1">
		 </div>
		 <div class="mb-3">
		   <label  class="form-label" >Recuperatorio 2</label>
		   <input type="number" class="form-control"    name="rGlobal2">
		 </div>
		 <input  name="idCurso" value="<%=curso.getId()%>" hidden> </td>
		 <button type="submit" class="btn btn-primary mb-3" name="btnCargar">Cargar</button>
	</form>
	<% if(request.getAttribute("estadoModificar")!= null){
		if((int)request.getAttribute("estadoModificar")>=1){%>
		<p>Modificado con ?xito!</p><% }%>
		<% if((int)request.getAttribute("estadoModificar") == -1){ %>
		<p>Error al modificar<p>
		<% } %> 
		<% } %>
		
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>