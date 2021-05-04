import java.util.ArrayList;
import java.util.List;

public abstract class BinaryExpression extends BaseExpression {
    private Expression leftExpression;
    private Expression rightExpression;

    public BinaryExpression(Expression left, Expression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

    public Expression getLeft() {
        return leftExpression;
    }

    public Expression getRight() {
        return rightExpression;
    }


    //check if needs to delete duplicate variable.
    @Override
    public List<String> getVariables() {
       List<String> result = new ArrayList<>();
       result.addAll(leftExpression.getVariables());
       result.addAll(rightExpression.getVariables());
       return result;
    }
}
