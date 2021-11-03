package launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scenes.dailyTrackerScene;

import java.io.IOException;

public class Main extends Application {

    public static Stage mainStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        mainStage.setTitle("Calorie Tracker");
        mainStage.setScene(new dailyTrackerScene());
        mainStage.show();
    }

}
