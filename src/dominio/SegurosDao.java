package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Seguros;

public class SegurosDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";

	public int eliminarSeguro(int id)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		int filas = 0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "delete from seguros where id="+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}

	
	public int agregarSeguro(Seguros seguros)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		int filas=0;
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into seguros(idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado) values ('"+seguros.getID()+"','"+seguros.getDescripcion()+"','"+seguros.getTipoSeguro()+"','"+seguros.getCostoContratacion()+"','"+seguros.getCostoMaxAsegurado()+"')";
			filas = st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	
	public ArrayList<Seguros> obtenerSeguros() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Seguros> lista = new ArrayList<Seguros>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idSeguro, descripcion, idTipo,c ostoContratacion, costoAsegurado FROM seguros");
			
			while(rs.next()){
				
				Seguros segurosRs = new Seguros();
				segurosRs.setID(rs.getInt("idSeguro"));
				segurosRs.setDescripcion(rs.getString("descripcion"));
				segurosRs.setTipoSeguro(rs.getInt("idTipo"));
				segurosRs.setCostoContratacion(rs.getFloat("costoContratacion"));
				segurosRs.setCostoMaxAsegurado(rs.getFloat("costoAsegurado"));
				
				lista.add(segurosRs);
			}
			
			conn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		
		}
		
		return lista;
	}

	
	public Seguros obtenerUnUsuario(int id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Seguros seguro = new Seguros();
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("Select * from seguros where idSeguro = ?");
			miSentencia.setInt(1, id); //Cargo el ID recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
			seguro.setID(resultado.getInt(1));
			seguro.setDescripcion(resultado.getString(2));
			seguro.setTipoSeguro(resultado.getInt(3));
		    seguro.setCostoContratacion(resultado.getFloat(4));
		    seguro.setCostoMaxAsegurado(resultado.getFloat(5));
			
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
		return seguro;
	}
	
}
