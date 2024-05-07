/*
Write a program that can dynamically change the font of a text 
in a label displayed on a stack pane. The text can be displayed 
in bold and italic at the same time. You can select the font 
name or font size from combo boxes, as shown in Figure. The 
available font names can be obtained using Font.getFamilies(). 
The combo box for the font size is initialized with numbers 
from 1 to 100.
*/
/*
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P9_1.java
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P9_1
*/
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class P9_1 extends Application {
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
        Text tName = new Text("Font Name");
        Text tSize = new Text("Font Size");
        
        Label label = new Label("Programming is fun");
        label.setFont(Font.font("Book Antiqua", FontWeight.NORMAL, 48));
        
        ComboBox<String> fontNames = new ComboBox<>(FXCollections.observableArrayList(Font.getFamilies()));
        fontNames.setValue("Book Antiqua");
        fontNames.setOnAction(e -> label.setFont(Font.font(fontNames.getValue(), label.getFont().getSize())));

        ComboBox<Integer> fontSize = new ComboBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100));
        fontSize.setValue(48);
        fontSize.setOnAction(e -> label.setFont(Font.font(label.getFont().getName(), fontSize.getValue())));

        CheckBox bold = new CheckBox("Bold");
        CheckBox italic = new CheckBox("Italic");
        bold.setOnAction(e -> {
            FontWeight fontWeight = bold.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL;
            FontPosture fontPosture = italic.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR;
            label.setFont(Font.font(label.getFont().getName(), fontWeight, fontPosture, label.getFont().getSize()));
        });
        italic.setOnAction(e -> {
            FontWeight fontWeight = bold.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL;
            FontPosture fontPosture = italic.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR;
            label.setFont(Font.font(label.getFont().getName(), fontWeight, fontPosture, label.getFont().getSize()));
        });

        HBox controls = new HBox(tName, fontNames, tSize, fontSize);
        controls.setSpacing(10);
        controls.setAlignment(Pos.TOP_CENTER);
        
        HBox checkboxes = new HBox(bold, italic);
        checkboxes.setSpacing(10);
        checkboxes.setAlignment(Pos.BOTTOM_CENTER);

        VBox vbox = new VBox(controls, label, checkboxes);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        Scene scene = new Scene(new StackPane(vbox), 500, 150);
        stage.setScene(scene);
        stage.setTitle("Exercise16_14");
        stage.show();
    }
}