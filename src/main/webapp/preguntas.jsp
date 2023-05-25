<!doctype html>
<html lang="en">
  <head>
          <%@
page language="Java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="true" import="com.producto.negocio.*" import="com.producto.seguridad.*"%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GAOS-PRINCIPAL</title>
    
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
        <td><a href="#">CONTACTANOS</a></td>
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
  
  <div id="preguntas">
  <table>
    <tr>
      <th id="pre">Pregunta</th>
      <th id="res">Respuesta</th>
    </tr>
    <tr>
      <td>¿Quiénes somos?</td>
      <td>GAOS es un grupo ASU de la Universidad Politecnica Salesiana que anteriormente estaban dedicados a actividades sociales, sin embargo actualmente hemos cambiado de enfoque, ahora programamos tanto para ayudar como divertirnos, creamos juegos actividades y damos soporte a mas organizaciones</td>
    </tr>
    <tr>
      <td>Actividades</td>
      <td>Tenemos actividades sociales y abiertas para todos, pues estamos creando nuestro primer videojuego, para poder ganar experiencia, y tambien damos asistencia de software al colegio Don Bosco</td>
    </tr>
    <tr>
      <td>Enfoque</td>
      <td>Estudia, recrearnos, recrearnos y ganar experiencia</td>
    </tr>
  </table>
</div>
  
  
  
  
 <br>
<br><br>
<br><br>


      <footer>
  <div class="container">
    <div class="row">
      <div class="col">
        <h3>Atención al cliente</h3>
        <table>
          <tr>
            <td><a href="preguntas.jsp">Preguntas frecuentes</a></td>
          </tr>
          <tr>
            <td><a href="contacto.jsp">Contacto</a></td>
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
        <a href="login.jsp" class="btn">Iniciar sesión</a>
      </div>
    </div>
  </div>
</footer>
     
     
     
     </body>
</html>