/* Write a program that displays a rectanguloid, as shown in Figure a. The cube should grow and shrink as the 
window grows or shrinks. 
*/
/*
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P8_3.java
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P8_3
*/
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class P8_3 extends Application {
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

    public void start(Stage stage) {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setStyle("-fx-background-color: black;");
        
        double rectDepth = 50, rectWidth = 100, rectHeight = 50, boxHeight = 30;
        Rectangle rectangle = new Rectangle(0, 0, rectWidth, rectHeight);
        rectangle.setFill(Color.BLUE);
        Box box = new Box(rectWidth, boxHeight, rectDepth);
        box.setTranslateY(rectHeight); // Translate box to sit on top of rectangle
        // box.setFill(Color.RED);
        Group group = new Group(rectangle, box);
        Scene scene = new Scene(group, rectWidth, rectHeight + boxHeight);
        stage.setHeight(500);
        stage.setWidth(500);
        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            double aspectRatio = rectWidth / (rectHeight + boxHeight);
            rectangle.setWidth(newValue.doubleValue());
            box.setWidth(newValue.doubleValue());
            // scene.setHeight(newValue.doubleValue() / aspectRatio);
            rectangle.setHeight(scene.getWidth() * aspectRatio - boxHeight);
        });
        stage.setScene(scene);
        stage.setTitle("P8_3");


        // stage.setScene(new Scene(gp, 500, 500));
        stage.show();
    } 
}