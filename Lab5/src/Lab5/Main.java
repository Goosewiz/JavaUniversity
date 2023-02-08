package Lab5;
import java.io.*;
import java.lang.reflect.*;
public class Main {
	public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException, IOException, ClassNotFoundException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		if (args.length == 4) {
			String name = "opel";
			int arg = 5;
			Vehicle auto1 = new Auto(name, arg);
			Vehicle motorcycle1 = new Motorcycle(name, arg);
			String output8 = auto1.toString();
			System.out.println("Working with method setPrice");
			System.out.println(output8);
			try {
				Class c = Class.forName(args[0]);
				//Constructor cons = c.getConstructor(new Class [] {String.class, Integer.TYPE});
				Method m = c.getMethod(args[1], new Class [] {String.class, Double.TYPE});
			    //Method ToString = c.getMethod("toString", new Class [] {});
			    String str = args[2];
			    Double val = Double.valueOf(args[3]);
			    //Object obj = cons.newInstance(name, arg);
			    //Object obj = (Object)auto1;
			    m.invoke(auto1, new Object [] {str, val});
			    System.out.println(auto1.toString());
			} 
			catch (ClassNotFoundException e) {
		        System.out.println("Класс не найден");
		    } 
			catch (NoSuchMethodException e) {
		        System.out.println("Метод не найден");
		    } 
			catch (IllegalAccessException e) {
		        System.out.println("Метод недоступен");
		    } 
			catch (InvocationTargetException e) {
		        System.out.println("При вызове возникло исключение");
		    }
			Vehicle auto2 = Static.refl(name, arg, auto1);
			System.out.println("Working with newInctanse");
			System.out.println(auto2.toString());
			System.out.println(auto2.getClass());
			System.out.println();
			Vehicle scooter1 = new Scooter(name, arg);
			System.out.println(Static.getMiddleValue(scooter1));
			Static.getNamesAndPrices(scooter1, arg);
			System.out.println();
			System.out.println("New mark is");
			scooter1.setMarkName("SomeBrandlyNewMark");
			System.out.println(scooter1.getMark());
			System.out.println();
			System.out.println("Changing model name");
		    scooter1.setModelName("Model0", "NotModelAtAll");
			String[] output = new String[arg];
			output = scooter1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Changing price of model");
			scooter1.setPrice("Model1", 12345);
			System.out.println(scooter1.getPrice("Model1"));
			//scooter1.setPrice("new", 12345);
			//scooter1.setPrice("Model1", -12345);
			//scooter1.addModelAndPrice("Model1", 123);
			System.out.println();
			System.out.println("Adding new model");
			scooter1.addModelAndPrice("ModelABC", 123);
			arg = arg + 1;
			output = scooter1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Deleting model");
			scooter1.deleteModelAndPrice("Model3");
			arg = arg - 1;
			output = scooter1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("All prices");
			double[] prices = new double[arg];
		    prices = scooter1.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(prices[i]);
			System.out.println();
			System.out.println("Returning number of models");
			System.out.println(scooter1.getModelsSize());
			String print = scooter1.toString();
			System.out.println("Work of new print method");
			System.out.println(print);
			String[] models = scooter1.getModelsNames();
			prices = scooter1.getAllPrices();
			auto1 = new Auto(scooter1.getMark(), 0);
			for (int i = 0; i<arg; i++) {
				auto1.addModelAndPrice(models[i], prices[i]);
			}
			print = auto1.toString();
			System.out.println("Copy of scooter");
			System.out.println(print);
			boolean result = scooter1.equals(auto1);
			System.out.println("Comapring result");
			System.out.println(result);
			//int y = scooter1.hashCode();
			System.out.println("First hash-code");
			//System.out.println(y);
			//y = auto1.hashCode();
			System.out.println("Second hash-code");
			//System.out.println(y);
			System.out.println();
			System.out.println("Working with Scooter");
			System.out.println();
			Vehicle scooter2 = new Scooter("No",0);
			scooter2 = (Vehicle) scooter1.clone();
			print = scooter1.toString();
			System.out.println("Object before copy");
			System.out.println(print);
			print = scooter2.toString();
			System.out.println("Copied object");
			System.out.println(print);
			scooter2.setModelName("NotModelAtAll", "Model0");
			print = scooter1.toString();
			System.out.println("Object before copy");
			System.out.println(print);
			print = scooter2.toString();
			System.out.println("Copied object with changed Mark Name");
			System.out.println(print);
			
			System.out.println();
			Vehicle QuadBike1 = new QuadBike(name, arg);
			System.out.println(Static.getMiddleValue(QuadBike1));
			Static.getNamesAndPrices(QuadBike1, arg);
			System.out.println();
			System.out.println("New mark is");
			QuadBike1.setMarkName("SomeBrandlyNewMark");
			System.out.println(QuadBike1.getMark());
			System.out.println();
			System.out.println("Changing model name");
		    QuadBike1.setModelName("Model0", "NotModelAtAll");
			output = new String[arg];
			output = QuadBike1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Changing price of model");
			QuadBike1.setPrice("Model1", 12345);
			System.out.println(QuadBike1.getPrice("Model1"));
			//QuadBike1.setPrice("new", 12345);
			//QuadBike1.setPrice("Model1", -12345);
			//QuadBike1.addModelAndPrice("Model1", 123);
			System.out.println();
			System.out.println("Adding new model");
			QuadBike1.addModelAndPrice("ModelABC", 123);
			arg = arg + 1;
			output = QuadBike1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Deleting model");
			QuadBike1.deleteModelAndPrice("Model3");
			arg = arg - 1;
			output = QuadBike1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("All prices");
			prices = new double[arg];
		    prices = QuadBike1.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(prices[i]);
			System.out.println();
			System.out.println("Returning number of models");
			System.out.println(QuadBike1.getModelsSize());
			print = QuadBike1.toString();
			System.out.println("Work of new print method");
			System.out.println(print);
			models = QuadBike1.getModelsNames();
			prices = QuadBike1.getAllPrices();
			auto1 = new Auto(QuadBike1.getMark(), 0);
			for (int i = 0; i<arg; i++) {
				auto1.addModelAndPrice(models[i], prices[i]);
			}
			print = auto1.toString();
			System.out.println("Copy of QuadBike");
			System.out.println(print);
			result = QuadBike1.equals(auto1);
			System.out.println("Comapring result");
			System.out.println(result);
			//y = QuadBike1.hashCode();
			System.out.println("First hash-code");
			//System.out.println(y);
			//y = auto1.hashCode();
			System.out.println("Second hash-code");
			//System.out.println(y);
			System.out.println();
			System.out.println("Working with QuadBike");
			System.out.println();
			Vehicle QuadBike2 = new QuadBike("No",0);
			QuadBike2 = (Vehicle) QuadBike1.clone();
			print = QuadBike1.toString();
			System.out.println("Object before copy");
			System.out.println(print);
			print = QuadBike2.toString();
			System.out.println("Copied object");
			System.out.println(print);
			QuadBike2.setModelName("NotModelAtAll", "Model0");
			print = QuadBike1.toString();
			System.out.println("Object before copy");
			System.out.println(print);
			print = QuadBike2.toString();
			System.out.println("Copied object with changed Mark Name");
			System.out.println(print);
			
			System.out.println();
			Vehicle Moped1 = new Moped(name, arg);
			System.out.println(Static.getMiddleValue(Moped1));
			Static.getNamesAndPrices(Moped1, arg);
			System.out.println();
			System.out.println("New mark is");
			Moped1.setMarkName("SomeBrandlyNewMark");
			System.out.println(Moped1.getMark());
			System.out.println();
			System.out.println("Changing model name");
		    Moped1.setModelName("Model0", "NotModelAtAll");
			output = new String[arg];
			output = Moped1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Changing price of model");
			Moped1.setPrice("Model1", 12345);
			System.out.println(Moped1.getPrice("Model1"));
			//Moped1.setPrice("new", 12345);
			//Moped1.setPrice("Model1", -12345);
			//Moped1.addModelAndPrice("Model1", 123);
			System.out.println();
			System.out.println("Adding new model");
			Moped1.addModelAndPrice("ModelABC", 123);
			arg = arg + 1;
			output = Moped1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Deleting model");
			Moped1.deleteModelAndPrice("Model3");
			arg = arg - 1;
			output = Moped1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("All prices");
			prices = new double[arg];
		    prices = Moped1.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(prices[i]);
			System.out.println();
			System.out.println("Returning number of models");
			System.out.println(Moped1.getModelsSize());
			print = Moped1.toString();
			System.out.println("Work of new print method");
			System.out.println(print);
			models = Moped1.getModelsNames();
			prices = Moped1.getAllPrices();
			auto1 = new Auto(Moped1.getMark(), 0);
			for (int i = 0; i<arg; i++) {
				auto1.addModelAndPrice(models[i], prices[i]);
			}
			print = auto1.toString();
			System.out.println("Copy of Moped");
			System.out.println(print);
			result = Moped1.equals(auto1);
			System.out.println("Comapring result");
			System.out.println(result);
			//y = Moped1.hashCode();
			System.out.println("First hash-code");
			//System.out.println(y);
			//y = auto1.hashCode();
			System.out.println("Second hash-code");
			//System.out.println(y);
			System.out.println();
			System.out.println("Working with Moped");
			System.out.println();
			Vehicle Moped2 = new Moped("No",0);
			Moped2 = (Vehicle) Moped1.clone();
			print = Moped1.toString();
			System.out.println("Object before copy");
			System.out.println(print);
			print = Moped2.toString();
			System.out.println("Copied object");
			System.out.println(print);
			Moped2.setModelName("NotModelAtAll", "Model0");
			print = Moped1.toString();
			System.out.println("Object before copy");
			System.out.println(print);
			print = Moped2.toString();
			System.out.println("Copied object with changed Mark Name");
			System.out.println(print);
			System.out.println();
			Vehicle autoN = new Auto(name, arg);
			Vehicle motorcycleN = new Motorcycle(name, arg);
			Vehicle scooterN = new Scooter(name, arg);
			Vehicle quadBikeN = new QuadBike(name, arg);
			Vehicle mopedN = new Moped(name, arg);
			Vehicle[] array = new Vehicle[5];
			array[0] = autoN;
			array[1] = motorcycleN;
			array[2] = scooterN;
			array[3] = quadBikeN;
			array[4] = mopedN;
			double newMiddlevalue = Static.getMiddleValueVariableLength(array);
			System.out.println(autoN.toString());
			System.out.println(motorcycleN.toString());
			System.out.println(scooterN.toString());
			System.out.println(quadBikeN.toString());
			System.out.println(mopedN.toString());
			System.out.println("Middle value of all things in array");
			System.out.println(newMiddlevalue);
			System.out.println();
			quadBikeN.setMarkName("q"+quadBikeN.getMark());
			Static.writeVehicle(quadBikeN);
			quadBikeN = Static.readVehicle();
			System.out.println(quadBikeN.toString());
		}
		/*String print = auto1.toString();
		System.out.println("Work of new print method");
		System.out.println(print);
		String[] models = auto1.getModelsNames();
		double[] prices = auto1.getAllPrices();
		for (int i = 0; i<arg; i++) {
			motorcycle1.setPrice(models[i], prices[i]);
		}
		print = motorcycle1.toString();
		System.out.println("Copy of auto");
		System.out.println(print);
		boolean result = auto1.equals(motorcycle1);
		System.out.println("Comapring result");
		System.out.println(result);
		int y = auto1.hashCode();
		System.out.println("First hash-code");
		System.out.println(y);
		y = motorcycle1.hashCode();
		System.out.println("Second hash-code");
		System.out.println(y);
		System.out.println();
		System.out.println("Working with Auto");
		System.out.println();
		Vehicle auto2 = new Auto("No",0);
		auto2 = (Vehicle) auto1.clone();
		print = auto1.toString();
		System.out.println("Object before copy");
		System.out.println(print);
		print = auto2.toString();
		System.out.println("Copied object with changed Mark Name");
		System.out.println(print);
		auto2.setModelName("Model0", "NotModelAtAll");
		print = auto1.toString();
		System.out.println("Object before copy");
		System.out.println(print);
		print = auto2.toString();
		System.out.println("Copied object with changed Mark Name");
		System.out.println(print);
		motorcycle1 = new Motorcycle(name, arg);
		System.out.println();
		System.out.println("Working with Motorcycle");
		System.out.println();
		Vehicle motorcycle2 = new Motorcycle("No",1);
		motorcycle2 = (Vehicle) motorcycle1.clone();
		print = motorcycle1.toString();
		System.out.println("Object before copy");
		System.out.println(print);
		print = motorcycle2.toString();
		System.out.println("Copied object with changed Mark Name");
		System.out.println(print);
		motorcycle2.setModelName("Model0", "NotModelAtAll");
		print = motorcycle1.toString();
		System.out.println("Object before copy");
		System.out.println(print);
		print = motorcycle2.toString();
		System.out.println("Copied object with changed Mark Name");
		System.out.println(print);*/
		/*String typeName = "Auto
		if (typeName.equals("Auto")) {
			System.out.println(Static.getMiddleValue(auto1));
			Static.getNamesAndPrices(auto1, arg);
			System.out.println();
			System.out.println("New mark is");
			auto1.setMarkName("SomeBrandlyNewMark");
			System.out.println(auto1.getMark());
			System.out.println();
			System.out.println("Changing model name");
			auto1.setModelName("Model0", "NotModelAtAll");
			String[] output = new String[arg];
			output = auto1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Changing price of model");
			auto1.setPrice("Model1", 12345);
			System.out.println(auto1.getPrice("Model1"));
			//auto1.setPrice("new", 12345);
			//auto1.setPrice("Model1", -12345);
			//auto1.addModelAndPrice("Model1", 123);
			System.out.println();
			System.out.println("Adding new model");
			auto1.addModelAndPrice("ModelABC", 123);
			arg = arg + 1;
			output = auto1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Deleting model");
			auto1.deleteModelAndPrice("Model3");
			arg = arg - 1;
			output = auto1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("All prices");
			double[] prices = new double[arg];
			prices = auto1.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(prices[i]);
			System.out.println();
			System.out.println("Returning number of models");
			System.out.println(auto1.getModelsSize());
		}
		else if (typeName.equals("Motorcycle")) {
			System.out.println(Static.getMiddleValue(motorcycle1));
			Static.getNamesAndPrices(motorcycle1, arg);
			System.out.println();
			System.out.println("New mark is");
			motorcycle1.setMarkName("SomeBrandlyNewMark");
			System.out.println(motorcycle1.getMark());
			System.out.println();
			System.out.println("Changing model name");
			motorcycle1.setModelName("Model0", "Model00000000");
			String[] output = new String[arg];
			output = motorcycle1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Changing price of model");
			motorcycle1.setPrice("Model1", 12345);
			System.out.println(motorcycle1.getPrice("Model1"));
			//motorcycle1.setPrice("new", 12345);
			motorcycle1.setPrice("Model1", -12345);
			//motorcycle1.addModelAndPrice("Model1", 123);
			System.out.println();
			System.out.println("Adding new model");
			motorcycle1.addModelAndPrice("ModelABC", 123);
			arg = arg + 1;
			output = motorcycle1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("Deleting model");
			motorcycle1.deleteModelAndPrice("Model3");
			arg = arg - 1;
			output = motorcycle1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			System.out.println();
			System.out.println("All prices");
			double[] prices = new double[arg];
			prices = motorcycle1.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(prices[i]);
			System.out.println();
			System.out.println("Returning number of models");
			System.out.println(motorcycle1.getModelsSize());
		}
		else 
			System.out.println("Wrong type");*/
		/*boolean flag = true;
		if (flag) {
			System.out.println(auto1.getMark());
			System.out.println(auto1.getModelsSize());
			int j = auto1.getModelsSize();
			String[] output = new String[j];
			double[] prices = new double[j];
			output = auto1.getModelsNames();
			prices = auto1.getAllPrices();
			for (int  i = 0; i<j; i++)
				System.out.println(output[i]);
			for (int  i = 0; i<j; i++)
				System.out.println(prices[i]);
			String path = "C:\\DANILA\\OOP - java\\Lab3\\byte.txt";
			OutputStream os = new FileOutputStream(path);
			auto1.setMarkName(Integer.toString(1) + auto1.getMark());
			Static.outputVehicle(auto1, os);
			InputStream is = new FileInputStream(path);
			auto1 = Static.inputVehicle(is);
			System.out.println();
			System.out.println(auto1.getMark());
			System.out.println(auto1.getModelsSize());
			j = auto1.getModelsSize();
			output = new String[j];
			prices = new double[j];
			output = auto1.getModelsNames();
			prices = auto1.getAllPrices();
			for (int  i = 0; i<j; i++)
				System.out.println(output[i]);
			for (int  i = 0; i<j; i++)
				System.out.println(prices[i]);
			String path2 = "";
			auto1.setMarkName(Integer.toString(1) + auto1.getMark());
			Writer pw;
			Reader pr;
			if (path2 == "")
			{
				pw = new OutputStreamWriter(System.out);
				pr = new InputStreamReader(System.in);
			}
			else
			{
				pw = new FileWriter(path2);
				pr = new FileReader(path2);
			}
			Static.writeVehicle(auto1, pw);
			auto1 = Static.readVehicle(pr);
			System.out.println();
			System.out.println(auto1.getMark());
			System.out.println(auto1.getModelsSize());
			j = auto1.getModelsSize();
			output = new String[j];
			prices = new double[j];
			output = auto1.getModelsNames();
			prices = auto1.getAllPrices();
			for (int  i = 0; i<j; i++)
				System.out.println(output[i]);
			for (int  i = 0; i<j; i++)
				System.out.println(prices[i]);
			System.out.println();
			auto1 = new Auto("NewName", 7);
			System.out.println(auto1.getMark());
			System.out.println(auto1.getModelsSize());
			output = auto1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			double[] outprice = auto1.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(outprice[i]);
			String document = "C:\\DANILA\\OOP - java\\Lab3\\saved.txt";
			FileOutputStream fileOut = new 	FileOutputStream(document);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(auto1);
			FileInputStream fileInput = new FileInputStream(document);
			ObjectInputStream input = new ObjectInputStream(fileInput);
			Vehicle auto2 = (Vehicle) input.readObject();
			System.out.println();
			System.out.println(auto2.getMark());
			System.out.println(auto2.getModelsSize());
			output = auto2.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			outprice = auto2.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(outprice[i]);
		}
		else {
			System.out.println(motorcycle1.getMark());
			System.out.println(motorcycle1.getModelsSize());
			int j = motorcycle1.getModelsSize();
			String[] output = new String[j];
			double[] prices = new double[j];
			output = motorcycle1.getModelsNames();
			prices = motorcycle1.getAllPrices();
			for (int  i = 0; i<j; i++)
				System.out.println(output[i]);
			for (int  i = 0; i<j; i++)
				System.out.println(prices[i]);
			String path = "C:\\DANILA\\OOP - java\\Lab3\\byte.txt";
			motorcycle1.setMarkName(Integer.toString(0) + motorcycle1.getMark());
			OutputStream os = new FileOutputStream(path);
			Static.outputVehicle(motorcycle1, os);
			InputStream is = new FileInputStream(path);
			motorcycle1 = Static.inputVehicle(is);
			System.out.println();
			System.out.println(motorcycle1.getMark());
			System.out.println(motorcycle1.getModelsSize());
			j = motorcycle1.getModelsSize();
			output = new String[j];
			prices = new double[j];
			output = motorcycle1.getModelsNames();
			prices = motorcycle1.getAllPrices();
			for (int  i = 0; i<j; i++)
				System.out.println(output[i]);
			for (int  i = 0; i<j; i++)
				System.out.println(prices[i]);
			String path2 = "C:\\DANILA\\OOP - java\\Lab3\\char.txt";
			motorcycle1.setMarkName(Integer.toString(0) + motorcycle1.getMark());
			Writer pw;
			Reader pr;
			if (path2 == "")
			{
				pw = new OutputStreamWriter(System.out);
				pr = new InputStreamReader(System.in);
			}
			else
			{
				pw = new FileWriter(path2);
				pr = new FileReader(path2);
			}
			Static.writeVehicle(motorcycle1, pw);
			motorcycle1 = Static.readVehicle(pr);
			System.out.println();
			System.out.println(motorcycle1.getMark());
			System.out.println(motorcycle1.getModelsSize());
			j = motorcycle1.getModelsSize();
			output = new String[j];
			prices = new double[j];
			output = motorcycle1.getModelsNames();
			prices = motorcycle1.getAllPrices();
			for (int  i = 0; i<j; i++)
				System.out.println(output[i]);
			for (int  i = 0; i<j; i++)
				System.out.println(prices[i]);
			System.out.println();
			motorcycle1 = new Motorcycle("NewName", 7);
			System.out.println(motorcycle1.getMark());
			System.out.println(motorcycle1.getModelsSize());
			output = motorcycle1.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			double[] outprice = motorcycle1.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(outprice[i]);
			String document = "C:\\DANILA\\OOP - java\\Lab3\\saved.txt";
			FileOutputStream fileOut = new 	FileOutputStream(document);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(motorcycle1);
			FileInputStream fileInput = new FileInputStream(document);
			ObjectInputStream input = new ObjectInputStream(fileInput);
			Vehicle motorcycle2 = (Vehicle) input.readObject();
			System.out.println();
			System.out.println(motorcycle2.getMark());
			System.out.println(motorcycle2.getModelsSize());
			output = motorcycle2.getModelsNames();
			for (int  i = 0; i<arg; i++)
				System.out.println(output[i]);
			outprice = motorcycle2.getAllPrices();
			for (int  i = 0; i<arg; i++)
				System.out.println(outprice[i]);			
		}*/
	}
}