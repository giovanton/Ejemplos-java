

/**
 * 
 * Clase con una función que recibe una serie de palabras y 
 * dice qué palabra es la más larga y en qué posición está
 * 
 * IMPORTANTE:: ASUMO QUE ESTOY PASANDO ARGUMENTOS Y ARGS
 * CONTIENE ALGO; YA QUE NO COMPRUEBO QUE SEA VACÍO Y EN ESE
 * CASO FALLARÍA
 * 
 * @author Val
 * @version 1.0
 *
 */
public class PalabraMayor {
	
	public static void main(String[] args) {
		
		String str_aux = null; //cadena auxiliar, donde voy a ir guardado cada
		
		String palabra_mayor = args[0]; //alguna tiene que ser la mayor, de momento, la mayor es la primera, es mi `punto de partida. Ahora tendré que comprar esta palabra con el resto, y ver así cuál es realmente la mayor de todas
		int posicion_mayor = 0;
		
		//recorro la estructura args, array de cadenas
		//como he asumidpo que la palabra mayor es la 0, tengo que recorrer el array desde la posición uno
		for (int i = 1; i < args.length; i++) {
			str_aux = args[i]; // accedo a la palabra actual
			//si la cadena actual tiene mayor longuitud que palabra_mayor
			if (str_aux.length() > palabra_mayor.length())
			{
				//it true, significa, que ahora palabra_mayor, pasa a ser str_aux
				palabra_mayor = str_aux;
				posicion_mayor = i;//guardo también la posición, porque me lo pide el enunciado. 
			} //else no hago nada
		}//fin del for 
		
		//finalmente, al salir del bucle, informo al usuario
		System.out.println("La palabra mayor es " + palabra_mayor + " y está en la posición "+posicion_mayor);
	}

}
