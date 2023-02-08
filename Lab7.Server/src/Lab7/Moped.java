package Lab7;

import java.io.Serializable;
import java.util.LinkedList;
public class Moped implements Vehicle {
    private String mark;
    private int size;
    private LinkedList<Model> array;
    public  Moped (String newmark, int number) {
        this.mark = newmark;
        this.size = number;
        this.array = new LinkedList<>();;
        for (int i = 0; i<number; i++) {
        	this.array.add(new Model(i));
        }
    }
    @Override
    public String getMark (){
        return this.mark;
    }
    @Override
    public void setMarkName (String newMark){
        this.mark = newMark;
    }
    private class Model implements Serializable{
        private String name;
        private double price;
        Model (int size) {
        	this.name = "Model" + size;
            this.price = (double)(Math.random()*10000);
        }
        Model (String name,double price) {
        	this.name = name;
            this.price = price;
        }
        
    }
    @Override
    public void setModelName (String oldname, String newname) throws NoSuchModelNameException, DuplicateModelNameException {
    	int position = -1;
    	double savedprice = 0;
    	for (int i = 0; i<this.size; i++)
    	{
    		if (newname.equals(this.array.get(i).name))
    			throw new DuplicateModelNameException(newname);
    		if (oldname.equals(this.array.get(i).name))
    		{
    			position = i;
    		    savedprice = this.array.get(position).price;
    		}
    	}
    	if (position != -1)
    	{
    	    Model insert = new Model (newname, savedprice);
    	    this.array.remove(position);
    		this.array.add(position, insert);
    		
    	}
    	else
    		throw new NoSuchModelNameException(oldname);
    }
    @Override
    public String[] getModelsNames () {
        String[] output = new String[this.size];
        for (int i = 0; i<this.size; i++)
        {
        	Model working = this.array.get(i);
            output[i] = working.name;
        }
        return output;
    }
    @Override
    public double getPrice (String modelname) throws NoSuchModelNameException{
        for (int i = 0; i<this.size; i++) {
            if (modelname.equals(this.array.get(i).name))
                return this.array.get(i).price;
        }
        throw new NoSuchModelNameException(modelname);
    }
    @Override
    public void setPrice (String modelname, double newPrice) throws NoSuchModelNameException{
    	if (newPrice < 0)
            throw new ModelPriceOutOfBoundsException(newPrice);
    	boolean flag = true;
        for (int i = 0; i<this.size; i++) {
            if (modelname.equals(this.array.get(i).name))
            {
                this.array.get(i).price = newPrice;
                flag = false;
                break;
            }
        }
        if (flag)
        	throw new NoSuchModelNameException(modelname);
    }
    @Override
    public double[] getAllPrices () {
        double[] output = new double[this.size];
        for (int i = 0; i<this.size; i++)
            output[i] = this.array.get(i).price;
        return output;
    }
    @Override
    public void addModelAndPrice (String newmodel, double newprice) throws DuplicateModelNameException {
        if (newprice < 0) {
            throw new ModelPriceOutOfBoundsException(newprice);
        }
        for (int i = 0; i<this.size; i++) {
            if (newmodel.equals(this.array.get(i).name))
                throw new DuplicateModelNameException(newmodel);
        }
        Model working = new Model(newmodel, newprice);
        this.array.add(working);
        this.size = this.size + 1;
    }
    @Override
    public void deleteModelAndPrice (String newmodel) throws NoSuchModelNameException {
        int i = 0;
        while (!(newmodel.equals(this.array.get(i).name)) && i<this.size)
            i++;
        if (i == this.size)
            throw new NoSuchModelNameException(newmodel);
        else {
        	this.array.remove(i);
        	this.size = this.size - 1;
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
    	Moped result = null;
    	try {
			result = (Moped)super.clone();
    		int j = this.getModelsSize();
			result.array = new LinkedList<Model>(this.array);
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    	return result;
    }
}