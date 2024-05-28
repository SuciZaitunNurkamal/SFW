package id.project.sfw;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.layout.CornerRadii;






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





      public void scene4(double bmi) {
            String category;
            Label resultLabel = new Label("RESULT ANDA: " + String.format("%.2f", bmi));
            resultLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 18px; -fx-font-weight: bold;");
            resultLabel.setTextFill(Color.WHITE);
            Image image = new Image("bmi.jpeg");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(400);
            imageView.setFitHeight(200);

            if (bmi < 18.5) {
                category = "UNDERWEIGHT";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                category = "NORMAL";
            } else {
                category = "OVERWEIGHT";
            }

            Label categoryLabel = new Label(" ANDA TERMASUK GOLONGAN " + category);
            categoryLabel.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 16px; -fx-font-weight: bold;");
            categoryLabel.setTextFill(Color.WHITE);

            Button rekomendasiButton = new Button("REKOMENDASI");
            Color newColorRekomendasi = Color.web("F4EEE0");
            rekomendasiButton.setTextFill(Color.BLACK);
            rekomendasiButton.setBackground(new Background(new BackgroundFill(newColorRekomendasi, new CornerRadii(300), Insets.EMPTY)));
            rekomendasiButton.setPadding(new Insets(5, 15, 5, 10));
            rekomendasiButton.setMaxWidth(125);
            rekomendasiButton.setMinHeight(0);
            // rekomendasiButton.setOnAction(event -> scene5());

            Button btnExit = new Button("EXIT");
            Color newColor3 = Color.web("F4EEE0");
            btnExit.setTextFill(Color.BLACK);
            btnExit.setBackground(new Background(new BackgroundFill(newColor3, new CornerRadii(100), Insets.EMPTY)));
            btnExit.setPadding(new Insets(5, 15, 5, 10));
            btnExit.setMaxWidth(125);
            btnExit.setMinHeight(0);
            btnExit.setOnAction(event -> stage.close());

            Label rekomendasiLabel = new Label("Berikut Rekomendasi Latihan menuju Golongan Normal ");
            rekomendasiLabel.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 16px; -fx-font-weight: bold;");
            rekomendasiLabel.setTextFill(Color.WHITE);

            VBox vBox = new VBox(20, resultLabel, imageView, categoryLabel);
            if (bmi < 18.5 || bmi >= 25) {
                vBox.getChildren().addAll(rekomendasiLabel, rekomendasiButton);
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
            stage.setScene(scene4);
        }





}