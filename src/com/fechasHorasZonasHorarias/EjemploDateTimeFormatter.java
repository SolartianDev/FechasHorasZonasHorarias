package com.fechasHorasZonasHorarias;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EjemploDateTimeFormatter {

    public static void main(String[] args) {
        String fechaHoraComoCadena = "2023-09-28T15:30:00";
        DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime fechaHoraAnalizada = LocalDateTime.parse(fechaHoraComoCadena, formatoPersonalizado);

        System.out.println("Fecha y hora analizada: " + fechaHoraAnalizada);
        
        
         LocalDate fecha = LocalDate.of(2023, 9, 28);

        // Formatear solo la fecha
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fecha.format(formatoFecha);
        System.out.println("Fecha formateada: " + fechaFormateada);
    }
}
