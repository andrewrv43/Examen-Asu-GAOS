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
            

<%
String usuario;
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
 
 int cod = Integer.parseInt(request.getParameter("cod"));
Evento pro=new Evento();
 pro.ConsulEditarProductos(cod);
  
 %>
 
            
<form class="otroForm" action="updateEvento" method="Post" style="color: white" enctype="multipart/form-data">
<table class="editEv">
<tr>
<td>ID Evento</td>
<td><input type="text" name="editarID" readonly="readonly" value="<%=pro.getId()%>"/></td>
</tr>
<tr>
<td>Categoria</td>
<td> 
<%categoria cat=new categoria();
out.print(cat.mostrarCategoriaEvento());
%>
 </td>
</tr>
<tr>
<td>Titulo</td>
<td> <input type="text" name="editarTitulo" value="<%=pro.getTitulo()%>"/> </td>
</tr>
<tr>
<td>Descripcion</td>
<td><input type="text" name="editarDescr" value="<%=pro.getDescr()%>"/></td>
</tr>
<tr>
<td>Foto</td>
<td><input type="file" name="foto" accept=".jpg"/></td><td>
<%out.print(pro.impFoto(pro.getId())); %>
</td>
</tr>

</table>

<br>
<br>
<input type="submit" value="Actualizar"> 

</form>
<div class="aside-container">
        <aside>
            <% 
                Pagina pag = new Pagina();
                String menu = pag.mostrarMenu(perfil);
                out.print(menu);
            %>
        </aside>
        </div>



 <br>
<br><br>
<br><br>
<br><br>
<br><br>
<br>
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