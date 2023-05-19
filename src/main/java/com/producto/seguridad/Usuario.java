package com.producto.seguridad;

import java.sql.ResultSet;
import com.producto.datos.*;

public class Usuario {
private String nombre;

private String direccion;
private String login;
private String clave;
private Integer perfil;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getPerfil() {
		return perfil;
	}
	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
	public boolean verificarUsuario(String nlogin, String nclave)
	{
	boolean respuesta=false;
	String sentencia= "Select * from tb_usuario where us_login='"+nlogin+
	"' and password='"+nclave+"';";
	//System.out.print(sentencia);
	try
	{
	ResultSet rs;
	Conexion clsCon=new Conexion();
	rs=clsCon.Consulta(sentencia);
	if(rs.next())
	{
	respuesta=true;
	this.setLogin(nlogin);
	this.setClave(nclave);
	this.setPerfil(rs.getInt(2));
	this.setNombre(rs.getString(3));
	}
	else
	{
	respuesta=false;
	rs.close();
	}
	}
	catch(Exception ex)
	{
	System.out.println( ex.getMessage());
	}
	return respuesta;
	}

	public void nuevoPostulante(String nombre,String correo,String usuario,String password,String cedula,String cv) {
		String sentencia= "insert into tb_usuario (id_perfil,nombre,correo,us_login,\"password\",cedula,\"CV\")values"
				+ "(3,'"+nombre+"','"+correo+"','"+usuario+"','"+password+"','"+cedula+"','"+cv+"');";
				//System.out.print(sentencia);
				try
				{
				ResultSet rs;
				Conexion clsCon=new Conexion();
				clsCon.Ejecutar(sentencia);
	}catch(Exception ex)
				{
		System.out.println( ex.getMessage());
		}
	}

	public String estado(String nlogin)
	{
	String respuesta="ERROR";
	String sentencia= "Select id_perfil from tb_usuario where nombre='"+nlogin+"';";
	//System.out.print(sentencia);
	System.out.println(nlogin);
	try
	{
	ResultSet rs;
	Conexion clsCon=new Conexion();
	rs=clsCon.Consulta(sentencia);
	while(rs.next())
	{
		if(rs.getInt(1)==3) {
			respuesta="EN ESPERA....";
		}else if(rs.getInt(1)==2) {
		respuesta="UN RESPETABLE Y HONORABLE MIEMBRO DE GAOS";
		}else if(rs.getInt(1)==1) {
			respuesta="UN PODEROSO ADMIN DE GAOS";
			}
	}

	}
	catch(Exception ex)
	{
	System.out.println( ex.getMessage());
	}
	return respuesta;
	}
}
