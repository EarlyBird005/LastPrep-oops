import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.effect.Light.Point;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class x extends Application {
    public void start(Stage stage) {
        Box box = new Box(150, 150, 150);
        // box.translateXProperty().set(300);
        // box.translateYProperty().set(300);
        box.setMaterial(new PhongMaterial(Color.WHEAT));


        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setNearClip(0);
        camera.setFarClip(1000);

        // camera.setTranslateX(300);
        // camera.setTranslateY(300);
        // camera.translateXProperty().set(box.getWidth());
        // camera.translateYProperty().set(box.getHeight());
        // camera.translateZProperty().set(500);
        
        
        Transform trans = new Rotate(10, Rotate.X_AXIS);
        camera.getTransforms().addAll(new Rotate(-10, Rotate.X_AXIS));
        Transform trans2 = new Rotate(15, Rotate.Y_AXIS);
        box.getTransforms().addAll(trans2);

        StackPane g = new StackPane(box);
        g.setAlignment(Pos.CENTER);
        Scene scene = new Scene(g, 600, 600);
        // scene.widthProperty().addListener((obs, oldVal, newVal) -> {
        //     box.setTranslateX(newVal.doubleValue()/2);
        // });
        // scene.heightProperty().addListener((obs, oldVal, newVal) -> {
        //     box.setTranslateY(newVal.doubleValue()/2);
        // });
        scene.setCamera(camera);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
