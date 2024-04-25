package pe.edu.uni.eurekaapp.prueba;

import java.sql.Connection;
import pe.edu.uni.eurekaapp.db.AccesoDB;

public class Prueba01 {

	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexion Ok.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
