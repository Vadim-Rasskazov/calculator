package calculator;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;

import java.util.ArrayList;

public class Calculatioin {
    ArrayList<Object> calculationData = new ArrayList<>();
    ArrayList<Object> userData = new ArrayList<>();

    public String calculate(ArrayList<Object> data) {
        Engine engine = Engine.newBuilder()
                .option("engine.WarnInterpreterOnly", "false")
                .build();
        Context ctx = Context.newBuilder("js").engine(engine).build();

        String result = toString(data);

        return String.valueOf(ctx.eval("js", result));
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
