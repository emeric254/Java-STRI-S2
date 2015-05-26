/**
 * 
 */
package com.java_s2.STRI.gestionBD;
import com.java_s2.STRI.utils.PostgreSQL;
/**
 * @author robin
 *
 */
public class mainCreerBD {

	/**
	 * Cree la base de donnees, en effectuant un clear avant
	 * @param args
	 */
	public static void main(String[] args) {
		PostgreSQL.creerBase();
	}

}
