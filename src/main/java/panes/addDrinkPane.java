package panes;

import Models.Day;
import Models.Drink;
import Models.NutritionItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import launch.Main;
import scenes.*;
import tables.DayTable;

public class addDrinkPane extends BorderPane {

    String drinkName;
    int drinkCalories;
    int drinkServing;
    Day day = Main.activeDay;

    public addDrinkPane() {
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

        final TextField drinkNameTF = new TextField();
        drinkNameTF.setPromptText("Name");
        drinkNameTF.setPrefColumnCount(10);
        drinkNameTF.getText();
        GridPane.setConstraints(drinkNameTF, 0, 0);
        grid.getChildren().add(drinkNameTF);

        final TextField drinkCaloriesTF = new TextField();
        drinkCaloriesTF.setPromptText("Calories");
        GridPane.setConstraints(drinkCaloriesTF, 0, 1);
        grid.getChildren().add(drinkCaloriesTF);

        final TextField drinkServingTF = new TextField();
        drinkServingTF.setPrefColumnCount(15);
        drinkServingTF.setPromptText("Serving");
        GridPane.setConstraints(drinkServingTF, 0, 2);
        grid.getChildren().add(drinkServingTF);


        Button submitDrink = new Button("Submit");
        submitDrink.setOnAction(e -> {
            if(drinkNameTF.getText().isEmpty() || drinkCaloriesTF.getText().isEmpty() || drinkServingTF.getText().isEmpty()) {
                if(drinkNameTF.getText().isEmpty()) {
                    drinkNameTF.setPromptText("Please Enter a Name");
                }
                if(drinkCaloriesTF.getText().isEmpty()) {
                    drinkCaloriesTF.setPromptText("Please Enter Calories");
                }
                if(drinkServingTF.getText().isEmpty()) {
                    drinkServingTF.setPromptText("Please Enter Serving");
                }
            } else {
                drinkName = drinkNameTF.getText();
                drinkCalories = Integer.parseInt(drinkCaloriesTF.getText());
                drinkServing = Integer.parseInt(drinkServingTF.getText());

                //TODO Save drinkName, drinkCalories, drinkServing to database
                Drink drink = new Drink(drinkName, drinkCalories, drinkServing, day.getId());

                drinkNameTF.clear();
                drinkCaloriesTF.clear();
                drinkServingTF.clear();
            }

        });
        GridPane.setConstraints(submitDrink, 1, 0);
        grid.getChildren().add(submitDrink);


        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            drinkNameTF.clear();
            drinkCaloriesTF.clear();
            drinkServingTF.clear();
        });
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);
        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);

    }
}
