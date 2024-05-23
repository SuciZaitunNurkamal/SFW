package id.project.sfw;
import javafx.stage.Stage;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.util.Duration;
import javafx.scene.layout.CornerRadii;



// import denn.bismillahproject.confiq.DbConnect;

public class App extends Application {

    private Stage stage;
    private TextField heightField;
    private TextField weightField;
    private TextField bmiField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.getIcons().add(new Image("/logoo.png"));
        scene1();
        stage.setResizable(true);
        stage.setTitle("BCC");
        stage.show();
    }

    private void scene1() {

        Image logoImage = new Image("/logoo.png");
        ImageView imageView = new ImageView(logoImage);
        imageView.setFitWidth(260);
        imageView.setPreserveRatio(true);
        HBox hBox2 = new HBox(imageView);
        hBox2.setAlignment(Pos.CENTER);

        Label label = new Label("WELCOME TO BCC");
        label.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 30px; -fx-font-weight: bold;");
        label.setTextFill(Color.WHITE);
        HBox hBox1 = new HBox(label);
        hBox1.setAlignment(Pos.CENTER);

        Button button = new Button("GET STARTED");
        button.setStyle("-fx-background-color: #008000;-fx-font-family: 'Sans-Serif'; -fx-font-weight: bold; -fx-padding: 10px 70px;-fx-font-size: 16px; -fx-border-color: BLACK; -fx-border-width: 1px; -fx-border-radius: 3;");
        button.setTextFill(Color.WHITE);
        button.setOnAction(v -> {
            // scene2();
        });
        HBox hBox3 = new HBox(button);
        hBox3.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, hBox1, hBox2, hBox3);
        vBox.setAlignment(Pos.CENTER);

        LinearGradient gradient = new LinearGradient(
            0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.web("#00B2FF")),    
            new Stop(0.3, Color.web("#87CEFA")),  
            new Stop(0.6, Color.web("#E0FFFF")),   
            new Stop(1, Color.web("#FFFFFF"))      
        );

        vBox.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene1 = new Scene(vBox, 620, 400);
        stage.setScene(scene1);
    }

}