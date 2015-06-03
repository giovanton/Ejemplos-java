import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ProcesoSAX {

	public static void main(String[] args) {

		try {
			// Creamos nuestro objeto libro vacío
			Libro libro = new Libro();
			LibroXML libroxml = new LibroXML(libro);
			HashMap<String, Libro> listaLibros = new HashMap<String, Libro>();
			// Creamos la factoria de parseadores por defecto
			XMLReader reader = XMLReaderFactory.createXMLReader();
			// Añadimos nuestro manejador al reader pasandole el objeto libro
			reader.setContentHandler(libroxml);
			// Procesamos el xml de ejemplo
			reader.parse(new InputSource(new FileInputStream("libros.xml")));
			listaLibros = (HashMap<String, Libro>) libroxml.getHml();

			System.out.println(listaLibros);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
