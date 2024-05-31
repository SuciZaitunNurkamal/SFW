package id.project.sfw.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
import id.project.sfw.confiq.DbConnect;

public class SceneSignUp {
    private Stage stage;

    public SceneSignUp(Stage stage) {
        this.stage = stage;
    }

    public void display() {
        Label titleLabel = new Label("Daftar Akun");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setId("label-Sign");
        HBox titleBox = new HBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Username");
        usernameLabel.setTextFill(Color.WHITE);
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Masukkan Username");
        VBox usernameBox = new VBox(usernameLabel, usernameInput);
        usernameBox.setSpacing(5);

        Label passwordLabel = new Label("Password");
        passwordLabel.setTextFill(Color.WHITE);
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Masukkan Password");
        VBox passwordBox = new VBox(passwordLabel, passwordInput);
        passwordBox.setSpacing(5);

        Label genderLabel = new Label("Jenis Kelamin");
        genderLabel.setTextFill(Color.WHITE);
        ComboBox<String> genderInput = new ComboBox<>();
        genderInput.getItems().addAll("Laki-laki", "Perempuan");
        genderInput.setPromptText("Pilih Jenis Kelamin");
        VBox genderBox = new VBox(genderLabel, genderInput);
        genderBox.setSpacing(5);

        Label labelError = new Label();
        labelError.setId("label-errorSign");
        labelError.setAlignment(Pos.CENTER);

        Button daftarButton = new Button("Daftar");
        Color newColorDaftar = Color.web("F4EEE0");
        daftarButton.setTextFill(Color.BLACK);
        daftarButton.setBackground(new Background(new BackgroundFill(newColorDaftar, new CornerRadii(300), Insets.EMPTY)));
        daftarButton.setPadding(new Insets(5, 15, 5, 10));
        daftarButton.setMaxWidth(125);
        daftarButton.setMinHeight(0);

        daftarButton.setOnAction(event -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            String gender = genderInput.getValue();

            if (username.isEmpty() || password.isEmpty() || gender == null) {
                labelError.setText("Tolong masukkan semua data");
                labelError.setTextFill(Color.WHITE);
            } else if (DbConnect.checkUsername(username)) {
                labelError.setText("Username Is Taken");
            } else if (!DbConnect.validatePassword(password)) {
                labelError.setText("Password harus berisi minimal 3 characters, maksimal 15 characters, setidaknya 1 angka dan 1 Huruf besar");
            } else {

                DbConnect.insertUser(username, password, gender);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }    
                Scene2 sceneBMIInput = new Scene2(stage);
                sceneBMIInput.display();
            }
        });

        Label sudahPunyaAkunLabel = new Label("Sudah punya akun?");
        sudahPunyaAkunLabel.setTextFill(Color.WHITE);
        Hyperlink masukLink = new Hyperlink("Masuk");
        HBox masukBox = new HBox(5, sudahPunyaAkunLabel, masukLink);
        masukBox.setAlignment(Pos.CENTER);
        masukLink.setOnAction(e -> {
            Login sceneLogin = new Login(stage);
            sceneLogin.display();
        });

        VBox vBox = new VBox(10, titleBox, usernameBox, passwordBox, genderBox, labelError, daftarButton, masukBox);
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

        vBox.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene signUpScene = new Scene(vBox, 620, 400);

        String css = this.getClass().getResource("/styles/style.css").toExternalForm();
        signUpScene.getStylesheets().add(css);

        stage.setScene(signUpScene);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }






    






}
