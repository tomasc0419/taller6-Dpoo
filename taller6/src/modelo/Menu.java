package modelo;

public class Menu {
	private String nombre;
	private Double precio;
	
	public Menu(String elNombre, Double elprecio ) {
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
