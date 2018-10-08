import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;


public class Log_In_Window{

    Scene scene;
    Log_In_Window() {
    }

    public Scene setLoginWindow() {

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

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 0, 3);
        GridPane.setConstraints(statusMsg, 0, 4, 4, 1);
        loginButton.setOnAction(event -> {
            String msg = loginStatus(nameInput.getText(), passInput.getText());
            if(msg.equals("correct")) {
                    File f = new File("E:\\Java t\\term project\\Users\\"+nameInput.getText()+".txt");
                    if(f.exists())
                    {
                        try {
                            BufferedReader in = new BufferedReader(new FileReader("E:\\Java t\\term project\\Users\\"+nameInput.getText()+".txt"));
                            String line = in.readLine();
                            if(line.equals(passInput.getText())) {
                                msg = "welcome " + nameInput.getText();
                                statusMsg.setText(msg);
                                Button ContinueButton = new Button("Continue");
                                GridPane.setConstraints(ContinueButton, 0, 5);
                                grid.getChildren().addAll(ContinueButton);
                            }
                            else {
                                msg = "Wrong Password";
                                statusMsg.setText(msg);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        msg = "Invalid Username";
                        statusMsg.setText(msg);
                    }
                }
                else
                    statusMsg.setText(msg);
        });

        Button back = new Button("Back");
        GridPane.setConstraints(loginButton, 0, 6);
        back.setOnAction(event -> {

        });



        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput,loginButton, statusMsg);
        grid.setAlignment(Pos.CENTER);

        scene = new Scene(grid, 800, 600);
        return scene;
    }

    Scene returnScene()
    {
        signupWindow obj = new signupWindow();
        return obj.setSignupWindow();
    }



    static String loginStatus(String userName, String PassWord)
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
        else msg = "correct";
        return msg;
    }

}
