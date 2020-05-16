/**
 * 
 */
package com.github.davidepastore.lotteria.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This file read the File.
 * @author <a href="https://github.com/DavidePastore">DavidePastore</a>
 * 
 */
public class FileReader {

	/**
	 * Read the content of the file and return an array of strings.
	 * @param filename the filename
	 * @return array of strings.
	 * @throws IOException
	 */
	public String[] readLines(String filename) throws IOException {
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(getClass()
			.getClassLoader().getResourceAsStream(filename));
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		List<String> lines = new ArrayList<String>();
		String strLine;
		  
		//Read File Line By Line
		while ((strLine = br.readLine()) != null){
			lines.add(strLine);
		}
		br.close();
		
        return lines.toArray(new String[lines.size()]);
    }

}
