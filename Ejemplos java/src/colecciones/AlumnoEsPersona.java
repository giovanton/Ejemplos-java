package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import persona.Alumno;
import persona.Persona;
import ejemploRepaso.exceptions.NotaException;

public class AlumnoEsPersona {

	// Persona pa = new Alumno("Paco", 15, 3);

	public static void main(String args[]) throws NotaException {

		Map<String, Persona> hm = new HashMap<String, Persona>();
		Persona p = new Persona("Paco", 33);
		hm.put(p.getNombre(), p);
		System.out.println(hm);
		p.setEdad(56);
		hm.put(p.getNombre(), p);
		System.out.println(hm);

		Map<Integer, Alumno> mapAlumnos = new LinkedHashMap();
		mapAlumnos.put(1, new Alumno("Marcos", 25, 5));
		mapAlumnos.put(2, new Alumno("Luis", 29, 6));
		mapAlumnos.put(3, new Alumno("Paco", 23, 8));
		mapAlumnos.put(4, new Alumno("Lucas", 30, 10));
		mapAlumnos.put(5, new Alumno("Mario", 22, 7));

		System.out.println(mapAlumnos);

		Map<Integer, Alumno> treeAlumnos = new TreeMap<Integer, Alumno>();
		treeAlumnos.put(8, new Alumno("Paco", 23, 8));
		treeAlumnos.put(5, new Alumno("Marcos", 25, 5));
		treeAlumnos.put(6, new Alumno("Luis", 29, 6));
		treeAlumnos.put(10, new Alumno("Lucas", 30, 10));
		treeAlumnos.put(7, new Alumno("Mario", 22, 7));

		System.out.println(treeAlumnos);

		Set<Persona> setPersonas = new TreeSet<Persona>();
		setPersonas.add(p);
		setPersonas.add(new Persona("Francesco", 32));
		setPersonas.add(new Persona("Valeriano", 12));

		System.out.println(setPersonas);

		Persona p1 = new Persona("Paco", 23);
		Persona p2 = new Persona("Manuel", 22);
		Persona p3 = new Persona("Luis", 31);
		Persona p4 = new Persona("Eric", 43);
		Persona p5 = new Persona("Marcos", 12);

		List<Persona> lp = new ArrayList<Persona>();
		lp.add(p1);
		lp.add(p2);
		lp.add(p3);
		lp.add(p4);
		lp.add(p5);

		Collections.sort(lp, new OrdenarPorNombre());
		System.out.println(lp);
	}
}
