package id.project.sfw.Scene;

import id.project.sfw.Hari.Hari1;
import id.project.sfw.Hari.Hari2;
import id.project.sfw.Hari.Hari3;
import id.project.sfw.Hari.Hari5;
import id.project.sfw.Hari.Hari6;
import id.project.sfw.Hari.Hari7;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SceneObe {
    private final Stage stage;
    private final double bmi;
    private String username;
    
    public SceneObe(Stage stage, double bmi, String username) {
        this.stage = stage;
        this.bmi = bmi;
        this.username = username;
    }
    
    public void display() {
        VBox layoutUtama = new VBox(10);
        layoutUtama.setPadding(new Insets(5));
        layoutUtama.setAlignment(Pos.TOP_CENTER);
        layoutUtama.setId("layout-scene");
    
        // Back button
        Button backButton = new Button();
        ImageView backIcon = new ImageView(new Image("/images/kmb.png"));
        backIcon.setFitHeight(20);
        backIcon.setFitWidth(20);
        backButton.setGraphic(backIcon);
        backButton.setId("back-btn");
        backButton.setOnAction(event -> {
            Scene4 scene4 = new Scene4(stage, bmi, username); 
            scene4.display();
        });
        
        // Exit button
        Button btnExit = new Button();
        ImageView exitIcon = new ImageView(new Image("/images/logout.png"));
        exitIcon.setFitHeight(20);
        exitIcon.setFitWidth(20);
        btnExit.setGraphic(exitIcon);
        // btnExit.setId("exit-btn");
        btnExit.setOnAction(event -> stage.close());

        // Align back and exit buttons in the same row
        HBox navigationBox = new HBox();
        navigationBox.setPadding(new Insets(5));
        navigationBox.setSpacing(10);
        navigationBox.setAlignment(Pos.CENTER);
        
        HBox backButtonBox = new HBox();
        backButtonBox.setAlignment(Pos.TOP_LEFT);
        backButtonBox.getChildren().add(backButton);
        HBox exitButtonBox = new HBox();
        exitButtonBox.setAlignment(Pos.TOP_RIGHT);
        exitButtonBox.getChildren().add(btnExit);

        navigationBox.getChildren().addAll(backButtonBox, exitButtonBox);
        HBox.setHgrow(backButtonBox, Priority.ALWAYS);
        HBox.setHgrow(exitButtonBox, Priority.ALWAYS);

        HBox row1 = new HBox(50);
        row1.setAlignment(Pos.CENTER);
        row1.getChildren().add(buatHariBox("Hari 1", "6 menit", "Mulai", true, stage));
        
        HBox row2 = new HBox(50);
        row2.setAlignment(Pos.CENTER);
        row2.getChildren().addAll(
            buatHariBox("Hari 2", "7 menit", "Mulai", false, stage),
            buatHariBox("Hari 3", "6 menit", "Mulai", false, stage)
        );
            
        HBox row3 = new HBox(50);
        row3.setAlignment(Pos.CENTER);
        row3.getChildren().addAll(
            buatHariBox("Hari 4", "Hari Istirahat!", null, false, stage),
            buatHariBox("Hari 5", "6 menit", "Mulai", false, stage)
        );
                
        HBox row4 = new HBox(50);
        row4.setAlignment(Pos.CENTER);
        row4.getChildren().addAll(
            buatHariBox("Hari 6", "6 menit", "Mulai", false, stage),
            buatHariBox("Hari 7", "6 menit", "Mulai", false, stage)
        );
                    
        layoutUtama.getChildren().addAll(navigationBox, row1, row2, row3, row4);
        
        Scene scene = new Scene(layoutUtama, 620, 400);
        scene.getStylesheets().add("/styles/style.css");  
        stage.setScene(scene);
        stage.show();
    }
        
    private HBox buatHariBox(String hari, String menit, String teksTombol, boolean hariPertama, Stage stage2) {
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
        
        if (teksTombol != null) {
            Button tombolAksi = new Button(teksTombol);
            tombolAksi.setStyle("-fx-background-color: #00C853; -fx-text-fill: white; -fx-background-radius: 15px; -fx-padding: 5 20 5 20;");
            hariBox.getChildren().add(tombolAksi);
            tombolAksi.setOnAction(event -> {
                switch (hari) {
                    case "Hari 1":
                        new Hari1(stage, bmi, username).display();
                        break;
                    case "Hari 2":
                        new Hari2(stage, bmi, username).display();
                        break;
                    case "Hari 3":
                        new Hari3(stage, bmi, username).display();
                        break;
                    case "Hari 5":
                        new Hari5(stage, bmi, username).display();
                        break;
                    case "Hari 6":
                        new Hari6(stage, bmi, username).display();
                        break;
                    case "Hari 7":
                        new Hari7(stage, bmi, username).display();
                        break;
                }
            });
        } else {
            ImageView ikonIstirahat = new ImageView(new Image("/images/sleep.png"));
            ikonIstirahat.setFitWidth(20);
            ikonIstirahat.setFitHeight(20);
            hariBox.getChildren().add(ikonIstirahat);
        }

        return hariBox;
    }
}
