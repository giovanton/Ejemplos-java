
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ProcesoJDOM {
	
	public static void main(String[] args) throws FileNotFoundException,
			JDOMException, IOException {

		//CREAMOS EL PARSER
		SAXBuilder builder = new SAXBuilder();
		// Construimos el arbol DOM a partir del fichero xml
		Document documentJDOM = builder.build(new FileInputStream("libros.xml"));

		//MOSTRAMOS EL DOCUMENTO
		Element raiz = documentJDOM.getRootElement();
		// Recorremos los hijos de la etiqueta ra�z
		List<Element> libros = raiz.getChildren();
		List<Libro> al = new ArrayList<Libro>();
		for (Element libro : libros) {
			//para cada libro, obtenemos su detalle
			System.out.println(libro.getAttribute("isbn"));
			String isbn = libro.getAttribute("isbn").toString();
			String tit = null;
			String autor = null;
			String anyo = null;
			String editorial = null;
			List<Element> detalles = libro.getChildren();
			for (Element detalle : detalles) {
				System.out.println("Nombre =" + detalle.getName());
				System.out.println("Valor =" + detalle.getValue());
				if (detalle.getName().equals("titulo")) {
					 tit = detalle.getValue();
				} else if (detalle.getName().equals("autor")) {
					 autor = detalle.getValue();
				} else if (detalle.getName().equals("anyo")) {
					 anyo = detalle.getValue();
				} else if (detalle.getName().equals("editorial")) {
					 editorial = detalle.getValue();
				}
			}
			Libro lib1 = new Libro();
			lib1.setIsbn(isbn);
			lib1.setTitulo(tit);
			lib1.setAutor(autor);
			lib1.setAnyo(anyo);
			lib1.setEditorial(editorial);
			al.add(lib1);
		}
		Collections.sort(al);
		System.out.println("lista ordenada :\n" + al);
		
		//A�ADO UN NUEVO HIJO
		Element padre = documentJDOM.getRootElement();
	    // Creamos una nueva etiqueta  
	    Element nuevolibro = new Element("libro");  
	    // A�adimos un atributo  
	    nuevolibro.setAttribute("isbn", "xxxx-yyyy");  
	    padre.addContent(nuevolibro);
	    Element nuevotitulo = new Element("título");
	    nuevolibro.addContent(nuevotitulo);
	    nuevotitulo.setText("Los Juegos del hambre");

	    
	   //SERIALIZO EL DOCUMENT A UN FICHERO DE SALIDA
	    
	    Format format = Format.getPrettyFormat();
	    // Creamos el serializador con el formato deseado  
	    XMLOutputter xmloutputter = new XMLOutputter(format);
	    // Serializamos el document parseado  
	    String docStr = xmloutputter.outputString(documentJDOM); 
	    //Volcamos en un fichero
	    FileWriter fw = new FileWriter("lsalida3.xml");
	    fw.write(docStr);
	    fw.close();
	    
	}

}
