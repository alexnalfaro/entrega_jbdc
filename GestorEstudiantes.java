package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorEstudiantes 
{
	Connection con;
	Statement st;
	ResultSet rs;
	public void abrirConexion()
	{
		try {
			String url = "jdbc:mysql://localhost/JDBC1";
			String user = "root";
			String psswd = "root";
			con = DriverManager.getConnection(url, user, psswd);
			System.out.println("Conectado");
		}	
		catch (Exception e)
		{
			System.out.println("Error en la conexion");
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	public GestorEstudiantes ()
	{
		
	}
	public ArrayList<Estudiante> listaEstudiantes()
	{
		ArrayList<Estudiante> a = new ArrayList<Estudiante>();
		return a;
	}
	public Estudiante buscarEstudiante (String id)
	{
		return null;
	}
	
	public void borrarEstudiante (String id)
	{
		
	}
	
	public void insertarEstudiante (Estudiante E1)
	{
		
	}
	public void modificarEstudiante (String id, Estudiante E1)
	{
		
	}
	
}
