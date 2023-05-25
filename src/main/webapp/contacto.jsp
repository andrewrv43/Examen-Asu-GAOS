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
  <div class="contact-container">
    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15959.080008401645!2d-78.5496183!3d-0.2819792!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x91d598bb780cdf8f%3A0x71cbab6b6dcb5b6a!2sUniversidad%20Polit%C3%A9cnica%20Salesiana%20-%20Campus%20Sur!5e0!3m2!1ses-419!2sec!4v1685023449621!5m2!1ses-419!2sec" width="500" height="500" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    <div class="contact-info">
      <h2>Información de Contacto</h2>
      <p>Teléfono: +593 99 566 8656</p>
      <p>Email: aruedav@est.ups.edu.ec</p>
      <p>Dirección: PF92+652, Av. y Av. Rumichaca Ñan, Av. Moran Valverde, Quito 170146</p>
    </div>
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