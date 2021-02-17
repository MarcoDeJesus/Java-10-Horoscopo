package com.marcodejesus.horoscopo.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManejadorDeFechas {

    public static Date convertirStringADate(String fecha){
        SimpleDateFormat formatoSimpleDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if(isFechaCorrecta(fecha)){
                return formatoSimpleDeFecha.parse(fecha);
            }else{
                throw new IllegalArgumentException("El formato de fecha no es correcto.");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isFechaCorrecta(String fecha){
        return fecha.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
    }
}
