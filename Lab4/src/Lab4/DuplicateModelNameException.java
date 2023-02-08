package Lab4;
public class DuplicateModelNameException extends Exception {
    public String attrName;
    public DuplicateModelNameException(String name) {
        super ("Model with name " + name + " already exsits");
        attrName = name;
    }
}