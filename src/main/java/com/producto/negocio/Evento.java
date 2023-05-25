package com.producto.negocio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;
import java.sql.SQLException;
import com.producto.datos.*;
import javax.servlet.ServletException;

import javax.servlet.http.Part;


public class Evento {
	private int id,tipo;
	private String titulo,descr,path;
		

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String todoEvento() {
		String sql = "SELECT * FROM tb_evento ORDER BY id_evento";
		Conexion con = new Conexion();
		String tabla = "";
		ResultSet rs = null;
		rs = con.Consulta(sql);
		
		try {
			while (rs.next()) {
				tabla += "<div class=\"nuevoEvento\">"
						+ "<div class=\"inEvento\" style=\"color: white\">"
						+ "<h1>"+rs.getString(3)+"</h1>"
						+ "<p>"+rs.getString(4)+"</p>\r\n"
						+ "</div>\r\n"
						+ "<img alt=\""+rs.getString(3)+"\" src=\"imagenes/"+rs.getString(5)+"\">"
						+ "</div>";
				
			}
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return tabla;
	}
	
	
	
	public void ConsulEditarProductos(int cod) {
		Conexion obj= new Conexion();
		ResultSet rs=null;
		String sql="select id_evento,id_tipoev,titulo,descripcion,foto from tb_evento where id_evento="+cod+";";
		System.out.println(sql);
		try {
			rs=obj.Consulta(sql);
			while(rs.next()) {
				setId(rs.getInt(1));
				setTipo(rs.getInt(2));
				setTitulo(rs.getString(3));
				setDescr(rs.getString(4));
				setPath(rs.getString(5));
			}
		} catch(Exception e) {
			
		}
		
	}

	public Evento(Integer id,Integer tipo,String titulo,String descr,String path) {
		setId(id);
		setTipo(tipo);
		setTitulo(titulo);
		setDescr(descr);
		setPath(path);
		
		System.out.println("\n"+getId()+"\n"+getTipo()+"\n"+getTitulo()+"\n"+getDescr()+"\n"+getPath()+"\n");
	}
	public Evento() {
		
	}
	public boolean modificarEvento(Integer id,Integer tipo,String titulo,String descr,String path) {
		Conexion obj= new Conexion();
		ResultSet rs=null;
		System.out.println(tipo+"id:"+id);
		String sql="UPDATE tb_evento SET titulo='"+titulo+"', id_tipoev='"+tipo+"', "
				+ "descripcion= '"+descr+"', path_foto='"+path+"' WHERE id_evento='"+id+"';";
		try {
			obj.Consulta(sql);

			return true;
		} catch(Exception e) {
			return false;
		}
		
		
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
	
	
	public void editarProductos(int cod) {
		Conexion obj= new Conexion();
		ResultSet rs=null;
		String sql="select id_producto,id_cat,nombre_pro,cantidad_pro,valor from tb_productos where id_producto="+cod+";";
		try {
			rs=obj.Consulta(sql);
			while(rs.next()) {

			}
		} catch(Exception e) {
			
		}
		
	}

	public void eliminarEvento(int cod) {
		Conexion obj= new Conexion();
		ResultSet rs=null;
		String sql="delete from tb_evento where id_evento='"+cod+"';";
		System.out.println(sql);
			obj.Ejecutar(sql);
			
	}
	
	public String consultarEvento() throws IOException {
        String sql = "SELECT * FROM tb_evento ORDER BY id_evento desc";
        Conexion con = new Conexion();
        String tabla = "";
        ResultSet rs = null;
        rs = con.Consulta(sql);
        String demas="C:\\Users\\paulr\\Documents\\eclipse-work\\ASUS_EXAMEN_GAOS\\src\\main\\webapp";
        String result="";
        File tempFile;
        FileOutputStream fos;
        int cont=0;

        try {
            while (rs.next()) {
                tempFile = new File(demas+"\\imagenes\\temporales\\"+rs.getString(3).replaceAll(" ", "")+".jpg");
                fos = new FileOutputStream(tempFile);
                byte[] foto = rs.getBytes("foto");
                fos.write(foto); 
                fos.close();
                System.out.println(tempFile.getAbsolutePath());
                tabla += "<div class=\"nuevoEvento\">"
						+ "<div class=\"inEvento\" style=\"color: white\">"
						+ "<h1>"+rs.getString(3)+"</h1>"
						+ "<p>"+rs.getString(4)+"</p>\r\n"
						+ "</div>\r\n"
						+ "<img src='imagenes/temporales/"+rs.getString(3).replaceAll(" ", "")+".jpg'>"
						+ "</div>";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        tabla += "</table>";
        return tabla;
    }
	public String impFoto(int cod) throws IOException {
	     String sql = "SELECT * FROM tb_evento where id_evento="+cod+" ORDER BY id_evento desc";
	        Conexion con = new Conexion();
	        String tabla = "";
	        ResultSet rs = null;
	        rs = con.Consulta(sql);
	        String demas="C:\\Users\\paulr\\Documents\\eclipse-work\\ASUS_EXAMEN_GAOS\\src\\main\\webapp";
	        String result="";
	        File tempFile;
	        FileOutputStream fos;
	        int cont=0;

	        try {
	            while (rs.next()) {
	                tempFile = new File(demas+"\\imagenes\\temporales\\"+rs.getString(3).replaceAll(" ", "")+".jpg");
	                fos = new FileOutputStream(tempFile);
	                byte[] foto = rs.getBytes("foto");
	                fos.write(foto); 
	                fos.close();
	                System.out.println(tempFile.getAbsolutePath());
	                tabla +="<img src='imagenes/temporales/"+rs.getString(3).replaceAll(" ", "")+".jpg' width=50px>";
							
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.print(e.getMessage());
	        }
	        return tabla;
	}

	 
	
	
}