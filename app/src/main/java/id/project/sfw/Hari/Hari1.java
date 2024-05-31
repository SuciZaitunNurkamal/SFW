package id.project.sfw.Hari;

import id.project.sfw.Scene.SceneObe;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;




public class Hari1 {
    private final Stage stage;
    private String username;
    private double bmi;

    public Hari1(Stage stage,double bmi,String username) {
        this.stage = stage;
        this.bmi = bmi;
        this.username = username;
    }

    public void display() {
        VBox layoutUtama = new VBox(10);
        layoutUtama.setPadding(new Insets(10));
        layoutUtama.setAlignment(Pos.TOP_CENTER);
        layoutUtama.setStyle("-fx-background-color: #f5f5f5;");

        Label latihanLabel = new Label("Latihan Hari 1 (5)");
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
                buatLatihanBox("Jumping jack", "00:30", "/images/jumpingjack.png"),
                buatLatihanBox("Sit-Up", "x16", "/images/situp.png"),
                buatLatihanBox("Angkat Lutut/Berlari", "00:30", "/images/muscle.png"),
                buatLatihanBox("Push-up", "x3", "/images/pushup.png"),
                buatLatihanBox("Crunch sepeda", "x16", "/images/bicycle.png")
                );
                latihanBox.setPadding(new Insets(20, 20, 20, 50));
                
        layoutUtama.getChildren().addAll(headerBox, latihanBox);
        
        Scene scene = new Scene(layoutUtama, 620, 400);
        stage.setScene(scene);
      
        
    }
    

   

    private Button createBackButton(Stage stage) {
        Button backButton = new Button();
        ImageView backIcon = new ImageView(new Image("/images/panah.png"));
        backIcon.setFitWidth(20);
        backIcon.setFitHeight(20);
        backButton.setGraphic(backIcon);
        backButton.setOnAction(e -> new SceneObe(stage, bmi,username).display());
        return backButton;
    }

    private HBox buatLatihanBox(String latihan, String repetisi, String iconPath) {
        HBox latihanBox = new HBox(10);
        latihanBox.setAlignment(Pos.CENTER_LEFT);

        ImageView iconView = new ImageView(new Image(iconPath));
        iconView.setFitWidth(30);
        iconView.setFitHeight(50);
        latihanBox.getChildren().add(iconView);

        Label latihanLabel = new Label(latihan);
        latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label repetisiLabel = new Label(repetisi);
        repetisiLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        latihanBox.getChildren().addAll(latihanLabel, repetisiLabel);
        
        return latihanBox;
    }
}
