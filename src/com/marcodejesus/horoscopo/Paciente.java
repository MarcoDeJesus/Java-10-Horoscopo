package com.marcodejesus.horoscopo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Paciente {

    public int calcularEdad(String fechaNacimiento) {
        try{
            LocalDate fecha = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate fechaActual = LocalDate.now();

            if ((fechaNacimiento != null) && (fechaActual != null)) {
                return Period.between(fecha, fechaActual).getYears();
            } else {
                return 0;
            }
        }catch(Exception ex){
            return 0;
        }
    }
}
