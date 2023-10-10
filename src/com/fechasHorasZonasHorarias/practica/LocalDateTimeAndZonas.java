
package com.fechasHorasZonasHorarias.practica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static java.time.Month.*;  // Meses
import static java.time.DayOfWeek.*; // Dias de la semana
import static java.time.temporal.ChronoUnit.*;  // DAYS, HOURS, etc
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeAndZonas {
    public static void main(String[] args) {
        
    
    // Cumpleaños de Abe Lincoln: 12 de febrero de 1809, falleció el 15 de abril de 1855
    //   ¿Cuántos años tenía cuando murió?
    //   ¿Cuántos días vivió?
    LocalDate abeNacimiento = LocalDate.of(1809, FEBRUARY, 12);
    LocalDate abeMuerte = LocalDate.of(1855, APRIL, 15);
    System.out.println("Abe tenía " + abeNacimiento.until(abeMuerte, YEARS) + " cuando falleció.");
    System.out.println("Abe vivió por " + abeNacimiento.until(abeMuerte, DAYS) + " días.");
    System.out.println("");

    // Benedict Cumberbatch, 19 de julio de 1976
    //   ¿Nació en un año bisiesto?
    //   ¿Cuántos días tenía el año en que nació?
    //   ¿Cuántas décadas tiene?
    //   ¿Qué día de la semana fue en su 21er cumpleaños?
    LocalDate bennedict = LocalDate.of(1976, JULY, 19);
    System.out.println("Benedict nació en un año bisiesto: " + bennedict.isLeapYear());
    System.out.println("Días en el año en que nació: " + bennedict.lengthOfYear());
    LocalDate ahora = LocalDate.now();
    System.out.println("Benedict tiene " + bennedict.until(ahora, DECADES) + " décadas.");
    System.out.println("Fue un " + bennedict.plusYears(21).getDayOfWeek() + " en su 21er cumpleaños.");
    System.out.println("");

    // Tren sale de Boston a las 1:45 PM y llega a Nueva York a las 7:25 PM
    //   ¿Cuántos minutos dura el viaje en tren?
    //   Si el tren se retrasó 1 hora 19 minutos, ¿cuál es la hora de llegada real?
    LocalTime salida = LocalTime.of(13, 45);
    LocalTime llegada = LocalTime.of(19, 25);
    System.out.println("Tiempo de viaje planeado: " + salida.until(llegada, MINUTES) + " minutos");
    System.out.println("Hora de llegada retrasada: " + llegada.plusHours(1).plusMinutes(19));
    System.out.println("");

    // Vuelo: Boston a Miami, sale el 24 de marzo a las 9:15 PM. Duración del vuelo es de 4 horas 15 minutos
    //   ¿Cuándo llega a Miami?
    //   ¿Cuándo llega si el vuelo se retrasa 4 horas 27 minutos?
    LocalDateTime salidaBoston = LocalDateTime.of(2014, MARCH, 24, 21, 15);
    LocalDateTime llegadaMiami = salidaBoston.plusHours(4).plusMinutes(15);
    System.out.println("El vuelo llega a Miami: " + llegadaMiami);
    System.out.println("La hora de llegada retrasada es: " + llegadaMiami.plusHours(4).plusMinutes(27));
    System.out.println("");

    // El semestre escolar comienza el segundo martes de septiembre de este año.
    //   Pista: Mira la clase TemporalAdjusters
    //   ¿Cuál es la fecha?
    //   Las vacaciones de verano comienzan el 25 de junio
    //   Suponiendo:
    //     * Dos semanas de descanso en diciembre
    //     * Dos semanas de vacaciones adicionales
    //     * La escuela se enseña de lunes a viernes
    //   ¿Cuántos días de escuela hay?
    //   Pista: lleva un seguimiento de las semanas cortas también
    int semanasExcluidas = 5;
    LocalDate inicioEscuela = LocalDate.of(2014, SEPTEMBER, 1).with(TemporalAdjusters.firstInMonth(TUESDAY)).with(TemporalAdjusters.next(TUESDAY));
    LocalDate finPrimeraSemana = inicioEscuela.with(TemporalAdjusters.next(FRIDAY));
    long diasPrimeraSemana = inicioEscuela.until(finPrimeraSemana, DAYS) + 1;
    System.out.println("La escuela comienza: " + inicioEscuela);
    LocalDate finEscuela = LocalDate.of(2015, JUNE, 25);
    System.out.println("La escuela termina:   " + finEscuela);
    long diasUltimasSemanas = 0;
    if (finEscuela.getDayOfWeek() != MONDAY) {
      LocalDate inicioUltimaSemana = finEscuela.with(TemporalAdjusters.previous(MONDAY));
      diasUltimasSemanas = inicioUltimaSemana.until(finEscuela, DAYS) + 1;
      semanasExcluidas++;
    }
    long dias = ((inicioEscuela.until(finEscuela, WEEKS) - semanasExcluidas) * 5); // 7 días por semana, los días laborables son 5/7 de una semana.
    dias = dias + diasPrimeraSemana + diasUltimasSemanas;
    System.out.println("Número de días de escuela: " + dias);
    System.out.println("");

    // Una reunión está programada para la 1:30 PM del próximo martes. Si hoy es martes, asumir que es hoy.
    //   ¿Cuál es la hora de las reuniones de la semana?
    LocalTime horaReunion = LocalTime.of(13, 30);
    LocalDate fechaReunion = LocalDate.now().with(TemporalAdjusters.nextOrSame(TUESDAY));
    LocalDateTime reunion = LocalDateTime.of(fechaReunion, horaReunion);
    System.out.println("La hora de la reunión es: " + reunion);
    System.out.println("");
}
}