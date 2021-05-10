import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Num implements Expression{

    Double myNum;

    public Num(Double x) {
        myNum = x;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return myNum.doubleValue();
    }

    @Override
    public double evaluate() throws Exception {
        return myNum.doubleValue();
    }

    @Override
    public List<String> getVariables() {
        List<String> empty = new ArrayList<>();
        return empty;
    }

    @Override
    // Returns a nice string representation of the expression.
    public String toString() {
        return myNum.toString();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Num(myNum.doubleValue());
    }
}
