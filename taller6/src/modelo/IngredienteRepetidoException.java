package modelo;

public class IngredienteRepetidoException extends HamburguesaException {
	   private static final long serialVersionUID = 1L;
		private static final String MENSAJE = "existe un ingrediente repetido";
	    
	    public IngredienteRepetidoException(String name) {
	        super(MENSAJE + " " + name);
	    }
}
