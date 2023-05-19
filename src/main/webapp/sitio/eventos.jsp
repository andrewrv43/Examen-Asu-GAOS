<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GAOS-PRINCIPAL</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/todo.css">
  </head>
  <body>

<header>
<%@
page language="Java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="true" import="com.producto.negocio.*" import="com.producto.seguridad.*"%>
  <div class="logo">
    <a href="index.jsp"><img src="imagenes/logo2.png" alt="Nombre de la empresa">
    <h1>GAOS</h1>
    </a>
  </div>
  <div class="links">
    <table>
      <tr>
        <td><a href="#">EVENTOS</a></td>
        <td><a href="#">CONTACTANOS</a></td>
        <td><a href="login.jsp">INICIAR SESION</a></td>
      </tr>
    </table>
  </div>
</header>

<div class="nuevoEvento">
<div class="inEvento" style="color: white">
<h1>TITULO</h1>
<p>dsfasdfasdfasdfsadfsadfsdjhfgasdjhfagsdjfhgasdfkjhsdgfjasdhgfaskdjfksadfgasdfjhgdsfjhsagdfjksdgfajksdhfgasjdhfgasjkdhfgasdkjhfgasdkjhfgasdjhfgasdjkhfgaksdjhfgksadjhf</p>
</div>
<img alt="NombreEvento" src="imagenes/img2.jpg">
</div>


<%
Evento ev=new Evento();
out.print(ev.todoEvento());
%>

     <footer>
  <div class="container">
    <div class="row">
      <div class="col">
        <h3>Atención al cliente</h3>
        <table>
          <tr>
            <td><a href="#">Preguntas frecuentes</a></td>
          </tr>
          <tr>
            <td><a href="#">Contacto</a></td>
          </tr>
        </table>
      </div>
      <div class="col">
        <h3>Síguenos en redes sociales</h3>
        <img src="imagenes/facebook.png" width="50px" height="50px" alt="Facebook">
        <img src="imagenes/twitter.png" width="50px" height="50px" alt="Twitter">
        <img src="imagenes/insta.png" width="50px" height="50px" alt="Instagram">
      </div>
      <div class="col">
        <a href="#" class="btn">Iniciar sesión</a>
      </div>
    </div>
  </div>
</footer>
     
     </body>
</html>