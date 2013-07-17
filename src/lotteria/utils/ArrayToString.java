/**
 * 
 */
package lotteria.utils;

import java.util.ArrayList;

/**
 * Generic utility for conversion from array of number to String.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class ArrayToString {
	
	/**
	 * Short array to String.
	 * @param arrayList array of short
	 * @return a String
	 */
	public static String shortArrayToString(ArrayList<Short> arrayList){
		StringBuilder stringBuilder = new StringBuilder("[");
		for(int i = 0; i < arrayList.size(); i++){
			stringBuilder.append(arrayList.get(i));
			if(i < arrayList.size() - 1){
				stringBuilder.append(", ");
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
