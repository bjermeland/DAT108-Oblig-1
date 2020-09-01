package no.hvl.dat108.Oppgave3;

import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Queue queue = new Queue();
		
		Thread t1 = new Thread(new Chef(queue), "Kokk 1");
		Thread t2 = new Thread(new Chef(queue), "Kokk 2");
		Thread t3 = new Thread(new Chef(queue), "Kokk 3");
		
		Thread t4 = new Thread(new Waiter(queue), "Servitør 1");
		Thread t5 = new Thread(new Waiter(queue), "Servitør 2");

		t1.start();
		t2.start();
		t3.start();
		
		Thread.sleep(3000);
		
		t4.start();
		t5.start();
	}

}
