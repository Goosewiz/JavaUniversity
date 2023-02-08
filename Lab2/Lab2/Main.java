package Lab2;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {
		System.out.println("Enter mark name");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.println("Enter models number");
		int arg = scan.nextInt();
		System.out.println("Choose Auto or Motorcycle");
		String uselessName = scan.nextLine();
		String typeName = scan.nextLine();
		scan.close();
		if (typeName.equals("Auto")) {
			Vehicle auto1 = new Auto(name, arg);
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
			Vehicle motorcycle1 = new Motorcycle(name, arg);
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
			System.out.println("Wrong type");
	}
}
