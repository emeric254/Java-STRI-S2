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
}
