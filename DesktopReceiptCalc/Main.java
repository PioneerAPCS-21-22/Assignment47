/**
 * Receipt calculator in JavaFX.
 * 
 * @author Mr. King 
 * @version April 2017
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Main extends Application {
    private TextField food;
    private TextField drink;
    private TextField sub;
    private TextField tax;
    private TextField total;
    private Button btnCalc;
    private Label error;
    private final double TAX_RATE = 0.09375;

    @Override
    public void start(Stage primaryStage) // Stage is the top-level JavaFX container (window)
    {
        primaryStage.setTitle("Receipt Calculator");
        GridPane pane = new GridPane(); // Root node for all objects (buttons, labels, etc.) in this resizeable layout

        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Initialize items
        food = new TextField();
        drink = new TextField();
        sub = new TextField();
        tax = new TextField();
        total = new TextField();
        btnCalc = new Button("Calculate");
        error = new Label("");
        error.setTextFill(Color.RED);

        // set button action
        btnCalc.setOnAction(e -> calculate());

        // add rest of Labels, TextFields, and Button
        pane.add(new Label("Food:"), 0, 0);
        pane.add(food, 1, 0);
        pane.add(new Label("Drink:"), 0, 1);
        pane.add(drink, 1, 1);
        pane.add(new Label("Subtotal:"), 0, 2);
        pane.add(sub, 1, 2);
        pane.add(new Label("Tax:"), 0, 3);
        pane.add(tax, 1, 3);
        pane.add(new Label("Total:"), 0, 4);
        pane.add(total, 1, 4);
        pane.add(btnCalc, 1, 5);
        pane.add(error, 1, 7);

        Scene scene = new Scene(pane, 250, 250); // Scene is the container for all content
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Calculate and fill in values for Subtotal, Tax, and Total.
    private void calculate() {
        error.setText("");
        if (food.getText().length() == 0 || drink.getText().length() == 0) {
            error.setText("Food and drink are blank.");
            return;
        }
        double foodTotal = Double.parseDouble(food.getText());
        double drinkTotal = Double.parseDouble(drink.getText());
        double subtotal = foodTotal + drinkTotal;

        // subtotal
        sub.setText(String.valueOf(subtotal));

        // tax
        double taxAmt = (foodTotal + drinkTotal) * TAX_RATE;
        tax.setText(String.valueOf(taxAmt));

        // grand total
        double grandTotal = subtotal + taxAmt;
        total.setText(String.valueOf(grandTotal));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}