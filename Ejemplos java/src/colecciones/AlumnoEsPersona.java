package colecciones;

import java.util.HashMap;
import java.util.Map;

import ejemploRepaso.base.*;;

public class AlumnoEsPersona {
	
	//Persona pa = new Alumno("Paco", 15, 3);
	

	public static void main(String args[]) {

		Map<String,Persona> hm = new HashMap<String,Persona>();
		Persona p = new Persona("Paco",33);
		hm.put(p.getNombre(),p);
		System.out.println(hm);
		p.setEdad(56);
		hm.put(p.getNombre(), p);
		System.out.println(hm);
	}
}
