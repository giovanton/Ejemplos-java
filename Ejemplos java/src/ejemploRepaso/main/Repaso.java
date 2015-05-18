package ejemploRepaso.main;

import java.io.IOException;

import ejemploRepaso.base.ListaPersonas;
import ejemploRepaso.base.Persona;
import ejemploRepaso.exceptions.InsertarPersonaException;
import ejemploRepaso.exceptions.PersonaNoEncontradaException;

public class Repaso {

	public static void main(String[] args) throws IOException {
		Persona p = new Persona("Marcos", 30);
		Persona p1 = new Persona("Lucas", 31);
		Persona p2= new Persona("Antonio", 32);
		Persona p3 = new Persona("Julian", 34);
		Persona p4 = new Persona("Luis", 33);
		
		ListaPersonas lp = new ListaPersonas();
		
		try {
			lp.insertarPersona(p);
			lp.insertarPersona(p1);
			lp.insertarPersona(p2);
			lp.insertarPersona(p3);
			lp.insertarPersona(p4);
			lp.insertarPersona(p4);
		} catch (InsertarPersonaException e) {
			e.printStackTrace();
		} catch (PersonaNoEncontradaException e) {
			e.printStackTrace();
		}
		lp.mostrar();
		try {
			System.out.println(lp.buscarPersona("Luis"));
			
		} catch (PersonaNoEncontradaException e) {
			e.printStackTrace();
		}
		lp.serializar();
		lp.deserializar();

	}

}
