package com.marcodejesus;

import com.marcodejesus.horoscopo.Psiquico;
import com.marcodejesus.horoscopo.helper.Sexo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Psiquico psiquico = null;
        String opcionSeleccionada = null;

        do{
            System.out.println("¿Quieres conocer tu Horóscopo?");
            System.out.println("Selecciona una de las opciones desde tu teclado: ");
            System.out.println("1 - para Walter.");
            System.out.println("2 - para Mizada.");
            System.out.println("3 - si no quieres conectar con el Universo.");

            opcionSeleccionada = scanner.nextLine();

            if(opcionSeleccionada.equals("1")){
                psiquico = new Psiquico("Gasparin", Sexo.HOMBRE);

                psiquico.Saludar();
                psiquico.PreguntarPorElEstadoDeAnimoDeLaPersona();
                psiquico.IniciarRitual();
                psiquico.DarHoroscopo();
            }else if(opcionSeleccionada.equals("2")) {
                psiquico = new Psiquico("Mizada Mohamed", Sexo.MUJER);

                psiquico.Saludar();
                psiquico.PreguntarPorElEstadoDeAnimoDeLaPersona();
                psiquico.IniciarRitual();
                psiquico.DarHoroscopo();
            }else if(opcionSeleccionada.equals("3")){
                System.out.println("Que la fuerza te acompañe! Bye!");
                break;
            }else{
                System.out.println();
                System.out.println("HEY! Solo selecciona una de las opciones en tu teclado. ");
                System.out.println("Del 1 al 3.");
                System.out.println();
            }
        }while(!opcionSeleccionada.equals("1")
                || !opcionSeleccionada.equals("2")
                || !opcionSeleccionada.equals("3"));
    }
}
