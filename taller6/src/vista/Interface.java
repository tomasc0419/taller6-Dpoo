package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import controlador.Restaurante;
import controlador.carga;
import modelo.Combo;
import modelo.Ingredientes;
import modelo.Menu;
import modelo.Pedidos;


public class Interface {

	private Restaurante res;

	public void ejecutarAplicacion() throws IOException
	{
		System.out.println("Hamburgueseria\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();



				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					Inicializaraplicacion();

				else if (opcion_seleccionada == 2 )
					ejecutarpedido();

				else if (opcion_seleccionada == 3 )
					buscarorden();


				else if (opcion_seleccionada == 4)
				{
					System.out.println("Saliendo de la aplicación ...");
					finalizarpedido();
					
					
					continuar = false;
				}


				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}








	private void ejecutarpedido() {
		boolean seguir = true
				;
		List<String> pedido = new ArrayList<>();
		double valor =  0;
		List<Double> individual = new ArrayList<>();

		while (seguir == true) {

			System.out.println("1. Desea pedir un combo? ");
			System.out.println("2. Desea pedir algo del menu? ");
			System.out.println("3. Desea agregar un ingrediente? ");
			System.out.println("4. Desea desea quitarle algun ingrediente?  ");
			System.out.println("5. Desea finalizar su orden? ");

			int decision = Integer.parseInt(input("Por favor seleccione una opción"));
			if (decision == 1) {
				// imprimo el combo y hago que elijan cual quieren 
				ArrayList<Combo> liscombo = res.darcombo();
				System.out.println(" El combo ");
				int b = 1;

				for (Combo elcombo : liscombo) {
					String nom = elcombo.darNombre();
					String hambur = elcombo.darHamburguesa();
					String papas = elcombo.darPapas();
					String gaseosa = elcombo.darGaseosa();
					Double precio = res.darprecioscombo(elcombo);


					System.out.println(b + "." + nom + " contiene: " + hambur + "," + papas + ", " + gaseosa + " a un precio de " + precio);
					b = b +1;
				}

				int comb = Integer.parseInt(input("Cual combo desea "));
				Combo cual = res.pedidocombo(comb-1);

				String nomb = cual.darNombre();


				pedido.add(nomb);
				Double precio = (res.darprecioscombo(cual));
				individual.add(precio);
				valor = valor + precio;

			}

			else if (decision == 2 ) {

				ArrayList<Menu> lismenu = res.darmenu();
				System.out.println(" El menu ");
				int a = 1;

				for (Menu elmenu : lismenu) {
					String nom = elmenu.darNombre();
					Double precio = elmenu.darPrecio();
					System.out.println(a + "." + nom + ": " + precio);
					a = a +1;
				}

				int men = Integer.parseInt(input("Que producto desea del menu "));
				String nombr = res.pedidproductonom(men-1);
				double precio1 = res.pedidproductopre(men-1);
				pedido.add(nombr);
				valor = valor + precio1;
				individual.add(precio1);


			}
			else if (decision == 3 ) {
				ArrayList<Ingredientes> lisingre = res.daringredientes();
				System.out.println(" Los ingredientes ");
				int c = 1;

				for (Ingredientes elingre : lisingre) {
					String nom = elingre.darNombre();
					Double precio = elingre.darPrecio();
					System.out.println(c + "." + nom + ": " + precio);
					c = c +1;
				}
				int in = Integer.parseInt(input("Que producto desea agregarle "));
				String nombr1 = res.pedidoingreonom(in-1);
				double precio2 = res.pedidoingrepre(in-1);

				pedido.add("Con " + nombr1);
				valor = valor + precio2;
				individual.add(precio2);






			}


			else if (decision == 4 ) {
				System.out.println(" Los ingredientes ");
				int d = 1;
				ArrayList<Ingredientes> lisingres = res.daringredientes();
				for (Ingredientes elingre : lisingres) {

					String nom = elingre.darNombre();
					Double precio = elingre.darPrecio();
					System.out.println(d + "." + nom + ": " + precio);
					d = d +1;
				}
				int in = Integer.parseInt(input("Que producto desea agregarle "));
				String nombr2 = res.pedidoingreonom(in-1);
				pedido.add( nombr2);


			}





			else if (decision == 5)
			{
				System.out.println("Finalizando pedido...");
				String name = input("Antes de finalizar el pedido, porfa ingrese su nombre ");
				String eldic = input("su dirección ");
				Random random = new Random();


				Integer numal = random.nextInt(9000) + 1000;
				Pedidos orden = new Pedidos(name, pedido, individual, valor, numal,eldic, valor);
				res.pedido(numal, orden);
				seguir = false;
				System.out.println("su orden quedo de tal manera: ");
				System.out.println("nombre: " + name);
				System.out.println("dirección: " + eldic);
				System.out.println("numero de orden: " + numal);
				
				int rep = individual.size();
				int x = 0;
				while (rep>x) {
					System.out.println(pedido.get(x)+ " $ "+ individual.get(x));

					x=x+1;
				}
				int sin = pedido.size();
				if (sin > rep) {

					while (sin > x){
						System.out.println(" sin el producto: " + pedido.get(x));
						x = x +1;

					}
				}

				System.out.println("El precio total " + valor);
				System.out.println("IVA " + (valor * 0.19));
				


			}
			else {
				System.out.println("el numero no esta en las opciones ");
			}


		}







	}



	private void finalizarpedido() throws IOException {
		Map<Integer, Pedidos> pedidos = res.darpedidos();
		BufferedWriter br = new BufferedWriter(new FileWriter("./data/ordenes.txt"));
		for (Pedidos elpedido : pedidos.values()) {
			String nom = elpedido.darNombre();
			Integer id = elpedido.elid();
			String dir = elpedido.dardic();
			ArrayList<String> productos = elpedido.darlista();
			ArrayList<Double> precios = elpedido.darlispre();
			br.newLine();
			
			br.write("nombre: " + nom);
			br.write("numero de orden: " + id);
			br.write("la dirección: " + dir);
		
			int rep = precios.size();
			int x = 0;
			while (rep>x) {
				br.write(productos.get(x)+ " $ "+ precios.get(x));

				x=x+1;
			}
			int sin = productos.size();
			if (sin > rep) {

				while (sin > x){
					br.write(" sin el producto: " + productos.get(x));
					x = x +1;

				}
			}
			String total = Double.toString(elpedido.elTotal());
			br.write(total);
			



		}

		br.close();
	}

	private void buscarorden() {
		Integer id = Integer.parseInt(input("Porfavor ingrese el id del producto que desea "));
		Pedidos fin = res.buscarped(id);
		String nom = fin.darNombre();

		System.out.println("su orden quedo de tal manera: ");
		System.out.println("nombre: " + nom);
		System.out.println("dirección: " + fin.dardic());
		System.out.println("numero de orden: " + fin.elid());

		int rep = fin.darlista().size();
		int x = 1;
		while (rep>x) {
			System.out.println(fin.darlista().get(x-1)+ " $ "+ fin.darlispre().get(x-1));

			x=x+1;
		}
		int sin = fin.darlispre().size();
		if (sin < rep) {

			while (sin < x){
				System.out.println(" - " + fin.darlista().get(sin));
				sin = sin +1;

			}
		}


	}


	/**

	 */
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Inicializar la aplicacion");
		System.out.println("2. Iniciar pedido ");
		System.out.println("3. Buscar pedido con id ");

		System.out.println("4. Salir de la aplicacion");
	}



	private void Inicializaraplicacion() {
		res = carga.Leer("data/combos.txt", "data/menu.txt", "data/ingredientes.txt");
		System.out.println("Se inicio la app");
	}
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws IOException
	{
		Interface consola = new Interface();
		consola.ejecutarAplicacion();
	}

}











