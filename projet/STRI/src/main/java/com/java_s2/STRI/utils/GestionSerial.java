package com.java_s2.STRI.utils;

import java.util.*;

public class GestionSerial {

	public boolean verifExistenceSerial(Map<Integer,Object> ensemble, int Serial)
	{
		return ensemble.containsKey(Serial);
	}
	
	public int prochainSerial(Map<Integer,Object> ensemble)
	{
		int Serial = 0;
		
		//@TODO re-implements a faire pour gros gains perf ...
		while(verifExistenceSerial(ensemble, Serial))
		{
			Serial++;
		}
		
		return Serial;
	}
}
