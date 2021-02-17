package com.marcodejesus.horoscopo;

import com.marcodejesus.horoscopo.helper.ManejadorDeFechas;

import java.util.Date;

public class SignoZodiacal {

    private String nombre;
    private String horoscopo;
    private Date fechaMinima;
    private Date fechaMaxima;

    public SignoZodiacal(){

    }

    public Date getFechaMinima(){
        return this.fechaMinima;
    }

    public Date getFechaMaxima(){
        return this.fechaMaxima;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setFechaMinima(String fechaMinima){
        this.fechaMinima = ManejadorDeFechas.convertirStringADate(fechaMinima);
    }

    public void setFechaMaxima(String fechaMaxima){
        this.fechaMaxima = ManejadorDeFechas.convertirStringADate(fechaMaxima);
    }

    public void setHoroscopo(String horoscopo){
        this.horoscopo = horoscopo;
    }

    public String getHoroscopo(){
        return this.horoscopo;
    }
}
