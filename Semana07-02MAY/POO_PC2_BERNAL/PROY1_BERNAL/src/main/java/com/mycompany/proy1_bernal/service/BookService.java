/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proy1_bernal.service;

import com.mycompany.proy1_bernal.db.AccesoDB;
import com.mycompany.proy1_bernal.dto.PromocionDto;
import com.mycompany.proy1_bernal.dto.PublicacionDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    //Consulta de promociones
    public List<PromocionDto> ConsultaPromo() {
        List<PromocionDto> lista = new ArrayList<>();

        String sql = "SELECT idpromocion IDPROMOCION, ";
        sql += "cantmin CANTMIN, ";
        sql += "cantmax CANTMAX, ";
        sql += "porcentaje PORCENTAJE ";
        sql += "FROM PROMOCION";

        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;

        try {
            // Conexion
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(sql);

            rs = pstm.executeQuery();
            //Filas de la tabla
            while (rs.next()) {
                int IDPROMOCION = rs.getInt("IDPROMOCION");
                int CANTMIN = rs.getInt("CANTMIN");
                int CANTMAX = rs.getInt("CANTMAX");
                double PORCENTAJE = rs.getDouble("PORCENTAJE");
                PromocionDto dto = new PromocionDto(IDPROMOCION, CANTMIN, CANTMAX, PORCENTAJE);
                lista.add(dto);
            }

            rs.close();
            pstm.close();

        } catch (Exception e) {
            throw new RuntimeException("Error en el servicio de CONSULTAPROMO.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

        return lista;
    }

    //Consulta de publicaciones segun su tipo
    public List<PublicacionDto> ConsultaPublicacion(String TipoPublicacion) {
        List<PublicacionDto> lista = new ArrayList<>();

        String sql = "SELECT p.idpublicacion IdPublicacion, ";
        sql += "p.titulo Titulo, ";
        sql += "p.autor Autor, ";
        sql += "p.nroedicion NroEdicion, ";
        sql += "p.precio Precio, ";
        sql += "p.stock Stock ";
        sql += "FROM PUBLICACION p ";
        sql += "JOIN TIPO t ON p.idtipo=t.idtipo ";
        sql += "WHERE t.descripcion= ? ";

        Connection cn= null;
        PreparedStatement pstm;
        ResultSet rs;

        try {
            // Conexion
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, TipoPublicacion);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String id = rs.getString("IdPublicacion");
                String titulo = rs.getString("Titulo");
                String autor = rs.getString("Autor");
                int nro_edicion = rs.getInt("NroEdicion");
                double precio = rs.getDouble("Precio");
                int stock = rs.getInt("Stock");
                PublicacionDto dto = new PublicacionDto(id, titulo, autor, nro_edicion, precio, stock);
                lista.add(dto);
            }

            rs.close();
            pstm.close();

        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso del service ConsultaPublicacion.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }
    
    //Registro de nuevas ventas
    public void RegistroVenta(String cliente, String fecha, int id_emp, String publi, int cant, double dscto ) {

        String sql;
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        
        int cantidad, stock_inicial, min, max, stock;
        double precio, porcentaje, subtotal, impuesto;
        

        //Proceso
        try {
            // Conexion
            cn = AccesoDB.getConnection();
            
            // Validando si el idpublicacion existe
            sql = "SELECT count(*) cantidad, idpublicacion, precio, stock Stock_inicio  FROM PUBLICACION WHERE idpublicacion= ? ";
            sql += "GROUP BY PUBLICACION.idpublicacion, PUBLICACION.precio, PUBLICACION.stock";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, publi);
            rs = pstm.executeQuery();
            rs.next();
           cantidad = rs.getInt("cantidad");
           precio= rs.getDouble("precio");
           stock_inicial= rs.getInt("Stock_inicio");
           
            rs.close();
            pstm.close();
            if (cantidad== 0) {
                throw new SQLException("El ID de la publicacion no existe.");
            }

            
            // Calculando el descuento
            sql = "SELECT  cantmin CANTMIN, cantmax CANTMAX,porcentaje PORCENTAJE FROM PROMOCION WHERE porcentaje= ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, String.valueOf(dscto));
            rs = pstm.executeQuery();
            rs.next();
            min = rs.getInt("CANTMIN");
            max = rs.getInt("CANTMAX");
            porcentaje= rs.getDouble("PORCENTAJE"); //hallamos el descuento
            
            rs.close();
            pstm.close();
//            if (cant>=min && cant<=max) {
//                throw new SQLException("El descuento esta correctamente.");
//            }
//            else{
//                throw new SQLException("El descuento esta incorrectamente.");
//            }

            
            
            // Calular venta
            double total;
            total = (precio-dscto)*cant;
            subtotal= total/ 1.18;
            impuesto= total-subtotal;
                    
                    

            // Validando si hay stock
            sql = "SELECT SUM(cantidad) cantididad_comprada FROM VENTA WHERE idpublicacion= ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, publi);
            rs = pstm.executeQuery();
            rs.next();
            stock= rs.getInt("cantidad_comprada");
            
            if ((stock_inicial-stock)<= 0) {
                throw new SQLException("No hay Stock disponible.");
            }
            rs.close();
            pstm.close();

            //insertaremos el id dela venta
            sql = "SELECT COUNT(*) cantidad FROM VENTA";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.next();
            int id_venta = rs.getInt("cantidad") + 1;
            rs.close();
            pstm.close();

            // Insertando en la tabla Venta
            sql = "INSERT INTO VENTA (idventa,cliente,fecha,idempleado,idpublicacion,cantidad,precio,dcto,subtotal,impuesto,total) ";
            sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id_venta);
            pstm.setString(2, cliente);
            pstm.setString(3, fecha);
            pstm.setInt(4, id_emp);
            pstm.setString(5, publi);
            pstm.setInt(6, cant);
            pstm.setDouble(7, precio);
            pstm.setDouble(8, dscto);
            pstm.setDouble(9, subtotal);
            pstm.setDouble(10, impuesto);
            pstm.setDouble(11, total);
            pstm.executeUpdate();
            pstm.close();

            cn.commit();

        } catch (SQLException e) {
            try {
                cn.rollback(); // Cancela la Tx
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback(); // Cancela la Tx
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en el proceso.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
}
