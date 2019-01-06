package ie.gmit.sw;
import java.util.LinkedHashMap;

public class CosineDistance extends Calculations {

	static int list = 0;
	static LinkedHashMap<Integer,String> sortedMap2 = new LinkedHashMap<Integer,String>();
	static LinkedHashMap<Integer,String> sortedMap11 = new LinkedHashMap<Integer,String>();
	/**Antaine Ó Conghaile
	 * @author A
	 * @param map1
	 * @param length1
	 * @return
	 *Takes a map of shingles and counts the number of 
	 *Unique Occurrences and removes repeats from
	 *The Updated List it returns
	 */
	
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
			return sortedMap1;
	}//End of Unique Words

	/**
	 * 
	 * @param sortedMap1
	 * @param sortedMap22
	 * @param shingleLength
	 * @param shingleLength2
	 * @throws InterruptedException
	 * Creates a map combining the two SortedMap1
	 * adding words they don't share with a value of 0
	 * It also creates a map of all words used by both maps
	 */
	public void countOccurences(LinkedHashMap<String, Integer> sortedMap1, LinkedHashMap<String, Integer> sortedMap22,int shingleLength, int shingleLength2) throws InterruptedException {
		// TODO Auto-generated method stub
		int i;
		int totalLength = shingleLength + shingleLength2;
		int firstRun = totalLength - shingleLength2;
		int secondRun = totalLength = shingleLength;
		String tempWord = null;
		int j = 0;
		
		for(i=1;i<firstRun;i++)
		{
			tempWord = sortedMap2.get(i);
			
			if(sortedMap1.keySet().contains(tempWord))
			{
				j++;
				sortedMap2.put(j, tempWord);
			}
			else{
				sortedMap11.put(j, tempWord);
				sortedMap1.put(tempWord,0);
			}
		}

		for(i=1;i<secondRun;i++)
		{
			tempWord = sortedMap11.get(i);
			
			 if(sortedMap22.keySet().contains(tempWord) == false)
			  {
				 sortedMap22.put(tempWord,0);
			  }
		}
		CosineDistance.CalculateDot(totalLength, sortedMap1,sortedMap22,sortedMap11,sortedMap2);		
	}//End of countOccurences
}//End of CosineDistance