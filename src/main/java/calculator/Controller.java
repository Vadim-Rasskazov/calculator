package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    Calculatioin calc = new Calculatioin();

    @FXML
    public void initialize() {
        rootPane.setOnKeyPressed(this::handleKeyPressed);

        equal.setOnAction(event -> onEqualButtonClick());
        clear.setOnAction(event -> onClearButtonClick());
        square.setOnAction(event -> onSquareButtonClick());
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
    }

    private void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER, EQUALS:
                if (event.isShiftDown()) {
                    onSymbolButtonClick("+");
                } else {
                    onEqualButtonClick();
                }
                break;
            case BACK_SPACE, ESCAPE, DELETE:
                onClearButtonClick();
                break;
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
                    onSquareButtonClick();
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
            case DECIMAL:
                onSymbolButtonClick(".");
                break;
        }
    }

    private void onNumberButtonClick(int number) {
        calc.userData.add(number);
        calc.calculationData.add(number);
        input.setText(calc.userResult(calc.userData));
    }

    private void onSymbolButtonClick(String symbol) {
        calc.userData.add(symbol);
        calc.calculationData.add(symbol);
        input.setText(calc.userResult(calc.userData));
    }

    private void onSquareButtonClick() {
        String userSquare = "^";
        String square = "**";
        calc.userData.add(userSquare);
        calc.calculationData.add(square);
        input.setText(calc.userResult(calc.userData));
    }

    private void onClearButtonClick() {
        calc.userData.clear();
        calc.calculationData.clear();
        input.setText(calc.userResult(calc.userData));
    }

    private void onEqualButtonClick() {
        String result = calc.calculate(calc.calculationData);
        input.setText(result);
        calc.userData.clear();
        calc.calculationData.clear();
        calc.userData.add(result);
        calc.calculationData.add(result);
    }
}
