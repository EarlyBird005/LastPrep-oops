/* 
Write a program that displays a moving text, as shown in Figure. The text moves from left to right circularly. 
When it disappears in the right, it reappears from the left. The text freezes when the mouse is pressed and moves 
again when the button is released.
*/
/*
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P9_2.java
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P9_2
*/
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class P9_2 extends Application {
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

    private boolean isPaused = false;
    double speed = 2;
    public void start(Stage stage) throws Exception {
        Text movingText = new Text("Programming is fun");
        movingText.setLayoutX(0);
        movingText.setLayoutY(50); // height/2
        Pane root = new Pane(movingText);

        Scene scene = new Scene(root, 400, 100);
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> isPaused = true);
        scene.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> isPaused = false);
        scene.heightProperty().addListener((obs, oldval, newVal) -> {
            movingText.setLayoutY(newVal.doubleValue() / 2);
        });
        
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                if (!isPaused) {
                    movingText.setLayoutX((movingText.getLayoutX() + speed) % scene.getWidth());
                }
            }
        };
        timer.start();

        stage.setScene(scene);
        stage.setTitle("Exercise15_27");
        stage.show();
    }
}