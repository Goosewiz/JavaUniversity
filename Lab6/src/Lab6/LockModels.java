package Lab6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockModels implements Runnable {
	private Vehicle something;
	private Lock myLock;
	public LockModels (Vehicle obj, Lock newLock) {
		something = obj;
		myLock = newLock;
	}
	public void run() {
		myLock.lock();
		try {
			String[] models = something.getModelsNames();
			for (int i = 0; i<something.getModelsSize();i++)
				System.out.println(models[i]);
		} 
		finally {
			myLock.unlock();
		}
	}
}
