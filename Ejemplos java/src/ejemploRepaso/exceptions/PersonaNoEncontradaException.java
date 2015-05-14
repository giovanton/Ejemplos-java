package ejemploRepaso.exceptions;

public class PersonaNoEncontradaException extends Exception{

public static final String mensaje = "Persona no encontrada en la lista.";
	
	public PersonaNoEncontradaException() {
		super(mensaje);
	}
}
