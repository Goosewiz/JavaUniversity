package Lab7;
import java.io.*;
import java.lang.reflect.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.net.*;
public class Main {
	public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException, IOException, ClassNotFoundException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException, InterruptedException {
		int serverNumber = 1024;
		ServerSocket serverSocket = null;
		try {    
			serverSocket = new ServerSocket(serverNumber);
			System.out.println("Send spam plz");
			Runnable r = new ThreadLab7(serverSocket);
			Thread t = new Thread(r);
			t.start();
		}
		catch (IOException e) {    
			System.out.println("Could not listen on port");    
			System.exit(-1);
		} 
	}
}