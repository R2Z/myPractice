package thread;

public class ThreadDemo {
	  
	 public static void main(String ar[]){
	  System.out.println("Inside Main Thread");
	  
	  System.out.println("Top Level Thread Group:" + Thread.currentThread().getThreadGroup().getParent().getName());
	  System.out.println("Main Thread Group:" + Thread.currentThread().getThreadGroup().getName());
	   
	  Thread thread1 = new Thread(new ThreadTask());
	  thread1.start();
	   
	 // Thread thread2 = new Thread(new ThreadTask());
	  Thread thread2 = new Thread(new ThreadTask(thread1));

	  thread2.start();
	  
	  //Thread thread3 = new Thread(new ThreadTask());
	  Thread thread3 = new Thread(new ThreadTask(thread2));
	  
	  thread3.start();
	    
	  try {
	   thread1.join();
	   thread2.join();
	   thread3.join();
	  } catch (InterruptedException e) {
	   e.printStackTrace();
	  }
	  System.out.println("End of Main Thread");  
	 }
	}

class ThreadTask implements Runnable{
	 
	 public ThreadTask() {}
	  
	 public ThreadTask(Thread threadToJoin) {
	  try {
	   threadToJoin.join();
	  } catch (InterruptedException e) {
	   e.printStackTrace();
	  }
	 }
	  
	 @Override
	 public void run() {
	  System.out.println("Start Thread :"+Thread.currentThread().getName());  
	  try {
	   Thread.sleep(1000);
	  } catch (InterruptedException e) {
	   e.printStackTrace();
	  }
	  System.out.println("End Thread :"+Thread.currentThread().getName());
	 } 
	}
