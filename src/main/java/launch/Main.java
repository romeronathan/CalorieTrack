package launch;

import Models.Day;
import database.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scenes.dailyTrackerScene;
import tables.DayTable;

import java.io.IOException;

public class Main extends Application {



    public static Stage mainStage;
    public static Day activeDay = new DayTable().getRecentDay();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Database db = Database.getInstance();

        mainStage = stage;
        mainStage.setTitle("Calorie Tracker");
        mainStage.setScene(new dailyTrackerScene());
        mainStage.show();

    }

}
