package panes;

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
    double currentProgress = 1250;
    double dailyGoal = 1250;
    double progressPercentage = (1 / dailyGoal) * currentProgress;

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
        MenuItem addDrink = new MenuItem("Add Drink");
        addDrink.setOnAction(e -> {
            Main.mainStage.setScene(new addDrinkScene());
        });
        MenuItem addGoal = new MenuItem("Add Daily Goal");
        addGoal.setOnAction(e -> {
            Main.mainStage.setScene(new dailyGoalScene());
        });
        addMenu.getItems().addAll(addFood, addDrink, addGoal);


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

        TextField itemNameTF = new TextField();
        itemNameTF.setPromptText("Food/Drink Name");
        addItem.add(itemNameTF, 1, 0);

        Button addItemButton = new Button("Add Item");
        addItemButton.setOnAction(e -> {
            itemName = itemNameTF.getText();
        });
        addItem.add(addItemButton, 2, 0);

        Button clearItemButton = new Button("Clear Item");
        clearItemButton.setOnAction(e -> {
            itemNameTF.clear();
        });
        addItem.add(clearItemButton, 3, 0);

        content.add(addItem, 0, 0);

        Text dailyGoalTracker = new Text("Daily Goal Tracker: " + dailyGoal + "\t");
        content.add(dailyGoalTracker, 1, 0);

        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(progressPercentage);
        progressBar.setPrefWidth(200);
        progressBar.setPrefHeight(20);
        content.add(progressBar, 2, 0);

        this.setCenter(content);
    }
}
