package Lab5;
import java.io.Serializable;
public interface Vehicle extends Serializable, Cloneable{
    String getMark ();
    void setMarkName (String newMark);
    void setModelName (String oldname, String newname) throws NoSuchModelNameException, DuplicateModelNameException;
    String[] getModelsNames ();
    double getPrice (String modelname) throws NoSuchModelNameException;
    void setPrice (String modelname, double newPrice) throws NoSuchModelNameException,ModelPriceOutOfBoundsException;
    double[] getAllPrices ();
    void addModelAndPrice (String newmodel, double newprice) throws DuplicateModelNameException,ModelPriceOutOfBoundsException;
    void deleteModelAndPrice (String newmodel) throws NoSuchModelNameException;
    int getModelsSize ();
    String toString();
    boolean equals(Object obj);
    int hashCode();
    Object clone();
}