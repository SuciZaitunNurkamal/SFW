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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.CornerRadii;
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



    public void scene5() {
            VBox layoutUtama = new VBox(10);
            layoutUtama.setPadding(new Insets(10));
            layoutUtama.setAlignment(Pos.TOP_CENTER);
            layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
        
            HBox row1 = new HBox(50);
            row1.setAlignment(Pos.CENTER);
            row1.getChildren().add(buatHariBox("Hari 1", "6 menit", "Mulai", true));
        
            HBox row2 = new HBox(50);
            row2.setAlignment(Pos.CENTER);
            row2.getChildren().addAll(
                    buatHariBox("Hari 2", "7 menit", "Mulai", false),
                    buatHariBox("Hari 3", "6 menit", "Mulai", false)
            );
        
            HBox row3 = new HBox(50);
            row3.setAlignment(Pos.CENTER);
            row3.getChildren().addAll(
                    buatHariBox("Hari 4", "Hari Istirahat!", null, false),
                    buatHariBox("Hari 5", "6 menit", "Mulai", false)
            );
        
            HBox row4 = new HBox(50);
            row4.setAlignment(Pos.CENTER);
            row4.getChildren().addAll(
                    buatHariBox("Hari 6", "6 menit", "Mulai", false),
                    buatHariBox("Hari 7", "6 menit", "Mulai", false)
            );
        
            layoutUtama.getChildren().addAll(row1, row2, row3, row4);
        
            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }


        private HBox buatHariBox(String hari, String menit, String teksTombol, boolean hariPertama) {
            HBox hariBox = new HBox(10);
            hariBox.setAlignment(Pos.CENTER_LEFT);
            hariBox.setPadding(new Insets(20, 20, 20, 50));
            hariBox.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px;");
            hariBox.setPrefWidth(290);
        
            VBox infoHariBox = new VBox(5);
            infoHariBox.setAlignment(Pos.CENTER_LEFT);
        
            Label labelHari = new Label(hari);
            labelHari.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
            Label labelMenit = new Label(menit);
            labelMenit.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        
            infoHariBox.getChildren().addAll(labelHari, labelMenit);
            hariBox.getChildren().add(infoHariBox);
        

            Label Keterangan = new Label("NOTE: Lakukan latihan ini sebanyak 7x4 hari !!!");
            Keterangan.setTextFill(Color.RED);
            HBox masukBox = new HBox(5, Keterangan);
            masukBox.setAlignment(Pos.CENTER);
            



            if (teksTombol != null) {
                Button tombolAksi = new Button(teksTombol);
                tombolAksi.setStyle("-fx-background-color: #00C853; -fx-text-fill: white; -fx-background-radius: 15px; -fx-padding: 5 20 5 20;");
                hariBox.getChildren().add(tombolAksi);
                tombolAksi.setOnAction(event -> {
                    switch (hari) {
                        case "Hari 1":
                            sceneHari1(stage);
                            break;
                        case "Hari 2":
                            sceneHari2(stage);
                            break;
                        case "Hari 3":
                            sceneHari3(stage);
                            break;
                        case "Hari 5":
                            sceneHari5(stage);
                            break;
                        case "Hari 6":
                            sceneHari6(stage);
                            break;
                        case "Hari 7":
                            sceneHari7(stage);
                            break;
                    }
                });
            } else {
                ImageView ikonIstirahat = new ImageView(new Image("sleep.png"));
                ikonIstirahat.setFitWidth(20);
                ikonIstirahat.setFitHeight(20);
                hariBox.getChildren().add(ikonIstirahat);
            }
        
            return hariBox;


        
        }

        private Button createBackButton(Stage stage) {
            Button backButton = new Button();
            ImageView backIcon = new ImageView(new Image("panah.png"));
            backIcon.setFitWidth(20);
            backIcon.setFitHeight(20);
            backButton.setGraphic(backIcon);
            backButton.setOnAction(e -> scene5());
            return backButton;
        }

        public void sceneHari1(Stage stage) {
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
                    buatLatihanBox("Jumping jack", "00:30", "jumpingjack.png"),
                    buatLatihanBox("Sit-Up", "x16", "situp.png"),
                    buatLatihanBox("Angkat Lutut/Berlari", "00:30", "muscle.png"),
                    buatLatihanBox("Push-up", "x3", "pushup.png"),
                    buatLatihanBox("Crunch sepeda", "x16", "bicycle.png"));
            latihanBox.setPadding(new Insets(20, 20, 20, 50));

            layoutUtama.getChildren().addAll(headerBox, latihanBox);

            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }

        public void sceneHari2(Stage stage) {
            VBox layoutUtama = new VBox(10);
            layoutUtama.setPadding(new Insets(10));
            layoutUtama.setAlignment(Pos.TOP_CENTER);
            layoutUtama.setStyle("-fx-background-color: #f5f5f5;");

            Label latihanLabel = new Label("Latihan Hari 2 (5)");
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
                    buatLatihanBox("Jumping Jacks", "00:30", "jumpingjack.png"),
                    buatLatihanBox("Push-Up", "x16", "pushup.png"),
                    buatLatihanBox("Plank", "00:30", "plank.png"),
                    buatLatihanBox("Sit-up", "x3", "situp.png"),
                    buatLatihanBox("Tricip Dip", "x16", "Tricip.png"));
            latihanBox.setPadding(new Insets(20, 20, 20, 50));

            layoutUtama.getChildren().addAll(headerBox, latihanBox);

            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }






      


}