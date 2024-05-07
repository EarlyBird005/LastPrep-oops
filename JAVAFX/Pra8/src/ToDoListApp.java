import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ToDoListApp extends Application {

    private List<Task> tasks = new ArrayList<>();
    private ComboBox<String> filterComboBox;
    private BorderPane root = new BorderPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root.setStyle("-fx-background-color: black");

        // Header
        Label header = new Label("To-Do List");
        header.setStyle("-fx-text-fill: #FF11A7; -fx-font-size: 30px; -fx-font-family: 'Monoton'");
        BorderPane.setAlignment(header, Pos.CENTER);
        root.setTop(header);

        // Center - Tasks List
        VBox tasksContainer = new VBox(10);
        tasksContainer.setPadding(new Insets(10));
        tasksContainer.setAlignment(Pos.CENTER);
        root.setCenter(tasksContainer);

        // Bottom - Control Buttons
        HBox controlButtons = new HBox(10);
        controlButtons.setAlignment(Pos.CENTER);
        controlButtons.setPadding(new Insets(10));
        Button shareButton = new Button("Share on WhatsApp");
        Button clearButton = new Button("Clear Data");
        controlButtons.getChildren().addAll(shareButton, clearButton);
        root.setBottom(controlButtons);

        // Filter ComboBox
        filterComboBox = new ComboBox<>();
        filterComboBox.getItems().addAll("All", "Active", "Completed");
        filterComboBox.setValue("All");
        filterComboBox.setOnAction(e -> filterTasks());
        controlButtons.getChildren().add(filterComboBox);

        // Scene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("To-Do List");
        primaryStage.show();

        // Event Handlers
        shareButton.setOnAction(e -> shareOnWhatsApp());
        clearButton.setOnAction(e -> clearData());

        // Initial Rendering
        renderTasks();
    }

    private void renderTasks() {
        VBox tasksContainer = (VBox) root.getCenter();
        tasksContainer.getChildren().clear();

        for (Task task : tasks) {
            Label taskLabel = new Label(task.getText() + " (Importance: " + task.getImportance() + ")");
            Button completeButton = new Button(task.isCompleted() ? "Uncomplete" : "Complete");
            Button deleteButton = new Button("Delete");

            HBox taskBox = new HBox(10);
            taskBox.getChildren().addAll(taskLabel, completeButton, deleteButton);
            tasksContainer.getChildren().add(taskBox);

            completeButton.setOnAction(e -> {
                task.setCompleted(!task.isCompleted());
                renderTasks();
            });

            deleteButton.setOnAction(e -> {
                tasks.remove(task);
                renderTasks();
            });
        }
    }

    private void filterTasks() {
        String filter = filterComboBox.getValue();
        List<Task> filteredTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (filter.equals("All") ||
                    (filter.equals("Active") && !task.isCompleted()) ||
                    (filter.equals("Completed") && task.isCompleted())) {
                filteredTasks.add(task);
            }
        }

        renderTasks(filteredTasks);
    }

    private void renderTasks(List<Task> filteredTasks) {
        VBox tasksContainer = (VBox) root.getCenter();
        tasksContainer.getChildren().clear();

        for (Task task : filteredTasks) {
            Label taskLabel = new Label(task.getText() + " (Importance: " + task.getImportance() + ")");
            Button completeButton = new Button(task.isCompleted() ? "Uncomplete" : "Complete");
            Button deleteButton = new Button("Delete");

            HBox taskBox = new HBox(10);
            taskBox.getChildren().addAll(taskLabel, completeButton, deleteButton);
            tasksContainer.getChildren().add(taskBox);

            completeButton.setOnAction(e -> {
                task.setCompleted(!task.isCompleted());
                renderTasks(filteredTasks);
            });

            deleteButton.setOnAction(e -> {
                tasks.remove(task);
                renderTasks(filteredTasks);
            });
        }
    }

    private void shareOnWhatsApp() {
        // Share tasks on WhatsApp
    }

    private void clearData() {
        tasks.clear();
        renderTasks();
    }

    private static class Task {
        private String text;
        private int importance;
        private boolean completed;

        @SuppressWarnings("unused")
        public Task(String text, int importance) {
            this.text = text;
            this.importance = importance;
        }

        public String getText() {
            return text;
        }

        public int getImportance() {
            return importance;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }
}