package persona;

import java.io.Serializable;

public class Persona implements Serializable, Comparable<Persona> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	int edad;

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return (this.nombre + " " + this.edad);
	}

	public String toStringObString() {
		String sup = super.toString();

		return sup;
	}

	public int compareTo(Persona o) {
		if (o.edad > this.edad) {
			return -1;
		} else if (o.edad < this.edad) {
			return 1;
		}
		return 0;
	}
}
