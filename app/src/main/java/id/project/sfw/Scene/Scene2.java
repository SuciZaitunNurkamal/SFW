package id.project.sfw.Scene;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class Scene2 {

    private Stage stage;

    public Scene2(Stage stage) {
        this.stage = stage;
    }

    public void display() {
        Label labelMenu = new Label("PILIH MENU");
        labelMenu.setTextFill(Color.WHITE);
        labelMenu.setId("label-menu");
        HBox hBox1 = new HBox(labelMenu);
        hBox1.setAlignment(Pos.CENTER);

        Button btnLogin = new Button("LOGIN");
        Color newColor4 = Color.web("F4EEE0");
        btnLogin.setTextFill(Color.BLACK);
        btnLogin.setBackground(new Background(new BackgroundFill(newColor4, new CornerRadii(100), Insets.EMPTY)));
        btnLogin.setPadding(new Insets(10, 15, 10, 10));
        btnLogin.setMaxWidth(125);
        btnLogin.setMinHeight(0);
        btnLogin.setOnAction(v -> {
            Login sceneLogin = new Login(stage);
            sceneLogin.display();
        });

        Button btnSignUp = new Button("SIGN UP");
        Color newColor5= Color.web("F4EEE0");
        btnSignUp.setTextFill(Color.BLACK);
        btnSignUp.setBackground(new Background(new BackgroundFill(newColor5, new CornerRadii(100), Insets.EMPTY)));
        btnSignUp.setPadding(new Insets(10, 15, 10, 10));
        btnSignUp.setMaxWidth(125);
        btnSignUp.setMinHeight(0);
        btnSignUp.setOnAction(v -> {
            SceneSignUp sceneSignUp = new SceneSignUp(stage);
            sceneSignUp.display();
        });

        VBox vBox1 = new VBox(btnLogin, btnSignUp);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(10);
        vBox1.setMaxWidth(125);

        VBox vBox = new VBox(10, hBox1, vBox1);
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

        Scene scene2 = new Scene(vBox, 620, 400);


        String css = this.getClass().getResource("/styles/style.css").toExternalForm();
        scene2.getStylesheets().add(css);

        stage.setScene(scene2);
    }
}
