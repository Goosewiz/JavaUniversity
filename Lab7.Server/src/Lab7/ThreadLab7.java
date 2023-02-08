package Lab7;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadLab7 implements Runnable {
	private ServerSocket serverSocket;
	public ThreadLab7 (ServerSocket first) {
		serverSocket = first;
	}
	public void run() {
		Socket clientSocket = null;
		try {    
			clientSocket = serverSocket.accept();
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            Auto auto1 = (Auto)in.readObject();
			double answer = Static.getMiddleValue(auto1);
			out.writeDouble(answer);
			out.flush();
            clientSocket.close();
		} catch (IOException e) {    
			System.out.println("Accept failed");
			System.exit(-1);
		} catch (ModelPriceOutOfBoundsException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
	}
