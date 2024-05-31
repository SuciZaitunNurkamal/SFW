package id.project.sfw.Scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class SceneBMIInput {
    private Stage stage;
    private String username;
    private double bmi;

    public SceneBMIInput(Stage stage, String username) {
        this.stage = stage;
        this.username = username;
    }

    public void display() {




        Label label = new Label("BCC CALCULATOR");
        label.setStyle("-fx-font-family:'Inter' 'Sans-Serif'; -fx-font-size: 30px; -fx-font-weight: bold;");
        label.setTextFill(Color.WHITE);

        
        HBox hBox1 = new HBox(label);
        hBox1.setAlignment(Pos.CENTER);



        
        
        Label heightLabel = new Label("Tinggi Badan (cm)");
        heightLabel.setId("label-height");
    
        heightLabel.setTextFill(Color.WHITE);
        TextField heightInput = new TextField();
        heightInput.setPromptText("Masukkan Tinggi Badan");
        heightInput.setId("weight-Field");
        heightInput.setMaxWidth(200);
      
        VBox heightBox = new VBox(heightLabel, heightInput);
        heightBox.setAlignment(Pos.CENTER);  
        heightBox.setSpacing(5);
       
       

        Label weightLabel = new Label("Berat Badan (kg)");
        weightLabel.setId("label-weight");
        
        weightLabel.setTextFill(Color.WHITE);
        TextField weightInput = new TextField();
        weightInput.setPromptText("Masukkan Berat Badan");
        weightInput.setMaxWidth(200);
        weightInput.setId("weight-Field");
       
        VBox weightBox = new VBox(weightLabel, weightInput);
        weightBox.setAlignment(Pos.CENTER);
        weightBox.setSpacing(5);


        Label labelError = new Label();
        labelError.setId("label-errorSign");
        labelError.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");
        Color newColorSubmit = Color.web("F4EEE0");
        submitButton.setTextFill(Color.BLACK);
        submitButton.setBackground(new Background(new BackgroundFill(newColorSubmit, new CornerRadii(300), Insets.EMPTY)));
        submitButton.setPadding(new Insets(5, 15, 5, 10));
        submitButton.setMaxWidth(125);
        submitButton.setMinHeight(0);

        submitButton.setOnAction(event -> {
            String weightText = weightInput.getText();
            String heightText = heightInput.getText();

            if (weightText.isEmpty() || heightText.isEmpty()) {
                labelError.setText("Tolong masukkan semua data");
                labelError.setTextFill(Color.WHITE);
            } else if (!isAngka(weightText) || !isAngka(heightText)) {
                labelError.setText("Input harus berupa angka saja");
                labelError.setTextFill(Color.WHITE);
            } 
            
            else {
                double weight = Double.parseDouble(weightText);
                double height = Double.parseDouble(heightText) / 100;
                DbConnect.updateUserBMI(username, weight, height);

                this.bmi = weight / (height * height);
                Scene4 scene4 = new Scene4(stage, this.bmi, username);
                scene4.display();
            }
        });

        VBox vBox = new VBox(10,hBox1,  heightBox,weightBox, labelError, submitButton);
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
        Scene bmiInputScene = new Scene(vBox, 620, 400);

        String css = this.getClass().getResource("/styles/style.css").toExternalForm();
        bmiInputScene.getStylesheets().add(css);

        stage.setScene(bmiInputScene);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }





    boolean isAngka(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }




    

}