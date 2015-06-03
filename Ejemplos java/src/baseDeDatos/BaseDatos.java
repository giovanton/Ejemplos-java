package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {

	public static void main(String[] args) throws Exception {

		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;

		try {
			// registro el driver, en realidad, hago que se ejecuten unas pocas
			// l�neas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver (new
			// oracle.jdbc.driver.OracleDriver());// m�todo equivalente al
			// anterior
			// Sea como sea, es, <<oye, si te piden una conexi�n, se la pides
			// a esa clase!>>
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "HR", "hr");
			stmt = conn.createStatement();
			rset = stmt
					.executeQuery("select * from employees where HR.employees.Salary > 3000 order by Salary");
			ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
			while (rset.next()) {
				Empleado e = new Empleado(rset.getInt(1), rset.getString(2),
						rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getDate(6), rset.getString(7),
						rset.getFloat(8), rset.getString(9), rset.getInt(10),
						rset.getInt(11));
				listaEmpleados.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally // libero recursos, de "adentro a fuera" , ResultSet,
					// Statment, Conexion
		{
			if (rset != null) {
				try {
					rset.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}

		}

	}

}
