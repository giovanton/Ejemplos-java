package exceptions;

import persona.Persona;

public class ProvocaError {

	private Persona pers;
	
	public ProvocaError() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona getPers() {
		return pers;
	}
	
	private void llenarArray(int veces){
		Persona[] arrayPers = new Persona[3];
		pers = new Persona("Giovanni",36);
		
		for (int i = 0;i < veces;i++){
			arrayPers[i] = pers; 
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int veces = 4;
		
		ProvocaError pro = new ProvocaError();
		try {
			pro.llenarArray(veces);	
		} catch (ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("Demasiadas personas introducidas");
		}
		
	}

}
