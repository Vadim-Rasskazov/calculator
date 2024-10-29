package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;

public class Calculation {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane background;

    @FXML
    private Button clear;

    @FXML
    private Button divide;

    @FXML
    private Button dot;

    @FXML
    private Button eight;

    @FXML
    private Button equal;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private TextField input;

    @FXML
    private Button lbracket;

    @FXML
    private Button minus;

    @FXML
    private Button multiply;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button plus;

    @FXML
    private Button rbracket;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button square;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;

    @FXML
    public void initialize() {
        ArrayList<Object> calculationData = new ArrayList<>();
        ArrayList<Object> userData = new ArrayList<>();

        equal.setOnAction(event -> {
            String result = calculate(calculationData);
            input.setText(result);
            userData.clear();
            calculationData.clear();
            userData.add(result);
            calculationData.add(result);

        });

        clear.setOnAction(event -> {
            userData.clear();
            calculationData.clear();
            userResult(userData);
        });

        zero.setOnAction(event -> {
            int zero = 0;
            userData.add(zero);
            calculationData.add(zero);
            userResult(userData);
        });

        dot.setOnAction(event -> {
            String dot = ".";
            userData.add(dot);
            calculationData.add(dot);
            userResult(userData);
        });

        plus.setOnAction(event -> {
            String plus = "+";
            userData.add(plus);
            calculationData.add(plus);
            userResult(userData);
        });

        one.setOnAction(event -> {
            int one = 1;
            userData.add(one);
            calculationData.add(one);
            userResult(userData);
        });

        two.setOnAction(event -> {
            int two = 2;
            userData.add(two);
            calculationData.add(two);
            userResult(userData);
        });

        three.setOnAction(event -> {
            int three = 3;
            userData.add(three);
            calculationData.add(three);
            userResult(userData);
        });

        minus.setOnAction(event -> {
            String minus = "-";
            userData.add(minus);
            calculationData.add(minus);
            userResult(userData);
        });

        four.setOnAction(event -> {
            int four = 4;
            userData.add(four);
            calculationData.add(four);
            userResult(userData);
        });

        five.setOnAction(event -> {
            int five = 5;
            userData.add(five);
            calculationData.add(five);
            userResult(userData);
        });

        six.setOnAction(event -> {
            int six = 6;
            userData.add(six);
            calculationData.add(six);
            userResult(userData);
        });

        multiply.setOnAction(event -> {
            String multiply = "*";
            userData.add(multiply);
            calculationData.add(multiply);
            userResult(userData);
        });

        square.setOnAction(event -> {
            String userSquare = "^";
            String square = "**";
            userData.add(userSquare);
            calculationData.add(square);
            userResult(userData);
        });

        seven.setOnAction(event -> {
            int seven = 7;
            userData.add(seven);
            calculationData.add(seven);
            userResult(userData);
        });

        eight.setOnAction(event -> {
            int eight = 8;
            userData.add(eight);
            calculationData.add(eight);
            userResult(userData);
        });

        nine.setOnAction(event -> {
            int nine = 9;
            userData.add(nine);
            calculationData.add(nine);
            userResult(userData);
        });

        divide.setOnAction(event -> {
            String divide = "/";
            userData.add(divide);
            calculationData.add(divide);
            userResult(userData);
        });

        lbracket.setOnAction(event -> {
            String lbracket = "(";
            userData.add(lbracket);
            calculationData.add(lbracket);
            userResult(userData);
        });

        rbracket.setOnAction(event -> {
            String rbracket = ")";
            userData.add(rbracket);
            calculationData.add(rbracket);
            userResult(userData);
        });
    }

    public void userResult(ArrayList<Object> data) {
        String result = toString(data);
        input.setText(result);
    }

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
}
