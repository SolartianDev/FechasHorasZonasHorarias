package com.fechasHorasZonasHorarias.practica;

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TiempoEntreFechas {

  public static void main(String[] args) {
    String formatoFecha = "MMMM d, yyyy";
    LocalDate unaFecha = null;

    boolean cadenaValida = false;
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formatoFecha);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (!cadenaValida) {
      System.out.print("Ingrese una fecha (" + formatoFecha + "): ");
      try {
        String fechaIngresada = br.readLine();
        unaFecha = LocalDate.parse(fechaIngresada, formateador);
        cadenaValida = true;
      } catch (IOException | DateTimeParseException ex) {
        cadenaValida = false;
      }
    }

    System.out.println("Fecha ingresada: " + unaFecha.format(formateador));
    LocalDate ahora = LocalDate.now();
    Period entreFechas;
    if (unaFecha.isBefore(ahora)) {
      entreFechas = Period.between(unaFecha, ahora);
    } else {
      entreFechas = Period.between(ahora, unaFecha);
    }
    int años = entreFechas.getYears();
    int meses = entreFechas.getMonths();
    int días = entreFechas.getDays();
    System.out.println("Hay " + años + " años, " 
            + meses + " meses, " 
            + días + " días entre ahora y la fecha ingresada.");
  }
}


