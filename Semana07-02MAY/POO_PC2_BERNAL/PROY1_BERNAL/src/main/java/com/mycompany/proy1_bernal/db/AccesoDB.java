/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proy1_bernal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ideas
 */
public class AccesoDB {
    
    private AccesoDB() {
	}

	public static Connection getConnection() throws SQLException {
		Connection cn = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String urlDB = "jdbc:sqlserver://localhost:1433;databaseName=BOOKSTORE;encrypt=True;TrustServerCertificate=True;";
		String usuario = "sa";
		String pass = "sql";
                
		try {
			// Cargando el driver
			Class.forName(driver).getDeclaredConstructor().newInstance();
                        
			//conexion
			cn = DriverManager.getConnection(urlDB, usuario, pass);
                        
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw new SQLException("No se encontro el Driver de la base de datos BOOKSTORE.");
		} catch (Exception e) {
			throw new SQLException("No se puede establecer la conexion con la Base de Datos BOOKSTORE.");
		}
		return cn;
	}
    
}
