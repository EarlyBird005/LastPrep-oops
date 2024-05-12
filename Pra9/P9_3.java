/* 
Create animation in Figure to meet the following requirements:
■ Allow the user to specify the animation speed in a text field.
■ Get the number of iamges and image’s file-name prefix from the user. For example, if the user enters n for the number of images and L for the image prefix, 
then the files are L1.gif, L2.gif, and so on, to Ln.gif. Assume that the images are stored in the image directory, a subdirectory of the program’s class directory. 
The animation displays the images one after the other.
■ Allow the user to specify an audio file URL. The audio is played while the animation runs.
*/
/*
javac --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml,javafx.media P9_3.java
java --module-path "D:\openjfx-21.0.2_windows-x64_bin-sdk\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml,javafx.media P9_3
*/
// https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3

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
import java.io.File;
import java.util.*;

public class P9_3 extends Application {
    private Timeline timeline = new Timeline();
    private MediaPlayer mediaPlayer;

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
        imageBox.setPrefWidth(400);
        imageBox.setPrefHeight(400);

        VBox vb2 = new VBox(new Text("Enter information for animation"));
        vb2.setAlignment(Pos.CENTER_LEFT);

        TextField tfSecond, tfPrefix, tfImage, tfURL;
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(3);
        gp.add(new Text("Animation speed in milliseconds"), 0, 0);
        gp.add(tfSecond = new TextField(), 1, 0);
        gp.add(new Text("Image file prefix"), 0, 1);
        gp.add(tfPrefix = new TextField(), 1, 1);
        gp.add(new Text("Number of images"), 0, 2);
        gp.add(tfImage = new TextField(), 1, 2);
        gp.add(new Text("Audio title URL"), 0, 3);
        gp.add(tfURL = new TextField(), 1, 3);

        startButton.setOnAction(event -> {
            imageBox.getChildren().clear();
            timeline.getKeyFrames().clear();
            int animationSpeed = tfSecond.getText().equals("") ? 0 : Integer.parseInt(tfSecond.getText());
            String imagePrefix = tfPrefix.getText();
            int imageCount = tfImage.getText().equals("") ? 0 : Integer.parseInt(tfImage.getText());
            String audioURL = tfURL.getText().contains("http") ? tfURL.getText() : changeToPath(tfURL.getText());

            if (!audioURL.isEmpty()) {
                try {
                    if (audioURL.contains("http")) {
                        mediaPlayer = new MediaPlayer(new Media(audioURL));
                        mediaPlayer.play();
                    } else {
                        File file = new File(audioURL);
                        mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
                        mediaPlayer.play();
                    }
                } catch (Exception e) {
                    System.err.println("Error occurred while playing: " + e.getMessage());
                }
            }

            for (int i = 1; i <= imageCount; i++) {
                int index = i;
                timeline.getKeyFrames().add(new KeyFrame(Duration.millis(animationSpeed * i), e -> {
                    ImageView imageView = new ImageView(new Image("/images/" + imagePrefix + index + ".gif"));
                    imageView.setFitWidth(100);
                    imageView.setPreserveRatio(true);
                    imageBox.getChildren().clear();
                    imageBox.getChildren().add(imageView);
                }));
            }
            timeline.playFromStart();
            timeline.setOnFinished(e1 -> {
                if (!audioURL.isEmpty()) {
                    mediaPlayer.stop();
                }
            });
        });

        VBox root = new VBox(vb1, imageBox, vb2, gp);
        root.setPadding(new Insets(5, 5, 5, 5));
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 800, 200);
        tfSecond.setPrefWidth(scene.getWidth());
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            tfSecond.setPrefWidth(newVal.doubleValue());
        });
        imageBox.heightProperty().addListener((obs, oldVal, newVal) -> {
            if (!imageBox.getChildren().isEmpty()) {
                scene.getWindow().setHeight(scene.getHeight() + newVal.doubleValue());
            }
        });
        stage.setTitle("Exercise16_23");
        stage.setScene(scene);
        stage.show();
    }

    private static String changeToPath(String str) {
        if (str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }
}