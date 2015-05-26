/**
 * 
 */
package com.java_s2.STRI.gestionBD;
import com.java_s2.STRI.utils.PostgreSQL;
/**
 * @author robin
 *
 */
public class mainSuppBD {

	/**
	 * Supprime les tables de la base de donnée si elle existe
	 * @param args
	 */
	public static void main(String[] args) {
		PostgreSQL.detruireBase();
	}

}
