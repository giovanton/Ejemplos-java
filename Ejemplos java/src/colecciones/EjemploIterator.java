package colecciones;

import java.util.ArrayList;
import java.util.Iterator;

import persona.Persona;

public class EjemploIterator {
	static ArrayList<Persona> personas;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		personas = new ArrayList<Persona>();
		Persona p = new Persona("Mario", 33);
		personas.add(p);
		Iterator<Persona> it_personas = personas.iterator();

		while (it_personas.hasNext()) {
			p = it_personas.next();
			System.out.println(p.getNombre() + " está en un ArrayList");
		}

	}

}
