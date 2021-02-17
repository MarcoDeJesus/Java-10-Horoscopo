package com.marcodejesus.horoscopo;

import com.marcodejesus.horoscopo.helper.ManejadorDeFechas;
import com.marcodejesus.horoscopo.signos.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Zodiaco {
    private static final int MES_PARA_SUMAR = 1;
    private static final String ANIO_DE_COMPARACION_SIGNOS_ZODIACALES = "/1990";
    private static final String ANIO_DE_COMPARASION_PARA_CAPRICORNIO = "/1989";
    private static final String SIGNO_ZODIACAL_CAPRICORNIO = "Capricornio";
    private static final int MES_DE_DICIEMBRE = 12;
    private GregorianCalendar calendario;
    private ArrayList<SignoZodiacal> signosZodiacales;
    private String fechaDeReferenciaEnString;
    private Date fechaEnDate;

    public Zodiaco(){
        this.calendario = new GregorianCalendar();
        this.signosZodiacales = new ArrayList<>();

        this.signosZodiacales.add(new Acuario());
        this.signosZodiacales.add(new Piscis());
        this.signosZodiacales.add(new Aries());
        this.signosZodiacales.add(new Tauro());
        this.signosZodiacales.add(new Geminis());
        this.signosZodiacales.add(new Cancer());
        this.signosZodiacales.add(new Leo());
        this.signosZodiacales.add(new Virgo());
        this.signosZodiacales.add(new Libra());
        this.signosZodiacales.add(new Escorpio());
        this.signosZodiacales.add(new Sagitario());
        this.signosZodiacales.add(new Capricornio());
    }

    public SignoZodiacal getSignoZodical(Date fechaNacimiento) {
        SignoZodiacal signoZodiacal = null;

        for (SignoZodiacal signo : signosZodiacales) {
            setFechaDeReferenciaEnString(signo, fechaNacimiento);
            if (elSignoZodiacalEsEncontrado(signo))
                signoZodiacal = signo;
        }

        return signoZodiacal;
    }

    //region Métodos que identifican y configuran la fecha de Referencia/Comparación de los
    // Signos Zodiacales.
    private void setFechaDeReferenciaEnString(SignoZodiacal signoZodiacal, Date fechaNacimiento){
        if(isCapricornio(signoZodiacal, fechaNacimiento)){
            setFechaDeReferenciaParaCapricornio(fechaNacimiento);
        }else{
            setFechaDeReferenciaParaSignosZodiacales(fechaNacimiento);
        }
    }

    private boolean isCapricornio(SignoZodiacal signoZodiacal, Date fechaNacimiento){
        int mes = getMesDeLaFechaDeNacimiento(fechaNacimiento);
        return signoZodiacal.getNombre().equals(SIGNO_ZODIACAL_CAPRICORNIO) && mes == MES_DE_DICIEMBRE;
    }

    private void setFechaDeReferenciaParaCapricornio(Date fechaNacimiento){
        setFechaDeReferenciaEnString(prepararFechaConAnioDeReferenica(fechaNacimiento, ANIO_DE_COMPARASION_PARA_CAPRICORNIO));
    }

    private void setFechaDeReferenciaParaSignosZodiacales(Date fechaNacimiento){
        setFechaDeReferenciaEnString(prepararFechaConAnioDeReferenica(fechaNacimiento, ANIO_DE_COMPARACION_SIGNOS_ZODIACALES));
    }

    private void setFechaDeReferenciaEnString(String fechaDeReferencia){
        fechaDeReferenciaEnString = fechaDeReferencia;
    }

    private String prepararFechaConAnioDeReferenica(Date fechaNacimiento, String anioDeComparacion){
        return getDiaDeLaFechaDeNacimiento(fechaNacimiento) +
                "/" +
                getMesDeLaFechaDeNacimiento(fechaNacimiento) +
                anioDeComparacion;
    }
    //endregion

    //region Métodos que trabajan con la configuracion y obtención del día
    // y mes de la Fecha de Nacimiento
    private int getMesDeLaFechaDeNacimiento(Date fecha){
        setCalendario(fecha);
        return getMesDeFecha() + MES_PARA_SUMAR;
    }

    private int getDiaDeLaFechaDeNacimiento(Date fecha){
        setCalendario(fecha);
        return getDiaDeFecha();
    }

    private void setCalendario(Date fecha){
        calendario.setTime(fecha);
    }

    private int getMesDeFecha(){
        return getCalendario().get(Calendar.MONTH);
    }

    private int getDiaDeFecha(){
        return getCalendario().get(Calendar.DAY_OF_MONTH);
    }

    private Calendar getCalendario(){
        return calendario;
    }
    //endregion

    //region Métodos que trabajan con la identificación de los Signos Zodiacales de acuerdo a las fechas
    private boolean elSignoZodiacalEsEncontrado(SignoZodiacal signoZodiacal){
        return (isLasFechasCoinciden(signoZodiacal));
    }

    private boolean isLasFechasCoinciden(SignoZodiacal signoZodiacal){
        return isFechaMinimaMenorOIgualALaFechaDeReferencia(signoZodiacal)
                && isFechaMaximaMenorOIgualALaFechaDeReferencia(signoZodiacal);
    }

    private boolean isFechaMinimaMenorOIgualALaFechaDeReferencia(SignoZodiacal signoZodiacal){
        setFechaDeReferenciaEnDate(getFechaDeReferenciaEnString());

        return !signoZodiacal
                .getFechaMinima()
                .after(getFechaDeReferenciaEnDate());
    }

    private boolean isFechaMaximaMenorOIgualALaFechaDeReferencia(SignoZodiacal signoZodiacal){
        setFechaDeReferenciaEnDate(getFechaDeReferenciaEnString());

        return !signoZodiacal
                .getFechaMaxima()
                .before(getFechaDeReferenciaEnDate());
    }

    private void setFechaDeReferenciaEnDate(String fecha){
        fechaEnDate = ManejadorDeFechas.convertirStringADate(fecha);
    }

    private String getFechaDeReferenciaEnString(){
        return fechaDeReferenciaEnString;
    }

    private Date getFechaDeReferenciaEnDate(){
        return fechaEnDate;
    }
    //endregion
}
