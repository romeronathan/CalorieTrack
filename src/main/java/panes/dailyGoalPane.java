package panes;

import Models.Day;
import Models.Drink;
import Models.NutritionItem;
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

public class dailyGoalPane extends BorderPane {

   //TODO: Will equal to daily goal set in database
    Text currentDailyGoal = new Text();
    Day day = Main.activeDay;
    public TableView tableView;

    int dailyGoalInt = day.getCalorieGoal();
    public dailyGoalPane() {
        NutritionTable nutritionTable = new NutritionTable();
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

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
                day.setCalorieGoal(dailyGoalInt);


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
        GridPane.setConstraints(clear, 2, 0);
        grid.getChildren().add(clear);
        grid.setAlignment(Pos.CENTER);

        currentDailyGoal.setText("Current Daily Goal: " + dailyGoalInt);
        GridPane.setConstraints(currentDailyGoal, 0, 1);
        grid.getChildren().add(currentDailyGoal);

        this.setTop(grid);

        tableView = new TableView();

        TableColumn<NutritionItem, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getName()));

        TableColumn<NutritionItem, String> column2 = new TableColumn<>("Calories");
        column1.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCalories() + ""));

        TableColumn<NutritionItem, String> column3 = new TableColumn<>("Portion");
        column1.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getPortion() + ""));


        tableView.getColumns().addAll(column1, column2, column3);
//        tableView.getItems().addAll(nutritionTable.);


    }
}