package com.marcodejesus.horoscopo.tests;

import com.marcodejesus.horoscopo.SignoZodiacal;
import com.marcodejesus.horoscopo.Zodiaco;
import com.marcodejesus.horoscopo.signos.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.marcodejesus.horoscopo.helper.ManejadorDeFechas.convertirStringADate;

public class HoroscopoTests {
    private static Date fechaConFormato;
    private static Zodiaco zodiaco;
    private static SignoZodiacal signoZodiacal;
    private static Acuario acuario;
    private static Piscis piscis;
    private static Aries aries;
    private static Tauro tauro;
    private static Geminis geminis;
    private static Cancer cancer;
    private static Leo leo;
    private static Virgo virgo;
    private static Libra libra ;
    private static Escorpio escorpio;
    private static Sagitario sagitario;
    private static Capricornio capricornio;
    private static List<String> listaFechasNacimiento;


    @BeforeClass
    public static void BeforeClass(){
        zodiaco = new Zodiaco();
        acuario= new Acuario();
        piscis = new Piscis();
        aries = new Aries();
        tauro = new Tauro();
        geminis = new Geminis();
        cancer = new Cancer();
        leo = new Leo();
        virgo = new Virgo();
        libra = new Libra();
        escorpio = new Escorpio();
        sagitario = new Sagitario();
        capricornio = new Capricornio();
        listaFechasNacimiento = Arrays.asList("20/01/1990","19/02/1990","21/03/1990","20/04/1990",
                "21/05/1990","21/06/1990","23/07/1990","23/08/1990","23/09/1990","23/10/1990","22/11/1990","22/12/1990");
    }

    @Test
    public void DadoUnaFechaDeNacimiento_CuandoSeDaConFormatoIncorrecto_EntoncesUnaExcepcionEsArrojada() throws ParseException {
        var nombreSignoZodiacal = "Acuario";
        var horoscopoEsperado = "Hoy tu mundo puede presentarse algo confuso. Quizás tratar de comprender qué está sucediendo no resulte la tarea más sencilla. ";
        Date fechaConFormato = convertirStringADate("2oiu0/993/13213201/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnaListaDeSignosZodiacalesConSusFechasDeNacimiento_CuandoSeComparanLasListasDeNombres_EntoncesLasListasSonIguales() throws ParseException {
        List<String> listaNombresActuales = null;
        String[] arregloDeNombres = new String[listaFechasNacimiento.size()];
        List<String> listaNombresEsperados = Arrays.asList(acuario.getNombre(), piscis.getNombre(), aries.getNombre(),
                tauro.getNombre(), geminis.getNombre(), cancer.getNombre(), leo.getNombre(), virgo.getNombre(), libra.getNombre(),
                escorpio.getNombre(), sagitario.getNombre(), capricornio.getNombre());

        for(int i = 0; i < listaFechasNacimiento.size(); i++){
            Date fechaConFormato = convertirStringADate(listaFechasNacimiento.get(i));
            signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

            arregloDeNombres[i] = signoZodiacal.getNombre();
        }
        listaNombresActuales = Arrays.asList(arregloDeNombres);

        Assert.assertEquals(listaNombresActuales, listaNombresEsperados, "Las listas no son iguales.");
        Assert.assertNotSame(listaNombresActuales, listaNombresEsperados, "Las listas son la misma.");
    }
    
    @Test
    public void DadoUnaListaDeSignosZodiacalesConSusHoroscopos_CuandoSeComparanLasListasDeHoroscopos_EntoncesLasListasSonIguales() throws ParseException {
        List<String> listaHoroscoposActual = null;
        String[] arregloDeNombres = new String[listaFechasNacimiento.size()];
        List<String> listaHoroscopoEsperada = Arrays.asList(acuario.getHoroscopo(), piscis.getHoroscopo(), aries.getHoroscopo(),
                tauro.getHoroscopo(), geminis.getHoroscopo(), cancer.getHoroscopo(), leo.getHoroscopo(), virgo.getHoroscopo(), libra.getHoroscopo(),
                escorpio.getHoroscopo(), sagitario.getHoroscopo(), capricornio.getHoroscopo());

        for(int i = 0; i < listaFechasNacimiento.size(); i++){
            Date fechaConFormato = convertirStringADate(listaFechasNacimiento.get(i));
            signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);
            arregloDeNombres[i] = signoZodiacal.getHoroscopo();
        }
        listaHoroscoposActual = Arrays.asList(arregloDeNombres);

        Assert.assertEquals(listaHoroscoposActual, listaHoroscopoEsperada, "Las listas no son iguales.");
        Assert.assertNotSame(listaHoroscoposActual, listaHoroscopoEsperada, "Las listas son la misma.");
    }

