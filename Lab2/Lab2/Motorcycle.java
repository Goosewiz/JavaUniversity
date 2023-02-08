package Lab2;

public class Motorcycle implements Vehicle {
     private class Model {
        private String name = null;
        private double price = Double.NaN;
        private Model prev = null;
        private Model next = null;
    }
     private int size = 0;
     private Model head;
     private long lastModified;
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
     //   int position = -1;
        for (int i = 0; i<size; i++)
        {
        	if (newname.equals(now.name))
        		throw new DuplicateModelNameException(newname);
        	if (oldname.equals(now.name))
        	{
        		//position = i;
        		del = now;
        		//now.name = newname;
            	//this.lastModified = System.currentTimeMillis();
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
}