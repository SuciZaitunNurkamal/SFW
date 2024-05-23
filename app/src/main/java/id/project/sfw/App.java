package id.project.sfw;
import javafx.stage.Stage;
import javafx.util.Duration;
import id.project.sfw.confiq.DbConnect;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;





public class App extends Application {

    private Stage stage;
 

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.getIcons().add(new Image("/logoo.png"));
        // scene1();
        stage.setResizable(true);
        stage.setTitle("BCC");
        stage.show();
    }




   private void scene3() {

        Label heightLabel = new Label("Height (m)");
        heightField = new TextField();
        heightLabel.setTextFill(Color.WHITE);
        heightField.setPromptText("Enter");

        Label weightLabel = new Label("Weight (kg)");
        weightField = new TextField();
        weightLabel.setTextFill(Color.WHITE);
        weightField.setPromptText("Enter");
        
        Label bmiLabel = new Label("BMI");
        bmiField = new TextField();
        bmiLabel.setTextFill(Color.WHITE);
        bmiField.setEditable(false);

        GridPane inputGrid = new GridPane();
        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.setPadding(new Insets(25, 25, 25, 25));

        inputGrid.add(heightLabel, 0, 0);
        inputGrid.add(heightField, 1, 0);
        inputGrid.add(weightLabel, 0, 1);
        inputGrid.add(weightField, 1, 1);
        inputGrid.add(bmiLabel, 0, 2);
        inputGrid.add(bmiField, 1, 2);

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> calculateBMI());

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> clearFields());

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> stage.close());

        HBox buttonBox = new HBox(10, calculateButton, clearButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(10, inputGrid, buttonBox);

        Image image = new Image("/bmi.jpeg");
        ImageView imageView = new ImageView(image);

        VBox root = new VBox(2, vbox, imageView);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

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

        root.setBackground(new Background( new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene3 = new Scene(root, 620, 400);
        stage.setScene(scene3);
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double bmi = weight / (height * height);
            bmiField.setText(String.format("%.2f", bmi));
        } catch (NumberFormatException e) {
            bmiField.setText("Invalid input");
        }
    }

    private void clearFields() {
        heightField.clear();
        weightField.clear();
        bmiField.clear();
    }






}