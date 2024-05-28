package id.project.sfw;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox; 
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.HBox;






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


    public void sceneHari5(Stage stage) {
        VBox layoutUtama = new VBox(10);
        layoutUtama.setPadding(new Insets(10));
        layoutUtama.setAlignment(Pos.TOP_CENTER);
        layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
    
        Label latihanLabel = new Label("Latihan Hari 5 (5)");
        latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    
        Button backButton = createBackButton(stage);

        HBox headerBox = new HBox(10);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.getChildren().addAll(latihanLabel, backButton);

        VBox latihanBox = new VBox(10);
        latihanBox.setAlignment(Pos.CENTER_LEFT);
        latihanBox.setPadding(new Insets(20));
        latihanBox.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px;");
    
        latihanBox.getChildren().addAll(
                buatLatihanBox("Knee Push Ups", "00:30", "kneepush.png"),
                buatLatihanBox("Plank", "x16", "plank.png"),
                buatLatihanBox("Pull-Up", "00:30", "pullUp.png"),
                buatLatihanBox("Lompat Tali", "x3", "LompatTali.png"),
                buatLatihanBox("Triceps dips", "x16", "Tricip.png")
        );
        latihanBox.setPadding(new Insets(20, 20, 20, 50));
    
        layoutUtama.getChildren().addAll(headerBox, latihanBox);
    
        Scene scene = new Scene(layoutUtama, 620, 400);
        stage.setScene(scene);
        stage.show();
    }

}