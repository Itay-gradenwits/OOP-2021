import java.util.Map;
import java.util.TreeMap;

public class Plus extends BinaryExpression{

    public Plus(Expression l, Expression r) {
        super(l,r);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return getLeftExpression().evaluate(assignment) + getRightExpression().evaluate(assignment);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Plus(getLeftExpression().assign(var, expression), getRightExpression().assign(var, expression));
    }

    @Override
    public String toString() {
        return getLeftExpression().toString() + "+" + getRightExpression().toString();
    }
}
