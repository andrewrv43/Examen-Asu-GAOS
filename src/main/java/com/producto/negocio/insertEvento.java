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
@WebServlet("/newEvento")
public class insertEvento extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Conexion obj= new Conexion();
		ResultSet rs=null;
		String titulo=request.getParameter("titulo");
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		String descr=request.getParameter("descr");
		InputStream inputStream=null;
		Part filePart = request.getPart("foto");
		PreparedStatement ps;
        String fileName = filePart.getSubmittedFileName();
        inputStream = filePart.getInputStream();
        String sql = "insert into tb_evento (id_tipoev,titulo,descripcion,foto) values (?,?,?,?)";
        byte[] imageBytes = inputStream.readAllBytes();
        try {
        	ps=obj.getConexion().prepareStatement(sql);
			ps.setInt(1, tipo);
			ps.setString(2, titulo);
	        ps.setString(3, descr); 
	        ps.setBytes(4, imageBytes);
			System.out.println(sql);
				ps.executeUpdate();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
        
			response.sendRedirect(request.getContextPath() + "/editarEventos.jsp");
	}

	 
	
	
}