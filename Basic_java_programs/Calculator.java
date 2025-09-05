import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private StringBuilder inputBuffer = new StringBuilder();
    private Label displayLabel;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        displayLabel = new Label();
        displayLabel.setMinWidth(200);
        displayLabel.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 5px;");
        GridPane.setColumnSpan(displayLabel, 4);
        gridPane.add(displayLabel, 0, 0);

        String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button button = new Button(buttonLabels[i][j]);
                button.setMinWidth(50);
                button.setOnAction(e -> handleButtonClick(button.getText()));
                gridPane.add(button, j, i + 1);
            }
        }

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String buttonText) {
        switch (buttonText) {
            case "=":
                evaluateExpression();
                break;
            default:
                inputBuffer.append(buttonText);
                displayLabel.setText(inputBuffer.toString());
        }
    }

    private void evaluateExpression() {
        try {
            String expression = inputBuffer.toString();
            double result = evaluate(expression);
            displayLabel.setText(String.valueOf(result));
        } catch (Exception e) {
            displayLabel.setText("Error");
        } finally {
            inputBuffer.setLength(0);
        }
    }

    private double evaluate(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                return x;
            }
        }.parse();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
