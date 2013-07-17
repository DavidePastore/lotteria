/**
 * 
 */
package lotteria.utils;

import java.io.IOException;


/**
 * It generates surnames.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class GeneratoreCognomi {

	private static String[] COGNOMI;
	private static boolean caricato = false;
	
	/**
	 * Generates a surname.
	 * @return the surname.
	 */
	public static String generaCognome(){
		if(!caricato){
			caricaCognomi();
			caricato = true;
		}
		int randomNumber;
		randomNumber = GeneratoreNumeri.generaNumero(COGNOMI.length);
		return COGNOMI[randomNumber];
	}
	
	/**
	 * Load surnames from the file.
	 */
	private static void caricaCognomi(){
		try {
			COGNOMI = FileReader.readLines("Cognomi.txt");
		} catch (IOException e) {
			System.out.println("Error: "+e);
		}
	}
}
