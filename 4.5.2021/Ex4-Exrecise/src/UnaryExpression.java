import java.util.List;

public abstract class UnaryExpression extends BaseExpression {
    private Expression e;
    public UnaryExpression(Expression e) {
        this.e = e;
    }

    public Expression getExpression() {
        return e;
    }

    @Override
    public List<String> getVariables() {
        return e.getVariables();
    }
}
