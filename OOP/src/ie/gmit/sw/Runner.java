package ie.gmit.sw;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Runner {
	
	private static ArrayList<String> shingle1 = new ArrayList<String>();
	private static ArrayList<String> shingle2 = new ArrayList<String>();
	private static String words[];
	private static int shingleLength;
	private static int shingleLength2;
	private static String[]files;
	private static BlockingQueue <String>queue = new LinkedBlockingDeque<>();
	private static LinkedHashMap<String, Integer> sortedMap1 = new LinkedHashMap<>();
	private static LinkedHashMap<String, Integer> sortedMap2 = new LinkedHashMap<>();
	
	/**
	 * @author Antaine Ó Congaile
	 * @param args
	 * @throws InterruptedException
	 * Calculates the Similarity between Two files using Cosine Distance
	 * by reading in the file and calling the parse() method to read the files in.
	 * The convertShingles() to convert the words into shingles.
	 * The createQue which adds the shingles to a queue.
	 * The mapShingle which adds the queue to a map/
	 * Repeat for file2
	 * Use countOccurrences() which inherits Calculations to calculate the CosineDistance
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();
		LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>();
		String direct;
		String query;
		files = new Menu().menu();
		direct = files[0];
		query = files[1];
		
	//File1
		//Convert Text into String[]
		words = new Parser().parse(direct);
		//Convert words[] to Shingles
		shingle1 = new ConvertShingles().convertShingles(words);
		shingleLength = shingle1.size();
		//Add to Queue
		queue = new Que().createQue(shingle1,shingleLength);
		//Add Queue to Map
		map1 = new Mapping().mapShingle(shingleLength,queue);
		//Sorts Map into Map of Unique Words and Number of Occurrences
		sortedMap1 = new CosineDistance().countUniqueWords(map1,shingleLength);
		//File2
		//Convert Text into String[]
		words = new Parser().parse(query);
		//Convert words[] to Shingles
		shingle2 = new ConvertShingles().convertShingles(words);
		shingleLength2 = shingle2.size();
		//Add to Queue
		queue = new Que().createQue(shingle2,shingleLength2);
		//Add Queue to Map
		map2 = new Mapping().mapShingle(shingleLength2,queue);
		//Sorts Map into Map of Unique Words and Number of Occurrences
		sortedMap2 = new CosineDistance().countUniqueWords(map2,shingleLength2);
		
		//Calculates Cosine Distance
		new CosineDistance().countOccurences(sortedMap1,sortedMap2,shingleLength,shingleLength2);
	}//End of Main
}//End of Runner
