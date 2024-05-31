package id.project.sfw.Scene;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Scene3 {

    private Stage stage;
    private TextField heightField;
    private TextField weightField;
    private String username;

    public Scene3(Stage stage, String username) {
        this.stage = stage;
        this.username = username;
    }


    public void display() {
        Label label = new Label("BCC Calculator");
        label.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 30px; -fx-font-weight: bold;");
        label.setTextFill(Color.WHITE);

        HBox hBox1 = new HBox(label);
        hBox1.setAlignment(Pos.CENTER);

        Label heightLabel = new Label("Height (cm):");
        heightLabel.setId("label-height");
        
        // heightLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 16px; -fx-font-weight: bold;");
        heightLabel.setTextFill(Color.WHITE);
        heightField = new TextField();
        // heightField.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 14px; -fx-border-color: #000000;");
        heightField.setId("height-field");
        heightField.setAlignment(Pos.CENTER);
        heightField.setMaxWidth(200);

        Label weightLabel = new Label("Weight (kg):");
        weightLabel.setId("label-weight");
        // weightLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 16px; -fx-font-weight: bold;");
        weightLabel.setTextFill(Color.WHITE);
        weightField = new TextField();
        weightField.setId("weight-Field");
      
        // weightField.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 14px; -fx-border-color: #000000;");
        weightField.setAlignment(Pos.CENTER);
        weightField.setMaxWidth(200);

        Button calculateButton = new Button("Calculate");
        Color newColorcalculator = Color.web("F4EEE0");
        calculateButton.setTextFill(Color.BLACK);
        calculateButton.setBackground(new Background(new BackgroundFill(newColorcalculator, new CornerRadii(300), Insets.EMPTY)));
        calculateButton.setOnAction(v -> calculateBMI());

        VBox vBox1 = new VBox(heightLabel, heightField, weightLabel, weightField, calculateButton);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(10);

        VBox vBox = new VBox(20, hBox1, vBox1);
        vBox.setAlignment(Pos.CENTER);

        Color maroonColor = Color.rgb(128, 0, 0);
        Color darkMaroonColor = Color.rgb(102, 0, 0);
        Color lightMaroonColor = Color.rgb(153, 0, 0);

        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, maroonColor),
                new Stop(0.3, darkMaroonColor),
                new Stop(0.6, lightMaroonColor),
                new Stop(1, maroonColor)
        );

        vBox.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

        
        Scene scene3 = new Scene(vBox, 620, 400);
        
        String css = this.getClass().getResource("/styles/style.css").toExternalForm();
        scene3.getStylesheets().add(css);
        
        
        stage.setScene(scene3);
    }

   
   
    public void calculateBMI() {
        String heightText = heightField.getText();
        String weightText = weightField.getText();
        try {
            double height = Double.parseDouble(heightText) / 100;
            double weight = Double.parseDouble(weightText);
            double bmi = weight / (height * height);

            Scene4 scene4 = new Scene4(stage, bmi, username);
            scene4.display();
        } catch (NumberFormatException e) {
            heightField.setText("Invalid input");
        }
    }
}
