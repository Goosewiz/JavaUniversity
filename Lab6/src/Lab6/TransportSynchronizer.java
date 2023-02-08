package Lab6;

public class TransportSynchronizer {
    private Vehicle v;
    private volatile int current = 0;
    private Object lock = new Object();
    private boolean set = true;
   
    public TransportSynchronizer(Vehicle v) {
        this.v = v;
    }
   
    public double printPrice() throws InterruptedException {
        double val;
        synchronized(lock) {
            double [] p = v.getAllPrices();
            if (!canPrintPrice()) throw new InterruptedException();
            while (!set)
                lock.wait();
            val = p[current];
            System.out.println("Print price: " + val);
            set = false;
            lock.notifyAll();
        }
        return val;
    }  
   
    public void printModel() throws InterruptedException {
        synchronized(lock) {
            String [] s = v.getModelsNames();
            if (!canPrintModel()) throw new InterruptedException();
            while (set)
                lock.wait();
            System.out.println("Print model: " + s[current]);
            current = current + 1;

            set = true;
            lock.notifyAll();
        }
    }
    
    public boolean canPrintPrice() {
        return current < v.getModelsSize() - 1;
    }
    
    public boolean canPrintModel() {
    	return current < v.getModelsSize();
    }
}
