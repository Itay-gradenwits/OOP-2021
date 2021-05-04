import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Var implements Expression{
    String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        if(!assignment.containsKey(name)) {
            throw new Exception("var is not in mapping");
        }
        return assignment.get(name);
    }

    @Override
    public double evaluate() throws Exception {
        throw new Exception("can't evaluate with no mapping");
    }

    @Override
    public List<String> getVariables() {
        List<String > vars = new ArrayList<>();
        vars.add(name);
        return vars;
    }

    @Override
    // Returns a nice string representation of the expression.
    public String toString() {
        return name;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if(var.equals(name)) {
            return expression;
        }
        return new Var(name);
    }
}
