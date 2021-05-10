import java.util.ArrayList;
import java.util.List;

public abstract class BinaryExpression extends BaseExpression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    public BinaryExpression(Expression l, Expression r){
        leftExpression = l;
        rightExpression = r;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public List<String> getVariables() {
        List<String> vars = new ArrayList<>();
        vars.addAll(leftExpression.getVariables());
        vars.addAll(rightExpression.getVariables());
        //remember to delete duplicate element.
        return vars;
    }
}
