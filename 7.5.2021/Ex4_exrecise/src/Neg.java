import java.util.Map;

public class Neg extends UnaryExpression{

    public Neg(Expression e){
        super(e);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return -1 * getInsideExpression().evaluate(assignment);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Neg(getInsideExpression().assign(var,expression));
    }
    @Override
    public String toString() {
        String result = "-(" + getInsideExpression().toString() +")";
        return result;
    }
}
