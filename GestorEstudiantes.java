package JDBC1;

import java.sql.Connection;
import java.sql.Date;
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
	public GestorEstudiantes()
	{
		try {
			String url = "jdbc:mysql://localhost/JDBC1";
			String user = "root";
			String psswd = "root";
			this.con = DriverManager.getConnection(url, user, psswd);
			System.out.println("Conectado");
		}	
		catch (Exception e)
		{
			System.out.println("Error en la conexion");
		}
	}
	public ArrayList<Estudiante> listaEstudiantes()
	{
		ArrayList<Estudiante> a = new ArrayList<Estudiante>();

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM students");
		}
		catch (SQLException e)
		{
			System.err.print("No hay datos en la tabla");
		}
		String rsid = null;
		String rsnombre = null;
		String rsciudad = null;
		String rstfno = null;
		Date rsfecha = null;
		int rscode = 0;
		
		try {
			while (rs.next())
			{
				rsid = rs.getString("Id");
				rsnombre = rs.getString("Nombre");
				rsciudad = rs.getString("Ciudad");
				rstfno = rs.getString("Telefono");
				rsfecha = rs.getDate("FechaNacmto");
				rscode = rs.getInt("DegreeCode");
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		Estudiante E1 = new Estudiante (rsid,rsnombre,rsciudad,rstfno,rsfecha,rscode);
		a.add(E1);
		return a;
	}
	public Estudiante buscarEstudiante (String id)
	{
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM students WHERE Id = '"+id+"'");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			System.err.print("No hay ningun empleado con ese identificador");
		}
		
		String rsid = null;
		String rsnombre = null;
		String rsciudad = null;
		String rstfno = null;
		Date rsfecha = null;
		int rscode = 0;
		
		try {
			rsid = rs.getString("Id");
			rsnombre = rs.getString("Nombre");
			rsciudad = rs.getString("Ciudad");
			rstfno = rs.getString("Telefono");
			rsfecha = rs.getDate("FechaNacmto");
			rscode = rs.getInt("DegreeCode");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		Estudiante E1 = new Estudiante (rsid,rsnombre,rsciudad,rstfno,rsfecha,rscode);
		return E1;
	}
	
	public void borrarEstudiante (String id)
	{
		try {
			st = con.createStatement();
			rs = st.executeQuery("DELETE FROM students WHERE Id = '"+id+"'");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			System.err.print("No hay ningun estudiante con ese identificador");
		}
	}
	
	public void insertarEstudiante (Estudiante E1)
	{
		try {
			String rsid = E1.id;
			String rsnombre = E1.nombre;
			String rsciudad = E1.ciudad;
			String rstfno = E1.telefono;
			Date rsdate = E1.fechanacmto;
			int rscode = E1.degreecode;
			st = con.createStatement();
			rs = st.executeQuery("INSERT INTO students VALUES ('"+rsid+"','"+rsnombre+"','"+rsciudad+"','"+rstfno+"','"+rsdate+"','"+rscode+"')");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	public void modificarEstudiante (String id, Estudiante E1)
	{
		try {
			String rsid = E1.id;
			String rsnombre = E1.nombre;
			String rsciudad = E1.ciudad;
			String rstfno = E1.telefono;
			Date rsdate = E1.fechanacmto;
			int rscode = E1.degreecode;
			st = con.createStatement();
			rs = st.executeQuery("UPDATE students SET Id = '"+rsid+"', Nombre = '"+rsnombre+"', Ciudad = '"+rsciudad+"', Telefono = '"+rstfno+"', FechaNacmto = '"+rsdate+"', DegreeCode = '"+rscode+"' WHERE Id = '"+id+"'");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	public void cerrarConexion()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
}
