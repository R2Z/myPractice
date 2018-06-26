package condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddConsumer {
	public static void main(String[] args) {
		int noOftasks = 2;
		Lock lock = new ReentrantLock();
		Condition[] conditions = new Condition[noOftasks];
		for (int i = 0; i < noOftasks; i++) {
			conditions[i] = lock.newCondition();
		}

		Buffer buf = new Buffer(100);
		new Thread(new NumProducer(lock, buf, conditions), "NumProducer").start();
		new Thread(new NumberConsumer(lock, buf, conditions), "EvenConsumer").start();
		new Thread(new NumberConsumer(lock, buf, conditions), "OddConsumer ").start();
	}
}

class NumProducer implements Runnable {
	Lock lock = null;
	Buffer buf = null;
	Condition[] conditions = null;

	public NumProducer(Lock lock, Buffer buf, Condition[] conditions) {
		
		this.lock = lock;
		this.buf = buf;
		this.conditions = conditions;
	}

	private void notifyThread(int no) {
		lock.lock();
		try {
			if (no % 2 == 0) {
				conditions[0].signal();
			} else {
				conditions[1].signal();
			}
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void run() {
		int no = 0;
		int tmpNo = 0;
		while (!buf.isMaxSet()) {
			while (buf.isValset()) {
				notifyThread(tmpNo);
			}
			if (no > buf.getMax()) {
				buf.setMaxSet(true);
				buf.setValset(false);
				break;
			}
			buf.setNo(no);
			buf.setValset(true);
			tmpNo = no;
			no++;
		}
	}
}

class NumberConsumer implements Runnable {
	Lock lock = null;
	Buffer buf = null;
	Condition[] conditions = null;

	public NumberConsumer(Lock lock, Buffer buf, Condition[] conditions) {
		this.lock = lock;
		this.buf = buf;
		this.conditions = conditions;
	}

	private void waitThread() throws InterruptedException {
		if (buf.getNo() % 2 == 0) {
			conditions[0].await(100, TimeUnit.MILLISECONDS);
		} else {
			conditions[1].await(100, TimeUnit.MILLISECONDS);
		}
	}

	public void run() {
		while (!buf.isMaxSet()) {
			if (buf.isValset()) {
				lock.lock();
				try {
					waitThread();
					if (buf.isValset()) {
						System.out.println("O/P by " + Thread.currentThread().getName() + " : " + buf.getNo());
						buf.setValset(false);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}
}

class Buffer {
	int no, max;
	boolean valset, maxSet;

	public boolean isMaxSet() {
		return maxSet;
	}

	public void setMaxSet(boolean maxSet) {
		this.maxSet = maxSet;
	}

	public Buffer(int max) {
		this.max = max;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public boolean isValset() {
		return valset;
	}

	public void setValset(boolean valset) {
		this.valset = valset;
	}
}