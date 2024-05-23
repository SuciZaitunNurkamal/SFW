package id.project.sfw;
import javafx.stage.Stage;
import id.project.sfw.confiq.DbConnect;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.layout.CornerRadii;



// import denn.bismillahproject.confiq.DbConnect;

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




  private void sceneLogin() {
       

        Label label = new Label("Login Page");
        label.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 30px; -fx-font-weight: bold;");
        label.setTextFill(Color.WHITE);
        HBox hBox1 = new HBox(label);
        hBox1.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Username");
        usernameLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 16px; -fx-font-weight: bold;");
        usernameLabel.setTextFill(Color.WHITE);
        TextField usernameInput = new TextField();
        usernameInput.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 14px; -fx-border-color: #000000;");
        usernameInput.setAlignment(Pos.CENTER);
        usernameInput.setMaxWidth(200);

        Label passwordLabel = new Label("Password");
        passwordLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 16px; -fx-font-weight: bold;");
        passwordLabel.setTextFill(Color.WHITE);
        PasswordField passwordInput = new PasswordField();
        passwordInput.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 14px; -fx-border-color: #000000;");
        passwordInput.setAlignment(Pos.CENTER);
        passwordInput.setMaxWidth(200);

        VBox vBox1 = new VBox(usernameLabel, usernameInput, passwordLabel, passwordInput);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(10);

        Button loginButton = new Button("LOGIN");

        Color newColor = Color.web("F4EEE0");
        loginButton.setBackground(new Background(new BackgroundFill(newColor, new CornerRadii(100), Insets.EMPTY)));
        loginButton.setPadding(new Insets(5, 10, 10, 10));
        loginButton.setMaxWidth(125);
        loginButton.setMinHeight(0);





        Button backButton = new Button("BACK");
        backButton.setTextFill(Color.WHITE);
        backButton.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(100), Insets.EMPTY)));
        backButton.setPadding(new Insets(5, 10, 10, 10));
        backButton.setMaxWidth(125);
        backButton.setMinHeight(0);
        // backButton.setOnAction(v -> scene2());

        VBox vBox2 = new VBox(loginButton, backButton);
        vBox2.setAlignment(Pos.CENTER);
    
        vBox2.setMinHeight(50);
        // vBox2.setId("button");
        vBox2.setSpacing(10);

        VBox vBox = new VBox(20, hBox1, vBox1, vBox2);
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
    
      
        vBox.setBackground(new Background( new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
       
        Scene sceneLogin = new Scene(vBox, 620, 400);
        stage.setScene(sceneLogin);

        loginButton.setOnAction(event -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();

            if (DbConnect.ValidasiLogin(username, password)) {
                // scene3(); 
            } else {
                System.out.println("Login Failed");
            }
        });
    }










}