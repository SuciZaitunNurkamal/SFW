package id.project.sfw;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
        






            return hariBox;


        }


}