package Lab2;
import java.util.Arrays;
public class Auto implements Vehicle {
    private String mark;
    private Model[] array;
    @Override
    public String getMark (){
        return this.mark;
    }
    @Override
    public void setMarkName (String newMark){
        this.mark = newMark;
    }
    private class Model {
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
    	for (int i = 0; i<array.length; i++)
    	{
    		if (newname.equals(array[i].name))
    			throw new DuplicateModelNameException(newname);
    		if (oldname.equals(array[i].name))
    			position = i;
    	}
    	if (position != -1)
    		array[position].name = newname;
    	else
    		throw new NoSuchModelNameException(oldname);
    }
    @Override
    public String[] getModelsNames () {
        String[] output = new String[array.length];
        for (int i = 0; i<array.length; i++)
            output[i] = array[i].name;
        return output;
    }
    @Override
    public double getPrice (String modelname) throws NoSuchModelNameException{
        for (int i = 0; i<array.length; i++) {
            if (modelname.equals(array[i].name))
                return array[i].price;
        }
        throw new NoSuchModelNameException(modelname);
    }
    @Override
    public void setPrice (String modelname, double newPrice) throws NoSuchModelNameException{
    	if (newPrice < 0)
            throw new ModelPriceOutOfBoundsException(newPrice);
    	boolean flag = true;
        for (int i = 0; i<array.length; i++) {
            if (modelname.equals(array[i].name))
            {
                array[i].price = newPrice;
                flag = false;
                break;
            }
        }
        if (flag)
        	throw new NoSuchModelNameException(modelname);
    }
    @Override
    public double[] getAllPrices () {
        double[] output = new double[array.length];
        for (int i = 0; i<array.length; i++)
            output[i] = array[i].price;
        return output;
    }
    @Override
    public void addModelAndPrice (String newmodel, double newprice) throws DuplicateModelNameException {
        if (newprice < 0) {
            throw new ModelPriceOutOfBoundsException(newprice);
        }
        for (int i = 0; i<array.length; i++) {
            if (newmodel.equals(array[i].name))
                throw new DuplicateModelNameException(newmodel);
        }
        array = Arrays.copyOf (array, array.length+1);
        array[array.length-1] =  new Model(newmodel,newprice);
    }
    @Override
    public void deleteModelAndPrice (String newmodel) throws NoSuchModelNameException {
        int i = 0;
        while (!(newmodel.equals(array[i].name)) && i<array.length)
            i++;
        if (i == array.length)
            throw new NoSuchModelNameException(newmodel);
        else {
            System.arraycopy(array, i+1, array, i, this.array.length-i-1);
            array = Arrays.copyOf (array, array.length-1);
        }
    }
    @Override
    public int getModelsSize () {
        return this.array.length;
    }
    public  Auto (String newmark, int size) {
        this.mark = newmark;
        this.array = new Model[size];
        for (int i = 0; i<size; i++) {
        	array[i] = new Model(i);
        }
    }
}