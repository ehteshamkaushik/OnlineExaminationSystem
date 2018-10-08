import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;


public class signupWindow {
    Scene scene;

    signupWindow() {
    }

    public Scene setSignupWindow() {

        Label statusMsg = new Label();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);


        Label nameLabel = new Label("Username : ");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passLabel = new Label("Password : ");
        GridPane.setConstraints(passLabel, 0, 1);

        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 1);

        Label passreLabel = new Label();
        passreLabel.setText("Confirm Password : ");
        GridPane.setConstraints(passreLabel, 0, 2);

        PasswordField passreInput = new PasswordField();
        passreInput.setPromptText("Password");
        GridPane.setConstraints(passreInput, 1, 2);

        Label emailLabel = new Label("Email : ");
        GridPane.setConstraints(emailLabel, 0, 3);

        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");
        GridPane.setConstraints(emailInput, 1, 3);
        GridPane.setConstraints(statusMsg, 0, 5, 2, 1);
        statusMsg.setStyle("-fx-text-fill: yellow");

        Button signupButton = new Button("Sign Up");
        signupButton.setStyle("-fx-alignment: baseline-right");
        GridPane.setConstraints(signupButton, 1, 4);

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-alignment: baseline-right");
        GridPane.setConstraints(backButton, 2, 4);


        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, passreLabel, passreInput, emailLabel, emailInput, signupButton, backButton, statusMsg);
        grid.setAlignment(Pos.CENTER);
        scene = new Scene(grid, 800, 600);


        signupButton.setOnAction(event -> {
            String msg = signupStatus(nameInput.getText(), passInput.getText(), emailInput.getText());
            if(msg.equals("correct")) {
                if(passreInput.getText().equals(passInput.getText())) {
                    File f = new File("E:\\Java t\\term project\\Users\\"+nameInput.getText()+".txt");
                    if(f.exists())
                    {
                        msg = "Already user!!";
                        statusMsg.setText(msg);
                    }
                    else {
                        creatNewUser user = new creatNewUser(nameInput.getText(), passInput.getText(), emailInput.getText());
                        msg = user.creatUser();
                        statusMsg.setText("welcome " +msg);
                        Button ContinueButton = new Button("Continue");
                        GridPane.setConstraints(ContinueButton, 0, 6);
                        grid.getChildren().addAll(ContinueButton);
                    }

                }
                else
                    statusMsg.setText("Password not confirmed");
            }
            else
                statusMsg.setText(msg);
        });

        backButton.setOnAction(event -> {
            Log_In_Window sc = new Log_In_Window();
            scene = sc.setLoginWindow();
            //return this.scene;
        });
        return scene;
    }
    String signupStatus(String userName, String PassWord, String email)
    {
        String msg = "";
        //System.out.println(userName);
        if(userName.equals(""))
        {
            msg = "No Username";
        }
        else if (PassWord.equals(""))
        {
            msg = "No Password";
        }
        else if(email.equals(""))
        {
            msg += "No Email";
        }
        else
            msg = "correct";
        return msg;
    }
}

