/**
 * 
 */
package com.github.davidepastore.lotteria;

import com.github.davidepastore.lotteria.utils.GeneratoreCognomi;
import com.github.davidepastore.lotteria.utils.GeneratoreNomi;
import com.github.davidepastore.lotteria.utils.PersonaUtils;

/**
 * The main class of the project.
 * @author davidepastore
 * 
 */
public class Main {
	
	private static final int NUM_PERSONE = 1000000;
	private static Persona[] persona = new Persona[NUM_PERSONE];
	private static Lotteria lotteria = new Lotteria();

	/**
	 * The application starts here!
	 * @param args line commands arguments.
	 */
	public static void main(String[] args) {
		//Creates Persona objects
		createPersonas();
		
		//Let Persona objects play
		letPersonasPlay();
		
		//Let perform the extraction
		lotteria.estrazione();
		
		//Print the content of the Persona objects and lottery
		//PersonaUtils.printPersonas(persona);
		lotteria.printLotteria();
		
		//Let Persona objects control the numbers
		letPersonasControllaNumeri();
		
		//Print Persona result
		//PersonaUtils.printPersonasResult(persona);
		
		//Print Statistics
		printStatistics();
		
	}
	
	/**
	 * Create Persona objects.
	 */
	private static void createPersonas(){
		for(int i = 0; i < NUM_PERSONE; i++){
			persona[i] = new Persona(GeneratoreNomi.generaNome(), GeneratoreCognomi.generaCognome());
		}
	}
	
	/**
	 * Let Persona play.
	 */
	private static void letPersonasPlay(){
		for(int i = 0; i < NUM_PERSONE; i++){
			persona[i].giocaNumeri();
		}
	}
	
	/**
	 * Let Persona controls numbers.
	 */
	private static void letPersonasControllaNumeri(){
		for(int i = 0; i < NUM_PERSONE; i++){
			persona[i].controllaNumeri(lotteria.getNumeriEstratti(), lotteria.getJolly());
		}
	}
	
	/**
	 * Print Statistics on the extraction.
	 */
	private static void printStatistics(){
		int number;
		float probabilita;
		for(int i = 6; i >= 0; i--){
			
			//Normal numbers
			number = PersonaUtils.numberPersonasWithNMatched(persona, i);
			probabilita = (float) number*100/persona.length;
			System.out.printf("Le persone che hanno indovinato %d numeri sono: %d (probabilità: %.4f%%).\n", i, number, probabilita);
			if(number > 0 && i != 0){
				//PersonaUtils.printPersonaWithNMatched(persona, i);
			}
			
			//Numbers + jolly
			if(i > 0 && i < 6){
				number = PersonaUtils.numberPersonasWithNMatchedAndJolly(persona, i, lotteria.getJolly());
				probabilita = (float) number*100/persona.length;
				System.out.printf("Le persone che hanno indovinato %d numeri con il jolly sono: %d (probabilità: %.4f%%).\n", i, number, probabilita);
				if(number > 0){
					//PersonaUtils.printPersonaWithNMatchedAndJolly(persona, i, lotteria.getJolly());
				}
			}
		}
	}
	
	/**
	 * This set the jackpot of the lottery.
	 */
	private void setMontepremi(){
		
	}

}
