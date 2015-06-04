package evaluacion.primera;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Conexion {
	private static final String RUTA_PROPERTIES = "db.properties";
	private static Logger log = Logger.getLogger("dblog");
	private static String cadena_conexion; 
	private static String usuario;
	private static String contrasenya;
	
	static{
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(RUTA_PROPERTIES));
			String s_driver = properties.getProperty("driver");
			cadena_conexion = properties.getProperty("cadena_conexion");
			usuario = properties.getProperty("user");
			contrasenya = properties.getProperty("password");
			Class.forName(s_driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Fichero de properties no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Fichero de properties no encontrado");
		} catch (ClassNotFoundException e) {
			log.error("Error al intentar conectar a la base de datos: driver no encontrado");
		}
		
	}
	
	
	public static Connection obtenerConexion () throws SQLException
	{
		/*Obtiene una nueva conexion con la base de datos*/
		return DriverManager.getConnection(cadena_conexion, usuario, contrasenya);
	}
	
	public static void liberarRecursos (Connection conn, Statement stmt, ResultSet rset)
	{
		/*Se liberan los recursos utilizados durante la conexion*/
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
	
	/*nuevo m�todo, sobrecarga del anterior, cuando necesit�is liberar recursos, despu�s
	de ejecutar una instrucci�n que NO es un SELECT ;)*/
	public static void liberarRecursos (Connection conn, Statement stmt)
	{
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
}
