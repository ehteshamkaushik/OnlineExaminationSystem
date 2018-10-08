import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class mainWindow extends Application{
    Stage window;
    Scene scene_login, scene_signup, scene;

    public static void main(String [] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Online Exam");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label welcomeMessage = new Label();
        welcomeMessage.setText("Welcome to online exam app");
        welcomeMessage.setStyle("-fx-font-size: 25pt");
        //welcomeMessage.setStyle("-fx-background-color: indigo");
        GridPane.setConstraints(welcomeMessage, 0, 0);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 0, 1);
        loginButton.setOnAction(event -> {
            Log_In_Window newloginWindow = new Log_In_Window();
            scene_login = newloginWindow.setLoginWindow();
            scene_login.getStylesheets().addAll("style.css");
            window.setScene(scene_login);
            window.show();
        });

        Button signupButton = new Button("Sign Up");
        GridPane.setConstraints(signupButton, 0, 2);
        signupButton.setOnAction(event -> {
            signupWindow newsignupWindow = new signupWindow();
            scene_signup = newsignupWindow.setSignupWindow();
            scene_signup.getStylesheets().addAll("style.css");
            window.setScene(scene_signup);
            window.show();
        });


        grid.getChildren().addAll(welcomeMessage,loginButton, signupButton);
        grid.setAlignment(Pos.CENTER);
        scene = new Scene(grid, 800, 600);
        scene.getStylesheets().addAll("style.css");
        window.setScene(scene);
        window.show();
    }
}

