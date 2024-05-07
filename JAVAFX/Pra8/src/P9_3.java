
/* 
Create animation in Figure to meet the following requirements:
■ Allow the user to specify the animation speed in a text field.
■ Get the number of iamges and image’s file-name prefix from the user. For example, if the user enters n for the number of images and L for the image prefix, 
then the files are L1.gif, L2.gif, and so on, to Ln.gif. Assume that the images are stored in the image directory, a subdirectory of the program’s class directory. 
The animation displays the images one after the other.
■ Allow the user to specify an audio file URL. The audio is played while the animation runs.
*/
/*
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P9_2.java
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml P9_2
*/
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.*;

public class P9_3 extends Application {
    private int imageCount;
    private String imagePrefix;
    private String audioURL;
    private double animationSpeed;
    Timeline timeline = new Timeline();

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
        Button startButton = new Button("Start Animation");
        VBox vb1 = new VBox(startButton);
        vb1.setAlignment(Pos.TOP_RIGHT);
        
        HBox imageBox = new HBox();
        imageBox.setAlignment(Pos.CENTER);
        imageBox.setPrefWidth(100);
        imageBox.setPrefHeight(100);

        Text textInfo = new Text("Enter information for animation");
        TextField tfSpeed, tfPrefix, tfImage, tfURL;

        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(3);
        gp.add(new Text("Animation speed in milliseconds"), 0, 0);
        gp.add(tfSpeed = new TextField(), 1, 0);
        gp.add(new Text("Image file prefix"), 0, 1);
        gp.add(tfPrefix = new TextField(), 1, 1);
        gp.add(new Text("Number of images"), 0, 2);
        gp.add(tfImage = new TextField(), 1, 2);
        gp.add(new Text("Audio title URL"), 0, 3);
        gp.add(tfURL = new TextField(), 1, 3);

        startButton.setOnAction(event -> {
            animationSpeed = tfSpeed.getText().equals("") ? 0 : Double.parseDouble(tfSpeed.getText());
            imagePrefix = tfPrefix.getText();
            imageCount = tfImage.getText().equals("") ? 0 : Integer.parseInt(tfImage.getText());
            audioURL = tfURL.getText();

            if (!audioURL.isEmpty()) {
                URL audioFile = getClass().getResource(audioURL);
                MediaPlayer mediaPlayer = new MediaPlayer(new Media(audioFile.toString()));
                mediaPlayer.play();
            }

            imageBox.getChildren().clear();
            for (int i = 1; i <= imageCount; i++) {
                Image image = new Image(getClass().getResourceAsStream("/images/" + imagePrefix + i + ".gif"));
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100); 
                imageView.setPreserveRatio(true);
                imageBox.getChildren().add(imageView);
                
                int index = i;
                timeline = new Timeline(new KeyFrame(Duration.millis(animationSpeed),
                    event1 -> {
                        imageView.setImage(new Image(getClass().getResourceAsStream("/images/" + imagePrefix + index + ".gif")));
                    }));
            }
            timeline.play();
        });

        VBox root = new VBox(vb1, imageBox, textInfo, gp);
        root.setPadding(new Insets(5, 5, 5, 5));
        
        Scene scene = new Scene(root, 800, 200);
        tfSpeed.setPrefWidth(scene.getWidth());
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            tfSpeed.setPrefWidth(newVal.doubleValue());
        });
        stage.setScene(scene);
        stage.setTitle("Exercise16_23");
        stage.show();
    }
}