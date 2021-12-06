package launch;

import Models.Day;
import constants.Const;
import database.Database;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scenes.*;
import tables.DayTable;
import tabs.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author Devon Divinecz & Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description
 */

public class Main extends Application {

    public static TabPane tabPane;
    public static Stage mainStage;
    public static Day activeDay;
    public static Menu activeDayTitle;
    public static MenuBar menu = new MenuBar();
    private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public static BorderPane root;
    public static Scene scene;

    public static dailyTrackerTab dailyTrackerTab;
    public static addItemTab addItemTab;
    public static addDayTab addDayTab;
    public static dailyGoalTab dailyGoalTab;
    public static historyTab historyTab;

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
        root = new BorderPane();

        //Menu

        Menu Menu = new Menu("File");



        MenuItem accountSettings = new MenuItem("Account Settings");
        accountSettings.setOnAction(e -> {
            mainStage.setScene(new accountSettingsScene());
        });

        MenuItem credits = new MenuItem("Credits");
        credits.setOnAction(e -> {
            mainStage.setScene(new creditsScene());
        });

        MenuItem exit = new MenuItem("Exit Application");
        formatter = new SimpleDateFormat("dd MMMM yyyy");
        activeDayTitle = new Menu("Tracking date: " + formatter.format(activeDay.getDate()));

        exit.setOnAction(e-> {
            System.exit(0);
        });
        Menu.getItems().addAll(accountSettings, credits, exit);

        menu.getMenus().addAll(Menu, activeDayTitle);
        root.setTop(menu);

        //TabPane

        tabPane = new TabPane();

        dailyTrackerTab dailyTrackerTab = tabs.dailyTrackerTab.getInstance();
        addItemTab addItemTab = tabs.addItemTab.getInstance();
        addDayTab addDayTab = tabs.addDayTab.getInstance();
        dailyGoalTab dailyGoalTab = tabs.dailyGoalTab.getInstance();
        historyTab historyTab = tabs.historyTab.getInstance();

        tabPane.getTabs().addAll(dailyTrackerTab, addItemTab, addDayTab, dailyGoalTab, historyTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        currentTab();

        root.setCenter(tabPane);

        mainStage = stage;
        stage.setTitle("Calorie Tracker");
        scene = new Scene(root, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);

        stage.setScene(scene);
        stage.show();

    }

    /**
     * @author Nathan Romero
     * @description Method to update the active day in the menu bar
     * @method @updateDate
     * @param day
     */

    public static void updateDate(Day day) {
        formatter = new SimpleDateFormat("dd MMMM yyyy");
        activeDay = day;
        activeDayTitle = new Menu("Tracking date: " + formatter.format(activeDay.getDate()));
        menu.getMenus().remove(1);
        menu.getMenus().add(activeDayTitle);
        dailyTrackerTab tab = dailyTrackerTab.getInstance();
        addDayTab dayTab = addDayTab.getInstance();
        addItemTab itemTab = addItemTab.getInstance();
        dailyGoalTab goalTab = dailyGoalTab.getInstance();
        historyTab historyTab = tabs.historyTab.getInstance();




        tab.refresh();
        dayTab.refresh();
        itemTab.refresh();
        goalTab.refresh();
        historyTab.refresh();
    }

    /**
     * @author Devon Divinecz
     * @description Method to return to the application
     * @method homeMenu
     */

    public static void homeMenu() {
        mainStage.setScene(scene);
    }

    /**
     * @author Devon Divinecz
     * @description Method to return to the application and open a specific tab
     * @method returnToWeeklyProgress
     */

    public static void returnToWeeklyProgress() {
        mainStage.setScene(scene);
        tabPane.getSelectionModel().select(4);
    }

    /**
     * @author Devon Divinecz
     * @description Method to change selected tab style
     * @method currentTab
     */
    public static void currentTab() {
        tabs.dailyTrackerTab.getInstance().setStyle(Const.CURRENT_TAB_STYLE);
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                if (newValue.equals(tabs.dailyTrackerTab.getInstance())) {
                    tabs.dailyTrackerTab.getInstance().setStyle(Const.CURRENT_TAB_STYLE);
                    tabs.addItemTab.getInstance().setStyle("");
                    tabs.addDayTab.getInstance().setStyle("");
                    tabs.dailyGoalTab.getInstance().setStyle("");
                    tabs.historyTab.getInstance().setStyle("");
                }
                else if (newValue.equals(tabs.addItemTab.getInstance())) {
                    tabs.addItemTab.getInstance().setStyle(Const.CURRENT_TAB_STYLE);
                    tabs.dailyTrackerTab.getInstance().setStyle("");
                    tabs.addDayTab.getInstance().setStyle("");
                    tabs.dailyGoalTab.getInstance().setStyle("");
                    tabs.historyTab.getInstance().setStyle("");
                }
                else if (newValue.equals(tabs.addDayTab.getInstance())) {
                    tabs.addDayTab.getInstance().setStyle(Const.CURRENT_TAB_STYLE);
                    tabs.dailyTrackerTab.getInstance().setStyle("");
                    tabs.addItemTab.getInstance().setStyle("");
                    tabs.dailyGoalTab.getInstance().setStyle("");
                    tabs.historyTab.getInstance().setStyle("");
                }
                else if (newValue.equals(tabs.dailyGoalTab.getInstance())) {
                    tabs.dailyGoalTab.getInstance().setStyle(Const.CURRENT_TAB_STYLE);
                    tabs.dailyTrackerTab.getInstance().setStyle("");
                    tabs.addItemTab.getInstance().setStyle("");
                    tabs.addDayTab.getInstance().setStyle("");
                    tabs.historyTab.getInstance().setStyle("");
                }
                else if (newValue.equals(tabs.historyTab.getInstance())) {
                    tabs.historyTab.getInstance().setStyle(Const.CURRENT_TAB_STYLE);
                    tabs.dailyTrackerTab.getInstance().setStyle("");
                    tabs.addItemTab.getInstance().setStyle("");
                    tabs.addDayTab.getInstance().setStyle("");
                    tabs.dailyGoalTab.getInstance().setStyle("");
                }
            }
        });
    }

}
