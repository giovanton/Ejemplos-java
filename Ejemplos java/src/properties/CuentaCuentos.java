package properties;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CuentaCuentos {

	public static InputStream fis;

	public CuentaCuentos() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args[0].equals("ES")) {
			fis = new FileInputStream("story_es.properties");
		} else if (args[0].equals("EN")) {
			fis = new FileInputStream("story_en.properties");
		} else if (args[0].equals("IT")) {
			fis = new FileInputStream("story_it.properties");
		}
		Properties prop = new Properties();
		prop.load(fis);
		String[] cuento = new String[3];
		cuento[0] = prop.getProperty("start");
		cuento[1] = prop.getProperty("body");
		cuento[2] = prop.getProperty("end");
		fis.close();
		FileWriter fos = new FileWriter(prop.getProperty("outfile"));

		for (int i = 0; i < cuento.length; i++) {
			fos.write(cuento[i]);
			System.out.println(cuento[i]);
		}
		fos.close();
	}

}
