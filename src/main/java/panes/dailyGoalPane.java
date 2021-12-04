package panes;

import Models.Day;
import Models.Drink;
import Models.NutritionItem;
import constants.Const;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import launch.Main;
import scenes.*;
import tables.DayTable;
import tables.NutritionTable;
import tabs.dailyTrackerTab;

/**
 * @author Devon Divinecz & Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description Pane to set the daily calorie goal for the user
 */

public class dailyGoalPane extends BorderPane {

   //TODO: Will equal to daily goal set in database
    Text currentDailyGoal = new Text();
    Day day = Main.activeDay;

    int dailyGoalInt = day.getCalorieGoal();
    public dailyGoalPane() {
        this.setStyle(Const.BACKGROUND_STYLE);

        //Content
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(5);

        final TextField dailyGoal = new TextField();
        dailyGoal.setPromptText("Daily Calorie Goal");
        dailyGoal.setStyle(Const.TEXT_STYLE);
        dailyGoal.setPrefColumnCount(10);
        dailyGoal.getText();
        GridPane.setConstraints(dailyGoal, 0, 0);
        grid.getChildren().add(dailyGoal);

        Button submitDailyGoal = new Button("Submit");
        submitDailyGoal.setStyle(Const.BUTTON_STYLE);
        submitDailyGoal.setOnAction(e -> {
            if(dailyGoal.getText().isEmpty()) {
                dailyGoal.setPromptText("Please enter a daily calorie goal");
            } else {
                dailyGoalInt = Integer.parseInt(dailyGoal.getText());
                currentDailyGoal.setText("Current Daily Goal: " + dailyGoalInt);
                day.setCalorieGoal(dailyGoalInt);
                dailyTrackerTab tab = dailyTrackerTab.getInstance();
                tab.refresh();

                dailyGoal.clear();
                //TODO: Save daily goal to database

                try {
                    new DayTable().updateDay(day);
                    Main.activeDay = day;
                    currentDailyGoal.setText("Current Daily Goal: " + dailyGoalInt);
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        });
        GridPane.setConstraints(submitDailyGoal, 1, 0);
        grid.getChildren().add(submitDailyGoal);

        Button clear = new Button("Clear");
        clear.setStyle(Const.BUTTON_STYLE);
        GridPane.setConstraints(clear, 2, 0);
        grid.getChildren().add(clear);
        grid.setAlignment(Pos.CENTER);

        currentDailyGoal.setText("Current Daily Goal: " + dailyGoalInt);
        currentDailyGoal.setStyle(Const.TEXT_STYLE);
        GridPane.setConstraints(currentDailyGoal, 0, 1);
        grid.getChildren().add(currentDailyGoal);

        this.setCenter(grid);

    }
}