/* Write a program that displays a rectanguloid, as shown in Figure a. The cube should grow and shrink as the 
window grows or shrinks. 
*/
/*
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P8_3.java
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P8_3
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util .*;

public class P8_3 extends Application {
    Rectangle rec1 = new Rectangle(200, 200, Color.TRANSPARENT);
    Rectangle rec2 = new Rectangle(200, 200, Color.TRANSPARENT);
    Line line1 = new Line();
    Line line2 = new Line();
    Line line3 = new Line();
    Line line4 = new Line();

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
        Pane pane = new Pane();
        pane.getChildren().addAll(rec1, rec2, line1, line2, line3, line4);
        Scene scene = new Scene(pane, 400, 400);

        rec1.setStroke(Color.BLACK);
        rec1.setTranslateX(50); // 100 - 50
        rec1.setTranslateY(150); // 100 + 50
        rec2.setStroke(Color.BLACK);
        rec2.setTranslateX(100);
        rec2.setTranslateY(100);
        updateLines();

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            rec1.setWidth(newVal.doubleValue() / 2);
            rec2.setWidth(newVal.doubleValue() / 2);
            rec1.setTranslateX(newVal.doubleValue() / 4 - 50);
            rec2.setTranslateX(newVal.doubleValue() / 4);
            updateLines();
        });
        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            rec1.setHeight(newVal.doubleValue() / 2);
            rec2.setHeight(newVal.doubleValue() / 2);
            rec1.setTranslateY(newVal.doubleValue() / 4 + 50);
            rec2.setTranslateY(newVal.doubleValue() / 4);
            updateLines();
        });
        
        stage.setTitle("Exercise14_14");
        stage.setScene(scene);
        stage.show();
    }

    private void updateLines() {
        line1.setStartX(rec1.getTranslateX());
        line1.setEndX(rec2.getTranslateX());
        line1.setStartY(rec1.getTranslateY());
        line1.setEndY(rec2.getTranslateY());

        line2.setStartX(rec1.getTranslateX());
        line2.setEndX(rec2.getTranslateX());
        line2.setStartY(rec1.getTranslateY() + rec1.getHeight());
        line2.setEndY(rec2.getTranslateY() + rec2.getHeight());

        line3.setStartX(rec1.getTranslateX() + rec1.getWidth());
        line3.setEndX(rec2.getTranslateX() + rec2.getWidth());
        line3.setStartY(rec1.getTranslateY() + rec1.getHeight());
        line3.setEndY(rec2.getTranslateY() + rec2.getHeight());

        line4.setStartX(rec1.getTranslateX() + rec1.getWidth());
        line4.setEndX(rec2.getTranslateX() + rec2.getWidth());
        line4.setStartY(rec1.getTranslateY());
        line4.setEndY(rec2.getTranslateY());
    }
}