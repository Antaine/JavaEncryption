package ie.gmit.sw;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Que {
	private static BlockingQueue <String>queue = new LinkedBlockingDeque<>();
	
	public BlockingQueue<String> createQue( ArrayList<String> shingle1, int length)
	{
		//int shingleLength = shingle1.size();
		int i =0;
		String test = "f";
		//addQue(shingleLength,shingle1);
		for(i=0;i<length;i++)
		{
			test = shingle1.get(i);
			queue.add(test);
		}
		//System.out.println(queue);
		
		return queue;
		
	}
	
}