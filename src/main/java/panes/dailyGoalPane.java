package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import launch.Main;
import scenes.*;

public class dailyGoalPane extends BorderPane {

    double dailyGoalInt; //TODO: Will equal to daily goal set in database
    Text currentDailyGoal = new Text();

    public dailyGoalPane() {
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
        grid.setHgap(5);

        final TextField dailyGoal = new TextField();
        dailyGoal.setPromptText("Daily Calorie Goal");
        dailyGoal.setPrefColumnCount(10);
        dailyGoal.getText();
        GridPane.setConstraints(dailyGoal, 0, 0);
        grid.getChildren().add(dailyGoal);

        Button submitDailyGoal = new Button("Submit");
        submitDailyGoal.setOnAction(e -> {
            if(dailyGoal.getText().isEmpty()) {
                dailyGoal.setPromptText("Please enter a daily calorie goal");
            } else {
                dailyGoalInt = Integer.parseInt(dailyGoal.getText());
                currentDailyGoal.setText("Current Daily Goal: " + dailyGoalInt);
                dailyGoal.clear();
                //TODO: Save daily goal to database
            }
        });
        GridPane.setConstraints(submitDailyGoal, 1, 0);
        grid.getChildren().add(submitDailyGoal);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 2, 0);
        grid.getChildren().add(clear);
        grid.setAlignment(Pos.CENTER);

        currentDailyGoal.setText("Current Daily Goal: " + dailyGoalInt);
        GridPane.setConstraints(currentDailyGoal, 0, 1);
        grid.getChildren().add(currentDailyGoal);

        this.setCenter(grid);

    }
}