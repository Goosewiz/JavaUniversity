package Lab7;
public class NoSuchModelNameException extends Exception {
    public String attrName;
    public NoSuchModelNameException(String name) {
        super ("Model with name " + name + " is not found");
        attrName = name;
    }
}