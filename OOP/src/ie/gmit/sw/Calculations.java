package ie.gmit.sw;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.math.*;

public class Calculations {

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
		ArrayList<String>usedShingles = new ArrayList<>();
		int count = 0;
		int j=1;
		length +=1;
		//System.out.println("sorted1 " + sorted1);
		//System.out.println("sorted2 " + sorted2);
		//System.out.println("sorted size1: " + sorted1.size());
		//System.out.println("sorted size2: " + sorted2.size());
		//System.out.println(length);
		
		for(i=0;i<length;i++)
		{
			word = words1.get(i);
			
			if(word != null && usedShingles.contains(word) == false)
			{
				
				j++;
				s = sorted1.get(word);
				t = sorted2.get(word);
				dot = s*t;
			//	System.out.println("Word "+word + " Sorted1 word: " +  " S "+ s + " T " + t + " sorted1Word" + sorted1.get(word));
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
			//System.out.println("Totals: S " + sTotal + " T "+tTotal+ " Dot Total "+ dotTotal+" Count "+ count);
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
		System.out.println("Cosine Distance "+cosineDistance);
	}
}
