
package pe.edu.uni.poo_ep_ayala.Pruebas;

import java.sql.Connection;
import pe.edu.uni.poo_ep_ayala.AccesoDb.AccesoDB;

/**
 *
 * @author Metodos
 */
public class Prueba1 {
    
    public static void main(String[] args) {
        
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion OK.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
