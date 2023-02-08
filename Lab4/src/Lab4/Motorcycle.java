package Lab4;
import java.io.Serializable;
public class Motorcycle implements Vehicle {
     private class Model implements Serializable {
        private String name = null;
        private double price = Double.NaN;
        private Model prev = null;
        private Model next = null;
    }
     private int size = 0;
     private Model head;
     private transient  long lastModified;
     private String mark;
     @Override
     public String getMark (){
        return this.mark;
    }
    @Override
    public void setMarkName (String newMark){
        this.mark = newMark;
    }
    {
    	lastModified = System.currentTimeMillis();
    }
    Motorcycle (String newmark, int size) {
        this.size = size;
        this.mark = newmark;
       // this.lastModified = System.currentTimeMillis();
        this.head = new Model();
        head.name = "Model0";
        head.price = (double)(Math.random()*10000);
        head.prev = head;
        head.next = head;
        for (int i = 1; i<size; i++){
            Model created = new Model();
            created.name = "Model" + i;
            created.price = (double)(Math.random()*10000);
            created.next = head;
            created.prev = head.prev;
            head.prev.next = created;
            head.prev = created;
            }
    }  
    @Override
    public void setModelName (String oldname, String newname) throws NoSuchModelNameException, DuplicateModelNameException {
        Model now = this.head;
        Model del =null;
        for (int i = 0; i<size; i++)
        {
        	if (newname.equals(now.name))
        		throw new DuplicateModelNameException(newname);
        	if (oldname.equals(now.name))
        	{
        		del = now;
        	}
        	now = now.next;
        }
        if (del == null)
        	throw new NoSuchModelNameException(oldname);
        del.name = newname;
        this.lastModified = System.currentTimeMillis();
    }
    @Override
    public String[] getModelsNames () {
        String[] output = new String[this.size];
        Model now = this.head;
        for (int i = 0; i<this.size; i++) {
            output[i] = now.name;
            now = now.next;
        }
        return output;
    }
    @Override
    public double getPrice (String modelname) throws NoSuchModelNameException{
        Model now = this.head;
        for (int i = 0; i<this.size; i++) {
            if (modelname.equals(now.name))
                return now.price;
            now = now.next;
        }
        throw new NoSuchModelNameException(modelname);
    }
    @Override
    public void setPrice (String modelname, double newPrice) throws NoSuchModelNameException{
    	 if (newPrice < 0)
             throw new ModelPriceOutOfBoundsException(newPrice);
        Model now = this.head;
        boolean flag = true;
        for (int i = 0; i<this.size; i++) {
            if (modelname.equals(now.name))
            {
                now.price = newPrice;
                this.lastModified = System.currentTimeMillis();
                flag = false;
                break;
            }
            now = now.next;
        }
        if (flag)
        	throw new NoSuchModelNameException(modelname);
    }
    @Override
    public double[] getAllPrices () {
        Model now = this.head;
        double[] output = new double[this.size];
        for (int i = 0; i<this.size; i++)
        {
            output[i] = now.price;
            now = now.next;
        }
        return output;
    }
    @Override
    public void addModelAndPrice (String newmodel, double newprice) throws DuplicateModelNameException{
        if (newprice < 0) {
            throw new ModelPriceOutOfBoundsException(newprice);
        }
        Model now = this.head;
        for (int i = 0; i<this.size; i++) {
            if (newmodel.equals(now.name))
                throw new DuplicateModelNameException(newmodel);
            now = now.next;
        }
        Model created = new Model();
        created.name = newmodel;
        created.price = newprice;
        created.next = head;
        created.prev = head.prev;
        head.prev.next = created;
        head.prev = created;
        this.lastModified = System.currentTimeMillis();
        size++;
    }
    @Override
    public void deleteModelAndPrice (String newmodel) throws NoSuchModelNameException{
        Model now = this.head;
        int i = 0;
        while (!(newmodel.equals(now.name)) && i < this.size+1)
            now = now.next;
        if (i == this.size+1)
            throw new NoSuchModelNameException(newmodel);
        else {
            now.prev.next = now.next;
            now.next.prev = now.prev;
            this.lastModified = System.currentTimeMillis();
            size--;
        } 
    }
    @Override
    public int getModelsSize () {
        return this.size;
    }
    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append(this.getMark());
    	sb.append(" ");
    	int j = this.getModelsSize();
    	sb.append(j);
    	String[] models = this.getModelsNames();
    	double[] prices = this.getAllPrices();
    	for (int i = 0; i<j; i++) {
    		sb.append(" ");
    		sb.append(models[i]);
    	}
    	for (int i = 0; i<j; i++) {
    		sb.append(" ");
    		sb.append(prices[i]);
    	}
    	String output = sb.toString();
    	return output;
    }
    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (!(obj instanceof Vehicle))
    		return false;
    	if (!(this.getMark().equals(((Vehicle) obj).getMark()) || this.getModelsSize() == ((Vehicle) obj).getModelsSize()))
    		return false;
    	int j = this.getModelsSize();
    	String[] models = this.getModelsNames();
    	double[] prices = this.getAllPrices();
    	String[] modelsObj = ((Vehicle) obj).getModelsNames();
    	double[] pricesObj = ((Vehicle) obj).getAllPrices();
    	for (int i = 0; i<j; i++) {
    		if (!((models[i].equals(modelsObj[i])) || (prices[i] == pricesObj[i])))
        		return false;
    	}
    	return true;
    }
    @Override
    public int hashCode() {
    	int result = this.getModelsSize();
    	int j = this.getModelsSize();;
    	String[] models = this.getModelsNames();
    	double[] prices = this.getAllPrices();
    	if (this.getMark() != null)
    		result = 31 * result + this.getMark().hashCode();
    	for (int i = 0; i<j; j++) {
    		result = 31 * result + models[i].hashCode();
    	}
    	for (int i = 0; i<j; j++) {
    		result = 31 * result + Long.valueOf(Double.doubleToLongBits(prices[i])).hashCode();
    	}
    	return result;
    }
    @Override
    public Object clone() {
    	Motorcycle result = null;
    	try {
    		result = (Motorcycle)super.clone();
    		//result.mark = this.mark;
    		int j = this.getModelsSize();
			String[] models = this.getModelsNames();
			double[] prices = this.getAllPrices();
			result.head = new Model();
			result.head.name = models[0];
		    result.head.price = prices[0];
		    result.head.prev = result.head;
		    result.head.next = result.head;
			for (int i = 1; i<j; i++) {
				Model created = new Model();
				created.name = models[i];
		        created.price = prices[i];
		        created.next = result.head;
		        created.prev = result.head.prev;
		        result.head.prev.next = created;
		        result.head.prev = created;			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    	return result;
    }
}