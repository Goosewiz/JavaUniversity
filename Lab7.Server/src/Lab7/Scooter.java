package Lab7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Scooter implements Vehicle {
	private String mark;
	private int size;
	private HashMap<String, Double> info;
	public  Scooter (String newmark, int number) {
        this.mark = newmark;
        this.size = number;
        this.info = new HashMap<>();
        String model = "Model";
        for (int i = 0; i<number; i++) {
        	this.info.put(model+i, (double)(Math.random()*10000));
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
    @Override
    public void setModelName (String oldname, String newname) throws NoSuchModelNameException, DuplicateModelNameException {
    	if (this.info.containsKey(newname))
    		throw new DuplicateModelNameException(newname);
    	if (!this.info.containsKey(oldname))
    		throw new NoSuchModelNameException(oldname);
    	Double number = this.info.get(oldname);
    	this.info.remove(oldname);
    	this.info.put(newname, number);
    }
    @Override
    public String[] getModelsNames () {
    	Set<String> keys = this.info.keySet();
        String[] output = keys.toArray(String[]::new);
        return output;
    }
    @Override
    public double getPrice (String modelname) throws NoSuchModelNameException{
    	if (!this.info.containsKey(modelname))
    		throw new NoSuchModelNameException(modelname);
        double output = this.info.get(modelname);
        return output;
    }
    @Override
    public void setPrice (String modelname, double newPrice) throws NoSuchModelNameException{
    	if (newPrice < 0)
            throw new ModelPriceOutOfBoundsException(newPrice);
    	if (!this.info.containsKey(modelname))
    		throw new NoSuchModelNameException(modelname);
    	this.info.remove(modelname);
    	this.info.put(modelname, newPrice);
    }
    @Override
    public double[] getAllPrices () {
    	ArrayList<Double> values = new ArrayList<>(this.info.values());
        double[] output = new double[values.size()];
    	for (int i = 0; i<values.size(); i++)
    		output[i] = values.get(i);
        return output;
    }
    @Override
    public void addModelAndPrice (String newmodel, double newprice) throws DuplicateModelNameException {
        if (newprice < 0)
            throw new ModelPriceOutOfBoundsException(newprice);
        if (this.info.containsKey(newmodel))
        	throw new DuplicateModelNameException(newmodel);
        this.info.put(newmodel, newprice);
    }
    @Override
    public void deleteModelAndPrice (String newmodel) throws NoSuchModelNameException {
    	if (!this.info.containsKey(newmodel))
    		throw new NoSuchModelNameException(newmodel);
        this.info.remove(newmodel);
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
    	Scooter result = null;
    	try {
			result = (Scooter)super.clone();
    		int j = this.getModelsSize();
    		result.info = new HashMap<String, Double>(this.info);
		} 
    	catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    	return result;
    }
}
