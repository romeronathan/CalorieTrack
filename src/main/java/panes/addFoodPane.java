package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final TextField foodName = new TextField();
        foodName.setPromptText("Name");
        foodName.setPrefColumnCount(10);
        foodName.getText();
        GridPane.setConstraints(foodName, 0, 0);
        grid.getChildren().add(foodName);

        final TextField foodCalories = new TextField();
        foodCalories.setPromptText("Calories");
        GridPane.setConstraints(foodCalories, 0, 1);
        grid.getChildren().add(foodCalories);

        final TextField foodPortion = new TextField();
        foodPortion.setPrefColumnCount(15);
        foodPortion.setPromptText("Portion");
        GridPane.setConstraints(foodPortion, 0, 2);
        grid.getChildren().add(foodPortion);

        Button submitFood = new Button("Submit");
        GridPane.setConstraints(submitFood, 1, 0);
        grid.getChildren().add(submitFood);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);

        this.setCenter(grid);


    }
}
