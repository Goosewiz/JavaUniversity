package Lab6;

public class ModelsRunnable implements Runnable {
	private TransportSynchronizer something;
	public ModelsRunnable (TransportSynchronizer obj) {
		something = obj;
	}
	public void run() {
		while(something.canPrintModel()) {
			try {
				something.printModel();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
