package panes;

import Models.Day;
import Models.NutritionItem;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import launch.Main;
import scenes.*;
import tables.NutritionTable;

public class dailyTrackerPane extends BorderPane {

    String itemName;
    Day day = Main.activeDay;
    double currentProgress = day.getCurrentCalories();
//    double currentProgress = 250;
    double dailyGoal = day.getCalorieGoal();
    double progressPercentage;
    public TableView tableView;

    public dailyTrackerPane() {
        NutritionTable nutritionTable = new NutritionTable();
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //Content

        GridPane addItem = new GridPane();
        addItem.setPadding(new Insets(10, 10, 10, 10));
        addItem.setHgap(10);

        Text dailyGoalTracker = new Text("Daily Goal Tracker: " + currentProgress + "/" + dailyGoal + "\t\t");
        addItem.add(dailyGoalTracker, 1, 0);

        ProgressBar progressBar = new ProgressBar();
        progressPercentage = (1 / dailyGoal) * currentProgress;
        if(progressPercentage > 1) {
            progressPercentage = 1;
        }
        progressBar.setProgress(progressPercentage);
        progressBar.setPrefWidth(200);
        progressBar.setPrefHeight(20);
        addItem.add(progressBar, 2, 0);

        this.setTop(addItem);

        tableView = new TableView();
        tableView.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        TableColumn<NutritionItem, String> column1 = new TableColumn<>("Name");
        column1.setPrefWidth(340);
        column1.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getName()));

        TableColumn<NutritionItem, String> column2 = new TableColumn<>("Portion");
        column2.setPrefWidth(340);
        column2.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getPortion() + ""));

        TableColumn<NutritionItem, String> column3 = new TableColumn<>("Calories");
        column3.setPrefWidth(340);
        column3.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCalories() + ""));


        tableView.getColumns().addAll(column1, column2, column3);
//        tableView.getItems().addAll(nutritionTable.);
        this.setCenter(tableView);
    }
}
