package panes;

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

public class addDrinkPane extends BorderPane {
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

        final TextField drinkName = new TextField();
        drinkName.setPromptText("Name");
        drinkName.setPrefColumnCount(10);
        drinkName.getText();
        GridPane.setConstraints(drinkName, 0, 0);
        grid.getChildren().add(drinkName);

        final TextField drinkCalories = new TextField();
        drinkCalories.setPromptText("Calories");
        GridPane.setConstraints(drinkCalories, 0, 1);
        grid.getChildren().add(drinkCalories);

        final TextField drinkServing = new TextField();
        drinkServing.setPrefColumnCount(15);
        drinkServing.setPromptText("Serving");
        GridPane.setConstraints(drinkServing, 0, 2);
        grid.getChildren().add(drinkServing);

        Text missingInfo = new Text();
        missingInfo.setFill(Color.RED);

        Button submitDrink = new Button("Submit");
        submitDrink.setOnAction(e -> {
            if(drinkName.getText().isEmpty() || drinkCalories.getText().isEmpty() || drinkServing.getText().isEmpty()) {
                missingInfo.setText("Missing Information");
            } else {

            }

        });
        GridPane.setConstraints(submitDrink, 1, 0);
        grid.getChildren().add(submitDrink);


        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);
        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);

    }
}
