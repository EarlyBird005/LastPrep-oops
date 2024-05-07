/*
1.	Write a program that displays five texts vertically, as shown in Figure. Set a random color and 
opacity for each text and set the font of each text to Times Roman, bold, italic, and 22 pixels.
*/
/*
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P8_1.java
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P8_1
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class P8_1 extends Application {
    public static void main(String[] args) {
        System.out.println("Name: Nanecha Dipak Kishorbhai\t Enrollment NO.: 220170116023");
        Date t = new Date();
        System.out.println(t);
        try {
            launch(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start(Stage stage) throws Exception {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(25, 25, 25, 25));
        Text[] t = new Text[5];

        for (int i = 0; i < 5; i++) {
            t[i] = new Text("Java");
            t[i].setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
            t[i].setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
            t[i].setRotate(90);
            hbox.getChildren().add(t[i]);
        }

        stage.setScene(new Scene(hbox));
        stage.setTitle("Exercise14_04");
        stage.show();
    }
}