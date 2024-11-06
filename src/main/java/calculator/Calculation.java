package calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.ArrayList;
import java.util.List;

public class Calculation {
    ArrayList<Object> calculationData = new ArrayList<>();
    ArrayList<Object> userData = new ArrayList<>();

    public Object outcome(ArrayList<Object> data) {
        if (data.isEmpty() ||
                (data.getFirst() instanceof String &&
                        !data.getFirst().equals("√") &&
                        !data.getFirst().equals("log") &&
                        !data.getFirst().equals("ln"))) {
            return null;
        } else {
            String result = calculationString(data);
            Expression expression = new ExpressionBuilder(result).build();
            double preResult = expression.evaluate();
            if (preResult == (int) preResult) {
                return (int) preResult;
            } else {
                return preResult;
            }
        }
    }

    public String calculationString(ArrayList<Object> data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            Object item = data.get(i);
            String functionName = switch (item.toString()) {
                case "√" -> "sqrt(";
                case "log" -> "log10(";
                case "ln" -> "log(";
                default -> null;
            };
            if (functionName != null) {
                int n = data.indexOf(item);
                data.set(n, functionName);
                if (data.get(n + 1) == "(") {
                    data.set(n + 1 , "");
                    for (int j = (n + 1); j < data.size(); j++) {
                        Object currentElement = data.get(j);
                        if (currentElement.equals(")")) {
                            break;
                        }
                    }
                } else {
                    for (int k = (n + 1); k < data.size(); k++) {
                        Object currentElement = data.get(k);
                        if (currentElement instanceof String) {
                            data.add(k, ")");
                            break;
                        }
                    }

                    List<Object> sublist = data.subList(n + 1, data.size());

                    if (!sublist.contains(")")) {
                        data.add(")");
                    }
                }
            }
        }
        for (Object item : data) {
            sb.append(item);
        }
        System.out.print(sb);
        return sb.toString();
    }

    public String userString(ArrayList<Object> data) {
        StringBuilder sb = new StringBuilder();
        for (Object item : data) {
            sb.append(item);
        }
        return sb.toString();
    }

    public String userResult(ArrayList<Object> data) {
        return userString(data);
    }
}
