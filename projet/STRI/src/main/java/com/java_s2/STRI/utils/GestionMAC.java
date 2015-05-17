package com.java_s2.STRI.utils;

import java.util.*;

public class GestionMAC {

	public static boolean verifExistenceMAC(Set ensemble, int addrMAC)
	{
		return GestionSerial.verifExistenceSerial(ensemble,addrMAC);
	}
	
	public static int prochainMAC(Set ensemble)
	{
		return GestionSerial.prochainSerial(ensemble);
	}
	
	public static String addrMACString(int addrMAC)
	{
		String chaine = Integer.toHexString(addrMAC).toUpperCase();
		while(chaine.length()<12)
			chaine = "0"+chaine;
		for(int i=2;i<chaine.length()-1;i+=3)
			chaine = chaine.substring(0, i) + ":" + chaine.substring(i);
		return chaine;
	}
}
