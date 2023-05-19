<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/todo.css">
  </head>
  <body>

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
        <td><a href="#">INICIAR SESION</a></td>
      </tr>
    </table>
  </div>
</header>

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


     <footer id="active">
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