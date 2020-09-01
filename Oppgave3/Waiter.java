package no.hvl.dat108.Oppgave3;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable {
	
	private Queue queue;
	private int currentBurger;
	private Random r = new Random();
	
	/**
	 * Initializes a new Waiter
	 * 
	 * @param table Common table for the restaurant
	 */
	public Waiter(Queue q) {
		this.queue = q;
	}
	
	/**
	 * Waiter serves burgers and removes them to table array, if table is empty, he waits.
	 * 
	 */
	@Override
	public void run() {
		
		try {
			while (true) {
				
				int randInt = r.nextInt(5) + 2;
				Thread.sleep(randInt * 1000);
				
				currentBurger = queue.pop();

				System.out.println(Thread.currentThread().getName()
						+ " tar av hamburger  (" + currentBurger + ") => " + queue.toString());
			}

		} catch (InterruptedException e) {
			System.out.println("An error occured.");
		}

	}
}
