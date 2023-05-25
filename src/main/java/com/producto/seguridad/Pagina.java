package com.producto.seguridad;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.producto.datos.*;

public class Pagina {
	private String descripcion;
	private String path;


	public Pagina() {
		// TODO Auto-generated constructor stub
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String mostrarMenu(int nperfil)
	{
	String menu="<h1 style=\"color:#fff\">MENU</h1>"
			+ "<ul>";
	String sql="SELECT * FROM tb_pagina pag, tb_perfil per, \"tb_perfilPagina\" pper "
	+
	"WHERE pag.id_pag=pper.id_pag AND pper.id_per=per.id_perfil AND pper.id_per= "+nperfil+" ORDER BY pag.id_pag desc";
	Conexion con = new Conexion();
	ResultSet rs=null;
	try
	{
	rs=con.Consulta(sql);
	while(rs.next())
	{
	menu+="<li><a href="+rs.getString(3)+" accesskey="+rs.getInt(1)+">"+rs.getString(2)+
	"</a></li>";
	}
	menu+="</ul>";
	}
	catch(SQLException e)
	{
		System.out.print(e.getMessage());
	}
	return menu;
	}	
}
