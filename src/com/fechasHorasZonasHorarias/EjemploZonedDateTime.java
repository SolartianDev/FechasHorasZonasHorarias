package com.fechasHorasZonasHorarias;

import java.time.ZonedDateTime;

import java.time.ZoneId;

public class EjemploZonedDateTime {

    public static void main(String[] args) {
        // Obtener la fecha y hora actual en una zona horaria específica
        ZonedDateTime ahora = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        System.out.println("Fecha y hora actual en Bogota: " + ahora);

        // Crear una fecha y hora específica en una zona horaria específica
        ZonedDateTime fechaHoraPersonalizada = ZonedDateTime.of(2023, 9, 28, 12, 0, 0, 0, ZoneId.of("Europe/Paris"));
        System.out.println("Fecha y hora personalizada en París: " + fechaHoraPersonalizada);

        // Realizar cálculos con las fechas y horas
        ZonedDateTime futuro = ahora.plusHours(3);
        System.out.println("Fecha y hora actual en Bogota después de 3 horas: " + futuro);

        // Convertir una fecha y hora a otra zona horaria
        ZonedDateTime mismoInstanteEnOtraZona = fechaHoraPersonalizada.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Mismo instante en Tokio: " + mismoInstanteEnOtraZona);
        
        ZonedDateTime mismoInstanteEnOtraZona2 = fechaHoraPersonalizada.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        System.out.println("Mismo instante en Paris: " + mismoInstanteEnOtraZona2);
    }
}

