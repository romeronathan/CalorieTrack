package launch;

import Models.Day;
import database.DBConst;
import database.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import scenes.*;
import tables.DayTable;
import tabs.*;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Main extends Application {

    public static TabPane tabPane;
    public static Stage mainStage;
    public static Day activeDay;
    public static Menu activeDayTitle;
    public static MenuBar menu = new MenuBar();
    private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Database db = Database.getInstance();

        BorderPane root = new BorderPane();
        if(activeDay == null) {
            activeDay = new DayTable().getRecentDay();
        }
        //Menu

        Menu exitMenu = new Menu("File");
        Menu blankMenu = new Menu(" ");
        MenuItem exit = new MenuItem("Exit Application");
        formatter = new SimpleDateFormat("dd MMMM yyyy");
        activeDayTitle = new Menu("Tracking date: " + formatter.format(activeDay.getDate()));

        exit.setOnAction(e-> {
            System.exit(0);
        });
        exitMenu.getItems().addAll(exit);

        menu.getMenus().addAll(exitMenu, blankMenu, activeDayTitle);
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
    public static void updateDate(Day day) {
        formatter = new SimpleDateFormat("dd MMMM yyyy");
        activeDay = day;
        activeDayTitle = new Menu("Tracking date: " + formatter.format(activeDay.getDate()));
        menu.getMenus().remove(1);
        menu.getMenus().add(activeDayTitle);
    }
}
