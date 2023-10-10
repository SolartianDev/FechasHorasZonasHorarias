// Paso 1: Importar las clases y métodos necesarios
package com.fechasHorasZonasHorarias.practica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static java.time.Month.*;  // Meses
import static java.time.DayOfWeek.*; // Días de la semana
import static java.time.temporal.ChronoUnit.*;  // DAYS, HOURS, etc
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeAndZonas {
    public static void main(String[] args) {
        // Paso 2: Declarar la clase y el método principal

        // Paso 3: Crear objetos para representar fechas de nacimiento y muerte de Abe Lincoln
        // y calcular su edad y días de vida.
        LocalDate abeNacimiento = LocalDate.of(1809, FEBRUARY, 12);
        LocalDate abeMuerte = LocalDate.of(1855, APRIL, 15);
        System.out.println("Abe tenía " + abeNacimiento.until(abeMuerte, YEARS) 
                + " cuando falleció.");
        System.out.println("Abe vivió por " + abeNacimiento.until(abeMuerte, DAYS)
                + " días.");
        System.out.println("");

        // Paso 4: Crear objeto para representar la fecha de nacimiento de Benedict Cumberbatch
        // y realizar cálculos relacionados con su nacimiento.
        LocalDate bennedict = LocalDate.of(1976, JULY, 19);
        System.out.println("Benedict nació en un año bisiesto: " + bennedict.isLeapYear());
        System.out.println("Días en el año en que nació: " + bennedict.lengthOfYear());
        LocalDate ahora = LocalDate.now();
        System.out.println("Benedict tiene " + bennedict.until(ahora, DECADES)
                + " décadas.");
        System.out.println("Fue un " + bennedict.plusYears(21).getDayOfWeek() 
                + " en su 21er cumpleaños.");
        System.out.println("");

        // Paso 5: Crear objetos para representar las horas de salida y llegada de un tren
        // y calcular la duración del viaje y la hora de llegada real si hay un retraso.
        LocalTime salida = LocalTime.of(13, 45);
        LocalTime llegada = LocalTime.of(19, 25);
        System.out.println("Tiempo de viaje planeado: " 
                + salida.until(llegada, MINUTES)+ " minutos");
        System.out.println("Hora de llegada retrasada: " 
                + llegada.plusHours(1).plusMinutes(19));
        System.out.println("");

        // Paso 6: Crear objetos para representar la fecha y hora de salida de un vuelo,
        // calcular la hora de llegada y la hora de llegada retrasada si hay un retraso.
        LocalDateTime salidaBoston = LocalDateTime.of(2014, MARCH, 24, 21, 15);
        LocalDateTime llegadaMiami = salidaBoston.plusHours(4).plusMinutes(15);
        System.out.println("El vuelo llega a Miami: " + llegadaMiami);
        System.out.println("La hora de llegada retrasada es: " 
                + llegadaMiami.plusHours(4).plusMinutes(27));
        System.out.println("");

        // Paso 7: Calcular la fecha de inicio y finalización del semestre escolar,
        // así como la cantidad de días de clases, teniendo en cuenta días de descanso y
        // que la escuela se enseña de lunes a viernes.
        int semanasExcluidas = 5;
        LocalDate inicioEscuela = LocalDate.of(2014, SEPTEMBER, 1).with(TemporalAdjusters.firstInMonth(TUESDAY)).with(TemporalAdjusters.next(TUESDAY));
        LocalDate finPrimeraSemana = inicioEscuela.with(TemporalAdjusters.next(FRIDAY));
        long diasPrimeraSemana = inicioEscuela.until(finPrimeraSemana, DAYS)
                + 1;
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

        // Paso 8: Calcular la hora de una reunión programada para el próximo martes y
        // mostrar la hora de la reunión.
        LocalTime horaReunion = LocalTime.of(13, 30);
        LocalDate fechaReunion = LocalDate.now().with(TemporalAdjusters.nextOrSame(TUESDAY));
        LocalDateTime reunion = LocalDateTime.of(fechaReunion, horaReunion);
        System.out.println("La hora de la reunión es: " + reunion);
        System.out.println("");
    }
}
