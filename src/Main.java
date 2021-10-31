import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        MenuBar menu = new MenuBar();

        Menu dailyTracker = new Menu("Daily Tracker");
        Menu weeklyProgress = new Menu("Weekly Progress");
        Menu addItems = new Menu("Add New Items");
        Menu credits = new Menu("Credits");
        Menu exit = new Menu("Exit");
        exit.setOnAction(e-> {
            System.exit(0);
        });

        menu.getMenus().addAll(dailyTracker, weeklyProgress, addItems, credits, exit);
        root.setTop(menu);

        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("Calorie Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
