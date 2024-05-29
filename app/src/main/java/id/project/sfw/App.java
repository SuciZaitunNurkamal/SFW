    package id.project.sfw;

    import javafx.stage.Stage;
    import id.project.sfw.confiq.DbConnect;
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
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.Background;
    import javafx.scene.layout.BackgroundFill;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox; 
    import javafx.scene.paint.Color;
    import javafx.scene.paint.CycleMethod;
    import javafx.scene.paint.LinearGradient;
    import javafx.scene.paint.Stop;
    import javafx.scene.text.Font;
    import javafx.scene.text.FontWeight;
    import javafx.scene.layout.CornerRadii;

    public class App extends Application {
            
        private Stage stage;
        private TextField heightField;
        private TextField weightField;
        private TextField bmiField;

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            stage = primaryStage;
            stage.getIcons().add(new Image("/bama.png"));
            scene1();
            stage.setResizable(false);
            stage.setTitle("BCC");
            stage.show();
        }

        private void scene1() {

            Image logoImage = new Image("/bama.png");
            ImageView imageView = new ImageView(logoImage);
            imageView.setFitWidth(260);
            imageView.setPreserveRatio(true);
            imageView.setOnMouseClicked(e -> scene1());
            HBox hBox2 = new HBox(imageView);
            hBox2.setAlignment(Pos.CENTER);

            Label label = new Label("WELCOME TO BCC");
            label.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 30px; -fx-font-weight: bold;");
            label.setTextFill(Color.WHITE);
            HBox hBox1 = new HBox(label);
            hBox1.setAlignment(Pos.CENTER);

            Button button = new Button("GET STARTED");
            button.setStyle("-fx-background-color: #008000;-fx-font-family: 'Sans-Serif'; -fx-font-weight: bold; -fx-padding: 10px 70px;-fx-font-size: 16px; -fx-border-color: BLACK; -fx-border-width: 1px; -fx-border-radius: 3;");
            button.setTextFill(Color.WHITE);
            button.setOnAction(v -> {
                scene2();
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
        
        
            vBox.setBackground(new Background( new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
        
            Scene scene1 = new Scene(vBox, 620, 400);
            stage.setScene(scene1);
        
        }



        private void scene2() {
            Label labelMenu = new Label("PILIH MENU");
            
            labelMenu.setTextFill(Color.WHITE);
            labelMenu.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 25px; -fx-font-weight: bold;");
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
                sceneLogin();
            });
            
            Button btnSignUp = new Button("SIGN UP");
            Color newColor5= Color.web("F4EEE0");
            btnSignUp.setTextFill(Color.BLACK);
            btnSignUp.setBackground(new Background(new BackgroundFill(newColor5, new CornerRadii(100), Insets.EMPTY)));
            btnSignUp.setPadding(new Insets(10, 15, 10, 10));
            btnSignUp.setMaxWidth(125);
            btnSignUp.setMinHeight(0);
            btnSignUp.setOnAction(v -> {
                sceneSignUp();
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
        
        
            vBox.setBackground(new Background( new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

            Scene scene2 = new Scene(vBox, 620, 400);
            stage.setTitle("BCC");
            stage.setScene(scene2);
        }




        private void sceneLogin() {
            Label label = new Label("Login Page");
        Color newColor1 = Color.web("F4EEE0");
        label.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 30px; -fx-font-weight: bold;");
        label.setTextFill(newColor1);
        label.setPadding(new Insets(10, 15, 10, 30));
        HBox hBox1 = new HBox(label);
        hBox1.setAlignment(Pos.CENTER);

        ImageView usernameIcon = new ImageView(new Image("user.png"));
        usernameIcon.setFitHeight(23);
        usernameIcon.setFitWidth(23);

        
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");
        usernameInput.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 14px; -fx-border-color: #000000; -fx-prompt-text-fill: rgba(0, 0, 0, 0.5);");
        usernameInput.setAlignment(Pos.CENTER_LEFT);
        usernameInput.setMaxWidth(200);

        HBox usernameBox = new HBox(usernameIcon, usernameInput);
        usernameBox.setSpacing(5);
        usernameBox.setAlignment(Pos.CENTER);

        ImageView passwordIcon = new ImageView(new Image("key.png"));
        passwordIcon.setFitHeight(23);
        passwordIcon.setFitWidth(23);


        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("********");
        passwordInput.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 14px; -fx-border-color: #000000; -fx-prompt-text-fill: rgba(0, 0, 0, 0.5);");
        passwordInput.setAlignment(Pos.CENTER_LEFT);
        passwordInput.setMaxWidth(200);

        HBox passwordBox = new HBox(passwordIcon, passwordInput);
        passwordBox.setSpacing(5);
        passwordBox.setAlignment(Pos.CENTER);

        Label labelError = new Label();
        labelError.setStyle("-fx-font-size: 14px; -fx-text-fill: WHITE; -fx-font-family: 'Sans-Serif';");
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
            backButton.setOnAction(v -> scene2());
        
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
            stage.setScene(sceneLogin);
        
            loginButton.setOnAction(event -> {
                String username = usernameInput.getText();
                String password = passwordInput.getText();
        
                if (username.isEmpty() || password.isEmpty()) {
                    labelError.setText("Tolong masukkan username dan password anda");
                } else if (DbConnect.ValidasiLogin(username, password)) {
                    scene3();
                } else {
                    labelError.setText("Login gagal. tolong masukkan password dan username yang benar.");
                }
            });
        }
        
        





        
        

        private void sceneSignUp() {

            Label titleLabel = new Label("Daftar Akun");
            titleLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 24px; -fx-font-weight: bold;");
            titleLabel.setTextFill(Color.WHITE);
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

            Label labelError = new Label();
            labelError.setStyle("-fx-font-size: 10px; -fx-text-fill: WHITE; -fx-font-family: 'Sans-Serif';");
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
            
            if (username.isEmpty() || password.isEmpty()) {
                labelError.setText("tolong masukkan username dan password");
                labelError.setTextFill(Color.WHITE);
            } else if (DbConnect.checkUsername(username)) {
                labelError.setText("Username Is Taken");
            } else if (!DbConnect.validatePassword(password)) {
                labelError.setText(" Password harus berisi  minimal 3 characters, maksimal 15 characters, setidaknya 1 angka dan  1 Huruf besar");
            } else {
                DbConnect.insertData(username, password);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    labelError.setText("Registration Successful!");
                    e.printStackTrace();
                }
                scene2();



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

        



        private void scene3() {
            Label label = new Label("BCC Calculator");
            label.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 30px; -fx-font-weight: bold;");
            label.setTextFill(Color.WHITE);

            HBox hBox1 = new HBox(label);
            hBox1.setAlignment(Pos.CENTER);

            Label heightLabel = new Label("Height (cm):");
            heightLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 16px; -fx-font-weight: bold;");
            heightLabel.setTextFill(Color.WHITE);
            heightField = new TextField();
            heightField.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 14px; -fx-border-color: #000000;");
            heightField.setAlignment(Pos.CENTER);
            heightField.setMaxWidth(200);

            Label weightLabel = new Label("Weight (kg):");
            weightLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 16px; -fx-font-weight: bold;");
            weightLabel.setTextFill(Color.WHITE);
            weightField = new TextField();
            weightField.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 14px; -fx-border-color: #000000;");
            weightField.setAlignment(Pos.CENTER);
            weightField.setMaxWidth(200);

            Button calculateButton = new Button("Calculate");
            // calculateButton.setStyle("-fx-background-color: #008000;-fx-font-family: 'Sans-Serif'; -fx-font-weight: bold; -fx-padding: 10px 70px;-fx-font-size: 16px; -fx-border-color: BLACK; -fx-border-width: 1px; -fx-border-radius: 3;");
            Color newColorcalculator = Color.web("F4EEE0");
            calculateButton.setTextFill(Color.BLACK);
            calculateButton.setBackground(new Background(new BackgroundFill(newColorcalculator, new CornerRadii(300), Insets.EMPTY)));
            // Color newColorDaftar = Color.web("F4EEE0");
            calculateButton.setOnAction(v -> calculateBMI());

            

            VBox vBox1 = new VBox(heightLabel, heightField, weightLabel, weightField, calculateButton);
            vBox1.setAlignment(Pos.CENTER);
            vBox1.setSpacing(10);

            VBox vBox = new VBox(20, hBox1, vBox1);
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

            Scene scene5 = new Scene(vBox, 620, 400);
            stage.setScene(scene5);
        }

        private void calculateBMI() {
            String heightText = heightField.getText();
            String weightText = weightField.getText();
            try {
                double height = Double.parseDouble(heightText) / 100;
                double weight = Double.parseDouble(weightText);
                double bmi = weight / (height * height);

                scene4(bmi);
            } catch (NumberFormatException e) {
                bmiField.setText("Invalid input");
            }
        }





        public void scene4(double bmi) {
            String category;
            Label resultLabel = new Label("RESULT ANDA: " + String.format("%.2f", bmi));
            resultLabel.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 18px; -fx-font-weight: bold;");
            resultLabel.setTextFill(Color.WHITE);
            Image image = new Image("bmi.jpeg");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(400);
            imageView.setFitHeight(200);

            if (bmi < 18.5) {
                category = "UNDERWEIGHT";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                category = "NORMAL";
            } else {
                category = "OVERWEIGHT";
            }

            Label categoryLabel = new Label(" ANDA TERMASUK GOLONGAN " + category);
            categoryLabel.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 16px; -fx-font-weight: bold;");
            categoryLabel.setTextFill(Color.WHITE);

            Button rekomendasiButton = new Button("REKOMENDASI");
            Color newColorRekomendasi = Color.web("F4EEE0");
            rekomendasiButton.setTextFill(Color.BLACK);
            rekomendasiButton.setBackground(new Background(new BackgroundFill(newColorRekomendasi, new CornerRadii(300), Insets.EMPTY)));
            rekomendasiButton.setPadding(new Insets(5, 15, 5, 10));
            rekomendasiButton.setMaxWidth(125);
            rekomendasiButton.setMinHeight(0);
            rekomendasiButton.setOnAction(event -> scene5());

            Button btnExit = new Button("EXIT");
            Color newColor3 = Color.web("F4EEE0");
            btnExit.setTextFill(Color.BLACK);
            btnExit.setBackground(new Background(new BackgroundFill(newColor3, new CornerRadii(100), Insets.EMPTY)));
            btnExit.setPadding(new Insets(5, 15, 5, 10));
            btnExit.setMaxWidth(125);
            btnExit.setMinHeight(0);
            btnExit.setOnAction(event -> stage.close());

            Label rekomendasiLabel = new Label("Berikut Rekomendasi Latihan menuju Golongan Normal ");
            rekomendasiLabel.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 16px; -fx-font-weight: bold;");
            rekomendasiLabel.setTextFill(Color.WHITE);

            VBox vBox = new VBox(20, resultLabel, imageView, categoryLabel);
            if (bmi < 18.5 || bmi >= 25) {
                vBox.getChildren().addAll(rekomendasiLabel, rekomendasiButton);
            } else {
                Label normalLabel = new Label("Selamat Anda tergolong normal");
                normalLabel.setTextFill(Color.WHITE);
                vBox.getChildren().addAll(normalLabel, btnExit);
            }

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

            Scene scene4 = new Scene(vBox, 620, 400);
            stage.setScene(scene4);
        }





        
        public void scene5() {
            VBox layoutUtama = new VBox(10);
            layoutUtama.setPadding(new Insets(10));
            layoutUtama.setAlignment(Pos.TOP_CENTER);
            layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
        
            HBox row1 = new HBox(50);
            row1.setAlignment(Pos.CENTER);
            row1.getChildren().add(buatHariBox("Hari 1", "6 menit", "Mulai", true));
        
            HBox row2 = new HBox(50);
            row2.setAlignment(Pos.CENTER);
            row2.getChildren().addAll(
                    buatHariBox("Hari 2", "7 menit", "Mulai", false),
                    buatHariBox("Hari 3", "6 menit", "Mulai", false)
            );
        
            HBox row3 = new HBox(50);
            row3.setAlignment(Pos.CENTER);
            row3.getChildren().addAll(
                    buatHariBox("Hari 4", "Hari Istirahat!", null, false),
                    buatHariBox("Hari 5", "6 menit", "Mulai", false)
            );
        
            HBox row4 = new HBox(50);
            row4.setAlignment(Pos.CENTER);
            row4.getChildren().addAll(
                    buatHariBox("Hari 6", "6 menit", "Mulai", false),
                    buatHariBox("Hari 7", "6 menit", "Mulai", false)
            );
        
            layoutUtama.getChildren().addAll(row1, row2, row3, row4);
        
            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }
        
        private HBox buatHariBox(String hari, String menit, String teksTombol, boolean hariPertama) {
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
        

            Label Keterangan = new Label("NOTE: Lakukan latihan ini sebanyak 7x4 hari !!!");
            Keterangan.setTextFill(Color.RED);
            HBox masukBox = new HBox(5, Keterangan);
            masukBox.setAlignment(Pos.CENTER);


            Button backButton = new Button();
            ImageView backIcon = new ImageView(new Image("panah.png"));
            
            backIcon.setFitWidth(20);
            backIcon.setFitHeight(20);
            backButton.setGraphic(backIcon);
            backButton.setOnAction(e -> scene5());
            



            if (teksTombol != null) {
                Button tombolAksi = new Button(teksTombol);
                tombolAksi.setStyle("-fx-background-color: #00C853; -fx-text-fill: white; -fx-background-radius: 15px; -fx-padding: 5 20 5 20;");
                hariBox.getChildren().add(tombolAksi);
                tombolAksi.setOnAction(event -> {
                    switch (hari) {
                        case "Hari 1":
                            sceneHari1(stage);
                            break;
                        case "Hari 2":
                            sceneHari2(stage);
                            break;
                        case "Hari 3":
                            sceneHari3(stage);
                            break;
                        case "Hari 5":
                            sceneHari5(stage);
                            break;
                        case "Hari 6":
                            sceneHari6(stage);
                            break;
                        case "Hari 7":
                            sceneHari7(stage);
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


        private Button createBackButton(Stage stage) {
            Button backButton = new Button();
            ImageView backIcon = new ImageView(new Image("panah.png")); 
            backIcon.setFitWidth(20);
            backIcon.setFitHeight(20);
            backButton.setGraphic(backIcon);
            backButton.setOnAction(e -> scene5());
            return backButton;
        }
    








        
        public void sceneHari1(Stage stage) {
            VBox layoutUtama = new VBox(10);
            layoutUtama.setPadding(new Insets(10));
            layoutUtama.setAlignment(Pos.TOP_CENTER);
            layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
        
            Label latihanLabel = new Label("Latihan Hari 1 (5)");
            latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

            Button backButton = createBackButton(stage);


        
        
            HBox headerBox = new HBox(10);
            headerBox.setAlignment(Pos.CENTER_LEFT);
            headerBox.getChildren().addAll(latihanLabel, backButton);
        
            VBox latihanBox = new VBox(10);
            latihanBox.setAlignment(Pos.CENTER_LEFT);
            latihanBox.setPadding(new Insets(20));
            latihanBox.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px;");
        
            latihanBox.getChildren().addAll(
                    buatLatihanBox("Jumping jack", "00:30", "jumpingjack.png"),
                    buatLatihanBox("Sit-Up", "x16", "situp.png"),
                    buatLatihanBox("Angkat Lutut/Berlari", "00:30", "muscle.png"),
                    buatLatihanBox("Push-up", "x3", "pushup.png"),
                    buatLatihanBox("Crunch sepeda", "x16", "bicycle.png")
            );
            latihanBox.setPadding(new Insets(20, 20, 20, 50));
        
            layoutUtama.getChildren().addAll(headerBox, latihanBox);
        
            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }
        
        public void sceneHari2(Stage stage) {
            VBox layoutUtama = new VBox(10); 
            layoutUtama.setPadding(new Insets(10));
            layoutUtama.setAlignment(Pos.TOP_CENTER);
            layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
        
            Label latihanLabel = new Label("Latihan Hari 2 (5)");
            latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
            Button backButton = createBackButton(stage);

            HBox headerBox = new HBox(10);
            headerBox.setAlignment(Pos.CENTER_LEFT);
            headerBox.getChildren().addAll(latihanLabel, backButton);
        
            VBox latihanBox = new VBox(10);
            latihanBox.setAlignment(Pos.CENTER_LEFT);
            latihanBox.setPadding(new Insets(20));
            latihanBox.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px;");
        
            latihanBox.getChildren().addAll(
                    buatLatihanBox("Jumping Jacks", "00:30", "jumpingjack.png"),
                    buatLatihanBox("Push-Up", "x16", "pushup.png"),
                    buatLatihanBox("Plank", "00:30", "plank.png"),
                    buatLatihanBox("Sit-up", "x3", "situp.png"),
                    buatLatihanBox("Tricip Dip", "x16", "Tricip.png")
            );
            latihanBox.setPadding(new Insets(20, 20, 20, 50));
        
            layoutUtama.getChildren().addAll(headerBox, latihanBox);
        
            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }
        
        public void sceneHari3(Stage stage) {
            VBox layoutUtama = new VBox(10);
            layoutUtama.setPadding(new Insets(10));
            layoutUtama.setAlignment(Pos.TOP_CENTER);
            layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
        
            Label latihanLabel = new Label("Latihan Hari 3 (5)");
            latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
            Button backButton = createBackButton(stage);

            HBox headerBox = new HBox(10);
            headerBox.setAlignment(Pos.CENTER_LEFT);
            headerBox.getChildren().addAll(latihanLabel, backButton);
        
            VBox latihanBox = new VBox(10);
            latihanBox.setAlignment(Pos.CENTER_LEFT);
            latihanBox.setPadding(new Insets(20));
            latihanBox.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px;");
        
            latihanBox.getChildren().addAll(
                    buatLatihanBox("Plank", "00:30", "plank.png"),
                    buatLatihanBox("Sit-up", "x16", "situp.png"),
                    buatLatihanBox("Bicycle Crunches", "00:30", "bicycle.png"),
                    buatLatihanBox("Tricep Dips", "x3", "gym.png"),
                    buatLatihanBox("Lompat tali", "x16", "LompatTali.png")
            );
            latihanBox.setPadding(new Insets(20, 20, 20, 50));
        
            layoutUtama.getChildren().addAll(headerBox, latihanBox);
        
            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }
        
        public void sceneHari5(Stage stage) {
        VBox layoutUtama = new VBox(10);
        layoutUtama.setPadding(new Insets(10));
        layoutUtama.setAlignment(Pos.TOP_CENTER);
        layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
    
        Label latihanLabel = new Label("Latihan Hari 5 (5)");
        latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    
        Button backButton = createBackButton(stage);

        HBox headerBox = new HBox(10);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.getChildren().addAll(latihanLabel, backButton);

        VBox latihanBox = new VBox(10);
        latihanBox.setAlignment(Pos.CENTER_LEFT);
        latihanBox.setPadding(new Insets(20));
        latihanBox.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px;");
    
        latihanBox.getChildren().addAll(
                buatLatihanBox("Knee Push Ups", "00:30", "kneepush.png"),
                buatLatihanBox("Plank", "x16", "plank.png"),
                buatLatihanBox("Pull-Up", "00:30", "pullUp.png"),
                buatLatihanBox("Lompat Tali", "x3", "LompatTali.png"),
                buatLatihanBox("Triceps dips", "x16", "Tricip.png")
        );
        latihanBox.setPadding(new Insets(20, 20, 20, 50));
    
        layoutUtama.getChildren().addAll(headerBox, latihanBox);
    
        Scene scene = new Scene(layoutUtama, 620, 400);
        stage.setScene(scene);
        stage.show();
    }


        public void sceneHari6(Stage stage) {
            VBox layoutUtama = new VBox(10);
            layoutUtama.setPadding(new Insets(10));
            layoutUtama.setAlignment(Pos.TOP_CENTER);
            layoutUtama.setStyle("-fx-background-color: #f5f5f5;");

        
            Label latihanLabel = new Label("Latihan Hari 6 (5)");
            latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
            Button backButton = createBackButton(stage);

            HBox headerBox = new HBox(10);
            headerBox.setAlignment(Pos.CENTER_LEFT);
            headerBox.getChildren().addAll(latihanLabel, backButton);
        
            VBox latihanBox = new VBox(10);
            latihanBox.setAlignment(Pos.CENTER_LEFT);
            latihanBox.setPadding(new Insets(20));
            latihanBox.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px;");
        
            latihanBox.getChildren().addAll(
                    buatLatihanBox("Lompat Tali", "00:30", "LompatTali.png"),
                    buatLatihanBox("Squat ", "x16", "squat.png"),
                    buatLatihanBox("Plank ", "00:30", "plank.png"),
                    buatLatihanBox("Push-Up", "x3", "pushup.png"),
                    buatLatihanBox("Triceps dips", "x16", "Tricip.png")
            );
            latihanBox.setPadding(new Insets(20, 20, 20, 50));
        
            layoutUtama.getChildren().addAll(headerBox, latihanBox);
        
            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.setTitle("BCC");
            stage.show();
        }
        
        public void sceneHari7(Stage stage) {
            VBox layoutUtama = new VBox(10);
            layoutUtama.setPadding(new Insets(10));
            layoutUtama.setAlignment(Pos.TOP_CENTER);
            layoutUtama.setStyle("-fx-background-color: #f5f5f5;");
        


            Label latihanLabel = new Label("Latihan Hari 7 (5)");
            latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
            Button backButton = createBackButton(stage);
            // backButton.setPadding(new Insets(0,0,0,80));

            HBox headerBox = new HBox(10);
            headerBox.setAlignment(Pos.CENTER_LEFT);
            headerBox.getChildren().addAll(latihanLabel, backButton);
            // headerBox.setPadding(new Insets(0,0,0,30));
        
            VBox latihanBox = new VBox(10);
            latihanBox.setAlignment(Pos.CENTER_LEFT);
            latihanBox.setPadding(new Insets(20));
            latihanBox.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 10px;");
        
            latihanBox.getChildren().addAll(
                    buatLatihanBox("Lompat Tali", "00:30", "LompatTali.png"),
                    buatLatihanBox("Triceps Dips","x16", "Tricip.png"),
                    buatLatihanBox(" Plank", "00:30", "plank.png"),
                    buatLatihanBox("Push-up", "x3", "pushup.png"),
                    buatLatihanBox("Pull-up", "x16", "pullUp.png")
            );
            latihanBox.setPadding(new Insets(20, 20, 20, 50));
        
            layoutUtama.getChildren().addAll(headerBox, latihanBox);
        
            Scene scene = new Scene(layoutUtama, 620, 400);
            stage.setScene(scene);
            stage.show();
        }
        
        private HBox buatLatihanBox(String latihan, String repetisi, String iconPath) {
            HBox latihanBox = new HBox(10);
            latihanBox.setAlignment(Pos.CENTER_LEFT);
        
            ImageView iconView = new ImageView(new Image(iconPath));
            iconView.setFitWidth(30);
            iconView.setFitHeight(50);
            latihanBox.getChildren().add(iconView);
        
            Label latihanLabel = new Label(latihan);
            latihanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
            Label repetisiLabel = new Label(repetisi);
            repetisiLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        
            latihanBox.getChildren().addAll(latihanLabel, repetisiLabel);
        
            return latihanBox;
        }
        
        










    }