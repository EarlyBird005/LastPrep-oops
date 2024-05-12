/*
Write a program that uses a bar chart to display the percentages of the overall grade represented by projects, quizzes, 
midterm exams, and the final exam, as shown in Figure b. Suppose that projects take 20 percent and are displayed in red, 
quizzes take 10 percent and are displayed in blue, midterm exams take 30 percent and are displayed in green, and the 
final exam takes 40 percent and is displayed in orange. Use the Rectangle class to display the bars. Interested readers may 
explore the JavaFXBarChart class for further study.
*/
/*
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P8_2.java
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P8_2
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class P8_2 extends Application {
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
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(5, 5, 5, 5));

        String[] components = { "Project", "Quiz", "Midterm", "Final" };
        int[] percentages = { 20, 10, 30, 40 };
        Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE };

        for (int i = 0; i < components.length; i++) {
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.BOTTOM_LEFT);
            vbox.setSpacing(5);
            Rectangle bar = new Rectangle();
            bar.setFill(colors[i]);
            bar.setWidth(100);
            bar.setHeight(percentages[i] * 3);

            Text t = new Text(components[i] + " -- " + percentages[i] + "%");
            vbox.getChildren().addAll(t, bar);
            hbox.getChildren().add(vbox);
        }

        Scene scene = new Scene(hbox);
        stage.setTitle("Exercise14_12");
        stage.setScene(scene);
        stage.show();
    }
}