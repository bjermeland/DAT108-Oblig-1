package no.hvl.dat108.Oppgave2;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private final static int MAX_SIZE = 5;
	private List<Integer> table = new ArrayList<Integer>(5);
	private static int TOTAL_BURGERS = 0;

	/**
	 * Adds a new burger to the table array
	 * 
	 */
	public void push() {
		table.add(TOTAL_BURGERS++);
	}

	/**
	 * Removes the first burger in the table array
	 * 
	 */
	public void pop() {
		table.remove(0);
	}

	/**
	 * @return int Returns index 0 or 0 if empty array
	 * 
	 */
	public int getFirst() {
		return this.isEmpty() ? 0 : table.get(0);
	}

	/**
	 * @return int Returns sum of TOTAL_BURGERS
	 * 
	 */
	public synchronized int totalBurgers() {
		return TOTAL_BURGERS;
	}

	/**
	 * @return int Returns length of table array
	 * 
	 */
	public synchronized int size() {
		return table.size();
	}

	/**
	 * @return boolean Returns true if table array is bigger or equal than MAX_SIZE variable, false if not
	 * 
	 */
	public synchronized boolean isFull() {
		return table.size() >= MAX_SIZE;
	}

	/**
	 * @return boolean Returns true if table array is empty, false if not
	 * 
	 */
	public synchronized boolean isEmpty() {
		return table.isEmpty();
	}

	/**
	 * @return String Returns table array in a pretty string format
	 * 
	 */
	public String toString() {
		String str = "[";
		for (int i = 0; i < table.size(); i++) {
			str += "(" + (table.get(i) + 1) + ")";
		}
		return str = str + "]";
	}
}
