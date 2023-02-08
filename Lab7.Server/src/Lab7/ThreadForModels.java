package Lab7;

public class ThreadForModels extends Thread {
	private Vehicle something;
	public ThreadForModels (Vehicle obj) {
		something = obj;
	}
	public void run() {
		String[] models = something.getModelsNames();
		for (int i = 0; i<something.getModelsSize();i++)
			System.out.println(models[i]);
	}
}