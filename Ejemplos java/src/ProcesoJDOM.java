import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcesoJDOM {

	public static void main(String[] args) throws FileNotFoundException,
			JDOMException, IOException {

		// CREAMOS EL PARSER
		SAXBuilder builder = new SAXBuilder();
		// Construimos el arbol DOM a partir del fichero xml
		Document documentJDOM = builder
				.build(new FileInputStream("libros.xml"));

		// MOSTRAMOS EL DOCUMENTO
		Element raiz = documentJDOM.getRootElement();
		// Recorremos los hijos de la etiqueta ra�z
		List<Element> libros = raiz.getChildren();
		List<Libro> al = new ArrayList<Libro>();
		Integer a = 0;
		for (Element libro : libros) {
			// para cada libro, obtenemos su detalle
			System.out.println(libro.getAttribute("isbn"));
			String isbn = libro.getAttribute("isbn").getValue();
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
			a++;
		}

		Collections.sort(al);
		System.out.println("lista ordenada :\n" + al);

		// A�ADO UN NUEVO HIJO
		Element padre = documentJDOM.getRootElement();
		// Creamos una nueva etiqueta
		Element nuevolibro = new Element("libro");
		// A�adimos un atributo
		nuevolibro.setAttribute("isbn", "xxxx-yyyy");
		padre.addContent(nuevolibro);
		Element nuevotitulo = new Element("título");
		nuevolibro.addContent(nuevotitulo);
		nuevotitulo.setText("Los Juegos del hambre");

		// SERIALIZO EL DOCUMENT A UN FICHERO DE SALIDA

		Format format = Format.getPrettyFormat();
		// Creamos el serializador con el formato deseado
		XMLOutputter xmloutputter = new XMLOutputter(format);
		// Serializamos el document parseado
		String docStr = xmloutputter.outputString(documentJDOM);
		// Volcamos en un fichero
		FileWriter fw = new FileWriter("lsalida3.xml");
		fw.write(docStr);
		fw.close();

		// Volvemos a generar un documento con el ArrayList ordenado
		Document docJDOM = new Document(new Element("libros"));
		Element pp = docJDOM.getRootElement();
		for (Libro l : al) {
			Element nuevolib = new Element("libro");
			nuevolib.setAttribute("isbn", l.getIsbn());
			pp.addContent(nuevolib);
			Element newtit = new Element("titulo");
			nuevolib.addContent(newtit);
			newtit.setText(l.getTitulo());
			Element newautor = new Element("autor");
			nuevolib.addContent(newautor);
			newautor.setText(l.getAutor());
			Element newany = new Element("anyo");
			nuevolib.addContent(newany);
			newautor.setText(l.getAnyo());
			Element newedit = new Element("editorial");
			nuevolib.addContent(newedit);
			newautor.setText(l.getEditorial());
		}
		Element newElement = new Element("Total");
		pp.addContent(newElement);
		newElement.setText(a.toString());
		Format format1 = Format.getPrettyFormat();
		// Creamos el serializador con el formato deseado
		XMLOutputter xmloutputter1 = new XMLOutputter(format1);
		// Serializamos el document parseado
		String docStr1 = xmloutputter1.outputString(docJDOM);
		// Volcamos en un fichero
		FileWriter fw1 = new FileWriter("librosort.xml");
		fw1.write(docStr1);
		fw1.close();
	}

}
