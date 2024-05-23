
package pe.edu.uni.poo_ep_ayala.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.poo_ep_ayala.AccesoDb.AccesoDB;

public class RetiroService {
    
    public void registro(String id_codigo, double retiro, int contra, String empleado) {
        // Variables 
        Connection cn = null;
        String sql,estado;
        String referencia = "NULL",tipo ="004";
        PreparedStatement pstm;
        ResultSet rs;
        int filas, cont,clav;
        double saldo,sal_act;
        // Proceso
        try {
            // Inicio de Tx
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            // Verificar si existe la cuenta 
            sql = "SELECT count(1) cont FROM Cuenta WHERE chr_cuencodigo = ? ";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, id_codigo);
            rs = pstm.executeQuery();
            rs.next();
            cont = rs.getInt("cont");
            pstm.close();
            rs.close();
            if (cont != 1) {
                throw new SQLException("La cuenta no existe.");
            }
            // Validar la clave
            sql = "select chr_cuenclave ";
            sql += "from Cuenta ";
            sql += "where chr_cuencodigo = ? ";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, id_codigo);
            rs = pstm.executeQuery();
            rs.next();
            clav = rs.getInt("chr_cuenclave");
            pstm.close();
            rs.close();
            if (clav != contra ) {
                throw new SQLException("No es la clave correcta.");
            }
            // Validar que la cuenta este activa
            sql = "select vch_cuenestado estado ";
            sql += "from Cuenta ";
            sql += "where chr_cuencodigo = ? ";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, id_codigo);
            rs = pstm.executeQuery();
            rs.next();
            estado = rs.getString("estado");
            pstm.close();
            rs.close();
            if (estado == "ACTIVO" ) {
                throw new SQLException("La cuenta no esta activa.");
            }
            // Obteniendo el saldo y movimientos
            sql = "select dec_cuensaldo saldo, ";
            sql += "int_cuencontmov cant ";
            sql += "from Cuenta ";
            sql += "where chr_cuencodigo = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, id_codigo);
            rs = pstm.executeQuery();
            rs.next();
            saldo = rs.getDouble("saldo");
            cont = rs.getInt("cant");
            pstm.close();
            rs.close();
            if (saldo-retiro < 0 ) {
                throw new SQLException("No hay saldo suficiente.");
            }
            // Calculando el saldo
            sal_act = saldo-retiro;
            // Actualizando la cuenta
            cont++;
            sql = "update Cuenta set dec_cuensaldo = ?, ";
            sql += "int_cuencontmov = ? ";
            sql += "where chr_cuencodigo = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setDouble(1, sal_act);
            pstm.setInt(2, cont);
            pstm.setString(3, id_codigo);
            filas = pstm.executeUpdate();
            pstm.close();
            if (filas != 1) {
                throw new SQLException("Es posible que la cuenta no exista");
            }
            // Registrando la venta
            sql = "insert into Movimiento(chr_cuencodigo,int_movinumero, ";
            sql += "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia) ";
            sql += "values(?,?,sysdatetime(),?,?,?,?)";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, id_codigo);
            pstm.setInt(2, cont);
            pstm.setString(3, empleado);
            pstm.setString(4, tipo);
            pstm.setDouble(5, retiro);
            pstm.setString(6, referencia);
            pstm.executeUpdate();
            pstm.close();
            // Confirmando Tx
            cn.commit();    

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso, intentelo luego.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
}
