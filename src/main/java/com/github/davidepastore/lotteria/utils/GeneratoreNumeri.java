/**
 * 
 */
package com.github.davidepastore.lotteria.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is an utility to generate numbers.
 * @author <a href="https://github.com/DavidePastore">DavidePastore</a>
 * 
 */
public class GeneratoreNumeri {
	
	/**
	 * Generates an integer number from 0(inclusive) to numeroMax (exclusive).
	 * @param numeroMax the max number.
	 * @return the number generates
	 */
	public static short generaNumero(int numeroMax){
		Random random = new Random();
		return (short) random.nextInt(numeroMax);
	}
	
	/**
	 * Generates an array of numero elementi elements integer numbers from 0 (inclusive) to numeroMax (exclusive).
	 * @param numeroMax the max number
	 * @param numeroElementi the number of elements
	 * @return the array of numbers
	 */
	public static ArrayList<Short> generaNumeriUnivoci(short numeroMax, short numeroElementi){
		ArrayList<Short> numeri = new ArrayList<Short>();
		short numeroGenerato;
		for(int i=0; i < numeroElementi; i++){
			numeroGenerato = (short) (generaNumero(numeroMax) + 1);
			if(ArrayUtils.contains(numeri, numeroGenerato)){
				i--;
			}
			else{
				numeri.add(numeroGenerato);
			}
		}
		return numeri;
	}
	
	/**
	 * Generates an array of numero elementi elements integer numbers from 0 (inclusive) to numeroMax (exclusive).
	 * @param numeroMax Max the max number
	 * @param numeroElementi Elementi the number of elements
	 * @param arrayOriginale the numbers must be different from this array.
	 * @return the array of numbers
	 */
	public static ArrayList<Short> generaNumeriUnivoci(short numeroMax, short numeroElementi, ArrayList<Short> arrayOriginale){
		short numeroGenerato;
		ArrayList<Short> numeri = new ArrayList<Short>();
		for(int i=0; i < numeroElementi; i++){
			numeroGenerato = (short) (generaNumero(numeroMax) + 1);
			if(ArrayUtils.contains(arrayOriginale, numeroGenerato)){
				i--;
			}
			else{
				numeri.add(numeroGenerato);
			}
		}
		return numeri;
	}

}
