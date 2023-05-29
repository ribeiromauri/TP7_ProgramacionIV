package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.TipoSeguro;

public class TipoSeguroDao 
{
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	
	public ArrayList<TipoSeguro> ListarTiposdeSeguros() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		ArrayList<TipoSeguro> lista = new ArrayList<TipoSeguro>();
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idTipo, descripcion FROM tiposeguros");
			
			while(rs.next())
			{
				TipoSeguro segurosRs = new TipoSeguro();
				segurosRs.setID(rs.getInt("idTipo"));
				segurosRs.setDescripcion(rs.getString("descripcion"));
				
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
	
}
