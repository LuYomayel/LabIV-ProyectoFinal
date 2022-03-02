<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<link rel="Stylesheet" href="Css/Login.css" />

<link rel="Stylesheet" href="Css/Normalize.css" />
</head>
<body>
	<form action="ServletLogin" method="post" class="form-login">
      <h5>Iniciar Sesion</h5>
      <input class="controls" type="text" name="usuario" value="" placeholder="Usuario">
      <input class="controls" type="password" name="contrasena" value="" placeholder="Contraseña">
      <input class="buttons" type="submit" value="Ingresar" name="btnAceptar">
     
      <% if(request.getAttribute("error")!=null){ 
      if(!(boolean)request.getAttribute("error")) {%>
      <label id="lblError">Usuario o contraseña incorrecto</label>
		<% }} %>
    
    </form>

</body>
</html>