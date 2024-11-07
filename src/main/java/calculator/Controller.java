package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField input;

    @FXML
    private Button divide, multiply, minus, plus, root, square, dot, lbracket, rbracket, log, ln;

    @FXML
    private Button zero, one, two, three, four, five, six, seven, eight, nine, clear, equal;

    Calculation calculate = new Calculation();

    @FXML
    public void initialize() {
        rootPane.setOnKeyPressed(this::handleKeyPressed);

        equal.setOnAction(event -> onEqualButtonClick());
        clear.setOnAction(event -> onClearButtonClick());
        zero.setOnAction(event -> onNumberButtonClick(0));
        one.setOnAction(event -> onNumberButtonClick(1));
        two.setOnAction(event -> onNumberButtonClick(2));
        three.setOnAction(event -> onNumberButtonClick(3));
        four.setOnAction(event -> onNumberButtonClick(4));
        five.setOnAction(event -> onNumberButtonClick(5));
        six.setOnAction(event -> onNumberButtonClick(6));
        seven.setOnAction(event -> onNumberButtonClick(7));
        eight.setOnAction(event -> onNumberButtonClick(8));
        nine.setOnAction(event -> onNumberButtonClick(9));
        dot.setOnAction(event -> onSymbolButtonClick("."));
        plus.setOnAction(event -> onSymbolButtonClick("+"));
        minus.setOnAction(event -> onSymbolButtonClick("-"));
        multiply.setOnAction(event -> onSymbolButtonClick("*"));
        divide.setOnAction(event -> onSymbolButtonClick("/"));
        lbracket.setOnAction(event -> onSymbolButtonClick("("));
        rbracket.setOnAction(event -> onSymbolButtonClick(")"));
        square.setOnAction(event -> onSymbolButtonClick("^"));
        root.setOnAction(event -> onSymbolButtonClick("√"));
        log.setOnAction(event -> onSymbolButtonClick("log"));
        ln.setOnAction(event -> onSymbolButtonClick("ln"));
    }

    private void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case DIGIT1, NUMPAD1:
                onNumberButtonClick(1);
                break;
            case DIGIT2, NUMPAD2:
                onNumberButtonClick(2);
                break;
            case DIGIT3, NUMPAD3:
                onNumberButtonClick(3);
                break;
            case DIGIT4, NUMPAD4:
                onNumberButtonClick(4);
                break;
            case DIGIT5, NUMPAD5:
                onNumberButtonClick(5);
                break;
            case NUMPAD6:
                onNumberButtonClick(6);
                break;
            case DIGIT7, NUMPAD7:
                onNumberButtonClick(7);
                break;
            case NUMPAD8:
                onNumberButtonClick(8);
                break;
            case NUMPAD9:
                onNumberButtonClick(9);
                break;
            case NUMPAD0:
                onNumberButtonClick(0);
                break;
            case DIGIT6:
                if (event.isShiftDown()) {
                    onSymbolButtonClick("^");
                } else {
                    onNumberButtonClick(6);
                }
                break;
            case DIGIT8:
                if (event.isShiftDown()) {
                    onSymbolButtonClick("*");
                } else {
                    onNumberButtonClick(8);
                }
                break;
            case DIGIT9:
                if (event.isShiftDown()) {
                    onSymbolButtonClick("(");
                } else {
                    onNumberButtonClick(9);
                }
                break;
            case DIGIT0:
                if (event.isShiftDown()) {
                    onSymbolButtonClick(")");
                } else{
                    onNumberButtonClick(0);
                }
                break;
            case ENTER, EQUALS:
                if (event.isShiftDown()) {
                    onSymbolButtonClick("+");
                } else {
                    onEqualButtonClick();
                }
                break;
            case BACK_SPACE:
                deleteLastCharacter();
                break;
            case ESCAPE, DELETE:
                onClearButtonClick();
                break;
            case PLUS, ADD:
                onSymbolButtonClick("+");
                break;
            case MINUS, SUBTRACT:
                onSymbolButtonClick("-");
                break;
            case MULTIPLY:
                onSymbolButtonClick("*");
                break;
            case SLASH, DIVIDE:
                onSymbolButtonClick("/");
                break;
            case DECIMAL, SEPARATOR:
                onSymbolButtonClick(".");
                break;
        }
    }

    private void onNumberButtonClick(int number) {
        calculate.userData.add(number);
        calculate.calculationData.add(number);
        input.setText(calculate.userResult(calculate.userData));
    }

    private void onSymbolButtonClick(String symbol) {
        calculate.userData.add(symbol);
        calculate.calculationData.add(symbol);
        input.setText(calculate.userResult(calculate.userData));
    }

    private void onClearButtonClick() {
        calculate.userData.clear();
        calculate.calculationData.clear();
        input.setText(calculate.userResult(calculate.userData));
    }

    private void onEqualButtonClick() {
        Object result = calculate.calculationResult(calculate.calculationData);
        onClearButtonClick();
        if (result == null) {
            input.setText("");
        } else {
            calculate.userData.add(result);
            calculate.calculationData.add(result);
            input.setText(result.toString());
        }
    }

    private void deleteLastCharacter() {
        if (calculate.userData.isEmpty()) {
            input.setText("");
        } else {
            calculate.userData.removeLast();
            calculate.calculationData.removeLast();
            input.setText(calculate.userResult(calculate.userData));
        }
    }
}
