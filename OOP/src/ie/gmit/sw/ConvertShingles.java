package ie.gmit.sw;

import java.util.ArrayList;

public class ConvertShingles {
	//Variables
	private ArrayList<String> al = new ArrayList<String>();
	private ArrayList<String> sh = new ArrayList<String>();
	
	//Separates textfile into Shingles
	/**
	 * @author Antaine Ó Conghaile
	 * @param words
	 * @return
	 * Counts Number of Strings in words[] And adds it to ArrayList al
	 * Then makes it easily divisible by 3
	 * by adding null elements and incrementing count if it its not
	 * Then it passes the list and updated count to concatWords()
	 * Where it groups words into groups of 3
	 * and than returns them as new list
	 */
	public ArrayList<String> convertShingles(String[] words)
	{
		double count = 0;
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
		i=0;
		
		count2 = count;
		
		while(count > 0)
		{		
			count += -1;
			al.add(words[k]);
			k++;
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
		sh = concatWords(al, count2);
		return sh;
	}//End of convertShingles
	
	//Concats 3 words into one String
	/**
	 * @author Antaine Ó Conghaile
	 * @param al
	 * @param count
	 * @return
	 * Takes the list of words and the number of them and 
	 * Sorts them into groups of 3.
	 * Then the groups are added as one String into an ArrayList
	 * The new ArrayList is then Returned
	 */
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
		
		al1.add(shingleWord);
		shingleWord = reset;
		wrd1 = reset;
		wrd2 = reset;
		wrd3 = reset;
	}
	return al1;
	}//End of while
}//End of concatWords