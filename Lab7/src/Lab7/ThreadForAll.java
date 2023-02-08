package Lab7;

public class ThreadForAll implements Runnable {
	private Vehicle something;
	public ThreadForAll (Vehicle obj) {
		something = obj;
	}
	public void run() {
		System.out.println(something.getMark());
	}
}
