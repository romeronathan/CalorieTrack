package launch;

import Models.Day;
import constants.Const;
import database.DBConst;
import database.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scenes.*;
import tables.DayTable;
import tabs.*;

import java.io.IOException;

public class Main extends Application {

    public static TabPane tabPane;
    public static Stage mainStage;
    public static Day activeDay = new DayTable().getRecentDay();
    public static BorderPane root;
    public static Scene scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Database db = Database.getInstance();

        root = new BorderPane();

        //Menu
        MenuBar menu = new MenuBar();

        Menu Menu = new Menu("File");

        MenuItem credits = new MenuItem("Credits");
        credits.setOnAction(e -> {
            mainStage.setScene(new creditsScene());
        });

        MenuItem exit = new MenuItem("Exit Application");
        exit.setOnAction(e-> {
            System.exit(0);
        });
        Menu.getItems().addAll(credits, exit);

        menu.getMenus().addAll(Menu);
        root.setTop(menu);

        //TabPane

        tabPane = new TabPane();

        dailyTrackerTab dailyTrackerTab = tabs.dailyTrackerTab.getInstance();
        weeklyProgressTab weeklyTrackerTab = tabs.weeklyProgressTab.getInstance();
        addItemTab addItemTab = tabs.addItemTab.getInstance();
        addDayTab addDayTab = tabs.addDayTab.getInstance();
        dailyGoalTab dailyGoalTab = tabs.dailyGoalTab.getInstance();

        tabPane.getTabs().addAll(dailyTrackerTab, weeklyTrackerTab, addItemTab, addDayTab, dailyGoalTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        root.setCenter(tabPane);

        mainStage = stage;
        stage.setTitle("Calorie Tracker");
        scene = new Scene(root, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        stage.setScene(scene);
        stage.show();

    }

    public static void homeMenu() {
        mainStage.setScene(scene);
    }

}
