package ie.gmit.sw;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;

public class Mapping extends Thread {
	private static int id =0;
	//private  LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
	private String q;
	int time = 1000;
	private static LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
	
	public String run(BlockingQueue <String>queue){
		try{
		 
			String q = queue.take();
			id++;
		//	System.out.println("id " + id);
			map.put(id, q);
		//	System.out.println(q);
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return q;
	}
	
	public LinkedHashMap<Integer, String> mapShingle(int length,BlockingQueue <String>queue) throws InterruptedException
	{
		map.clear();
		id =0;
		q = null;
		//System.out.println("Map Queue " + queue);
		//System.out.println("map Start " + map);
		Mapping t1 = new Mapping();
		Mapping t2 = new Mapping();
		Mapping t3 = new Mapping();
		t1.start();
		while(id < length)
		{
			//System.out.println(queue);
			if(queue.size() != 0)
			{
				//System.out.println("T1 " + id);
				t1.run(queue);
			}
			
			//System.out.println(queue);
			if(queue.size() != 0)
			{
				//System.out.println("T2");
				t2.run(queue);
			}
			//System.out.println(queue);
			if(queue.size() != 0)
			{
				//System.out.println("T3");
				t3.run(queue);
			}
					
		}

		return map;
	}
}

