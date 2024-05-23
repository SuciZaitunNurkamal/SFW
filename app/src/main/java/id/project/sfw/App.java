package id.project.sfw;
import javafx.stage.Stage;
import javafx.util.Duration;
import id.project.sfw.confiq.DbConnect;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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




  private void sceneSignUp() {

        Label titleLabel = new Label("Daftar Akun");
        titleLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 24px; -fx-font-weight: bold;");
        titleLabel.setTextFill(Color.WHITE);
        HBox titleBox = new HBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Username");
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Masukkan Username");
        VBox usernameBox = new VBox(usernameLabel, usernameInput);
        usernameBox.setSpacing(5);

        Label passwordLabel = new Label("Password");
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Masukkan Password");
        VBox passwordBox = new VBox(passwordLabel, passwordInput);
        passwordBox.setSpacing(5);

        Label labelError = new Label();
        labelError.setStyle("-fx-font-size: 10px; -fx-text-fill: RED; -fx-font-family: 'Sans-Serif';");
        labelError.setAlignment(Pos.CENTER);

        Button daftarButton = new Button("Daftar");
        daftarButton.setTextFill(Color.WHITE);
        daftarButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(300), Insets.EMPTY)));
        daftarButton.setPadding(new Insets(10, 20, 20, 20));
        daftarButton.setMaxWidth(125);
        daftarButton.setMinHeight(50);

        daftarButton.setOnAction(event -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
        
            if (username.isEmpty() || password.isEmpty()) {
                labelError.setText("tolong masukkan username dan password");
                labelError.setTextFill(Color.WHITE);
            } else if (DbConnect.checkUsername(username)) {
                labelError.setText("Username Is Taken");
            } else if (!DbConnect.validatePassword(password)) {
                labelError.setText("Paswword salah. Password harus berisi  minimal 3 characters, maksimal 10 characters, setidaknya 1 angka dan  1 Huruf besar");
            } else {
                DbConnect.insertData(username, password);
                labelError.setText("Registration Successful!");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> scene2());
                pause.play();
            }
        });

        Label sudahPunyaAkunLabel = new Label("Sudah punya akun?");
        sudahPunyaAkunLabel.setTextFill(Color.WHITE);
        Hyperlink masukLink = new Hyperlink("Masuk");
        HBox masukBox = new HBox(5, sudahPunyaAkunLabel, masukLink);
        masukBox.setAlignment(Pos.CENTER);
        masukLink.setOnAction(e -> sceneLogin());

        VBox vBox = new VBox(10, titleBox, usernameBox, passwordBox, labelError, daftarButton, masukBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.setMaxWidth(400);

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
        Scene signUpScene = new Scene(vBox, 620, 400);
        stage.setScene(signUpScene);
    }









}