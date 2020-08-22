package no.hvl.dat108.Oppgave2;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	private final static int MAX_SIZE = 5;
	private List<Integer> table = new ArrayList<Integer>(5);
	private static int TOTAL_BURGERS = 0;
	
	
	public void push() {
		table.add(TOTAL_BURGERS++);
	}
	
	public void pop() {
		table.remove(0);
	}
	
	public int getFirst() {
		return this.isEmpty() ? 0 : table.get(0);
	}
	
	public synchronized int totalBurgers() {
		return TOTAL_BURGERS;
	}
	
	public synchronized int size() {
		return table.size();
	}
	
	public synchronized boolean isFull() {
		return table.size() >= MAX_SIZE;
	}
	
	public synchronized boolean isEmpty() {
		return table.isEmpty();
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i < table.size(); i++) {
			str += "(" + (table.get(i) + 1) + ")";
		}
		return str = str + "]";
	}
}
