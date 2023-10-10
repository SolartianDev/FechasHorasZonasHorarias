package com.fechasHorasZonasHorarias;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class EjemploOffsetDateTime {

    public static void main(String[] args) {
        // Crear una fecha y hora con un desplazamiento específico desde UTC
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2023, 9, 28, 12, 0, 0, 0, ZoneOffset.ofHours(-5));
        System.out.println("Fecha y hora con desplazamiento: " + offsetDateTime);

        // Obtener la fecha y hora actual con desplazamiento
        OffsetDateTime ahoraConDesplazamiento = OffsetDateTime.now();
        System.out.println("Fecha y hora actual con desplazamiento: " + ahoraConDesplazamiento);

        // Realizar cálculos con OffsetDateTime
        OffsetDateTime futuro = ahoraConDesplazamiento.plusHours(3);
        System.out.println("Fecha y hora actual con desplazamiento después de 3 horas: " + futuro);
        
        
        
         // Definir la zona horaria de Londres
        ZoneId London = ZoneId.of("Europe/London");

        // Supongamos que staffCall es una LocalDateTime en la zona horaria Pacific
        LocalDateTime staffCall = LocalDateTime.of(2023, 9, 28, 12, 0);

        // Convertir staffCall a OffsetDateTime
        OffsetDateTime staffCallOffset = staffCall.atOffset(ZoneOffset.ofHours(-7));

        // Convertir staffCallOffset a ZonedDateTime en la zona horaria de Londres
        ZonedDateTime staffCallUK = staffCallOffset.atZoneSameInstant(London);

        System.out.println("Staff call (Pacific) is at: " + staffCallOffset);
        System.out.println("Staff call (UK) is at:      " + staffCallUK);
    }
}
