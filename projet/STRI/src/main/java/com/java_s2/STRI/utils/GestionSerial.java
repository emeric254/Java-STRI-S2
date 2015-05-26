package com.java_s2.STRI.utils;

import java.util.*;

/**
 * Classe qui gere les numeros d identifiant des classes
 * 
 * @author robin
 *
 */
public class GestionSerial {

    /**
     * Verifie l'existance d'un serial dans la liste set
     * 
     * @param set
     * @param Serial
     * @return Boolean 
     */
    public static boolean verifExistenceSerial(Set<Integer> set, int Serial)
    {
        return set.contains(Serial);
    }

    /**
     * retourne le prochain identifiant numerique correspondant a la set
     * @param set
     * @return int
     */
    public static int prochainSerial(Set<Integer> set)
    {
        int Serial = 0;

        // TODO re-implements a faire pour gros gains perf ...
        while(verifExistenceSerial(set, Serial))
        {
            Serial++;
        }

        return Serial;
    }
}
