/**
 * 
 */
package lotteria.utils;

import java.util.ArrayList;

/**
 * Array utility methods.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class ArrayUtils {
	
	/**
	 * Does ArrayList contain the needle?
	 * @param numeri ArrayList of short
	 * @param needle the needle to find.
	 * @return the boolean value.
	 */
	public static boolean contains(ArrayList<Short> numeri, short needle){
		return numeri.contains(needle);
		/*
		for(int i=0; i < numeri.size(); i++){
			if(numeri.get(i) == needle){
				return true;
			}
		}
		return false;
		*/
	}

}
