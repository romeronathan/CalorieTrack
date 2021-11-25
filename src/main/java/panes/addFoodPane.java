package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import launch.Main;
import scenes.*;

public class addFoodPane extends BorderPane {

    String foodName;
    int foodCalories;
    int foodPortion;

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

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final TextField foodNameTF = new TextField();
        foodNameTF.setPromptText("Name");
        foodNameTF.setPrefColumnCount(10);
        foodNameTF.getText();
        GridPane.setConstraints(foodNameTF, 0, 0);
        grid.getChildren().add(foodNameTF);

        final TextField foodCaloriesTF = new TextField();
        foodCaloriesTF.setPromptText("Calories");
        GridPane.setConstraints(foodCaloriesTF, 0, 1);
        grid.getChildren().add(foodCaloriesTF);

        final TextField foodPortionTF = new TextField();
        foodPortionTF.setPrefColumnCount(15);
        foodPortionTF.setPromptText("Portion");
        GridPane.setConstraints(foodPortionTF, 0, 2);
        grid.getChildren().add(foodPortionTF);

        Button submitFood = new Button("Submit");
        submitFood.setOnAction(e -> {
            if(foodNameTF.getText().isEmpty() || foodCaloriesTF.getText().isEmpty() || foodPortionTF.getText().isEmpty()) {
                if(foodNameTF.getText().isEmpty()) {
                    foodNameTF.setPromptText("Please Enter Name");
                }
                if(foodCaloriesTF.getText().isEmpty()) {
                    foodCaloriesTF.setPromptText("Please Enter Calories");
                }
                if(foodPortionTF.getText().isEmpty()) {
                    foodPortionTF.setPromptText("Please Enter Portion");
                }
            } else {
                foodName = foodNameTF.getText();
                foodCalories = Integer.parseInt(foodCaloriesTF.getText());
                foodPortion = Integer.parseInt(foodPortionTF.getText());
                //TODO Save foodName, foodCalories, foodPortion to database
                foodNameTF.clear();
                foodCaloriesTF.clear();
                foodPortionTF.clear();
            }
        });
        GridPane.setConstraints(submitFood, 1, 0);
        grid.getChildren().add(submitFood);

        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            foodNameTF.clear();
            foodCaloriesTF.clear();
            foodPortionTF.clear();
        });
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);
        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);


    }
}
