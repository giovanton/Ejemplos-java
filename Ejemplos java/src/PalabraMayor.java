

/**
 * 
 * Clase con una funci�n que recibe una serie de palabras y 
 * dice qu� palabra es la m�s larga y en qu� posici�n est�
 * 
 * IMPORTANTE:: ASUMO QUE ESTOY PASANDO ARGUMENTOS Y ARGS
 * CONTIENE ALGO; YA QUE NO COMPRUEBO QUE SEA VAC�O Y EN ESE
 * CASO FALLAR�A
 * 
 * @author Val
 * @version 1.0
 *
 */
public class PalabraMayor {
	
	public static void main(String[] args) {
		
		String str_aux = null; //cadena auxiliar, donde voy a ir guardado cada
		
		String palabra_mayor = args[0]; //alguna tiene que ser la mayor, de momento, la mayor es la primera, es mi `punto de partida. Ahora tendr� que comprar esta palabra con el resto, y ver as� cu�l es realmente la mayor de todas
		int posicion_mayor = 0;
		
		//recorro la estructura args, array de cadenas
		//como he asumidpo que la palabra mayor es la 0, tengo que recorrer el array desde la posici�n uno
		for (int i = 1; i < args.length; i++) {
			str_aux = args[i]; // accedo a la palabra actual
			//si la cadena actual tiene mayor longuitud que palabra_mayor
			if (str_aux.length() > palabra_mayor.length())
			{
				//it true, significa, que ahora palabra_mayor, pasa a ser str_aux
				palabra_mayor = str_aux;
				posicion_mayor = i;//guardo tambi�n la posici�n, porque me lo pide el enunciado. 
			} //else no hago nada
		}//fin del for 
		
		//finalmente, al salir del bucle, informo al usuario
		System.out.println("La palabra mayor es " + palabra_mayor + " y est� en la posici�n "+posicion_mayor);
	}

}
