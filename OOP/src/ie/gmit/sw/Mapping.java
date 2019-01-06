package ie.gmit.sw;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;

public class Mapping extends Thread {
	private static int id =0;
	private String q;
	private static LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
	/**
	 * @author Antaine Ó Conghaile
	 * @param queue
	 * @return
	 * Takes a Shingle from the Queue and
	 * Adds it to a map 
	 */
	public String run(BlockingQueue <String>queue){
		try{
			String q = queue.take();
			id++;
			map.put(id, q);
		}catch (Exception e) {
		}
		return q;
	}//End of run
	
	/**
	 * @author Antaine Ó Conghaile
	 * @param length
	 * @param queue
	 * @return
	 * @throws InterruptedException
	 * Takes a Queue of shingles and adds them
	 * to a LinkedHashMap by Using Threads to call the run Method
	 * if queue is not empty.
	 * Returns the LinkedHashMap
	 */
	public LinkedHashMap<Integer, String> mapShingle(int length,BlockingQueue <String>queue) throws InterruptedException
	{
		//Resets Variables
		map.clear();
		id =0;
		//Creates Threads
		Mapping t1 = new Mapping();
		Mapping t2 = new Mapping();
		Mapping t3 = new Mapping();
		t1.start();
		t2.start();
		t3.start();
		
		//Runs Threads while Queue is not empty
		while(id < length)
		{
			if(queue.size() != 0)
			{
				t1.run(queue);
			}
			
			if(queue.size() != 0)
			{
				t2.run(queue);
			}

			if(queue.size() != 0)
			{
				t3.run(queue);
			}			
		}
		return map;
	}//End of mapShingle
}//End of Mapping

