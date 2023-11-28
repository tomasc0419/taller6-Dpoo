package modelo;

public class Ingredientes {
	private String nombre;
	private Double precio;
	
	public Ingredientes(String elNombre, Double elprecio ) {
		this.nombre = elNombre;
		this.precio = elprecio;
	}
	public String darNombre()
	{
		return nombre;
	}
	public Double darPrecio()
	{
		return precio;
}
	}

