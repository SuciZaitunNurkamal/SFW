package id.project.sfw.Scene;

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

public class Scene1 {

    private Stage stage;

    public Scene1(Stage stage) {
        this.stage = stage;
    }

    public void display() {
        Image logoImage = new Image("/images/bama.png");
        ImageView imageView = new ImageView(logoImage);
        imageView.setFitWidth(260);
        imageView.setPreserveRatio(true);
        imageView.setOnMouseClicked(e -> display());
        HBox hBox2 = new HBox(imageView);
        hBox2.setAlignment(Pos.CENTER);

        Label label = new Label("WELCOME TO BCC");
        label.setId("label-scene");
        label.setTextFill(Color.WHITE);
        HBox hBox1 = new HBox(label);
        hBox1.setAlignment(Pos.CENTER);

        
        Button button = new Button("GET STARTED");
        button.setId("button-scene1");
        button.setTextFill(Color.WHITE);
        button.setOnAction(v -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.display();
        });
        HBox hBox3 = new HBox(button);
        hBox3.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, hBox1, hBox2, hBox3);
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
    
        Scene scene1 = new Scene(vBox, 620, 400);
        
        String css = this.getClass().getResource("/styles/style.css").toExternalForm();
        scene1.getStylesheets().add(css);
        
        stage.setScene(scene1);
    }
}






