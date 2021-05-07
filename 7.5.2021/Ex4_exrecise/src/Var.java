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
            throw new Exception("my var is not in the map");
        }
        if(assignment.get(name) == null) {
            throw new Exception("the value is null");
        }
        return assignment.get(name);
    }

    @Override
    public double evaluate() throws Exception {
        throw new Exception("we need a map");
    }

    @Override
    public List<String> getVariables() {
        List<String> vars = new ArrayList<>();
        vars.add(name);
        return vars;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if(var.equals(name)){
            return expression;
        }
        return new Var(name);
    }

    @Override
    public String toString() {
        return name;
    }

}
