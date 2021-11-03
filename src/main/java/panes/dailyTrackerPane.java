package panes;

import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class dailyTrackerPane extends BorderPane {

    public dailyTrackerPane() {
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        MenuBar menu = new MenuBar();

        Menu dailyTracker = new Menu("Daily Tracker");
        Menu weeklyProgress = new Menu("Weekly Progress");
        Menu addItems = new Menu("Add New Items");
        Menu credits = new Menu("Credits");

        Menu exitMenu = new Menu("Exit");
        MenuItem exit = new MenuItem("Exit Application");
        exit.setOnAction(e-> {
            System.exit(0);
        });
        exitMenu.getItems().add(exit);

        menu.getMenus().addAll(dailyTracker, weeklyProgress, addItems, credits, exitMenu);
        this.setTop(menu);
    }
}
