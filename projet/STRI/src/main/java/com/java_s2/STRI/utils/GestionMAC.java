package com.java_s2.STRI.utils;

import java.util.Map;

public class GestionMAC {

	public static boolean verifExistenceMAC(Map<Integer,Object> ensemble, int addrMAC)
	{
		return GestionSerial.verifExistenceSerial(ensemble,addrMAC);
	}
	
	public static int prochainMAC(Map<Integer,Object> ensemble)
	{
		return GestionSerial.prochainSerial(ensemble);
	}
	
	public static String addrMACString(int addrMAC)
	{
		String chaine = Integer.toHexString(addrMAC).toUpperCase();
		while(chaine.length()<12)
			chaine = "0"+chaine;
		
		return chaine;
	}
}
