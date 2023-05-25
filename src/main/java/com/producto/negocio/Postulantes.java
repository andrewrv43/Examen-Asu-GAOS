package com.producto.negocio;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.producto.datos.*;

public class Postulantes{
	public String consultarPostulantes() {
		String sql = "SELECT * FROM tb_usuario where id_perfil=3 ORDER BY id_usuario";
		Conexion con = new Conexion();
		String tabla = "<table class=tablaPostulantes><th>ID</th><th>Nombre</th><th>Correo</th><th>Cedula</th>";
		ResultSet rs = null;
		rs = con.Consulta(sql);
		try {
			while (rs.next()) {
				tabla += "<tr><td>" + rs.getInt(1) + "</td>" + "<td>" + rs.getString(3) + "</td>"+ "<td>" + rs.getString(4) + "</td>"+ "<td>" + rs.getString(7) + "</td>"
								+ "<td> <a href= aceptar.jsp?cod=" + rs.getInt(1) + "><pre style=\"text-align:center\">ACEPTAR</pre></a></td>"
										+ "<td> <a href= eliminarPostulante.jsp?cod=" + rs.getInt(1) + "><pre style=\"text-align:center\">NEGAR</pre></a></td></tr>";

				
			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla += "</table>";
		return tabla;
	}
	public void aceptarPostulante(int cod) {
		String sql = "update tb_usuario set id_perfil=2 where id_usuario='"+cod+"';";
		Conexion con = new Conexion();
		con.Ejecutar(sql);
		
		
	}
	public void eliminarPostulante(int cod) {
		Conexion obj= new Conexion();
		ResultSet rs=null;
		String sql="delete from tb_usuario where id_usuario='"+cod+"';";
		System.out.println(sql);
			obj.Ejecutar(sql);
			
	}
}