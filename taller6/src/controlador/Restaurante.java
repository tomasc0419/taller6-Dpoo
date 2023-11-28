package controlador;

import java.util.ArrayList;

import java.util.Map;

import modelo.Combo;
import modelo.Ingredientes;
import modelo.Menu;
import modelo.Pedidos;



public class Restaurante {
	
	private ArrayList<Combo> combos;
	private ArrayList<Menu> menu;
	private ArrayList<Ingredientes> ingredientes;
	private Map <Integer, Pedidos> pedidos;
	

	public Restaurante(Map<String, Combo> combos, Map<String, Menu> menu, Map<String, Ingredientes> ingredientes, Map <Integer, Pedidos> pedidos)
	{
		this.combos = new ArrayList<Combo>(combos.values());
		this.menu = new ArrayList<Menu>(menu.values());
		this.ingredientes = new ArrayList<Ingredientes>(ingredientes.values());
		this.pedidos = pedidos;
		
	}
	
	public ArrayList<Menu> darmenu() {
		
		return menu;
	}
	public ArrayList<Ingredientes> daringredientes() {
		
		return ingredientes;
	}
	public ArrayList<Combo> darcombo() {
		
		return combos;
	}
	public Map <Integer, Pedidos> darpedidos() {
		
		return pedidos;
	}
	public Double darprecioscombo(Combo com) {
		double respuesta = 0;
		int pos =  0;
		boolean sigue = true;
		double desc = 0;
		String nomcombo = com.darNombre();
		String des = com.darDescuento();
		
		if (des.equals("10%")) {
			desc = 0.1;
		}
		else {
			desc = 0.07;
			
		}
		
		while ( sigue == true && combos.size()> pos)  {
			Combo elcombo = combos.get(pos);
			String nombre = elcombo.darNombre();
			if (nombre.equals(nomcombo)){
				String hambur = elcombo.darHamburguesa();
				
				String papa = elcombo.darPapas();
				String gas = elcombo.darGaseosa();
				sigue = false;
				int posicion = 0;
				boolean seguir = true;
				while ( menu.size()> posicion && seguir == true) {
					Menu ingre = menu.get(posicion);
					String ingres = ingre.darNombre();
					if (ingres.equals(papa)) {
						respuesta = respuesta +  (ingre.darPrecio()*desc);
						seguir = false;
						
						
								
					}
				
					posicion = posicion +1;
				}
				posicion = 0;
				seguir = true;
				while ( menu.size()> posicion && seguir == true) {
					Menu ingre = menu.get(posicion);
					String ingres = ingre.darNombre();
					if (ingres.equals(gas)) {
						respuesta = respuesta +  (ingre.darPrecio()*desc);
						seguir = false;
						
								
					}
				
					posicion = posicion +1;
				}
				posicion = 0;
				seguir = true;
				while ( menu.size()> posicion && seguir == true) {
					Menu ingre = menu.get(posicion);
					String ingres = ingre.darNombre();
					if (ingres.equals(hambur)) {
						respuesta = respuesta +  (ingre.darPrecio()*desc);
						
						seguir = false;
								
					}
				
					posicion = posicion +1;
				}
				
				
				
				
						
				
						
			}
			pos = pos + 1;
					
		}
		return respuesta;
		
	}
	public  Combo pedidocombo(int pos) {
		Combo respuesta = combos.get(pos);
		
		
		return respuesta;
		
		
	}
	public  String pedidproductonom(int pos) {
		Menu respuesta = menu.get(pos);
		String nom = respuesta.darNombre();
		
		return nom;
	}
	public  Double pedidproductopre(int pos) {
		Menu respuesta = menu.get(pos);
		Double nom = respuesta.darPrecio();
		
		return nom;
	}
	public  Double pedidoingrepre(int pos) {
		Ingredientes respuesta = ingredientes.get(pos);
		Double nom = respuesta.darPrecio();
		
		return nom;
	}
	public  String pedidoingreonom(int pos) {
		Ingredientes respuesta = ingredientes.get(pos);
		String nom = respuesta.darNombre();
		
		return nom;
	}
	public void pedido(Integer orden, Pedidos pedido) {
		pedidos.put(orden, pedido);
		
	}	
	public Pedidos buscarped(Integer id) {
		Pedidos actual = pedidos.get(id);
		
		
		return actual;
		
	}
}


	