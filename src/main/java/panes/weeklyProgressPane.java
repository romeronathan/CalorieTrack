package panes;

import Models.Day;
import Models.NutritionItem;
import constants.Const;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import launch.Main;
import scenes.*;
import tables.DayTable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class weeklyProgressPane extends BorderPane {

    public TableView tableView;
    private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public weeklyProgressPane() {
        this.setBackground(new Background(new BackgroundFill(Const.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        ArrayList<Day> days = new DayTable().getAllDays();

        //Content

        tableView = new TableView();
        tableView.setBackground(new Background(new BackgroundFill(Const.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        TableColumn<Day, String> column1 = new TableColumn<>("Day");
        column1.setCellValueFactory(e -> new SimpleStringProperty(formatter.format(e.getValue().getDate()) + ""));
        column1.setPrefWidth(256);

        TableColumn<Day, String> column2 = new TableColumn<>("Calorie Consumption");
        column2.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCurrentCalories() + ""));
        column2.setPrefWidth(256);

        TableColumn<Day, String> column3 = new TableColumn<>("Calorie Goal");
        column3.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCalorieGoal() + ""));
        column3.setPrefWidth(256);

        TableColumn<Day, String> column4 = new TableColumn<>("Goal Status");
        //TODO set checkmark image or xmark image for if goal is met or not
//        column4.setCellValueFactory(e -> new SimpleStringProperty());
        column4.setPrefWidth(128);

        TableColumn<Day, String> column5 = new TableColumn<>("View Day");
        column5.setCellValueFactory(e -> new SimpleStringProperty());
        column5.setPrefWidth(128);



        tableView.getColumns().addAll(column1, column2, column3, column4, column5);
        tableView.getItems().addAll(days);
        this.setCenter(tableView);

    }

}
