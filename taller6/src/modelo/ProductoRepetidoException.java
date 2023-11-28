package modelo;


public class ProductoRepetidoException extends HamburguesaException {
	    private static final long serialVersionUID = 1L;
		private static final String MENSAJE = "existe un Producto repetido!";
	    
	    public ProductoRepetidoException(String name) {
	        super(MENSAJE + " " + name);
	    }
}
