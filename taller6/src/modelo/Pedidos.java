package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedidos {
	private int id; 
	private String nombre;
	private String dic;
	
	private List<String> productos;
	
	private List<Double> lisprecios;
	private Double total; 
	
	
	public Pedidos(String elNombre, List<String> pedido, List<Double> individual, Double elTotal, int numal, String eldic, Double eltotal) {
		this.nombre = elNombre;
		this.productos = pedido;
		this.lisprecios = individual;
		this.total = elTotal;
		this.id = numal;
		this.dic = eldic;
		this.total = eltotal;
		
		
		
		
	}	




	public String darNombre()
	{
		return nombre;
	}
	public ArrayList<String> darlista()
	{
		
		return (ArrayList<String>) productos;
	}
	public ArrayList<Double> darlispre ()
	{
		return (ArrayList<Double>) lisprecios;
	}
	public Double elTotal()
	{
		return total;
}
	public  int elid()
	{
		return id;
}
	public String dardic()
	{
		return dic;
}
}

