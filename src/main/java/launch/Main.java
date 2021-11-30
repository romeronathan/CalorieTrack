package launch;

import Models.Day;
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

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Database db = Database.getInstance();

        BorderPane root = new BorderPane();

        //Menu
        MenuBar menu = new MenuBar();

        Menu exitMenu = new Menu("File");
        MenuItem exit = new MenuItem("Exit Application");
        exit.setOnAction(e-> {
            System.exit(0);
        });
        exitMenu.getItems().addAll(exit);

        menu.getMenus().addAll(exitMenu);
        root.setTop(menu);

        //TabPane

        tabPane = new TabPane();

        dailyTrackerTab dailyTrackerTab = tabs.dailyTrackerTab.getInstance();
        weeklyProgressTab weeklyTrackerTab = tabs.weeklyProgressTab.getInstance();
        addItemTab addItemTab = tabs.addItemTab.getInstance();
        addDayTab addDayTab = tabs.addDayTab.getInstance();
        dailyGoalTab dailyGoalTab = tabs.dailyGoalTab.getInstance();
        creditTab creditTab = tabs.creditTab.getInstance();

        tabPane.getTabs().addAll(dailyTrackerTab, weeklyTrackerTab, addItemTab, addDayTab, dailyGoalTab, creditTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        root.setCenter(tabPane);

        stage.setTitle("Calorie Tracker");
        Scene scene = new Scene(root, DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
        stage.setScene(scene);
        stage.show();

    }

}
