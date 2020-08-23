package no.hvl.dat108.Oppgave3;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Table table = new Table();
		
		Thread t1 = new Thread(new Chef(table), "Kokk 1");
		Thread t2 = new Thread(new Chef(table), "Kokk 2");
		Thread t3 = new Thread(new Chef(table), "Kokk 3");
		
		Thread t4 = new Thread(new Waiter(table), "Servitør 1");
		Thread t5 = new Thread(new Waiter(table), "Servitør 2");

		t1.start();
		t2.start();
		t3.start();
		
		Thread.sleep(3000);
		
		t4.start();
		t5.start();
	}

}
