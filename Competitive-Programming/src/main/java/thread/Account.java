package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	
	private String accId;
	private float amount;
	public Lock lock = new ReentrantLock();
	
	public Account(String accId,float amount){
		this.accId = accId;
		this.amount = amount;
	}
	
	public void credit(float value){
		this.amount +=value;
	}
	
	public void debit(float value){
		this.amount -=value;
	}
	
	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", amount=" + amount + "]";
	}
}
