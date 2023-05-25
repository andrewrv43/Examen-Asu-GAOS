package com.producto.negocio;
import java.sql.PreparedStatement;
import java.io.*;	
import java.sql.ResultSet;
import java.sql.SQLException;
import com.producto.datos.*;

public class Producto {


public Producto() {
	
}
	public String consultarTodo() {
		String sql = "SELECT * FROM tb_evento ORDER BY id_evento";
		Conexion con = new Conexion();
		String tabla = "<table class=tablaPostulantes border=1><th>ID</th><th>Titulo</th>";
		ResultSet rs = null;
		rs = con.Consulta(sql);
		try {
			while (rs.next()) {
				tabla += "<tr><td>" + rs.getInt(1) + "</td>" + "<td>" + rs.getString(3) + "</td>"
								+ "<td> <a href= editP.jsp?cod=" + rs.getInt(1) + " a><pre style=\"text-align:center\">Modificar</pre></a></td>"
								+ "<td> <a href= eliminar.jsp?cod=" + rs.getInt(1) + "><pre style=\"text-align:center\">Eliminar</pre></a></td>"
										
								+ "</tr>";

				
			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla += "</table>";
		return tabla;
	}

	public String buscarProductoCategoria(int cat)
	{
	String sentencia="SELECT nombre_pro, valor FROM tb_productos WHERE id_cat="+cat;
	Conexion con=new Conexion();
	ResultSet rs=null;
	String resultado="<table border=3>";
	try
	{
	rs=con.Consulta(sentencia);
	while(rs.next())
	{
	resultado+="<tr><td>"+ rs.getString(1)+"</td>"
	 + "<td>"+rs.getDouble(2)+"</td></tr>";
	}
	resultado+="</table>";
	}
	catch(SQLException e)
	{
	System.out.print(e.getMessage());
	}
	System.out.print(resultado);
	return resultado;
	}
	public String mostrarTodo() {
		String sql = "SELECT * FROM tb_productos ORDER BY id_producto";
		Conexion con = new Conexion();
		String tabla = "<div class=\"productos\">";
		ResultSet rs = null;
		rs = con.Consulta(sql);
		try {
			int i=0;
			while (rs.next()) {
				System.out.println(rs.getString(3).replaceAll(" ","").trim());
				tabla += "<div class=\"pro\"><img src=\"images/productos/"+rs.getString(3).replaceAll(" ","").trim()+".png\"><br><h3>" + rs.getString(3) + "</h3><br><p>"+rs.getDouble(5)+ "</div>";
				i++;
				if(i==3) {
					tabla+="</div><div class=\"productos\">";
				i=0;
				}
			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla += "</div>";
		return tabla;
	}
	public String mostrarOferta() {
		String sql = "SELECT * FROM tb_productos WHERE oferta=1 ORDER BY id_producto";
		Conexion con = new Conexion();
		String tabla = "<div class=\"productos\">";
		ResultSet rs = null;
		rs = con.Consulta(sql);
		try {
			int i=0;
			while (rs.next()) {
				System.out.println(rs.getString(3).replaceAll(" ","").trim());
				tabla += "<div class=\"pro\"><img src=\"images/productos/"+rs.getString(3).replaceAll(" ","").trim()+".png\"><br><h3>" + rs.getString(3) + "</h3><br><p>Precio con Oferta:"+rs.getDouble(9)+ "</p><br>"
						+ "<p><s>Precio con Normal:"+rs.getDouble(5)+ "</s></p></div>";
				i++;
				if(i==3) {
					tabla+="</div><div class=\"productos\">";
				i=0;
				}
			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla += "</div>";
		return tabla;
	}
	

	
	
	
	public boolean eliminarProducto(int cod) {
		Conexion obj= new Conexion();
		ResultSet rs=null;
		String sql="delete from tb_productos where id_producto='"+cod+"';";
		try {
			obj.Consulta(sql);
			return true;
		} catch(Exception e) {
			return false;
		}
		
		
	}
	
	public String ingresarProducto(int cat,String nombre, int cantidad, double precio,
			String directorio)
			{
		System.out.println("adios "+cat+"hola\n");
			String result="";
			Conexion con=new Conexion();
			PreparedStatement pr=null;
			String sql="INSERT INTO tb_productos (id_cat,"
			+ "nombre_pro,cantidad_pro,valor,descripcion,foto) "
			+ "VALUES("+cat+",'"+nombre+"',"+cantidad+","+precio+",'ProductoIngresadoPorWeb','"+directorio+"')";
			
			con.Ejecutar(sql);
//			try{
//			pr=con.getConexion().prepareStatement(sql);
//			//pr.setInt(1,id);
//			pr.setInt(1,cat);
//			pr.setString(2, nombre);
//			pr.setInt(3, cantidad);
//			pr.setDouble(4, precio);
//			pr.setString(5, nombre);
//			File fichero=new File(directorio);
//			FileInputStream streamEntrada=new FileInputStream(fichero);
//			pr.setBinaryStream(6, streamEntrada,(int)fichero.length());
//			if(pr.executeUpdate()==1)
//			{
//			result="Inserción correcta";
//			}
//			else
//			{
//			result="Error en inserción";
//			}
//			}
//			catch(Exception ex){
//				result=ex.getMessage();
//			}
//			finally
//			{
//			try
//			{
//			pr.close();
//			con.getConexion().close();
//			}
//			catch(Exception ex)
//			{
//			System.out.print(ex.getMessage());
//			}
//			}
			return result;
			}
	
	
	public void oferta(int cod){
		Conexion obj= new Conexion();
		ResultSet rs=null;
		String sql="";//"update tb_productos set \"precioOferta\"=valor*0.4 where id_producto='"+cod+"';";
		//obj.Ejecutar(sql);
		System.out.println(cod);
		try {
			sql="select oferta from tb_productos where id_producto='"+cod+"';";
			rs=obj.Consulta(sql);
			while(rs.next()) {
				if(rs.getInt(1)==0) {
					sql="update tb_productos set oferta=1 where id_producto='"+cod+"';";
					obj.Ejecutar(sql);
					sql="update tb_productos set \"precioOferta\"=valor*0.4 where id_producto='"+cod+"';";
					obj.Ejecutar(sql);
					return;
				}
				else {
					sql="update tb_productos set oferta=0 where id_producto='"+cod+"';";
					obj.Ejecutar(sql);
					sql="update tb_productos set \"precioOferta\"=valor where id_producto='"+cod+"';";
					obj.Ejecutar(sql);
					return;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
