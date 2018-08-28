package br.gov.cgsus.gerenciamentocontrato.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static Integer diferencaDeDiasEntreDatas(Date inicio, Date termino) {
        // Dando um exemplo: quantos dias se passam desde 07/09/1822 até 05/06/2006?
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false);
        long dt = (termino.getTime() - inicio.getTime()) + 3600000; // 1 hora para compensar horário de verão
        String retorno = (dt / 86400000L)+""; // passaram-se 67111 dias
        return new Integer(retorno);
    }
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static void main(String[] args) {
		System.out.println(round(48.664666D, 2));
	}

}
