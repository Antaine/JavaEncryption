package ie.gmit.sw;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Calculations {

	/**
	 * @author Antaine Ó Conghaile
	 * @param length
	 * @param sorted1
	 * @param sorted2
	 * @param words1
	 * @param words2
	 * Gets the number of occurrences by words
	 * in each text file by checking the values of the sorted maps by searching 
	 * the index with all the words uses where a word is not null
	 * It stores them in s & t which are used to calculate the dot
	 * and the totals are kept.
	 * Using this it calculates the magnitude of s & t
	 * and the cosine distance.
	 * It then prints the cosine distance as a percentage
	 */
	protected static void CalculateDot(int length,LinkedHashMap<String, Integer> sorted1, LinkedHashMap<String, Integer>sorted2,
			LinkedHashMap<Integer,String>words1, LinkedHashMap<Integer, String> words2)
	{
		int i =0;
		String word = null;
		int s = 0;
		int t = 0;
		int dot;
		length = words1.size();
		int dotTotal = 0;
		int sTotal = 0;
		int tTotal =0;
		double sMag = 0;
		double tMag = 0;
		double dMag = 0;
		double cosineDistance =0;
		double cosPrecent=0;
		ArrayList<String>usedShingles = new ArrayList<>();
		int count = 0;
		length +=1;

		for(i=0;i<length;i++)
		{
			word = words1.get(i);
			
			if(word != null && usedShingles.contains(word) == false)
			{
				s = sorted1.get(word);
				t = sorted2.get(word);
				dot = s*t;
				count = i;
				sTotal += sorted1.get(word);
				tTotal += t;
				if(dot>1 && s!=0 && t!=0)
				{
					dot =2;
				}
				dotTotal += dot;				
			}
			usedShingles.add(word);
			s=0;
			t=0;
		}
		System.out.println("TotalTotals: S " + sTotal + " T "+tTotal+ " Dot Total "+ dotTotal+" Count "+ count);
		sMag = Math.sqrt(sTotal);
		tMag = Math.sqrt(tTotal);
		dMag = sMag + tMag; 
		System.out.println("S Total: "+sMag);
		System.out.println("T Total: "+tMag);
		System.out.println("D Total: "+dMag);
		System.out.println(dotTotal);
		cosineDistance = dotTotal/(sMag*tMag);
		cosPrecent = cosineDistance * 100;
		if(cosPrecent>100) cosPrecent = 100;
		System.out.println("Cosine Distance "+cosPrecent+"%");
	}
}