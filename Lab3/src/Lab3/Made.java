package Lab3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Made {
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
	public static void writeVehicle (Vehicle v, Writer out) throws IOException {
		PrintWriter pw = new PrintWriter(out);
		String mark = v.getMark();
		char c = mark.charAt(0);
		int flag = Character.getNumericValue(c);
		mark = mark.substring(1);
		int number = v.getModelsSize();
		String[] models = v.getModelsNames();
		double[] prices = v.getAllPrices();
		pw.println(flag);
		pw.println(mark);
		pw.println(number);
		for (int i = 0; i<number; i++)
			pw.println(models[i]);
		for (int i = 0; i<number; i++)
			pw.println(prices[i]);
		pw.flush();
	}
	public static Vehicle readVehicle (Reader in) throws IOException, NoSuchModelNameException, DuplicateModelNameException {
		BufferedReader br = new BufferedReader(in);
		int flag = Integer.parseInt(br.readLine());
	    String  mark = br.readLine();
		int number = Integer.parseInt(br.readLine());
		String[] models = new String[number];
		double[] prices = new double[number];
		for (int i = 0; i<number; i++)
			models[i] = br.readLine();
		for (int i = 0; i<number; i++)
			prices[i] = Double.parseDouble(br.readLine());
		if (flag == 1) {
			Vehicle auto1 = new Auto(mark,0);
			for (int i = 0; i<number; i++) {
				auto1.addModelAndPrice(models[i], prices[i]);
			}
			return auto1;
		}
		else {
			Vehicle motorcycle1 = new Motorcycle(mark,1);
			motorcycle1.setPrice("Model0", prices[0]);
			for (int i = 1; i<number; i++) {
				motorcycle1.addModelAndPrice(models[i], prices[i]);
			}
			return motorcycle1;
		}
	}
}