    @Test
    public void DadoUnSignoAcuarioConFechaDeRangoInicial_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Acuario";
        var horoscopoEsperado = "Hoy tu mundo puede presentarse algo confuso. Quizás tratar de comprender qué está sucediendo no resulte la tarea más sencilla. ";
        Date fechaConFormato = convertirStringADate("20/01/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoAcuarioConFechaDeRangoFinal_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Acuario";
        var horoscopoEsperado = "Hoy tu mundo puede presentarse algo confuso. Quizás tratar de comprender qué está sucediendo no resulte la tarea más sencilla. ";
        Date fechaConFormato = convertirStringADate("18/02/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoAcuarioConFechaDeRangoIntermedio_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Acuario";
        var horoscopoEsperado = "Hoy tu mundo puede presentarse algo confuso. Quizás tratar de comprender qué está sucediendo no resulte la tarea más sencilla. ";
        Date fechaConFormato = convertirStringADate("01/02/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoPiscisConFechaDeRangoInicial_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Piscis";
        var horoscopoEsperado = "Tu personalidad ha cambiado ligeramente en las últimas semanas y hoy podrías ver indicaciones de que los demás están cambiando su concepto de ti; es probable que ganes más respeto y consideración. ";
        Date fechaConFormato = convertirStringADate("19/02/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoPiscisConFechaDeRangoFinal_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Piscis";
        var horoscopoEsperado = "Tu personalidad ha cambiado ligeramente en las últimas semanas y hoy podrías ver indicaciones de que los demás están cambiando su concepto de ti; es probable que ganes más respeto y consideración. ";
        Date fechaConFormato = convertirStringADate("20/03/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoPiscisConFechaDeRangoIntermedio_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Piscis";
        var horoscopoEsperado = "Tu personalidad ha cambiado ligeramente en las últimas semanas y hoy podrías ver indicaciones de que los demás están cambiando su concepto de ti; es probable que ganes más respeto y consideración. ";
        Date fechaConFormato = convertirStringADate("15/03/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoAriesConFechaDeRangoInicial_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Aries";
        var horoscopoEsperado = "Cierta información nueva y fascinante, posiblemente relacionada con temas espirituales o metafísicos, podrían llegar a ti a través de libros, revistas, televisión o la Internet. ";
        Date fechaConFormato = convertirStringADate("21/03/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoAriesConFechaDeRangoFinal_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Aries";
        var horoscopoEsperado = "Cierta información nueva y fascinante, posiblemente relacionada con temas espirituales o metafísicos, podrían llegar a ti a través de libros, revistas, televisión o la Internet. ";
        Date fechaConFormato = convertirStringADate("19/04/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoAriesConFechaDeRangoIntermedio_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Aries";
        var horoscopoEsperado = "Cierta información nueva y fascinante, posiblemente relacionada con temas espirituales o metafísicos, podrían llegar a ti a través de libros, revistas, televisión o la Internet. ";
        Date fechaConFormato = convertirStringADate("09/04/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoCapricornioConFechaDeRangoInicial_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Capricornio";
        var horoscopoEsperado = "Las estrellas indican que hoy podrías recibir varias cartas o llamadas telefónicas. Puedes recibir información científica fascinante sobre un tema que te interesa. ";
        Date fechaConFormato = convertirStringADate("22/12/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoCapricornioConFechaDeRangoFinal_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Capricornio";
        var horoscopoEsperado = "Las estrellas indican que hoy podrías recibir varias cartas o llamadas telefónicas. Puedes recibir información científica fascinante sobre un tema que te interesa. ";
        Date fechaConFormato = convertirStringADate("19/01/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }

    @Test
    public void DadoUnSignoCapricornioConFechaDeRangoIntermedio_CuandoSeVerificaElNombreYElHoroscopo_EntoncesElNombreYElHoroscopoCorrectoEsTraido() throws ParseException {
        var nombreSignoZodiacal = "Capricornio";
        var horoscopoEsperado = "Las estrellas indican que hoy podrías recibir varias cartas o llamadas telefónicas. Puedes recibir información científica fascinante sobre un tema que te interesa. ";
        Date fechaConFormato = convertirStringADate("04/01/1970");

        signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        Assert.assertEquals(signoZodiacal.getNombre(), nombreSignoZodiacal, "El Nombre del Signo Zodiacal es incorrecto.");
        Assert.assertEquals(signoZodiacal.getHoroscopo(), horoscopoEsperado, "El Horoscopo del Signo Zodiacal es incorrecto.");
    }
}
