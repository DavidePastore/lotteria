package lotteria.utils;

import java.io.IOException;


/**
 * It generates names.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class GeneratoreNomi {
	
	private static String[] NOMI;
	private static boolean caricato = false;
	
	/**
	 * Generates a name.
	 * @return the name
	 */
	public static String generaNome(){
		if(!caricato){
			caricaNomi();
			caricato = true;
		}
		int randomNumber;
		randomNumber = GeneratoreNumeri.generaNumero(NOMI.length);
		return NOMI[randomNumber];
	}
	
	/**
	 * Load names from the file.
	 */
	private static void caricaNomi(){
		try {
			NOMI = FileReader.readLines("Nomi.txt");
		} catch (IOException e) {
			System.out.println("Error: "+e);
		}
	}

}
