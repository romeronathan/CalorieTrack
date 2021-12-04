package panes;

import Models.Day;
import Models.NutritionItem;
import constants.Const;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import launch.Main;
import scenes.*;
import tables.DayTable;
import tables.NutritionTable;

import java.util.ArrayList;

public class dailyTrackerPane extends BorderPane {

    String itemName;
    Day day = Main.activeDay;
    double currentProgress;
//    double currentProgress = 250;
    double dailyGoal = day.getCalorieGoal();
    double progressPercentage;
    public static Text deletedRecord;
    public TableView tableView;
    PieChart breakdownChart;
    ObservableList<PieChart.Data> pieChartData;

    public dailyTrackerPane() {
        NutritionTable nutritionTable = new NutritionTable();
        ArrayList<NutritionItem> items = new DayTable().getDayItems(Main.activeDay.getId());
        this.setStyle(Const.BACKGROUND_STYLE);

        for (NutritionItem item: items) {
            currentProgress += item.getCalories();
        }


        //Content

        GridPane addItem = new GridPane();
        addItem.setPadding(new Insets(10, 10, 10, 10));
        addItem.setHgap(10);

        Text dailyGoalTracker = new Text("Daily Goal Tracker: " + currentProgress + "/" + dailyGoal + "\t\t");
        dailyGoalTracker.setStyle(Const.TEXT_STYLE);
        addItem.add(dailyGoalTracker, 1, 0);

        ProgressBar progressBar = new ProgressBar();
        progressPercentage = (1 / dailyGoal) * currentProgress;
        if(progressPercentage > 1) {
            progressPercentage = 1;
        }
        if(currentProgress > dailyGoal) {
            progressBar.setStyle(Const.PROGRESS_BAR_RED);
        } else {
            progressBar.setStyle(Const.PROGRESS_BAR_GREEN);
        }
        progressBar.setProgress(progressPercentage);
        progressBar.setPrefWidth(200);
        progressBar.setPrefHeight(20);
        addItem.add(progressBar, 2, 0);

        deletedRecord = new Text("\tRecord Deleted!");
        deletedRecord.setStyle(Const.DELETE_RECORD_STYLE);
        deletedRecord.setVisible(false);
        addItem.add(deletedRecord, 3, 0);

        this.setTop(addItem);

        tableView = new TableView();
        tableView.setStyle(Const.BACKGROUND_STYLE);

        TableColumn<NutritionItem, String> column1 = new TableColumn<>("Name");
        column1.setPrefWidth(118);
        column1.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getName()));

        TableColumn<NutritionItem, String> column2 = new TableColumn<>("Portion");
        column2.setPrefWidth(118);
        column2.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getPortion() + ""));

        TableColumn<NutritionItem, String> column3 = new TableColumn<>("Calories");
        column3.setPrefWidth(118);
        column3.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCalories() + ""));

        TableColumn<NutritionItem, String> column4 = new TableColumn<>("Type");
        column4.setPrefWidth(118);
        column4.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getType()));

        TableColumn column5 = new TableColumn<>("Delete Records");
        column5.setPrefWidth(100);
        column5.setCellValueFactory(new PropertyValueFactory<NutritionItem, String>("deleteButton"));
        column5.setStyle(Const.CENTER_ALIGNMENT_STYLE);

        TableColumn column6 = new TableColumn<>("Update Records");
        column6.setPrefWidth(100);
        column6.setCellValueFactory(new PropertyValueFactory<NutritionItem, String>("updateButton"));
        column6.setStyle(Const.CENTER_ALIGNMENT_STYLE);


        tableView.getColumns().addAll(column1, column2, column3, column4, column5, column6);

        tableView.getItems().addAll(items);
        this.setCenter(tableView);

        breakdownChart = new PieChart();
        breakdownChart.setTitle("Calorie Intake Breakdown");
        breakdownChart.setLabelsVisible(true);
        breakdownChart.setPrefWidth(350);
        breakdownChart.setStyle(Const.CHART_STYLE);
        this.setRight(breakdownChart);
        generateChart();

    }

    public void refreshTable(){
        ArrayList<NutritionItem> items = new DayTable().getDayItems(Main.activeDay.getId());
        System.out.println("MAde it here");

        currentProgress = 0;
        dailyGoal = 0;
        tableView.getItems().clear();
        tableView.getItems().addAll(items);

    }

    public void generateChart() {
        ArrayList<NutritionItem> items = new DayTable().getDayItems(Main.activeDay.getId());

        int mealCalories = 0;
        int snackCalories = 0;
        int drinkCalories = 0;

        for(NutritionItem i : items) {
            if(i.getType().equals("meal")) {
                mealCalories += i.getCalories();
            }
            else if(i.getType().equals("snack")) {
                snackCalories += i.getCalories();
            }
            else if(i.getType().equals("drink")) {
                drinkCalories += i.getCalories();
            }
        }
//        System.out.println("Meal Calories: " + mealCalories + " Snack Calories: " + snackCalories + " Drink Calories: " + drinkCalories);

        pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Meal", mealCalories),
                new PieChart.Data("Snack", snackCalories),
                new PieChart.Data("Drink", drinkCalories)
        );

        breakdownChart.setData(pieChartData);
    }

}
