package no.hvl.dat108.Oppgave2;
import java.util.Random; 

public class Chef implements Runnable  {
	
	private Table table;
	private Random r = new Random();
	
	public Chef(Table table) {
		this.table = table;
	}
	
	@Override
	public void run() {
		
		try {
			while (true) {

				int randInt = r.nextInt(5) + 2;
				Thread.sleep(randInt * 1000);
				
				if (!table.isFull()) {

					synchronized(table) {
						
						table.push();
						
						System.out.println(Thread.currentThread().getName()
								+ " legger på hamburger   (" + table.totalBurgers() + ") => " + table.toString());
						
						table.notifyAll();
					}
					
				} else {
					synchronized(table) {
						System.out.println("### " + Thread.currentThread().getName()
								+ " er klar med en hamburger, men rutsjebanen er full. Venter! ###");
						table.wait();
					}
				}
			}

		} catch (InterruptedException e) {
			System.out.println("An error occured.");
		}

	}
	
}
