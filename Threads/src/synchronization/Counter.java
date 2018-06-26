package synchronization;

public class Counter {
	
	public static int var;
	
	public synchronized int incCounter(){
		return var++;
	}
	

	public static synchronized int decCounter(){
		return var--;
	}
}
