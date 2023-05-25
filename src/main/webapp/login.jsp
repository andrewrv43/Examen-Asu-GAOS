<!doctype html>
<html lang="en">
  <head>
   <%@
page language="Java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="true" import="com.producto.negocio.*" import="com.producto.seguridad.*"%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/todo.css">
  </head>
  <body id=bod>

<header>
  <div class="logo">
    <a href="index.jsp"><img src="imagenes/logo2.png" alt="Nombre de la empresa">
    <h1>GAOS</h1>
    </a>
  </div>
  <div class="links">
    <table>
      <tr>
        <td><a href="eventos.jsp">EVENTOS</a></td>
        <td><a href="contacto.jsp">CONTACTANOS</a></td>
        <% HttpSession sesion = request.getSession();
        if(sesion.getAttribute("usuario")==null){
        %>
        <td><a href="login.jsp">INICIAR SESION</a></td>
       <% }
       else{%> 
       <td><a href="perfil.jsp">PERFIL</a></td>
       <%} %>
      </tr>
    </table>
  </div>
</header>
<div id="bg"></div>
<div class="login-box">
  <h2>INICIO DE SESION</h2>
  <form method="post" action="verificarLogin.jsp">
    <div class="user-box">
      <input type="text" name="usuario" required>
      <label>Usuario</label>
    </div>
    <div class="user-box">
      <input type="password" name="clave" required>
      <label>Contraseña</label>
    </div>
   <div class="botonesLogin">
    <input id="btnLogin" type="submit" value="INICIAR">
    <br>
    <p style="color: white">Si no tienes cuenta, creala <a href="registro.jsp">aqui.</a></p>
    </div> 
  </form>
</div>


     </body>
</html>