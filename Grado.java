package JDBC1;

public class Grado 
{
	int degreeCode;
	String titulo;
	int horas;
	
	public Grado (int id, String t, int h)
	{
		this.degreeCode = id;
		this.titulo = t;
		this.horas = h;
	}
	
	public String toString ()
	{
		return this.degreeCode+"\t"+this.titulo+"\t"+this.horas;
	}
}
