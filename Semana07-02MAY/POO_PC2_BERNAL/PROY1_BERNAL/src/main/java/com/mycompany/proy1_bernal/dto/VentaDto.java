/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proy1_bernal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class VentaDto {
    private int idventa;
    private String cliente;
    private String fecha;
    private int idempleado;
    private String idpublicacion;
    private int cantidad;
    private double precio;
    private double dcto;
    private double subtotal;
    private double impuesto;
    private double total;
}
