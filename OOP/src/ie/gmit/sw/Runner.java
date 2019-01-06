package ie.gmit.sw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Runner {

	private static ArrayList<String> shingle1 = new ArrayList<String>();
	private static ArrayList<String> shingle2 = new ArrayList<String>();
	private static ArrayList<String> al = new ArrayList<String>();
	private static String words[];
	private static int shingleLength;
	private static int shingleLength2;
	private static BlockingQueue <String>queue = new LinkedBlockingDeque<>();
	private static  BlockingQueue <String>queue2 = new LinkedBlockingDeque<>();

	
	
	private static LinkedHashMap<String, Integer> sortedMap1 = new LinkedHashMap<>();
	private static LinkedHashMap<String, Integer> sortedMap2 = new LinkedHashMap<>();
	private static LinkedHashMap<String, Integer> sortedMap3 = new LinkedHashMap<>();
	//private static ArrayList<String,Integer> finalMap2 = new LinkedHashMap<>();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();
		LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>();
		Scanner console = new Scanner (System.in);
		String direct;
		String query;
		System.out.print("Enter Directory:");
		direct = console.nextLine();
		System.out.print(direct +"\n");
		System.out.print("Enter File or URl:");
		query = console.nextLine();
		int totalLength;
		System.out.print(query + "\n");
		
	
		words = new Parser().parse("./Input/"+direct);	
	//	System.out.println("Words1: " + Arrays.toString(words));
		shingle1 = new ConvertShingles().convertShingles(words);
		shingleLength = shingle1.size();
	//	System.out.println("Shingle1  " +shingle1);
		queue = new Que().createQue(shingle1,shingleLength);
		//System.out.println("Queue1 " +queue);
		//----------------------------------------------------------
		map1 = new Mapping().mapShingle(shingleLength,queue);
		//cloneMap = map1;
		//System.out.println("Clone Map " + cloneMap);
	//	System.out.println("Map 1" + map1);
		sortedMap1 = new CosineDistance().countUniqueWords(map1,shingleLength);
	//	System.out.println("Sorted Map 1" + sortedMap1);
		//----------------------------------------------------------
		words = new Parser().parse("./Input/"+query);
	//	System.out.println("");
	//	System.out.println(Arrays.toString(words));
		shingle2 = new ConvertShingles().convertShingles(words);
	//	System.out.println("Shingle2  " +shingle2);
		shingleLength2 = shingle2.size();
		totalLength = shingleLength + shingleLength2;
		queue2 = new Que().createQue(shingle2,shingleLength2);
	//	System.out.println("Queue " +queue2);
		//----------------------------------------------------------
	//	System.out.println("Map 1" + map1);
	//	map1.lock();
		map2 = new Mapping().mapShingle(shingleLength2,queue2);
	//	System.out.println("Map 2" + map2);
	//	System.out.println("Map 1" + map1);
		//System.out.println("Clone Map " + cloneMap);
		sortedMap2 = new CosineDistance().countUniqueWords(map2,shingleLength2);
		//System.out.println("Sorted Map 1" + sortedMap1);
		//----------------------------------------------------------
	//	System.out.println(new Que().createQue(shingle1,shingleLength));
		
		sortedMap3.putAll(sortedMap1);
		sortedMap3.putAll(sortedMap2);
		//queue = new Que().createQue(shingle1,shingleLength);
		//System.out.println("Later Queue "+queue);
	//	System.out.println("Sorted Map Final 1" + sortedMap1);
	//	System.out.println("Sorted Map Final 2" + sortedMap2);
	//	System.out.println("Sorted Map Final 3" + sortedMap3);
		new CosineDistance().countOccurences(sortedMap1,sortedMap2,shingleLength,shingleLength2);
		//sortedMap3 = new CosineDistance().countUniqueWords(sortedMap3,totLength2);
		
		console.close();
	}
	
}
