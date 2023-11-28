package controlador;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileReader;

import modelo.Combo;
import modelo.Ingredientes;
import modelo.Menu;
import modelo.Pedidos;


public class carga {
	public static Restaurante Leer(String archivo, String archivo2, String archivo3) {
		try {

			Map <String, Combo> Combos = new HashMap<>();
			Map <String, Menu> Menu = new HashMap<>();
			Map <String, Ingredientes> Ingredientes = new HashMap<>();
			Map <Integer, Pedidos> pedido = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;
			while((linea=br.readLine()) != null) {
				String [] partes = linea.split(";");

				String elnombre = partes[0];
				String eldescuento = partes[1];
				String lahamburguesa = partes[2];
				String laspapas = partes[3];
				String lagaseosa = partes[4];

				Combo elcombo = new Combo(elnombre, eldescuento, lahamburguesa, laspapas, lagaseosa);
				Combos.put(elnombre, elcombo);
			}
			br.close();
			BufferedReader br1 = new BufferedReader(new FileReader(archivo2));
			String linea1;
			while((linea1=br1.readLine()) != null) {
				String [] partes = linea1.split(";");
			
				String nombre = partes[0];
				Double precio = Double.parseDouble(partes[1]);
				Menu elmenu = new Menu(nombre, precio);
				Menu.put(nombre, elmenu);
			}
			br1.close();
			BufferedReader br2 = new BufferedReader(new FileReader(archivo3));
			String linea2;
			while((linea2=br2.readLine()) != null) {
				String [] partes = linea2.split(";");
			
				String nombre = partes[0];
				Double precio = Double.parseDouble(partes[1]);
				Ingredientes elingrediente = new Ingredientes (nombre, precio);
				Ingredientes.put(nombre, elingrediente);
			}
			br2.close();
		
			
		
			
		
			Restaurante res = new Restaurante(Combos, Menu, Ingredientes, pedido);
			return res;



	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;

}

}
