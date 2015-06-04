package ejemploRepaso.base;

import java.io.IOException;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class EsSerializado extends TypeSafeMatcher<Persona> {
	ListaPersonas lp = new ListaPersonas();
	Persona[] pArray = new Persona[10];

	public void describeTo(Description descripcion) {
		descripcion.appendText("Resultado esperado personas:" + pArray + "\n");
		descripcion.appendText("Obtenido personas:" + pArray);
	}

	@Override
	public boolean matchesSafely(Persona p1) {

		boolean dev = false;
		try {
			pArray = lp.deserializar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Persona p = pArray[0];
		if ((p.getNombre().equals(p1.getNombre()))
				&& (p.getEdad() == p1.getEdad())) {
			dev = true;
		}
		return dev;
	}

}
