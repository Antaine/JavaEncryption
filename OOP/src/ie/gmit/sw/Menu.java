package ie.gmit.sw;

import java.util.Scanner;

public class Menu {
	/**
	 * @author Antaine Ó Conghaile
	 * @version 1.0
	 * @return
	 * 
	 * Menu Outputs Prompts for User Input.
	 * Returns the Path for File 1 & File2 as String[] 
	 * 
	 */
	public String[] menu()
	{
		String fileArray[] = new String[2];
		Scanner console = new Scanner (System.in);
		String direct;
		String query;
		
		System.out.print("Enter File1 Including Path and file Type: ");
		direct = console.nextLine();
		System.out.print(direct +"\n");
		System.out.print("Enter File2: ");
		query = console.nextLine();
		System.out.print(query + "\n");
		fileArray[0] = direct;
		fileArray[1] = query;
		console.close();
		return fileArray;
	}
}
