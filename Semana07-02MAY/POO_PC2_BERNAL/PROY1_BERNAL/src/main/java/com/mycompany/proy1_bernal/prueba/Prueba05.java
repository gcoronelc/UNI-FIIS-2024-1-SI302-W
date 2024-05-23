/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proy1_bernal.prueba;

import com.mycompany.proy1_bernal.dto.PublicacionDto;
import com.mycompany.proy1_bernal.service.BookService;
import java.util.List;

public class Prueba05 {
    //Consulta de las publicaciones segun el tipo de publicacion
    public static void main(String[] args) {
        try {
            String tipo = "Revista";

            BookService service = new BookService();
            List<PublicacionDto> lista = service.ConsultaPublicacion(tipo);

            if (lista.isEmpty()) {
                throw new RuntimeException("El tipo de publicacion no esxiste.");
            }
            for (PublicacionDto dto : lista) {
                System.out.println(dto.toString());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
