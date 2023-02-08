package Lab3;
import java.io.*;
public class Main {
	public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException, IOException, ClassNotFoundException {
		String name = "opel";
		int arg = 5;
		String typeName = "Auto";
		Vehicle auto1 = new Auto(name, arg);
		Vehicle motorcycle1 = new Motorcycle(name, arg);
		/*if (typeName.equals("Auto")) {
			System.out.println(Made.getMiddleValue(auto1));
			Made.getNamesAndPrices(auto1, arg);
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
			System.out.println(Made.getMiddleValue(motorcycle1));
			Made.getNamesAndPrices(motorcycle1, arg);
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
		boolean flag = true;
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
			Made.outputVehicle(auto1, os);
			InputStream is = new FileInputStream(path);
			auto1 = Made.inputVehicle(is);
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
			Made.writeVehicle(auto1, pw);
			auto1 = Made.readVehicle(pr);
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
			Made.outputVehicle(motorcycle1, os);
			InputStream is = new FileInputStream(path);
			motorcycle1 = Made.inputVehicle(is);
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
			Made.writeVehicle(motorcycle1, pw);
			motorcycle1 = Made.readVehicle(pr);
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
		}
	}
}
