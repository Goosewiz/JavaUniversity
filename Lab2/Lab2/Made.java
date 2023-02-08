package Lab2;

public class Made {
	static double getMiddleValue(Vehicle something){
		double middlevalue = 0;
		//String[] output0 = new String[arg];
		double[] output = something.getAllPrices();
		for (int i = 0; i<output.length; i++) {
			middlevalue = middlevalue + output[i];
		}
		return middlevalue = middlevalue/output.length;
	}
	static void getNamesAndPrices(Vehicle something, int arg) {
		String[] output0 = new String[arg];
		double[] output = new double[arg];
		output = something.getAllPrices();
		output0 = something.getModelsNames();
		for (int i = 0; i<arg; i++) {
			System.out.println(output0[i] + " " + output[i]);
		}
	}
}
