package Lab8;

public class Calculator {
	private double value1;
    private char operator;
    private double value2;
    private double result;
    public double getValue1() {
        return value1;
    }
    public void setValue1(double v1) {
        value1 = v1;
    }   
    public double getValue2() {
        return value2;
    }
    public void setValue2(double v2) {
        value2 = v2;
    }    
    public char getOperator() {
        return operator;
    }
    public void setOperator(char op) {
        operator = op;
    }    
    public String getResult() {
        return Double.toString(result);
    }
    public void setResult(double res) {
        result = res;
    }
    public Calculator(){
    	value1 = 0;
        operator = '+';
        value2 = 0;
        result = 0;
    }
    public String calculate() {
        switch (operator) {
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '*':
                result = value1 * value2;
                break;
            case '/':
                result = value1 / value2;
                break;
            case '^':
                result = Math.pow(value1, value2);
                break;
            case 'r':
                result = Math.sqrt(value1);
                break;
        }
        int temp = (int)result;
        if (result == temp)
        	return Integer.toString(temp);
        else
        	return Double.toString(result);
    }
}
