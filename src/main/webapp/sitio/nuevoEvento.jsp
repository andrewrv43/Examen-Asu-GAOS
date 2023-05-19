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
        <td><a href="login.jsp">INICIAR SESION</a></td>
      </tr>
    </table>
  </div>
</header>
            

<%
String usuario;
HttpSession sesion = request.getSession();
 if (sesion.getAttribute("usuario") == null) //Se verifica si existe la variable
 {
 %>
 <jsp:forward page="login.jsp">
 <jsp:param name="error" value="Debe registrarse en el sistema."/>
 </jsp:forward>
 <%
 }
 else
 {
 usuario=(String)sesion.getAttribute("usuario"); //Se devuelve los valores de atributos
 int perfil=(Integer)sesion.getAttribute("perfil");
  %>
 
            
<form action="nEvento.jsp" method="post" style="color: white">
<table>
<tr>
<td>Categoria</td>
<td> <input type="text" name="tipo" required/> </td>
</tr>
<tr>
<td>Titulo</td>
<td> <input type="text" name="titulo" required/> </td>
</tr>
<tr>
<td>Descripcion</td>
<td><input type="text" name="descr" required/></td>
</tr>
<tr>
<td>Path Foto</td>
<td><input type="text" name="editarPath" required/></td>
</tr>

</table>

<br>
<br>
<input type="submit" name="Actualizar"> 

</form>




<%
}
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