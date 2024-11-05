package calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.ArrayList;

public class Calculation {
    ArrayList<Object> calculationData = new ArrayList<>();
    ArrayList<Object> userData = new ArrayList<>();

    public Object outcome(ArrayList<Object> data) {
        if (data.isEmpty() || data.getFirst() instanceof String)  {
            return null;
        } else {
            String result = toString(data);
            Expression expression = new ExpressionBuilder(result).build();
            double preResult = expression.evaluate();
            if (preResult == (int) preResult) {
                return (int) preResult;
            } else {
                return preResult;
            }
        }
    }

    public String toString(ArrayList<Object> list) {
        StringBuilder sb = new StringBuilder();
        for (Object item : list) {
            sb.append(item);
        }
        return sb.toString();
    }

    public String userResult(ArrayList<Object> data) {
        return toString(data);
    }
}
