package ie.gmit.sw;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class CosineDistance extends Calculations {

	String[] words = null;
	static int[] occurences1;
	int[] occurences2;
	int dotProduct;
	static int list = 0;
	//static int j = 0;
	static LinkedHashMap<Integer,String> sortedMap2 = new LinkedHashMap<Integer,String>();
	static LinkedHashMap<Integer,String> sortedMap11 = new LinkedHashMap<Integer,String>();
	static LinkedHashMap<String, Integer> occurances = new LinkedHashMap<String,Integer>();
	static LinkedHashMap<Integer, String> testMap = new LinkedHashMap<>();
	
	LinkedHashMap<String, Integer>countUniqueWords(LinkedHashMap<Integer, String> map1,int length1)
	{
		String tempWord;
		int i=0;
		
		LinkedHashMap<String, Integer> sortedMap1 = new LinkedHashMap<String,Integer>();
		for(i=1;i<length1;i++)
		{
			tempWord = map1.get(i);
			if(sortedMap1.keySet().contains(tempWord))
			{
				sortedMap1.put(tempWord,sortedMap1.get(tempWord)+1);
				if(list == 0)
				{
					sortedMap1.put(tempWord,sortedMap1.get(tempWord)+1);
					
					//occurences1[j] +=1;
				}
				
			}
			
			else{
				sortedMap1.put(tempWord,1);
				
			}
			if(list ==0)
			{sortedMap11.put(i,tempWord);
			}
			sortedMap2.put(i,tempWord);
		}
			 list++;		
		//	System.out.println("Sorted map " +sortedMap1);	
		//	System.out.println("Sorted map 2" +sortedMap2);
			return sortedMap1;
	}

	public LinkedHashMap<String, Integer>countOccurences(LinkedHashMap<String, Integer> sortedMap1, LinkedHashMap<String, Integer> sortedMap22,int shingleLength, int shingleLength2) throws InterruptedException {
		// TODO Auto-generated method stub
		int i;
		int k;
		int totalLength = shingleLength + shingleLength2;
		int firstRun = totalLength - shingleLength2;
		int secondRun = totalLength = shingleLength;
		String tempWord = null;
		int j = 0;
		
		for(i=1;i<firstRun;i++)
		{
			tempWord = sortedMap2.get(i);
			 k = shingleLength2;
			//System.out.println(tempWord);
			
			if(sortedMap1.keySet().contains(tempWord))
			{
				//sortedMap22.put(tempWord, sortedMap22.get(tempWord)+1);
				//System.out.println("Entered ifs");
				j++;
				sortedMap2.put(j, tempWord);
			}
			else{
				//System.out.println("Entered else");
			//	j++;
				sortedMap11.put(j, tempWord);
				sortedMap1.put(tempWord,0);
			}
			
		}
		
		j = 0;
		for(i=1;i<secondRun;i++)
		{
			//System.out.println("Test " +tempWord);
			tempWord = sortedMap11.get(i);
			 k = shingleLength;
			//System.out.println(tempWord);
			
			if(sortedMap22.keySet().contains(tempWord))
			{
				//j++;
				//sortedMap22.put(tempWord, sortedMap22.get(tempWord)+1);
				//System.out.println("Entered ifs");
				//totalLength++;
			}
			else{
				//System.out.println("Entered else");
				//j++;
				//sortedMap2.put(j, tempWord);
				sortedMap22.put(tempWord,0);
				
			//	System.out.println("Test " +tempWord);
			}
			
			//System.out.println("J "+j);
		}

	//	System.out.println("Words 1 " + sortedMap11);
	//	System.out.println(sortedMap11.get(0));
	//	System.out.println("Complete Sorted Map 1 "+sortedMap1);
	//	System.out.println("Words 2 " + sortedMap2);
	//	System.out.println("Complete Sorted Map 2 " +sortedMap22);
		CalculateDot(totalLength, sortedMap1,sortedMap22,sortedMap11,sortedMap2);
		
		
		return null;
	}


}
