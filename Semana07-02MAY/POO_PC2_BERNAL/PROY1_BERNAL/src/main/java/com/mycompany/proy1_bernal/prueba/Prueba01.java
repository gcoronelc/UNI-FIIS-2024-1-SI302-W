/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proy1_bernal.prueba;

import com.mycompany.proy1_bernal.db.AccesoDB;
import java.sql.Connection;

/**
 *
 * @author Ideas
 */
public class Prueba01 {
    public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection(); //conexion
			System.out.println("Se conecto con la base de datos BOOKSTORE.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
