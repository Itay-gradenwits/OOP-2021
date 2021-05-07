import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Num implements Expression{

    private Double myNum;

    public Num(Double num) {
        myNum = num;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return myNum;
    }

    @Override
    public double evaluate() throws Exception {
        return myNum;
    }

    @Override
    public List<String> getVariables() {
        List<String> empty = new ArrayList<>();
        return empty;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Num(myNum);
    }

    @Override
    public String toString() {
       return myNum.toString();
    }
}
