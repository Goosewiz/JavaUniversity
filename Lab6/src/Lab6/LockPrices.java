package Lab6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPrices implements Runnable {
	private Vehicle something;
	private Lock myLock;
	public LockPrices (Vehicle obj, Lock newLock) {
		something = obj;
		myLock = newLock;
	}
	public void run() {
		myLock.lock();
		try {
			double[] prices = something.getAllPrices();
			for (int i = 0; i<something.getModelsSize();i++)
				System.out.println(prices[i]);
		} 
		finally {
			myLock.unlock();
		}
	}
}
