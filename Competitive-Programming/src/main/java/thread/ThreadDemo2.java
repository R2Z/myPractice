package thread;

public class ThreadDemo2{
	 public static void main(String[] args) throws InterruptedException {
	   
	  Thread t1 = new Thread(new Runnable() {
	   @Override
	   public void run() {
	   throw new RuntimeException("Thread Exception Example");
		  // System.exit(0);
	   }
	  });
	  t1.start();
	   
	  
	  
	  while(true){
	   System.out.println("ThreadDemo.main()");
	   Thread.sleep(100);
	  }
	 }
	}
