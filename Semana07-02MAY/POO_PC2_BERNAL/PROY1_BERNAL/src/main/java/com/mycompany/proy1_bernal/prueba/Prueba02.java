/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proy1_bernal.prueba;

import com.mycompany.proy1_bernal.dto.PromocionDto;
import com.mycompany.proy1_bernal.service.BookService;
import java.util.List;


public class Prueba02 {
    //Prueba para consultar la tabla de promociones
    public static void main(String[] args) {
        try {
            BookService service = new BookService();
            List<PromocionDto> lista = service.ConsultaPromo();
            
            for (PromocionDto dto : lista) {
                System.out.println(dto.toString());
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
