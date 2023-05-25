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
@WebServlet("/updateEvento")
public class updateEventos extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Conexion obj= new Conexion();
		PreparedStatement ps;
		ResultSet rs=null;
		String titulo=request.getParameter("editarTitulo");
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		String descr=request.getParameter("editarDescr");
		InputStream inputStream=null;
		Part filePart = request.getPart("foto");
		if(filePart!=null) {
			
	        String fileName = filePart.getSubmittedFileName();
	        inputStream = filePart.getInputStream();
	        String sql = "update tb_evento set titulo=?,descripcion=?,id_tipoev=?,foto=? where id_evento="+request.getParameter("editarID")+";";
	        byte[] imageBytes = inputStream.readAllBytes();
	        try {
	        	ps=obj.getConexion().prepareStatement(sql);
	        	ps.setString(1, titulo);
		        ps.setString(2, descr); 
	        	ps.setInt(3, tipo);
		        ps.setBytes(4, imageBytes);
				System.out.println(sql);
					ps.executeUpdate();
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			String sql = "update tb_evento set titulo='"+titulo+"',descripcion='"+descr+"',id_tipoev="+tipo+" id_evento="+request.getParameter("editarID")+";";
	        try {

					obj.Ejecutar(sql);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		response.sendRedirect(request.getContextPath() + "/editarEventos.jsp");
	}

	 
	
	
}