import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class y extends Application {
    @Override
    public void start(Stage stage) {
        Box box = new Box(200, 200, 200);
        box.setMaterial(new PhongMaterial(Color.WHEAT));
        box.autosize();
        
        box.setStyle("-fx-border-width: black;" + "-fx-border-width: 5px;");
        box.setRotate(45);
        box.setRotationAxis(new Point3D(1, 3, 0));


        PerspectiveCamera camera = new PerspectiveCamera();
        // camera.setFieldOfView(45);
        // camera.setTranslateZ(-100);

        
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(box);

        Scene scene = new Scene(root, 500, 300);
        scene.setCamera(camera);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
