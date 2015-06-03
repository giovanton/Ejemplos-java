package ejemploRepaso.exceptions;

import ejemploRepaso.base.ListaPersonas;

public class InsertarPersonaException extends Exception {

	public static final String mensaje = "Número de personas excedido. Máximo "
			+ ListaPersonas.CAPACIDAD + " personas";

}
