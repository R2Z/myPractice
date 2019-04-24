package thread;

public class Test {
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
		}).start();
	}

}
