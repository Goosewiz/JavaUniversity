package Lab7;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.lang.reflect.*;
public class Static {
	static double getMiddleValue(Vehicle something){
		double middlevalue = 0;
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
	public static void outputVehicle (Vehicle v, OutputStream out) throws IOException{
		DataOutputStream dos = new DataOutputStream(out);
		String mark = v.getMark();
		char c = mark.charAt(0);
		int flag = Character.getNumericValue(c);
		mark = mark.substring(1);
		int number = v.getModelsSize();
		String[] models = v.getModelsNames();
		double[] prices = v.getAllPrices();
		int j = mark.length();
		dos.writeInt(flag);
		dos.writeInt(j);
		dos.writeBytes(mark);
		dos.writeInt(number);
		for (int i = 0; i<number; i++)
		{
			dos.writeInt(models[i].length());
			dos.writeBytes(models[i]);
		}
		for (int i = 0; i<number; i++)
			dos.writeDouble(prices[i]);	
	}
	public static Vehicle inputVehicle (InputStream in) throws IOException, NoSuchModelNameException, DuplicateModelNameException{
		DataInputStream dis = new DataInputStream(in);
		int flag = dis.readInt();
		int size = dis.readInt();
		byte[] buffer = new byte[size];
		for (int i = 0; i<size; i++)
			buffer[i] = dis.readByte();
		String mark = new String(buffer);
		int modelsNumber = dis.readInt();
		String[] models = new String[modelsNumber];
		double[] prices = new double[modelsNumber];
		for (int i = 0; i<modelsNumber; i++) {
			int nextSize = dis.readInt();
			byte[] bufferSize = new byte[nextSize];
			for (int j = 0; j<nextSize; j++) {
				bufferSize[j] = dis.readByte();
			}
			models[i] = new String(bufferSize);
		}
		for (int i = 0; i<modelsNumber; i++)
			prices[i] = dis.readDouble();
		if (flag == 1) {
			Vehicle auto1 = new Auto(mark,0);
			for (int i = 0; i<modelsNumber; i++) {
				auto1.addModelAndPrice(models[i], prices[i]);
			}
			return auto1;
		}
		else {
			Vehicle motorcycle1 = new Motorcycle(mark,1);
			motorcycle1.setPrice("Model0", prices[0]);
			for (int i = 1; i<modelsNumber; i++) {
				motorcycle1.addModelAndPrice(models[i], prices[i]);
			}
			return motorcycle1;
		}
	}
	public static void writeVehicle (Vehicle v) throws IOException {
		System.out.printf("Mark: %s, models number: %s%n", v.getMark(), v.getModelsSize());
		String [] names = v.getModelsNames();
		double [] prices = v.getAllPrices();
		for (int i = 0; i<v.getModelsSize(); i++)
			System.out.printf("Model: %s, her price: %s%n", names[i], prices[i]);
	}
	public static Vehicle readVehicle () throws IOException, NoSuchModelNameException, DuplicateModelNameException {
		Scanner scan = new Scanner(System.in);
		String flag = scan.nextLine();
		String mark = scan.nextLine();
		int number = Integer.parseInt(scan.nextLine());
		String[] models = new String[number];
		double[] prices = new double[number];
		for (int i = 0; i<number; i++)
			models[i] = scan.nextLine();
		for (int i = 0; i<number; i++)
			prices[i] = Double.parseDouble(scan.nextLine());
		if (flag == "a") {
			Vehicle auto1 = new Auto(mark,0);
			for (int i = 0; i<number; i++) {
				auto1.addModelAndPrice(models[i], prices[i]);
			}
			return auto1;
		}
		else if (flag == "m"){
			Vehicle motorcycle1 = new Motorcycle(mark,1);
			motorcycle1.setPrice("Model0", prices[0]);
			for (int i = 1; i<number; i++) {
				motorcycle1.addModelAndPrice(models[i], prices[i]);
			}
			return motorcycle1;
		}
		else if (flag == "s"){
			Vehicle scooter1 = new Scooter(mark,0);
			for (int i = 0; i<number; i++) {
				scooter1.addModelAndPrice(models[i], prices[i]);
			}
			return scooter1;
		}
		else if (flag == "q"){
			Vehicle quadBike1 = new QuadBike(mark,0);
			for (int i = 0; i<number; i++) {
				quadBike1.addModelAndPrice(models[i], prices[i]);
			}
			return quadBike1;
		}
		else{
			Vehicle moped1 = new Moped(mark,0);
			for (int i = 0; i<number; i++) {
				moped1.addModelAndPrice(models[i], prices[i]);
			}
			return moped1;
		}
	}
	public static Vehicle refl(String name, int number, Vehicle object)
	{
		Class c = object.getClass();
		try {
			Constructor cons = c.getConstructor(new Class [] {String.class, Integer.TYPE});
			Vehicle auto1 = (Vehicle)cons.newInstance(name, number);
			return auto1;
		}
		catch (Exception e){
			return null;
		}
	}
	static double getMiddleValueVariableLength(Vehicle ... a){
		double middlevalue = 0;
		int k = 0;
		for (int i = 0; i<a.length; i++) {
			double[] output = a[i].getAllPrices();
			for (int j = 0; j<a[i].getModelsSize(); j++)
				middlevalue = middlevalue + output[j];
			k = k + a[i].getModelsSize();
		}
		return middlevalue = middlevalue/k;
	}
}