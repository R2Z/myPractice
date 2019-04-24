package thread;

public class ExceptionINThread {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new WorkerThread());
		t1.setName("T4");
		 
		t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
		        @Override
		 public void uncaughtException(Thread t, Throwable e){
		    System.out.println("Thread Exception Handler :Thread Name :"+t.getName() + " Message :"+e.getMessage());
		        }
		});
		t1.start();
	}
}

class WorkerThread extends Thread {
	 public void run() {
	  throw new RuntimeException("RuntimeException");
	 }
	}
