/**
 * 
 */
package lotteria.utils;

import lotteria.Persona;

/**
 * Generic utility for Persona.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 * 
 */
public class PersonaUtils {
	
	private static final short spacesNum = 30;
	
	/**
	 * Print a persona.
	 * @param persona the persona object you want to print.
	 */
	public static void printPersona(Persona persona){
		String numeriGiocati = ArrayToString.shortArrayToString(persona.getNumeriGiocati());
		System.out.printf("%-15.15s %-15.15s %-" + spacesNum + "."+spacesNum+"s\n" , persona.getNome(), persona.getCognome(), numeriGiocati);
	}
	
	/**
	 * Print an array of persona.
	 * @param persone the persona array you want to print.
	 */
	public static void printPersonas(Persona[] persone){
		for(int i=0; i < persone.length; i++){
			printPersona(persone[i]);
		}
	}
	
	/**
	 * Print a persona statistics.
	 * @param persona the persona object you want to print.
	 */
	private static void printPersonaResult(Persona persona) {
		String numeriGiocati;
		String numeriIndovinati;
		numeriGiocati = ArrayToString.shortArrayToString(persona.getNumeriGiocati());
		numeriIndovinati = ArrayToString.shortArrayToString(persona.getNumeriIndovinati());
		System.out.printf("%-15.15s %-15.15s %-" + spacesNum + "."+spacesNum+"s %-15.15b %-15.15s \n" , persona.getNome(), persona.getCognome(), numeriGiocati, persona.won(), numeriIndovinati);
	}

	/**
	 * Print the personas statistics.
	 * @param persone persone the persona array you want to print.
	 */
	public static void printPersonasResult(Persona[] persone) {
		for(int i=0; i < persone.length; i++){
			printPersonaResult(persone[i]);
		}
	}
	
	/**
	 * Print the persona statistics with jolly.
	 * @param persona persone the persona array you want to print.
	 * @param jolly the jolly value
	 */
	public static void printPersonaResultWithJolly(Persona persona, short jolly) {
		String numeriGiocati;
		String numeriIndovinati;
		numeriGiocati = ArrayToString.shortArrayToString(persona.getNumeriGiocati());
		numeriIndovinati = ArrayToString.shortArrayToString(persona.getNumeriIndovinati());
		System.out.printf("%-15.15s %-15.15s %-" + spacesNum + "."+spacesNum+"s %-7.7b %-15.15s with jolly: [%-5d] \n" , persona.getNome(), persona.getCognome(), numeriGiocati, persona.won(), numeriIndovinati, jolly);
	}

	/**
	 * Print the person who matched number numbers.
	 * @param persone the persona array in which you want to search
	 * @param number number matched
	 */
	public static void printPersonaWithNMatched(Persona[] persone, int number) {
		boolean trovato = false;
		for(int i=0; i < persone.length; i++){
			if(persone[i].getNumeriIndovinati().size() == number){
				printPersonaResult(persone[i]);
				trovato = true;
			}
		}
		if(!trovato){
			System.out.println("Nessuna persona ha indovinato "+number+" numeri.");
		}
	}
	
	/**
	 * Return the number of Personas who matched number numbers.
	 * @param persone the persona array you want to print.
	 * @param number number matched
	 * @return Return the number of Personas who matched number numbers.
	 */
	public static int numberPersonasWithNMatched(Persona[] persone, int number){
		int conta = 0;
		for(int i=0; i < persone.length; i++){
			if(persone[i].getNumeriIndovinati().size() == number){
				conta++;
			}
		}
		return conta;
	}
	
	/**
	 * Print the person who matched number numbers with jolly.
	 * @param persone the persona array in which you want to search
	 * @param number number matched
	 * @param jolly the jolly number
	 */
	public static void printPersonaWithNMatchedAndJolly(Persona[] persone, int number, short jolly) {
		boolean trovato = false;
		int numTrovati = 0;
		for(int i=0; i < persone.length; i++){
			if(persone[i].getNumeriIndovinati().size() == number && persone[i].getNumeriGiocati().contains(jolly)){
				printPersonaResultWithJolly(persone[i], jolly);
				trovato = true;
				numTrovati++;
			}
		}
		if(!trovato){
			System.out.println("Nessuna persona ha indovinato "+number+" numeri.");
		}
		
		System.out.println("Numero trovati: "+numTrovati+".");
	}
	
	/**
	 * Return the number of Personas who matched number numbers and jolly.
	 * @param persone the persona array you want to print.
	 * @param number number matched
	 * @param jolly the jolly number
	 * @return Return the number of Personas who matched number numbers and jolly.
	 */
	public static int numberPersonasWithNMatchedAndJolly(Persona[] persone, int number, short jolly){
		int conta = 0;
		for(int i=0; i < persone.length; i++){
			if(persone[i].getNumeriIndovinati().size() == number && persone[i].getNumeriGiocati().contains(jolly)){
				conta++;
			}
		}
		return conta;
	}
	
	

}
