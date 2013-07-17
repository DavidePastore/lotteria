package lotteria;

import java.util.ArrayList;

import lotteria.utils.GeneratoreNumeri;

/**
 * Persona representation.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class Persona {
	
	private String nome;
	private String cognome;
	private ArrayList<Short> numeriGiocati = new ArrayList<Short>();
	
	private ArrayList<Short> numeriIndovinati = new ArrayList<Short>();
	private boolean jollyIndovinato = false;
	
	/**
	 * Constructor of the class.
	 * @param nome the name of the Persona.
	 * @param cognome the surname of the Persona.
	 */
	public Persona(String nome, String cognome){
		this.nome = nome;
		this.cognome = cognome;
	}
	
	/**
	 * Play the numbers.
	 */
	public void giocaNumeri(){
		numeriGiocati = GeneratoreNumeri.generaNumeriUnivoci((short) 90,(short) 6);
	}
	
	/**
	 * Get the name of the Persona.
	 * @return the name of the Persona.
	 */
	public String getNome(){
		return nome;
	}
	
	/**
	 * Get the surname of the Persona.
	 * @return the surname of the Persona.
	 */
	public String getCognome(){
		return cognome;
	}

	/**
	 * @return the numeriGiocati
	 */
	public ArrayList<Short> getNumeriGiocati() {
		return numeriGiocati;
	}

	/**
	 * @param numeriGiocati the numeriGiocati to set
	 */
	public void setNumeriGiocati(ArrayList<Short> numeriGiocati) {
		this.numeriGiocati = numeriGiocati;
	}
	
	/**
	 * @return the numeriIndovinati
	 */
	public ArrayList<Short> getNumeriIndovinati() {
		return numeriIndovinati;
	}

	/**
	 * @param numeriIndovinati the numeriIndovinati to set
	 */
	public void setNumeriIndovinati(ArrayList<Short> numeriIndovinati) {
		this.numeriIndovinati = numeriIndovinati;
	}
	
	/**
	 * Check if a person has won.
	 * @param numeriLotteria the numbers of lottery.
	 * @param jolly the jolly
	 */
	public void controllaNumeri(ArrayList<Short> numeriLotteria, short jolly){
		
		//Check for numbers of lottery
		for(int i=0; i < numeriLotteria.size(); i++){
			for(int j=0; j < numeriGiocati.size(); j++){
				if(numeriGiocati.get(j) == numeriLotteria.get(i)){
					numeriIndovinati.add(numeriGiocati.get(j));
				}
			}
		}
		
		//Check for jolly
		if(numeriGiocati.contains(jolly)){
			jollyIndovinato = true;
		}
		
	}
	
	/**
	 * Check if a person has won (has guessed at least one number).
	 * @return boolean value.
	 */
	public boolean won(){
		if(numeriIndovinati.size() > 0 || jollyIndovinato){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Check if the jolly has been found.
	 * @return the jolly has been found?
	 */
	public boolean jollyIndovinato(){
		return jollyIndovinato;
	}

}
