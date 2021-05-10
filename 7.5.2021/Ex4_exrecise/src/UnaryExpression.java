import java.util.List;

public abstract class UnaryExpression extends BaseExpression{
    private final Expression insideExpression;

    public UnaryExpression(Expression e) {
        insideExpression = e;
    }

    public Expression getInsideExpression() {
        return insideExpression;
    }

    @Override
    public List<String> getVariables() {
        return insideExpression.getVariables();
    }
}
