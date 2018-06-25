import java.util.Random;

public class LastMinuteValue {

	public static void main(String[] args) {

		CounterUtil counter = new CounterUtil();

		Random rand = new Random();

		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					counter.updateHitCounts(rand.nextLong());
				}
			}).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					counter.getHitsLastSecond();
					counter.getHitsLastMinute();
					counter.getHitsLastHour();
				}
			}).start();
		}

	}

}

class CounterUtil {

	private long secCount;
	private int minCounter;
	private int hourCounter;
	private long[] minCount = new long[60];
	private long[] hourCount = new long[60];

	public synchronized void getHitsLastSecond() {
		System.out.println(Thread.currentThread().getName() + " Hit Last Secs" + secCount);
	}

	public synchronized void getHitsLastMinute() {

		long hitCount = 0;
		for (long l : minCount) {
			hitCount += l;
		}
		System.out.println(Thread.currentThread().getName() + " Hit Last Min" + hitCount);
	}

	public synchronized void getHitsLastHour() {
		long hitCount = 0;
		for (long l : hourCount) {
			hitCount += l;
		}

		System.out.println(Thread.currentThread().getName() + " Hit Last Hour " + hitCount);

	}

	public synchronized void updateHitCounts(long hits) {
		secCount = hits;
		updateLastMinHits(hits);
		updateLastHourHits();
	}

	public void updateLastMinHits(long hits) {

		if (minCounter > 59) {
			minCounter = 0;
		}
		minCount[minCounter] = hits;
		minCounter++;
	}

	public void updateLastHourHits() {

		long hits = 0;
		
		if (hourCounter > 59) {
			hourCounter = 0;
		}
		
		for (long l : minCount) {
			hits += l;
		}
		
		hourCount[hourCounter] = hits;
		hourCounter++;
	}
}