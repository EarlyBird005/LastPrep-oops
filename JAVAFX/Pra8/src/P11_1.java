/*
Write a program that lets the user enter numbers from a graphical user interface 
and displays them in a text area, as shown in Figure. Use a linked list to 
store the numbers. Do not store duplicate numbers. Add the buttons Sort, 
Shuffle, and Reverse to sort, shuffle, and reverse the list.
*/

/*
to compile
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P11_1.java

to run
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P11_1
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class P11_1 extends Application {
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

    public static String print(LinkedList<Integer> ll) {
        String str = "";
        for (int e : ll) {
            str += e + " ";
        }
        return str;
    }

    public void start(Stage stage) throws Exception {
        LinkedList<Integer> ll = new LinkedList<>();

        Text t = new Text("Enter a number:");
        TextField tf = new TextField();
        TextArea ta = new TextArea("Empty");
        ta.setEditable(false);
        ta.setPrefSize(400, 50);
        tf.setOnAction(e -> {
            int num = Integer.parseInt(tf.getText());
            if (ll.isEmpty()) {
                ta.clear();
            }
            if (!ll.contains(num)) {
                ll.add(num);
            }
            tf.clear();
            ta.setText(print(ll));
        });

        Button sort = new Button("Sort");
        sort.setOnAction(e -> {
            Collections.sort(ll);
            ta.setText(print(ll));
        });

        Button shuffle = new Button("Shuffle");
        shuffle.setOnAction(e -> {
            Collections.shuffle(ll);
            ta.setText(print(ll));
        });

        Button reverse = new Button("Reverse");
        reverse.setOnAction(e -> {
            Collections.reverse(ll);
            ta.setText(print(ll));
        });

        HBox hbox = new HBox(t, tf);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        HBox buttonBox = new HBox(sort, shuffle, reverse);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(hbox, ta, buttonBox);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox);
        stage.setTitle("Exercise20_02");
        stage.setScene(scene);
        stage.show();
    }
}