import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;

// @SuppressWarnings("unused")
public class Main extends Application {
    public static void main(String[] args) {launch(args);}

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    public void start(Stage stage) {
        file = new File("D:\\Deepak\\Songs\\As It Was.mp3");
        System.out.println(file.exists());
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        Button btn = new Button("Start");
        btn.setOnAction(e -> {
            mediaPlayer.play();
        });
        Button btn2 = new Button("Stop");
        btn2.setOnAction(e -> {
            mediaPlayer.stop();
        });
        Scene scene = new Scene(new VBox(btn, btn2));
        stage.setScene(scene);
        stage.show();
    }
}
