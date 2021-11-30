package panes;

import Models.Day;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import launch.Main;
import scenes.*;

public class dailyTrackerPane extends BorderPane {

    String itemName;
    Day day = Main.activeDay;
    double currentProgress = day.getCurrentCalories();
    double dailyGoal = day.getCalorieGoal();
    double progressPercentage;

    public dailyTrackerPane() {
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
        MenuItem addGoal = new MenuItem("Add Daily Goal");
        addGoal.setOnAction(e -> {
            Main.mainStage.setScene(new dailyGoalScene());
        });
        addMenu.getItems().addAll(addFood, addGoal);


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

        GridPane content = new GridPane();

        GridPane addItem = new GridPane();
        addItem.setPadding(new Insets(10, 10, 10, 10));
        addItem.setHgap(10);





        content.add(addItem, 0, 0);

        Text dailyGoalTracker = new Text("Daily Goal Tracker: " + dailyGoal + "\t");
        content.add(dailyGoalTracker, 1, 0);

        ProgressBar progressBar = new ProgressBar();
        progressPercentage = (1 / dailyGoal) * currentProgress;
        if(progressPercentage > 1) {
            progressPercentage = 1;
        }
        progressBar.setProgress(progressPercentage);
        progressBar.setPrefWidth(200);
        progressBar.setPrefHeight(20);
        content.add(progressBar, 2, 0);

        this.setCenter(content);
    }
}
