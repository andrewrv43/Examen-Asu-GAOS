<!DOCTYPE html>
<html>
    <head>
            <%@
page language="Java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="true" import="com.producto.negocio.*" import="com.producto.seguridad.*"%>
        <charset meta="utf-8"> </charset>
        <title>MENU-GAOS</title>
        <!-- PARA HACER LINKS HOJAS DE ESTILO CSS-->
        <link href="css/todo.css" rel="stylesheet" type="text/css">
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
            


<div class="register-box" id="caja-registro">
  <h2>REGISTRO DE USUARIO</h2>
  <form action="newPostulante" method="Post" enctype="multipart/form-data">
    <div class="user-box">
      <input type="text" name="nombre" required>
      <label>Nombre</label>
    </div>
    <div class="user-box">
      <input type="email" name="correo" required>
      <label>Correo</label>
    </div>
    <div class="user-box">
      <input type="text" name="cedula" required>
      <label>Cedula</label>
    </div>
    <div class="user-box">
      <input type="text" name="usuario" required>
      <label>Usuario</label>
    </div>
    <div class="user-box">
      <input type="password" name="clave" required>
      <label>Contraseņa</label>
    </div>
    <div class="user-box">
    <p style="color: white">Hoja de Vida</p>
      <input type="file" name="pdf" accept=".pdf" required>   
    </div>
   <div class="botonesLogin">
    <input id="btnLogin" type="submit" value="POSTULAR">   
    </div> 
  </form>
</div>     
    </body>
</html>