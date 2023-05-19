package com.producto.negocio;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.producto.datos.*;

public class categoria{
	int id;
	String nombre;
	
	public String mostrarCategoria()
	{
	String combo="<select name=cmbCategoria>";
	String sql="SELECT * FROM tb_tipo_evento";
	ResultSet rs=null;
	Conexion con=new Conexion();
	try
	{
	rs=con.Consulta(sql);
	while(rs.next())
	{
	combo+="<option value="+rs.getInt(1)+ ">"+rs.getString(2)+"</option>";
	}
	combo+="</select>";
	}
	catch(SQLException e)
	{
	System.out.print(e.getMessage());
	}
	return combo;
	}

	
	
}