package Lab7;

public class ThreadForPrices extends Thread {
	private Vehicle something;
	public ThreadForPrices (Vehicle obj) {
		something = obj;
	}
	public void run() {
		double[] prices = something.getAllPrices();
		for (int i = 0; i<something.getModelsSize();i++)
			System.out.println(prices[i]);
	}
}
