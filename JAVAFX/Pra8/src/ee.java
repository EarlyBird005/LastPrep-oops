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
import java.net.URL;
import javafx.util.*;

public class ee extends Application {
    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int imageCount;
    private String imagePrefix;
    private String audioURL;
    private double animationSpeed;
    Timeline timeline = new Timeline();

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
            imageCount = tfImage.getText().equals("") ? 0 : Integer.parseInt(tfImage.getText());
            imagePrefix = tfPrefix.getText();
            animationSpeed = tfSpeed.getText().equals("") ? 0 : Double.parseDouble(tfSpeed.getText());
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
        stage.show();
    }
}