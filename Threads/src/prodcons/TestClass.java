package prodcons;

public class TestClass {

	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		new Thread(new Producer(storage)).start();
		new Thread(new Consumer(storage)).start();
	}
}
