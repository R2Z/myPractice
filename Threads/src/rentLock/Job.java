package rentLock;

public class Job implements Runnable{

	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.printf("%s: Going for task \n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		//System.out.printf("%s: task has been completed\n", Thread.currentThread().getName());
	}

}
