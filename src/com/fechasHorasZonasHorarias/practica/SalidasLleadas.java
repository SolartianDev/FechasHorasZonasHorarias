// Paso 1: Importar las clases y métodos necesarios
package com.fechasHorasZonasHorarias.practica;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static java.time.Month.*;

public class SalidasLleadas {
    public static void main(String[] args) {
        // Paso 2: Declarar la clase y el método principal

        // Paso 3: Definir zonas horarias para los aeropuertos
        // Utilizando la información proporcionada.

        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");

        // Paso 4: Definir la información del vuelo 123, San Francisco a Boston.

        LocalDateTime salida = LocalDateTime.of(2014, JUNE, 13, 22, 30);
        ZonedDateTime salidaSFO = ZonedDateTime.of(salida, SFO);
        System.out.println("El vuelo 123 sale de SFO a las:   " + salidaSFO);
        ZonedDateTime horaSalidaEnBOS = salidaSFO.toOffsetDateTime().atZoneSameInstant(BOS);
        System.out.println("Hora local en BOS al despegue: " + horaSalidaEnBOS);
        System.out.println("Tiempo de vuelo: 5 horas 30 minutos");
        ZonedDateTime llegadaBOS = salidaSFO.plusHours(5).plusMinutes(30).toOffsetDateTime().atZoneSameInstant(BOS);
        System.out.println("El vuelo 123 llega a BOS:      " + llegadaBOS);
        ZonedDateTime horaLlegadaEnSFO = llegadaBOS.toOffsetDateTime().atZoneSameInstant(SFO);
        System.out.println("Hora local en SFO a la llegada:   " + horaLlegadaEnSFO);
        System.out.println("");

        // Paso 5: Definir la información del vuelo 456, San Francisco a Bangalore, India.

        salida = LocalDateTime.of(2014, JUNE, 28, 22, 30);
        salidaSFO = ZonedDateTime.of(salida, SFO);
        System.out.println("El vuelo 456 sale de SFO a las:    " + salidaSFO);
        ZonedDateTime horaSalidaEnBLR = salidaSFO.toOffsetDateTime().atZoneSameInstant(BLR);
        System.out.println("Hora local en BLR al despegue: " + horaSalidaEnBLR);
        System.out.println("Tiempo de vuelo: 22 horas");
        ZonedDateTime llegadaBLR = salidaSFO.plusHours(22).toOffsetDateTime().atZoneSameInstant(BLR);
        System.out.println("El vuelo 456 llega a BLR:      " + llegadaBLR);
        horaLlegadaEnSFO = llegadaBLR.toOffsetDateTime().atZoneSameInstant(SFO);
        System.out.println("Hora local en SFO a la llegada:   " + horaLlegadaEnSFO);
        System.out.println("");

        // Paso 6: Definir la información del vuelo 123, San Francisco a Boston, en noviembre.

        salida = LocalDateTime.of(2014, NOVEMBER, 1, 22, 30);
        salidaSFO = ZonedDateTime.of(salida, SFO);
        System.out.println("El vuelo 123 sale de SFO a las:    " + salidaSFO);
        horaSalidaEnBOS = salidaSFO.toOffsetDateTime().atZoneSameInstant(BOS);
        System.out.println("Hora local en BOS al despegue: " + horaSalidaEnBOS);
        System.out.println("Tiempo de vuelo: 5 horas 30 minutos");
        llegadaBOS = salidaSFO.plusHours(5).plusMinutes(30).toOffsetDateTime().atZoneSameInstant(BOS);
        System.out.println("El vuelo 123 llega a BOS:      " + llegadaBOS);
        horaLlegadaEnSFO = llegadaBOS.toOffsetDateTime().atZoneSameInstant(SFO);
        System.out.println("Hora local en SFO a la llegada:   " + horaLlegadaEnSFO);
        System.out.println("");
    }
}
