package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
	//private ArrayList<String> al = new ArrayList<String>();
	//private ArrayList<String> sh = new ArrayList<String>();
	String[] words = null;
	int occurences1;
	int occurences2;
	int dotProduct;

	public String[] parse(String res) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(res));
			
			int i = 0;
			int j = 0;
			String line;// = null;
			String testLine = "";
			
		//Parse File
			while((line = br.readLine()) != null)
			{
				line= line.toUpperCase().replaceAll("[^A-za-z0-9\\s\\w\\-\\n]", "");
				testLine += line;
			}
			
			words = testLine.split("\\W+");
		//	System.out.println(Arrays.toString(words));
			br.close();
			//al = convertShingles(words);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return words;
	}//end parse
}//End of concatWords
