
package pe.edu.uni.poo_ep_ayala.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.poo_ep_ayala.AccesoDb.AccesoDB;
import pe.edu.uni.poo_ep_ayala.Dto.CuentasDto;


public class CuentasService {
    
    public List<CuentasDto> getCuentas(String id_cliente) {
        // Variables
        List<CuentasDto> lista = new ArrayList<>();
        String sql = "select c.chr_cuencodigo codigo, ";
        sql += "s.vch_sucunombre sucursal, ";
        sql += "m.vch_monedescripcion moneda, ";
        sql += "c.vch_cuenestado estado, c.dec_cuensaldo saldo ";
        sql += "from Cuenta c ";
        sql += "join Sucursal s on c.chr_sucucodigo = s.chr_sucucodigo ";
        sql += "join Moneda m on c.chr_monecodigo = m.chr_monecodigo ";
        sql += "where chr_cliecodigo = ?";
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        // Proceso
        try {
            // Conexion
            cn = AccesoDB.getConnection();
            // Preparando Consulta
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, id_cliente);
            // Ejecutando consulta
            rs = pstm.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String sucursal = rs.getString("sucursal");
                String moneda = rs.getString("moneda");
                String estado = rs.getString("estado");
                double saldo = rs.getDouble("saldo");
                CuentasDto dto = new CuentasDto(codigo, sucursal, moneda, estado, saldo);
                lista.add(dto);
            }
            // Liberando objetos
            pstm.close();
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        // Resultado
        return lista;
    }
}
