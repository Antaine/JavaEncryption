package ie.gmit.sw;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Que {
	private static BlockingQueue <String>queue = new LinkedBlockingDeque<>();
	
	/**
	 * @author Antaine Ó Conghaile
	 * @version 1.0
	 * @param shingle1
	 * @param length
	 * @return
	 * Takes in a ArrayList of Shingles
	 * Then adds them to a queue using a for loop
	 * That runs equal to the number of shingles in the ArrayList
	 */
	public BlockingQueue<String> createQue( ArrayList<String> shingle1, int length)
	{
		int i =0;
		String test = "";
		for(i=0;i<length;i++)
		{
			test = shingle1.get(i);
			queue.add(test);
		}
		//System.out.println(queue);		
		return queue;
	}//End of createQue
}//End of Class