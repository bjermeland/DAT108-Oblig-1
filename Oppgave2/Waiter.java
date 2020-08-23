package no.hvl.dat108.Oppgave2;

import java.util.Random;

public class Waiter implements Runnable {
	private Table table;
	private Random r = new Random();
	
	/**
	 * Initializes a new Waiter
	 * 
	 * @param table Common table for the restaurant
	 */
	public Waiter(Table table) {
		this.table = table;
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

				if (!table.isEmpty()) {
				
					synchronized(table) {
						
						table.pop();
						
						System.out.println(Thread.currentThread().getName()
								+ " tar av hamburger  (" + table.getFirst() + ") => " + table.toString());
						
						table.notifyAll();
					}
					
				} else {
					synchronized(table) {
						System.out.println("### " + Thread.currentThread().getName()
								+ " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");
						table.wait();
					}
				}
			}

		} catch (InterruptedException e) {
			System.out.println("An error occured.");
		}

	}
}
