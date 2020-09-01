package no.hvl.dat108.Oppgave3;
import java.util.Random;
import java.util.concurrent.BlockingQueue; 

public class Chef implements Runnable  {
	
	private Queue queue;
	private Random r = new Random();
	
	/**
	 * Initializes a new Chef
	 * 
	 * @param table Common table for the restaurant
	 */
	public Chef(Queue q) {
		this.queue = q;
	}
	
	/**
	 * Chef makes burgers and adds them to table array, if table is full, he waits.
	 * 
	 */
	@Override
	public void run() {
		
		try {
			while (true) {

				int randInt = r.nextInt(5) + 2;
				Thread.sleep(randInt * 1000);

				queue.push();
				
				System.out.println(Thread.currentThread().getName()
						+ " legger på hamburger   (" + queue.getTotalBurgers() + ") => " + queue.toString());
				
				
			}

		} catch (InterruptedException e) {
			System.out.println("An error occured.");
		}

	}
	
}
