import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class showQuestion extends Application{
    Stage window;
    //ScrollBar sp = new ScrollBar();
    public static void main(String [] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Question");
        String line[] = new String[10];
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        int i = 0;
        while(i <= 9)
        {
            line[i] = inFromServer.readLine();
            i++;
        }

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        int j = 0, k = 0;
        while (j < 2) {
            ToggleGroup group = new ToggleGroup();
            Label ques = new Label(line[k++]);

            RadioButton op1 = new RadioButton(line[k++]);
            RadioButton op2 = new RadioButton(line[k++]);
            RadioButton op3 = new RadioButton(line[k++]);
            RadioButton op4 = new RadioButton(line[k++]);

            op1.setToggleGroup(group);
            op2.setToggleGroup(group);
            op3.setToggleGroup(group);
            op4.setToggleGroup(group);

            Button button = new Button("Submit");
            button.setOnAction(event -> {
                String ans = HandleOption(op1, op2, op3, op4);
                System.out.println("ans is : " + ans);
            });

            VBox question = new VBox(10);
            HBox options = new HBox(10);
            options.getChildren().addAll(op1,op2,op3,op4);
            question.getChildren().addAll(ques, options, button);
            GridPane.setConstraints(question, 0, j);
            grid.getChildren().addAll(question);
            j++;
        }
       // grid.getChildren().addAll(sp);
        Scene scene = new Scene(grid, 800, 600);


        scene.getStylesheets().addAll("style.css");
        window.setScene(scene);
        scene.getStylesheets().addAll("style.css");
        window.show();
    }

    private String HandleOption(RadioButton op1, RadioButton op2, RadioButton op3, RadioButton op4) {
        String ans = "";
        if(op1.isSelected())
            ans = op1.getText();
        if(op2.isSelected())
            ans = op2.getText();
        if(op3.isSelected())
            ans = op3.getText();
        if(op4.isSelected())
            ans = op4.getText();
        return ans;
    }
}
