package ie.gmit.sw;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	//Variables
	String[] words = null;
	
	//parse File Method
	/**
	 * @author Antaine Ó Conghaile
	 * @version 1.0
	 * @param res
	 * @return
	 * Reads File res and Converts the File to a String
	 * Than Removes any non Suitable Characters before
	 * Finally Splitting the text into seperate words
	 * Returns String[] version of Text File 
	 */
	public String[] parse(String res) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(res));
			String line;// = null;
			String testLine = "";
			
		//Parse File
			while((line = br.readLine()) != null)
			{
				line= line.toLowerCase().replaceAll("[^A-za-z0-9\\s\\w\\-\\n]", "");
				testLine += line;
			}
			
			words = testLine.split("\\W+");
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Returns String Array containing the textfile
		return words;
	}//end parse
}//End of concatWords
