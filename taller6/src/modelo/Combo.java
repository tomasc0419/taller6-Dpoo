package modelo;





public class Combo {
	private String nombre;
	private String descuento;
	private String hamburguesa;
	private String papas;
	private String gaseosa;
	
	public Combo(String elNombre, String eldescuento, String lahamburguesa, String laspapas, String lagaseosa) {
		this.nombre = elNombre;
		this.descuento = eldescuento;
		this.hamburguesa = lahamburguesa;
		this.papas = laspapas;
		this.gaseosa = lagaseosa;
	}	




	public String darNombre()
	{
		return nombre;
	}
	public String darDescuento()
	{
		
		return descuento;
	}
	public String darPapas()
	{
		return papas;
	}
	public String darGaseosa()
	{
		return gaseosa;
	}
	public String darHamburguesa()
	{
		return hamburguesa;
	}
	}
	
	

