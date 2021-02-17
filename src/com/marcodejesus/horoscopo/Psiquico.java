package com.marcodejesus.horoscopo;

import com.marcodejesus.horoscopo.helper.ManejadorDeFechas;
import com.marcodejesus.horoscopo.helper.Sexo;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.marcodejesus.horoscopo.helper.ManejadorDeFechas.isFechaCorrecta;

public class Psiquico {
    private String nombre;
    private final boolean genero;
    private String secreto;
    private String estadoDeAnimo;
    private String fechaNacimiento;
    Scanner escaner;
    private Date fechaConFormato;
    private final Paciente paciente;

    public Psiquico(String nombre, Sexo sexo) {
        this.nombre = nombre;
        this.genero = sexo == Sexo.HOMBRE;
        escaner = new Scanner(System.in);
        paciente = new Paciente();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void ImprimirMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public void ImprimirSaltoDeLinea(){
        System.out.println();
    }

    public void PensarAntesDeResponder(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getArticuloDeterminadoDeGenero() {
        return genero ? "El" : "La";
    }

    private String getVocalDeGenero(){
        return genero ? "o" : "a";
    }

    public void Saludar(){
        ImprimirMensaje("Hola! Que gusto estar aquí contigo.");
        ImprimirMensaje("Mi nombre es :");
        ImprimirSaltoDeLinea();

        ImprimirMensaje("******************************************************************");
        ImprimirMensaje("****  " + getPresentacionDelPsiquico());
        ImprimirMensaje("******************************************************************");
        ImprimirSaltoDeLinea();

        ImprimirMensaje("Y seré tu Espiritista durante ésta sesión.");
    }

    private String getPresentacionDelPsiquico(){
        return getAdjetivosDeFormaAleatoria() + " - " + getNombre().toUpperCase();
    }

    public String getAdjetivosDeFormaAleatoria() {
        Random aleatorio = new Random();
        String adjetivoAleatorio = "";

        List<String> listaDeAdjetivos = Arrays.asList(getArticuloDeterminadoDeGenero() + " Increible",
                getArticuloDeterminadoDeGenero() + " Poderos" + getVocalDeGenero(),
                getArticuloDeterminadoDeGenero() + " únic"+ getVocalDeGenero() + " Vidente",
                getArticuloDeterminadoDeGenero() + " Majestuos" + getVocalDeGenero());

        int numeroDeElementos = 3;

        for (int contador = 0; contador < numeroDeElementos; contador++) {
            int indiceAleatorio = aleatorio.nextInt(listaDeAdjetivos.size());
            adjetivoAleatorio = listaDeAdjetivos.get(indiceAleatorio);
        }

        return adjetivoAleatorio;
    }

    public void PreguntarPorElEstadoDeAnimoDeLaPersona() {
        ImprimirMensaje("Cuéntame, ¿Cómo te sientes el día de hoy?");
        estadoDeAnimo = escaner.nextLine();
        PensarAntesDeResponder(1);

        ImprimirMensaje("Te entiendo totalmente.");
        ImprimirMensaje("Te aseguro que después de ésta sesión, te sentirás mucho mejor!");
        ImprimirSaltoDeLinea();
        PensarAntesDeResponder(4);
    }

    public void IniciarRitual() {
        ImprimirMensaje("Ok! Iniciemos....");
        ImprimirMensaje("Dame tu fecha de nacimiento por favor.");
        ImprimirSaltoDeLinea();
        PensarAntesDeResponder(3);

        ImprimirMensaje("Ah! Recuerda que tiene que ser en formato de 'día/mes/año', OK?");
        ImprimirMensaje("Por ejemplo: 01/01/2019");
        ImprimirSaltoDeLinea();

        ValidateQueLaFechaSeaCorrecta();
        ImprimirSaltoDeLinea();

        ImprimirMensaje("... okayyyyyyyy.. mmm.. bien");
        PensarAntesDeResponder(2);
        ImprimirSaltoDeLinea();

        ImprimirMensaje("Oye, para tener ésta edad, te has mantenido en MUUYYY BUENA FORMA. Eh! ;)");
        PensarAntesDeResponder(1);

        ImprimirMensaje("Dime, ¿Cuál es tu secreto?");
        secreto = escaner.nextLine();
        PensarAntesDeResponder(2);
        ImprimirSaltoDeLinea();

        ImprimirMensaje("Wow! Gracias por el tip lo pondré en práctica.");
    }

    private void ValidateQueLaFechaSeaCorrecta() {
        boolean fechaCorrecta;

        do{
            ImprimirMensaje("Escribe aquí tu fecha de nacimiento: ");
            fechaNacimiento = escaner.nextLine();
            fechaCorrecta = isFechaCorrecta(fechaNacimiento);

            if(fechaCorrecta){
                fechaConFormato = ManejadorDeFechas.convertirStringADate(fechaNacimiento);
                break;
            }else{
                ImprimirSaltoDeLinea();
                ImprimirMensaje("No me eches mentiras, esa no es tu fecha de Nacimiento.");
                ImprimirMensaje("Vamos, tu puedes. Inténtalo de nuevo. dia/mes/año");
                ImprimirSaltoDeLinea();
            }
        }while(!fechaCorrecta);
    }

    public void DarHoroscopo() {
        PensarAntesDeResponder(3);
        ImprimirSaltoDeLinea();

        ImprimirMensaje("Bueno basta de charla. Además tengo que cobrar mis $800 por sesión");
        PensarAntesDeResponder(5);

        ImprimirMensaje("Me toca leer tu futuro y darte el horóscopo.");
        PensarAntesDeResponder(2);

        ImprimirMensaje("Así que ahí va....");

        PensarAntesDeResponder(3);
        ImprimirSaltoDeLinea();

        ImprimirMensaje("Ummmmmmmmmm..... ju ja cha cha cha...");
        ImprimirMensaje("Conectando con el Universo... ;)");
        PensarAntesDeResponder(6);
        ImprimirSaltoDeLinea();

        ImprimirMensaje("No te desesperes, ya voy!!! Cúenta conmigo:");
        PensarAntesDeResponder(3);

        ContarRegresivamente();

        ImprimirMensaje("LISTO!!!!!!!");
        PensarAntesDeResponder(1);

        Zodiaco zodiaco = new Zodiaco();
        SignoZodiacal signoZodiacal = zodiaco.getSignoZodical(fechaConFormato);

        ImprimirSaltoDeLinea();
        ImprimirMensaje("******************************************************************");
        ImprimirMensaje("******** Eres el Increible y Magnificente: " + signoZodiacal.getNombre().toUpperCase());
        ImprimirMensaje("******************************************************************");
        PensarAntesDeResponder(4);

        ImprimirMensaje("******** Y Tu Horóscopo del Día es: ");
        ImprimirMensaje("******** " + signoZodiacal.getHoroscopo());
        ImprimirMensaje("******************************************************************");
        PensarAntesDeResponder(9);
        ImprimirSaltoDeLinea();
        ImprimirSaltoDeLinea();

        ImprimirMensaje("De verdad espero que te sientas mucho mejor que antes; Recuerdas? Todo " + estadoDeAnimo.toUpperCase() + " y así!");
        PensarAntesDeResponder(4);
        ImprimirSaltoDeLinea();

        int edadPaciente = paciente.calcularEdad(fechaNacimiento);

        ImprimirMensaje("******************************************************************");
        ImprimirMensaje("********  Bueno, Seguiré tu consejo de: " + secreto + (edadPaciente>0 ? " para verme y sentirme de " + edadPaciente + " AÑOS!!!" : "."));
        ImprimirMensaje("******************************************************************");
        ImprimirSaltoDeLinea();
        PensarAntesDeResponder(4);

        ImprimirMensaje("EL UNIVERSO QUIERE QUE SEPAS QUE ERES UN GRAN DESARROLLADOR DE SOFTWARE!!!!");
        PensarAntesDeResponder(3);
        ImprimirSaltoDeLinea();
    }

    private void ContarRegresivamente() {
        for(int i = 3; i >=1; i--){
            ImprimirMensaje("En -> " + i + " <- ");
            PensarAntesDeResponder(2);
        }
    }
}
