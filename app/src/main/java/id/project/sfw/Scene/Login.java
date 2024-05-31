package id.project.sfw.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import id.project.sfw.confiq.DbConnect;




public class Login {

    private Stage stage;

    public Login(Stage stage) {
        this.stage = stage;
    }

    public void display() {
        Label label = new Label("Login Page");
        Color newColor1 = Color.web("F4EEE0");
        label.setId("label-Login");
        label.setTextFill(newColor1);
        label.setPadding(new Insets(10, 15, 10, 30));
        HBox hBox1 = new HBox(label);
        hBox1.setAlignment(Pos.CENTER);

        ImageView usernameIcon = new ImageView(new Image("/images/user.png"));
        usernameIcon.setFitHeight(23);
        usernameIcon.setFitWidth(23);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");
        usernameInput.setId("text-field");
        usernameInput.setAlignment(Pos.CENTER_LEFT);
        usernameInput.setMaxWidth(200);

        HBox usernameBox = new HBox(usernameIcon, usernameInput);
        usernameBox.setSpacing(5);
        usernameBox.setAlignment(Pos.CENTER);

        ImageView passwordIcon = new ImageView(new Image("/images/key.png"));
        passwordIcon.setFitHeight(23);
        passwordIcon.setFitWidth(23);

        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("********");
        passwordInput.setId("field-pw");
        passwordInput.setAlignment(Pos.CENTER_LEFT);
        passwordInput.setMaxWidth(200);

        TextField passwordTextInput = new TextField();
        passwordTextInput.setManaged(false);
        passwordTextInput.setVisible(false);
        passwordTextInput.setStyle(passwordInput.getStyle());
        passwordTextInput.setAlignment(Pos.CENTER_LEFT);
        passwordTextInput.setMaxWidth(200);

        ImageView eyeIcon = new ImageView(new Image("/images/eye.png"));
        eyeIcon.setFitHeight(23);
        eyeIcon.setFitWidth(23);
        eyeIcon.setCursor(Cursor.HAND);

        StackPane passwordStack = new StackPane();
        passwordStack.getChildren().addAll(passwordInput, passwordTextInput);

        eyeIcon.setOnMouseClicked(event -> {
            if (passwordInput.isVisible()) {
                passwordTextInput.setText(passwordInput.getText());
                passwordInput.setVisible(false);
                passwordTextInput.setVisible(true);
                passwordTextInput.setManaged(true);
            } else {
                passwordInput.setText(passwordTextInput.getText());
                passwordTextInput.setVisible(false);
                passwordTextInput.setManaged(false);
                passwordInput.setVisible(true);
            }
        });

        HBox passwordBox = new HBox(passwordIcon, passwordStack, eyeIcon);
        passwordBox.setSpacing(5);
        passwordBox.setAlignment(Pos.CENTER);
        passwordBox.setPadding(new Insets(0,0,0,30));

        Label labelError = new Label();
        labelError.setId("label-eror");
        labelError.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox(usernameBox, passwordBox, labelError);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(10);

        Button loginButton = new Button("LOGIN");
        Color newColor = Color.web("F4EEE0");
        loginButton.setTextFill(Color.BLACK);
        loginButton.setBackground(new Background(new BackgroundFill(newColor, new CornerRadii(100), Insets.EMPTY)));
        loginButton.setPadding(new Insets(5, 15, 5, 10));
        loginButton.setMaxWidth(125);
        loginButton.setMinHeight(0);

        Button backButton = new Button("BACK");
        Color newColor3 = Color.web("F4EEE0");
        backButton.setTextFill(Color.BLACK);
        backButton.setBackground(new Background(new BackgroundFill(newColor3, new CornerRadii(100), Insets.EMPTY)));
        backButton.setPadding(new Insets(5, 15, 5, 10));
        backButton.setMaxWidth(125);
        backButton.setMinHeight(0);
        backButton.setOnAction(v -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.display();
        });

        VBox vBox2 = new VBox(loginButton, backButton);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setMinHeight(50);
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
        
        vBox.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Scene sceneLogin = new Scene(vBox, 620, 400);
        
        String css = this.getClass().getResource("/styles/style.css").toExternalForm();
        sceneLogin.getStylesheets().add(css);

       
        stage.setScene(sceneLogin);
        
        loginButton.setOnAction(event -> {
            String username = usernameInput.getText();
            String password = passwordInput.isVisible() ? passwordInput.getText() : passwordTextInput.getText();
            
            if (username.isEmpty() || password.isEmpty()) {
                labelError.setText("Tolong masukkan username dan password anda");
            } else if (DbConnect.validateLogin(username, password)) {
                SceneBMIInput scene3 = new SceneBMIInput(stage, username);
                scene3.display();
            } else {
                labelError.setText("Login gagal. tolong masukkan password dan username yang benar.");
            }
           
            
        });
        
        
    }
}
