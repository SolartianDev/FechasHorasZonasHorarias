// Paso 1: Importar las clases y métodos necesarios
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
    // Paso 2: Declarar la clase y el método principal

    // Paso 3: Definir el formato de fecha y crear una variable para almacenar una fecha.
    String formatoFecha = "MMMM d, yyyy";
    LocalDate unaFecha = null;

    // Paso 4: Inicializar una variable booleana para verificar la validez de la cadena de fecha.
    boolean cadenaValida = false;

    // Paso 5: Crear un formateador de fecha y un lector de entrada (BufferedReader).
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formatoFecha);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Paso 6: Usar un bucle para solicitar una fecha hasta que se ingrese una cadena válida.
    while (!cadenaValida) {
      System.out.print("Ingrese una fecha (" + formatoFecha + "): ");
      try {
        // Paso 7: Leer la fecha ingresada como cadena y tratar de convertirla a un objeto LocalDate.
        String fechaIngresada = br.readLine();
        unaFecha = LocalDate.parse(fechaIngresada, formateador);
        cadenaValida = true;
      } catch (IOException | DateTimeParseException ex) {
        // Paso 8: Capturar excepciones de entrada incorrecta y mantener cadenaValida como falso.
        cadenaValida = false;
      }
    }

    // Paso 9: Imprimir la fecha ingresada.
    System.out.println("Fecha ingresada: " + unaFecha.format(formateador));

    // Paso 10: Obtener la fecha actual.
    LocalDate ahora = LocalDate.now();
    Period entreFechas;

    // Paso 11: Calcular el período de tiempo (años, meses y días) entre las dos fechas.
    if (unaFecha.isBefore(ahora)) {
      entreFechas = Period.between(unaFecha, ahora);
    } else {
      entreFechas = Period.between(ahora, unaFecha);
    }

    // Paso 12: Extraer los componentes del período (años, meses y días).
    int años = entreFechas.getYears();
    int meses = entreFechas.getMonths();
    int días = entreFechas.getDays();

    // Paso 13: Imprimir la diferencia de tiempo entre las dos fechas.
    System.out.println("Hay " + años + " años, " 
            + meses + " meses, " 
            + días + " días entre ahora y la fecha ingresada.");
  }
}



