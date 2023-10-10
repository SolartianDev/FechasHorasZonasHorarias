package com.fechasHorasZonasHorarias;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.zone.ZoneOffsetTransition;

public class EjemploZoneOffsetTransition {

    public static void main(String[] args) {
        ZoneId USEast = ZoneId.of("America/New_York");
        LocalDateTime lateNight = LocalDateTime.of(2014, 3, 9, 2, 30); // Supongamos que "MARCH" es igual a 3
        ZoneOffsetTransition zot = USEast.getRules().getTransition(lateNight);
        
        if (zot != null) {
            if (zot.isGap()) {
                System.out.println("Es un 'gap'");
            }
            if (zot.isOverlap()) {
                System.out.println("Es una 'overlap'");
            }
        } else {
            System.out.println("No hay transición en esta fecha y hora");
        }
    }
}
