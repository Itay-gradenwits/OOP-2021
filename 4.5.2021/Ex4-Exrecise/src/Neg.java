import java.util.Map;

public class Neg extends UnaryExpression{

    public Neg(Expression e) {
        super(e);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return -1 * getExpression().evaluate(assignment);
    }

    @Override
    public double evaluate() throws Exception {
        return  -1 * getExpression().evaluate();
    }

    @Override
    public String toString() {
        return "-(" + getExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Neg(getExpression().assign(var,expression));
    }
}
