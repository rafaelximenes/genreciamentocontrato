package br.gov.cgsus.gerenciamentocontrato.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.domain.UsuarioContrato;
import br.gov.cgsus.gerenciamentocontrato.service.UsuarioBusiness;

public class Util {
	
	public static Integer diferencaDeDiasEntreDatas(Date inicio, Date termino) {
        // Dando um exemplo: quantos dias se passam desde 07/09/1822 até 05/06/2006?
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false);
        long dt = (termino.getTime() - inicio.getTime()) + 3600000; // 1 hora para compensar horário de verão
        String retorno = (dt / 86400000L)+""; // passaram-se 67111 dias
        return new Integer(retorno) +1;
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
	
	public static String geraSHA256(String string) { 
		MessageDigest digest;
		byte[] hash = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			hash = digest.digest(string.getBytes(StandardCharsets.UTF_8));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static boolean temPerfilParaAcessar(Usuario u, Contrato c, Integer codFuncionalidade) {
		if(u==null || c==null || codFuncionalidade==null) 
			return false;
		if(u.getId()==null || c.getId()==null) {
			return false;
		}
		if(isAdmin(u, c))
			return true;
		UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("id_contrato", c.getId());
		map.put("id_usuario", u.getId());
		map.put("id_funcionalidade", codFuncionalidade);
		try {
			return usuarioBusiness.selectUsuarioTemPerfil(map);
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static boolean isAdmin(Usuario u, Contrato c) {
		UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
		UsuarioContrato uc = new UsuarioContrato();
		uc.setContrato(c);
		uc.setUsuario(u);
		try {
			return usuarioBusiness.selectUsuarioIsAdmin(uc);
		} catch (Exception e) {
			return false;
		}
	}

}
