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



      
    
            if (teksTombol != null) {
                Button tombolAksi = new Button(teksTombol);
                tombolAksi.setStyle("-fx-background-color: #00C853; -fx-text-fill: white; -fx-background-radius: 15px; -fx-padding: 5 20 5 20;");
                hariBox.getChildren().add(tombolAksi);
                tombolAksi.setOnAction(event -> {
                    switch (hari) {
                        case "Hari 1":
                            scene6(stage);
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
    

        
        public void scene6(Stage stage) {
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
                    buatLatihanBox("Crunch sepeda", "x16", "bicycle.png")
            );
            latihanBox.setPadding(new Insets(20, 20, 20, 50));
        
            layoutUtama.getChildren().addAll(headerBox, latihanBox);
        
            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }




        }


}