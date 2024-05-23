package id.project.sfw;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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




    private void scene2() {
        Label labelMenu = new Label("PILIH MENU");

       labelMenu.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 25px; -fx-font-weight: bold;");
       labelMenu.setTextFill(Color.WHITE);
       HBox hBox1 = new HBox(labelMenu);
       hBox1.setAlignment(Pos.CENTER);

       Button btnLogin = new Button("LOGIN");
       btnLogin.setTextFill(Color.WHITE);
       btnLogin.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(100), Insets.EMPTY)));
       btnLogin.setPadding(new Insets(10, 20, 20, 20));
       btnLogin.setMaxWidth(150);
       btnLogin.setMinHeight(50);
       btnLogin.setOnAction(v -> {
        //    sceneLogin();
       });

       Button btnSignUp = new Button("SIGN UP");
       btnSignUp.setTextFill(Color.WHITE);
       btnSignUp.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(100), Insets.EMPTY)));
       btnSignUp.setPadding(new Insets(10, 20, 20, 20));
       btnSignUp.setMaxWidth(150);
       btnSignUp.setMinHeight(50);
       btnSignUp.setOnAction(v -> {
        //    sceneSignUp();
       });

       VBox vBox1 = new VBox(btnLogin, btnSignUp);
       vBox1.setAlignment(Pos.CENTER);
       vBox1.setSpacing(10);
       vBox1.setMaxWidth(250);

       VBox vBox = new VBox(10, hBox1, vBox1);
       vBox.setAlignment(Pos.CENTER);

       LinearGradient gradient = new LinearGradient(
           0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
           new Stop(0, Color.web("#00B2FF")),     
           new Stop(0.3, Color.web("#87CEFA")),   
           new Stop(0.6, Color.web("#E0FFFF")),   
           new Stop(1, Color.web("#FFFFFF"))      
       );

       vBox.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

       Scene scene2 = new Scene(vBox, 620, 400);
       stage.setTitle("BCC");
       stage.setScene(scene2);
   }












}