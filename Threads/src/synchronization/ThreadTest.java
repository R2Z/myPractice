package synchronization;

public class ThreadTest {

	public static void main(String[] args) {

		Counter cnt = new Counter();

		new Thread(new Runnable() {

			@Override
			public void run() {
				cnt.incCounter();
				System.out.println(cnt.var);
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				cnt.decCounter();
				System.out.println(cnt.var);
			}
		}).start();

	}
}
