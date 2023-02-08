package Lab7;

public class PricesRunnable implements Runnable {
	private TransportSynchronizer something;
	public PricesRunnable (TransportSynchronizer obj) {
		something = obj;
	}
	public void run() {
		while(something.canPrintPrice()) {
			try {
				something.printPrice();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
