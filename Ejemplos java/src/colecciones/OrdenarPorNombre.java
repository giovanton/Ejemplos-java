package colecciones;

import java.util.Comparator;

import persona.Persona;

public class OrdenarPorNombre implements Comparator<Persona>{

	public int compare(Persona o1, Persona o2) {
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
