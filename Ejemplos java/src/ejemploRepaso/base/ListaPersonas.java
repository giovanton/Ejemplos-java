package ejemploRepaso.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Properties;

import colecciones.Recorrer;
import ejemploRepaso.exceptions.InsertarPersonaException;
import ejemploRepaso.exceptions.PersonaNoEncontradaException;

public class ListaPersonas implements Iterable {

	public static final int CAPACIDAD = 10;

	private Persona[] array_personas;
	private int numeroPersonas;

	public ListaPersonas() {
		this.array_personas = new Persona[CAPACIDAD];
		this.numeroPersonas = 0;
	}

	public Persona[] getLista_personas() {
		return array_personas;
	}

	public Persona buscarPersona(String nombre)
			throws PersonaNoEncontradaException {
		int a = 0;
		Persona p = null;
		boolean encontrado = false;
		while (!encontrado && (a <= numeroPersonas)) {
			if (array_personas[a].getNombre().equals(nombre)) {
				p = array_personas[a];
				encontrado = true;
				return p;
			}
			a++;
		}
		;

		return null;
	}

	public Persona buscarPersona(int edad) {
		int a = 0;
		Persona p = null;
		boolean encontrado = false;

		while (!encontrado && (a <= numeroPersonas)) {
			if (array_personas[a].getEdad() == edad) {
				p = array_personas[a];
				encontrado = true;
				return p;
			}
			a++;
		}

		return null;
	}

	public boolean serializar() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("serializa.properties");
		prop.load(fis);
		String archivo = prop.getProperty("destino");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				archivo));
		oos.writeObject(array_personas);
		oos.close();
		fis.close();

		return false;
	}

	public Persona[] deserializar() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("serializa.properties");
		prop.load(fis);
		String archivo = prop.getProperty("destino");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				archivo));
		try {
			array_personas = (Persona[]) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ois.close();
		return array_personas;
	}

	public void insertarPersona(Persona p) throws InsertarPersonaException,
			PersonaNoEncontradaException {
		boolean duplicado = false;
		int a = 0;
		if (!estaLlena()) {
			/*
			 * while (!duplicado || a<= numeroPersonas) { //TODO : hacer un
			 * m�todo aparte para comprobar la duplicidad if
			 * (p.getNombre().equals(array_personas[a].getNombre())){
			 * System.out.println("Esta persona esta en la lista"); duplicado =
			 * true; }else{
			 */
			array_personas[numeroPersonas] = p;
			numeroPersonas++;// }
			a++;
			// }
		} else {
			throw new InsertarPersonaException();
		}
	}

	public int numeroPersonas() {
		return numeroPersonas;
	}

	public boolean estaLlena() {
		if (numeroPersonas == CAPACIDAD)
			return true;
		return false;
	}

	public void mostrar() {
		for (int i = 0; i < numeroPersonas; i++) {
			System.out.println(array_personas[i]);
		}
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		Recorrer reco = new Recorrer();
		return reco;
	}
}
