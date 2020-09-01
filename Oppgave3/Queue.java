package no.hvl.dat108.Oppgave3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queue {
	
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
	private static int TOTAL_BURGERS = 0;

	/**
	 * Adds a new burger to the BlockingQueue
	 * @throws InterruptedException 
	 * 
	 */
	public void push() throws InterruptedException {
		queue.put(TOTAL_BURGERS++);
	}

	/**
	 * Removes the first burger in the BlockingQueue
	 * @throws InterruptedException 
	 * 
	 */
	public int pop() throws InterruptedException {
		return queue.take();
	}
	
	/**
	 * @return int Returns sum of TOTAL_BURGERS
	 * 
	 */
	public int getTotalBurgers() {
		return TOTAL_BURGERS;
	}

	/**
	 * @return String Returns table array in a pretty string format
	 * 
	 */
	public String toString() {
		String str = "[";
		for (Object i : queue.toArray()) {
			str += "(" + ((int)i + 1) + "), ";
		}
		str = str.replaceAll(", $", "");
		return str += "]";
	}

}
