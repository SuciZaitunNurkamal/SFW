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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Scene5 {
    private final Stage stage;
    private final double bmi;
    
    public Scene5(Stage stage, double bmi) {
        this.stage = stage;
        this.bmi = bmi;
    }
    
    public void display() {
        VBox layoutUtama = new VBox(10);
        layoutUtama.setPadding(new Insets(10));
        layoutUtama.setAlignment(Pos.TOP_CENTER);
        layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
        
        Button backButton = new Button();
        ImageView backIcon = new ImageView(new Image("back.png"));
        backIcon.setFitHeight(20);
        backIcon.setFitWidth(20);
        backButton.setGraphic(backIcon);
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setOnAction(event -> {
            Scene4 scene4 = new Scene4(stage, bmi, null); 
            scene4.display();
        });
        
        HBox navigationBox = new HBox(5);
        navigationBox.setAlignment(Pos.TOP_LEFT);
        navigationBox.getChildren().add(backButton);
        
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
                                new Hari1(stage, bmi, teksTombol).display();;
                                break;
                                case "Hari 2":
                                new Hari2(stage, bmi, teksTombol).display();
                                break;
                                case "Hari 3":
                                new Hari3(stage, bmi, teksTombol).display();;
                                break;
                                case "Hari 5":
                                new Hari5(stage, bmi, teksTombol).display();
                                break;
                                case "Hari 6":
                                new Hari6(stage, bmi, teksTombol).display();
                                break;
                                case "Hari 7":
                                new Hari7(stage, bmi, teksTombol).display();;
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
            }
            
            
            