package com.java_s2.STRI.utils;

import java.util.*;

/**
 * @author robin
 *
 */
public class GestionMAC {

	/**
	 * Verifie l'existence de l'adresse mac dans la Set ensemble
	 * 
	 * @param ensemble
	 * @param addrMAC
	 * @return
	 */
	public static boolean verifExistenceMAC(Set<Integer> ensemble, int addrMAC)
	{
		return GestionSerial.verifExistenceSerial(ensemble,addrMAC);
	}
	
	/**
	 * Genere la prochaine adresse mac unique dans le programme
	 * 
	 * @param ensemble
	 * @return
	 */
	public static int prochainMAC(Set<Integer> ensemble)
	{
		return GestionSerial.prochainSerial(ensemble);
	}
	
	/**
	 * Retourne une adresse mac au format chaine FF:FF:FF:FF:FF:FF
	 * @param addrMAC
	 * @return
	 */
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
