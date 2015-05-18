package com.java_s2.STRI.utils;

import java.util.*;

public class GestionSerial {

    public static boolean verifExistenceSerial(Set<Integer> set, int Serial)
    {
        return set.contains(Serial);
    }

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
