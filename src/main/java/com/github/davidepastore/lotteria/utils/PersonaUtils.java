/**
 * 
 */
package com.github.davidepastore.lotteria.utils;

import com.github.davidepastore.lotteria.Persona;

/**
 * Generic utility for Persona.
 * @author <a href="https://github.com/DavidePastore">DavidePastore</a>
 * 
 */
public class PersonaUtils {
	
	private static final short spacesNum = 30;
	
	/**
	 * Print a persona.
	 * @param persona the persona object you want to print.
	 * @param nomeMaxSize The max size of the nome field.
	 * @param cognomeMaxSize The max size of the cognome field.
	 */
	public static void printPersona(Persona persona, int nomeMaxSize, int cognomeMaxSize){
		String numeriGiocati = ArrayToString.shortArrayToString(persona.getNumeriGiocati());
		System.out.printf("%-" + nomeMaxSize + "." + nomeMaxSize + "s %-" + cognomeMaxSize + "." + cognomeMaxSize + "s %-" + spacesNum + "." + spacesNum + "s\n" , persona.getNome(), persona.getCognome(), numeriGiocati);
	}
	
	/**
	 * Print an array of persona.
	 * @param persone the persona array you want to print.
	 */
	public static void printPersonas(Persona[] persone){
		int nomeMaxSize = calculateSizeOfNomeField(persone, -1, (short) -1);
		int cognomeMaxSize = calculateSizeOfCognomeField(persone, -1, (short) -1);
		for(int i=0; i < persone.length; i++){
			printPersona(persone[i], nomeMaxSize, cognomeMaxSize);
		}
	}
	
	/**
	 * Print a persona statistics.
	 * @param persona the persona object you want to print.
	 * @param nomeMaxSize The max size of the nome field.
	 * @param cognomeMaxSize The max size of the cognome field.
	 */
	private static void printPersonaResult(Persona persona, int nomeMaxSize, int cognomeMaxSize) {
		String numeriGiocati;
		String numeriIndovinati;
		numeriGiocati = ArrayToString.shortArrayToString(persona.getNumeriGiocati());
		numeriIndovinati = ArrayToString.shortArrayToString(persona.getNumeriIndovinati());
		System.out.printf("%-" + nomeMaxSize + "." + nomeMaxSize + "s %-" + cognomeMaxSize + "." + cognomeMaxSize + "s %-" + spacesNum + "." + spacesNum + "s %-15.15b %-15.15s \n" , persona.getNome(), persona.getCognome(), numeriGiocati, persona.won(), numeriIndovinati);
	}

	/**
	 * Print the personas statistics.
	 * @param persone persone the persona array you want to print.
	 */
	public static void printPersonasResult(Persona[] persone) {
		int nomeMaxSize = calculateSizeOfNomeField(persone, -1, (short) -1);
		int cognomeMaxSize = calculateSizeOfCognomeField(persone, -1, (short) -1);
		for(int i=0; i < persone.length; i++){
			printPersonaResult(persone[i], nomeMaxSize, cognomeMaxSize);
		}
	}
	
	/**
	 * Print the persona statistics with jolly.
	 * @param persona persone the persona array you want to print.
	 * @param jolly the jolly value.
	 * @param nomeMaxSize The max size of the nome field.
	 * @param cognomeMaxSize The max size of the cognome field.
	 */
	public static void printPersonaResultWithJolly(Persona persona, short jolly, int nomeMaxSize, int cognomeMaxSize) {
		String numeriGiocati;
		String numeriIndovinati;
		numeriGiocati = ArrayToString.shortArrayToString(persona.getNumeriGiocati());
		numeriIndovinati = ArrayToString.shortArrayToString(persona.getNumeriIndovinati());
		System.out.printf("%-" + nomeMaxSize + "." + nomeMaxSize + "s %-" + cognomeMaxSize + "." + cognomeMaxSize + "s %-" + spacesNum + "." + spacesNum + "s %-7.7b %-15.15s with jolly: [%-5d] \n" , persona.getNome(), persona.getCognome(), numeriGiocati, persona.won(), numeriIndovinati, jolly);
	}

	/**
	 * Print the person who matched number numbers.
	 * @param persone the persona array in which you want to search
	 * @param number number matched
	 */
	public static void printPersonaWithNMatched(Persona[] persone, int number) {
		boolean trovato = false;
		int nomeMaxSize = calculateSizeOfNomeField(persone, number, (short) -1);
		int cognomeMaxSize = calculateSizeOfCognomeField(persone, number, (short) -1);
		for(int i=0; i < persone.length; i++){
			if(persone[i].getNumeriIndovinati().size() == number){
				printPersonaResult(persone[i], nomeMaxSize, cognomeMaxSize);
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
		int nomeMaxSize = calculateSizeOfNomeField(persone, number, jolly);
		int cognomeMaxSize = calculateSizeOfCognomeField(persone, number, jolly);
		for(int i=0; i < persone.length; i++){
			if(persone[i].getNumeriIndovinati().size() == number && persone[i].getNumeriGiocati().contains(jolly)){
				printPersonaResultWithJolly(persone[i], jolly, nomeMaxSize, cognomeMaxSize);
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
	public static int numberPersonasWithNMatchedAndJolly(Persona[] persone, int number, int jolly){
		int conta = 0;
		for(int i=0; i < persone.length; i++){
			if(persone[i].getNumeriIndovinati().size() == number && persone[i].getNumeriGiocati().contains(jolly)){
				conta++;
			}
		}
		return conta;
	}

	/**
	 * Calculate the max size of the nome field.
	 * @param persone The array with the persone of which calculate the max nome size.
	 * @param number number matched.
	 * @param jolly The jolly number.
	 * @return Returns the max of the nome field.
	 */
	private static int calculateSizeOfNomeField(Persona[] persone, int number, short jolly) {
		int size = 1;
		for (int i = 0; i < persone.length; i++) {
			if((number == -1 || persone[i].getNumeriIndovinati().size() == number) &&
				(jolly == -1 || persone[i].getNumeriGiocati().contains(jolly))){
				int length = persone[i].getNome().length();
				if (size < length) {
					size = length;
				}
			}
		}

		return size;
	}
	
	/**
	 * Calculate the max size of the cognome field.
	 * @param persone The array with the persone of which calculate the max cognome size.
	 * @param number number matched.
	 * @param jolly The jolly number.
	 * @return Returns the max of the cognome field.
	 */
	private static int calculateSizeOfCognomeField(Persona[] persone, int number, short jolly) {
		int size = 1;
		for (int i = 0; i < persone.length; i++) {
			if((number == -1 || persone[i].getNumeriIndovinati().size() == number) &&
				(jolly == -1 || persone[i].getNumeriGiocati().contains(jolly))){
				int length = persone[i].getCognome().length();
				if (size < length) {
					size = length;
				}
			}
		}

		return size;
	}

}
