package id.project.sfw.Scene;


import id.project.sfw.Models.Female;
import id.project.sfw.Models.Human;
import id.project.sfw.Models.Male;
import id.project.sfw.confiq.DbConnect;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class Scene4 {
    
    private Stage stage;
    private double bmi;
    private String username;
    private Human human;

    public Scene4(Stage stage, double bmi, String username) {
        this.stage = stage;
        this.bmi = bmi;
        this.username = username;
        if (DbConnect.getUserGender(username).toLowerCase().equals("laki-laki")) {
            this.human = new Male(username, bmi);
        } else {
            this.human = new Female(username, bmi);
        }
    }
    
    public void display() {
        String category;

        Label resultLabel = new Label("RESULT ANDA: " + String.format("%.2f", this.bmi));
        resultLabel.setId("label-result");    

        ImageView imageView = new ImageView(new Image("/images/bmi.jpeg"));
        imageView.setFitWidth(400);
        imageView.setFitHeight(200);

        if (human.isMale()) {
            if (bmi < 18.5) {
                category = "UNDERWEIGHT";
            } else if (bmi < 25) {
                category =  "NORMAL WEIGHT";
            } else if (bmi < 30) {
                category = "OVERWEIGHT";
            } else {
                category = "OBESITAS";
            }
        } else {
            if (bmi < 18.5) {
                category = "UNDERWEIGHT";
            } else if (bmi < 24) {
                category = "NORMAL WEIGHT";
            } else if (bmi < 29) {
                category = "OVERWEIGHT";
            } else {
                category = "OBESITAS";
            }
        }

        Button backButton = new Button();
        ImageView backIcon = new ImageView(new Image("/images/arrowput.png"));
        backIcon.setFitHeight(30);
        backIcon.setFitWidth(30);
        backButton.setGraphic(backIcon);
        backButton.setId("back-button");
        backButton.setOnAction(event -> {
            SceneBMIInput scene3 = new SceneBMIInput(stage,username);
            scene3.display();
        });

        Label categoryLabel = new Label(" ANDA TERMASUK GOLONGAN " + category);
        categoryLabel.setId("category-label");
    
        Button rekomendasiButton = new Button("REKOMENDASI");
        Color newColorRekomendasi = Color.web("F4EEE0");
        rekomendasiButton.setTextFill(Color.BLACK);
        rekomendasiButton.setBackground(new Background(new BackgroundFill(newColorRekomendasi, new CornerRadii(300), Insets.EMPTY)));
        rekomendasiButton.setPadding(new Insets(5, 15, 5, 10)); 
        rekomendasiButton.setMaxWidth(125);
        rekomendasiButton.setMinHeight(0);

        Button btnExit = new Button("EXIT");
        Color newColor3 = Color.web("F4EEE0");
        btnExit.setTextFill(Color.BLACK);
        btnExit.setBackground(new Background(new BackgroundFill(newColor3, new CornerRadii(100), Insets.EMPTY)));
        btnExit.setPadding(new Insets(5, 15, 5, 10));
        btnExit.setMaxWidth(125);
        btnExit.setMinHeight(0);
        btnExit.setOnAction(event -> stage.close());

        Label rekomendasiLabel = new Label("Berikut Rekomendasi Latihan menuju Golongan Normal ");
        rekomendasiLabel.setId("rekomendasi-label");
        HBox backButtonBox = new HBox(backButton);
        backButtonBox.setAlignment(Pos.TOP_LEFT);
        backButtonBox.setPadding(new Insets(0, 100, 10, 0));

        VBox vBox = new VBox(5, backButtonBox,resultLabel, imageView, categoryLabel);
        vBox.setPadding(new Insets(0, 0, 95, 0));

        if (bmi < 18.5) {
            vBox.getChildren().addAll(rekomendasiLabel, rekomendasiButton);
            vBox.setPadding(new Insets(5, 15, 5, 10));
            rekomendasiButton.setOnAction(event -> {
                SceneUnderweight sceneUnderweight = new SceneUnderweight(stage, bmi, username);
                sceneUnderweight.display();
            });
        } else if (bmi >= 25) {
            vBox.getChildren().addAll(rekomendasiLabel, rekomendasiButton);
            vBox.setPadding(new Insets(5, 15, 5, 10));
            rekomendasiButton.setOnAction(event -> {
                SceneObe sceneObe = new SceneObe(stage, bmi, username);
                sceneObe.display();
            });
        } else {
            Label normalLabel = new Label("Selamat Anda tergolong normal");
            normalLabel.setTextFill(Color.WHITE);
            vBox.getChildren().addAll(normalLabel, btnExit);
        }

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

        Scene scene4 = new Scene(vBox, 620, 400);

        String css = this.getClass().getResource("/styles/style.css").toExternalForm();
        scene4.getStylesheets().add(css);
        stage.setScene(scene4);
    }
}
