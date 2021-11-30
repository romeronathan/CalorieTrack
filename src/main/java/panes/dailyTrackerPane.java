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

        //Content

        GridPane content = new GridPane();

        GridPane addItem = new GridPane();
        addItem.setPadding(new Insets(10, 10, 10, 10));
        addItem.setHgap(10);
        content.add(addItem, 0, 0);

        Text dailyGoalTracker = new Text("Daily Goal Tracker: " + currentProgress + "\t");
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
