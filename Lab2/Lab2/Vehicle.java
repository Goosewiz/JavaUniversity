package Lab2;
public interface Vehicle {
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
}