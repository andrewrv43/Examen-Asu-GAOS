<!DOCTYPE html>
<html>
    <head>
            <%@
page language="Java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="true" import="com.producto.negocio.*" import="com.producto.seguridad.*"%>
        <charset meta="utf-8"> </charset>
        <title>GAOS</title>
        <!-- PARA HACER LINKS HOJAS DE ESTILO CSS-->
        <link href="css/estilo.css" rel="stylesheet" type="text/css">

<%
Usuario usuario=new Usuario();
String nlogin=request.getParameter("usuario");
String nclave=request.getParameter("clave");
HttpSession sesion=request.getSession(); //Se crea la variable de sesi�n
boolean respuesta=usuario.verificarUsuario(nlogin,nclave);
if (respuesta)
{
sesion.setAttribute("usuario", usuario.getNombre()); //Se a�ade atributos
sesion.setAttribute("perfil", usuario.getPerfil()); //Se a�ade atributos
response.sendRedirect("perfil.jsp"); //Se redirecciona a una p�gina espec�fica
}
else
{
%>
<jsp:forward page="login.jsp">
<jsp:param name="error" value="Datos incorrectos.<br>Vuelva a intentarlo."/>
</jsp:forward>
<%
}
%>

    </body>
</html>