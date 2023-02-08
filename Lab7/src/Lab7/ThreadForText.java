package Lab7;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ThreadForText implements Runnable {
	private String something;
	private BlockingQueue<Vehicle> bq;
	public ThreadForText (String obj, BlockingQueue<Vehicle> b) {
		something = obj;
		bq = b;
	}
	public void run() {
		Path path = Paths.get(something);
		try {
			Scanner scan = new Scanner(path);
			String mark = scan.nextLine();
			Vehicle auto1 = new Auto(mark, 5);
			bq.put(auto1);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}