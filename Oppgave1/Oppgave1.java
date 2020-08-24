package no.hvl.dat108.Oppgave1;
import javax.swing.JOptionPane;

public class Oppgave1 {
	
	private static String msg;
	private static volatile boolean exit = false;
	
	
	public static void main(String[] args)
	  {
		new Thread(() -> {
	    	while(!exit) {
	    		msg = JOptionPane.showInputDialog(null,
	    		        "Skriv inn din melding, quit for å slutte");
	    	    if(msg.equals("quit")) exit = true;
	    	}
	    }).start();
	    
	    new Thread(() -> {
	    	while(!exit) {
		    	try {
					Thread.sleep(3000);
					System.out.println(msg);
				} catch (InterruptedException e) {
					System.out.println("Error occured while sleeping the Thread");
				}
	    	}
	    }).start();
	  }
}
