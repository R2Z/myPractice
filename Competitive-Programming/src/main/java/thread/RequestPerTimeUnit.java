package thread;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestPerTimeUnit {
	
	public static AtomicInteger freqSec[] = new AtomicInteger[1000];
	
	public static void main(String[] args) {
		
		 ExecutorService executor = Executors.newFixedThreadPool(10);
		 RequestCountProvider countProvider = new RequestCountProvider();
		 
		 for(int i=0; i < 1000; i++) {
			 executor.execute(new MyTask(countProvider));
		 }
		 
		
		 executor.shutdown();
	}

}

class MyTask implements Runnable{

	RequestCountProvider countProvider;
	
	public MyTask(RequestCountProvider countProvider){
		this.countProvider = countProvider;
	}
	
	@Override
	public void run() {
		Calendar calendar = Calendar.getInstance();
		countProvider.addRequestTime(calendar);
	}
	
}


class RequestCountProvider{
	
	public AtomicInteger freqSec[] = new AtomicInteger[1000];
	//public AtomicInteger freqMin[] = new AtomicInteger[60];
	//public AtomicInteger freqHour[] = new AtomicInteger[60];
	
	public void addRequestTime(Calendar calendar){
		
		int milliSec = calendar.get(Calendar.MILLISECOND);
		
		if(freqSec[milliSec] != null){
			freqSec[milliSec] =  new AtomicInteger(freqSec[milliSec].incrementAndGet());
		}else{
			freqSec[milliSec] = new AtomicInteger(1); 
		}
		
		System.out.println("gerFrequenciesPersecond " +gerFrequenciesPersecond());
		/*int sec = calendar.get(Calendar.SECOND);
		if(freqMin[sec] != null){
			freqMin[sec] =  new AtomicInteger(gerFrequenciesPersecond());
		}else{
			freqMin[sec] = new AtomicInteger(1); 
		}*/
		
	}
	
	public int gerFrequenciesPersecond(){
		
		int count = 0;
		
		for(int i=0; i < 1000; i++){
			if(freqSec[i] != null){
				count += freqSec[i].get();
			}
		}
		
		return count;
	}
	
}