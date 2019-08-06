package br.com.thoughts.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetData {
    public String data(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }
}
