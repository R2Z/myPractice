package prodcons;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {
	private int maxSize;
	private LinkedList<Date> storage;

	public EventStorage() {
		maxSize = 4;
		storage = new LinkedList<>();
	}

	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.offer(new Date());
		System.out.println("Inside Set storage.size "+ storage.size());
		notifyAll();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Inside get storage size "+ storage.size()+ " value extracted " + ((LinkedList<?>) storage).poll());
		notifyAll();
	}
}
