package serializacion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import persona.*;

public class EscribeObjeto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int edad = 36;
		String nombre = "Giovanni";
//		Persona p = new Persona(nombre,edad);
		Persona[] personas;
		
		personas = new Persona[3];
		
		for (int a=0;a<3;a++){
			personas[a] = new Persona(nombre,edad);

		}
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("c:\\users\\alumno\\salida.dat"));
	
		salida.writeObject(personas);
		salida.close();
		//p = null;
		
		
		personas = null;
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("c:\\users\\alumno\\salida.dat"));
		personas = (Persona[])entrada.readObject();
		entrada.close();
		for (int i=0; i < personas.length;i++){
			System.out.println(personas[i]);
		}

	}

}
