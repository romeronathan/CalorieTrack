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
import launch.Main;
import scenes.*;

public class addFoodPane extends BorderPane {
    public addFoodPane() {
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //Menu Bar
        MenuBar menu = new MenuBar();

        //Tracker Menu
        Menu trackerMenu = new Menu("Tracker");
        MenuItem dailyTracker = new MenuItem("Daily Tracker");
        dailyTracker.setOnAction(e -> {
            Main.mainStage.setScene(new dailyTrackerScene());
        });
        MenuItem weeklyProgress = new MenuItem("Weekly Progress");
        weeklyProgress.setOnAction(e -> {
            Main.mainStage.setScene(new weeklyProgressScene());
        });
        trackerMenu.getItems().addAll(dailyTracker, weeklyProgress);

        //Add Items Menu
        Menu addMenu = new Menu("Add");
        MenuItem addFood = new MenuItem("Add Food");
        addFood.setOnAction(e -> {
            Main.mainStage.setScene(new addFoodScene());
        });
        MenuItem addDrink = new MenuItem("Add Drink");
        addDrink.setOnAction(e -> {
            Main.mainStage.setScene(new addDrinkScene());
                });
        addMenu.getItems().addAll(addFood, addDrink);


        //Exit Menu
        Menu exitMenu = new Menu("Exit");
        MenuItem credits = new MenuItem("Credits");
        credits.setOnAction(e -> {
            Main.mainStage.setScene(new creditsScene());
        });
        MenuItem exit = new MenuItem("Exit Application");
        exit.setOnAction(e-> {
            System.exit(0);
        });
        exitMenu.getItems().addAll(credits, exit);

        menu.getMenus().addAll(trackerMenu, addMenu, exitMenu);
        this.setTop(menu);

        //Content


    }
}
