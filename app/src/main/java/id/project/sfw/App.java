
package id.project.sfw;

import id.project.sfw.Scene.Scene1;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


//   KELOMPOK 14   SFW

//  Suci Zaitun Nurkamal H0712310
//  Muh Fajrin Suhar H071231029
//  Wahyu Rusman H0712310




public class App extends Application {
    
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.getIcons().add(new Image("/images/bama.png"));
        Scene1 scene1 = new Scene1(stage);
        scene1.display();
        stage.setResizable(false);
        stage.setTitle("BCC");
        stage.show();
    }
}