/**
 * 
 */
package lotteria;

import java.util.ArrayList;

import lotteria.utils.ArrayToString;
import lotteria.utils.GeneratoreNumeri;

/**
 * This class represents the lottery.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class Lotteria {
	
	private long montepremi = 20 * 1000 * 1000l;
	private short jolly = 0;
	private ArrayList<Short> numeriEstratti = new ArrayList<Short>();
	
	
	/**
	 * Get the jackpot.
	 * @return the jackpot.
	 */
	public long getMontepremi(){
		return this.montepremi;
	}
	
	/**
	 * Set the jackpot.
	 * @param montepremi
	 */
	public void setMontepremi(long montepremi){
		this.montepremi = montepremi;
	}
	
	/**
	 * Performs the extraction of numbers.
	 */
	public void estrazione(){
		numeriEstratti = GeneratoreNumeri.generaNumeriUnivoci((short) 90,(short) 6);
		jolly = GeneratoreNumeri.generaNumeriUnivoci((short) 90,(short) 6, numeriEstratti).get(0);
	}
	
	/**
	 * Get numbers.
	 * @return numbers.
	 */
	public ArrayList<Short> getNumeriEstratti(){
		return numeriEstratti;
	}
	
	/**
	 * Set numbers.
	 * @param numeri numbers to set.
	 */
	public void setNumeriEstratti(ArrayList<Short> numeri){
		this.numeriEstratti = numeri;
	}

	/**
	 * @return the jolly.
	 */
	public short getJolly() {
		return jolly;
	}

	/**
	 * @param jolly the jolly to set.
	 */
	public void setJolly(short jolly) {
		this.jolly = jolly;
	}
	
	/**
	 * It will print the lottery numbers.
	 */
	public void printLotteria(){
		String stringNumeri = ArrayToString.shortArrayToString(numeriEstratti);
		System.out.printf("Lotteria: %42s Jolly: %d \n", stringNumeri, jolly);
	}
	

}
