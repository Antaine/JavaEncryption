package ie.gmit.sw;

import java.util.LinkedHashMap;
import java.math.*;

public class Calculations {

	protected void CalculateDot(int length,LinkedHashMap<String, Integer> sorted1, LinkedHashMap<String, Integer>sorted2,
			LinkedHashMap<Integer,String>words1, LinkedHashMap<Integer, String> words2)
	{
		int i =0;
		String word;
		int s;
		int t;
		int dot;
		length = words1.size();
		int dotTotal = 0;
		int sTotal = 0;
		int tTotal =0;
		double sMag = 0;
		double tMag = 0;
		double dMag = 0;
		double cosineDistance =0;
		
		for(i=0;i<length;i++)
		{
			dot =0;
			word = words1.get(i);
			s =sorted1.get(word);
			t =sorted2.get(word);
			dot = t*s;
		
	//		if(dot>0)
	//		{System.out.println(word + " s" + s + " t" + t + " dot " + dot);
			
	//		}
			sTotal +=s;
			tTotal +=t;
			dotTotal += dot;
			
		}
		
		System.out.println(sTotal);
		System.out.println(tTotal);
		System.out.println(dotTotal);
		
		sMag = Math.sqrt(sTotal);
		tMag = Math.sqrt(tTotal);
		dMag = sMag + tMag;
		
		System.out.println(sMag);
		System.out.println(tMag);
		System.out.println(dMag);
		
		cosineDistance = dMag/(sMag * tMag);
		System.out.println("Cosine Distance " + cosineDistance);
	}
}
