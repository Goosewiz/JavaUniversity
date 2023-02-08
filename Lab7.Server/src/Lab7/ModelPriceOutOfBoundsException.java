package Lab7;
public class ModelPriceOutOfBoundsException extends RuntimeException {
    public double attrName;
    public ModelPriceOutOfBoundsException(double name) {
        super ("Price " + name + " is not comparable");
        attrName = name;
    }
}