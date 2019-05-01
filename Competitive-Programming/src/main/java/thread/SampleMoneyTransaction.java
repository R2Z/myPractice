package thread;

public class SampleMoneyTransaction {

	public static void main(String[] args) {

		Account a = new Account("Account 1", 5000);
		Account b = new Account("Account 2", 5000);

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					transferMoneyWithSync(a, b, 500);
					System.out.println(a.toString());
					System.out.println(b.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					transferMoneyWithTryLock(a, b, 500);
					System.out.println(a.toString());
					System.out.println(b.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
		
		
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					transferMoneyWithTryLock(b, b, 1500);
					System.out.println(a.toString());
					System.out.println(b.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

	}

	public static void transferMoneyWithSync(Account fromAccount, Account toAccount, float amount) throws Exception {

		synchronized (fromAccount) {
			// acquired lock on fromAccount Object
			synchronized (toAccount) {
				// acquired lock on toAccount Object
				if (amount > fromAccount.getAmount()) {
					throw new Exception("Insufficient Balance");
				} else {
					fromAccount.debit(amount);
					toAccount.credit(amount);
				}
			}
		}
	}

	public static boolean transferMoneyWithTryLock(Account fromAccount, Account toAccount, float amount) throws Exception {

		// we are defining a stopTime
		boolean bool = false;
		long stopTime = System.nanoTime() + 5000;
		while (!bool) {
			if (fromAccount.lock.tryLock()) {
				try {
					if (toAccount.lock.tryLock()) {
						try {
							if (amount > fromAccount.getAmount()) {
								throw new Exception("Insufficient Balance");
							} else {
								fromAccount.debit(amount);
								toAccount.credit(amount);
								bool = true;
							}

						} finally {
							toAccount.lock.unlock();
						}
					}

				} finally {
					fromAccount.lock.unlock();
				}
			}
			if (System.nanoTime() < stopTime){
				bool = true;
			}	

			Thread.sleep(100);
		} // while
		return bool;
	}

}
