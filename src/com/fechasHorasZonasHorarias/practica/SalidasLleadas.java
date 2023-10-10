package com.fechasHorasZonasHorarias.practica;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static java.time.Month.*;

public class SalidasLleadas {
    public static void main(String[] args) {
    // Utilizando la siguiente información:
    //   * Usa America/New_York como zona horaria para el Aeropuerto Logan de Boston (BOS).
    //   * Usa America/Los_Angeles como zona horaria para el Aeropuerto de San Francisco (SFO).
    //   * Usa Asia/Calcuta como zona horaria para el Aeropuerto Internacional de Bengaluru en Bangalore (BLR).
    ZoneId SFO = ZoneId.of("America/Los_Angeles");
    ZoneId BOS = ZoneId.of("America/New_York");
    ZoneId BLR = ZoneId.of("Asia/Calcutta");

    // Vuelo 123, San Francisco a Boston, sale de SFO a las 10:30 PM el 13 de junio de 2014
    // El vuelo dura 5 horas 30 minutos
    //   ¿Cuál es la hora local en Boston cuando despega el vuelo?
    //   ¿Cuál es la hora local en el Aeropuerto Logan de Boston cuando llega el vuelo?
    //   ¿Cuál es la hora local en San Francisco cuando llega el vuelo?
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

    // Vuelo 456, San Francisco a Bangalore, India, sale de SFO el sábado a las 10:30 PM el 28 de junio de 2014
    // El tiempo de vuelo es de 22 horas
    //   ¿Llegará el viajero a una reunión en Bangalore el lunes a las 9 AM hora local?
    //   ¿Podrá el viajero llamar a su esposo a una hora razonable?
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

    // Vuelo 123, San Francisco a Boston, sale de SFO a las 10:30 PM el sábado, 1 de noviembre de 2014
    // El tiempo de vuelo es de 5 horas 30 minutos.
    //   ¿En qué día y hora llega el vuelo a Boston?
    //   ¿Qué sucedió?
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
