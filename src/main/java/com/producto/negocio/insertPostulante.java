package com.producto.negocio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;
import java.sql.SQLException;
import com.producto.datos.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig
@WebServlet("/newPostulante")
public class insertPostulante extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 try {
		Conexion obj= new Conexion(); 
		ResultSet rs=null;
		String nombre=request.getParameter("nombre");
		String correo=request.getParameter("correo");
		String us_login=request.getParameter("usuario");
		String pass=request.getParameter("clave");
		String cedula=request.getParameter("cedula");
		
		    File archivoPDF = new File("C:\\Users\\paulr\\Downloads\\"+request.getParameter("pdf"));
            byte[] pdfBytes = new byte[(int) archivoPDF.length()];
		    	    
		    System.out.println(archivoPDF);
		
		InputStream inputStream=null;
		
		PreparedStatement ps;

        String sql = "insert into tb_usuario (id_perfil,nombre,correo,us_login,password,cedula,pdf) values (?,?,?,?,?,?,?)";
 
       
        	ps=obj.getConexion().prepareStatement(sql);
			ps.setInt(1,3);
			ps.setString(2, nombre);
	        ps.setString(3, correo); 
	        ps.setString(4, us_login);
	        ps.setString(5, pass);
	        ps.setString(6, cedula);
	        ps.setBytes(7,pdfBytes);
	        
			System.out.println(sql);
				ps.executeUpdate();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
        
			response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	 
	
	
}