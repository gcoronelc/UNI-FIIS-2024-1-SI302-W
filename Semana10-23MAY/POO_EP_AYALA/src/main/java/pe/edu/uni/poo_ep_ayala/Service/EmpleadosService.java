
package pe.edu.uni.poo_ep_ayala.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.poo_ep_ayala.AccesoDb.AccesoDB;
import pe.edu.uni.poo_ep_ayala.Dto.EmpleadosDto;


public class EmpleadosService {
    
    public List<EmpleadosDto> getEmpleados(String id_sucursal) {
        // Variables
        List<EmpleadosDto> lista = new ArrayList<>();
        String sql = "select e.chr_emplcodigo codigo, ";
        sql += "CONCAT(e.vch_emplpaterno,e.vch_emplmaterno,e.vch_emplnombre) nombre, ";
        sql += "e.vch_emplusuario usuario, ";
        sql += "a.dtt_asigfechaalta fecha, ";
        sql += "a.dtt_asigfechabaja fec_baja ";
        sql += "from Empleado e ";
        sql += "join Asignado a on e.chr_emplcodigo = a.chr_emplcodigo ";
        sql += "where chr_sucucodigo = ?";
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        // Proceso
        try {
            // Conexion
            cn = AccesoDB.getConnection();
            // Preparando Consulta
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, id_sucursal);
            // Ejecutando consulta
            rs = pstm.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String usuario = rs.getString("usuario");
                String fecha = rs.getString("fecha");
                String fec_baja = rs.getString("fec_baja");
                if (fec_baja == null) {
                    fec_baja = "NO DISPONIBLE";
                }
                EmpleadosDto dto = new EmpleadosDto(codigo, nombre, usuario, fecha, fec_baja);
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
