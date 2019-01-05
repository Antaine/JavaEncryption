package ie.gmit.sw;

import java.util.ArrayList;

public class ConvertShingles {
	private ArrayList<String> al = new ArrayList<String>();
	private ArrayList<String> sh = new ArrayList<String>();
	public ArrayList<String> convertShingles(String[] words)
	{
		double count = 0;
		double numberofShingles = 0;
		double test = 0;
		int i = 0;
		int k =0;
		double count2;

		for (i = 0; i < words.length; i ++)
		{  
			if (words[i] != null)
		    {
		        count ++;
			}
		}//End of for
		
		numberofShingles = (count-1)/3;
		//System.out.println(count);
		//System.out.println(numberofShingles);
		test = (count) %3;
		//System.out.println(test);
		//System.out.println("Entered if  = 0");
		i=0;
		
		count2 = count;
		
		while(count > 0)
		{		
			count += -1;
			al.add(words[k]);
			k++;
		//	System.out.println("");
			i++;
		}
			
		if(count2 % 3 == 2)
		{
			al.add(null);
			count2 +=1;
		}
			
		if(count2 % 3 == 1)
		{
			al.add(null);
			al.add(null);
			count2 += 2;
		}
		
		//System.out.print(al);
		String word1 = null;
		String word2 = null;
		String word3 = null;
		sh = concatWords(al, count2);
		//System.out.println(sh);
		return sh;
	}//End of convertShingles
	
	public ArrayList<String> concatWords(ArrayList<String> al, double count)
	
{
	ArrayList<String> al1 = new ArrayList<String>();
	double count1 = count;
	String shingleWord = "";
	String reset = " ";
	String wrd1 = null,wrd2 = null,wrd3 = null;
	int k =0;
	
	while(k < count1)
	{
		if(k % 3 == 0)
		{
			wrd1 = al.get(k);
			k++;
		}
		
		if(k % 3 == 1)
		{
			wrd2 = al.get(k);
			shingleWord +=wrd1 + wrd2;
			k++;
		}
		
		if(k % 3 == 2)
		{
			wrd3 = al.get(k);
			k++;
		}
		shingleWord =wrd1+ " " + wrd2+ " " + wrd3;
		//System.out.println(shingleWord);
		
		al1.add(shingleWord);
		shingleWord = reset;
		wrd1 = reset;
		wrd2 = reset;
		wrd3 = reset;
	}
	//System.out.println(al1);
	
	return al1;
	}//End of while
}//End of concatWords
	

