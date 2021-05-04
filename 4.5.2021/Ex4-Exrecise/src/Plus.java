import java.util.Map;

public class Plus extends BinaryExpression{

    public Plus(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return getLeft().evaluate(assignment) + getRight().evaluate(assignment);
    }

    @Override
    public double evaluate() throws Exception {
        return getLeft().evaluate() + getRight().evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Plus(getLeft().assign(var, expression), getRight().assign(var, expression));
    }
}