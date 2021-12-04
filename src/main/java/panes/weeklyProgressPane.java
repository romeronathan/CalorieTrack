package panes;

import Models.Day;
import Models.NutritionItem;
import constants.Const;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import launch.Main;
import scenes.*;
import tables.DayTable;


import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Devon Divinecz & Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description Pane to view weeklyProgress of completed days
 */

public class weeklyProgressPane extends BorderPane {

    public TableView tableView;
    public static Text weeklyDeletedRecord;
    private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public weeklyProgressPane() {
        this.setStyle(Const.BACKGROUND_STYLE);

        ArrayList<Day> days = new DayTable().getAllDays();

            Image imgOne = new Image("file:images/checkmark.png");
            Image imgTwo = new Image("file:images/xmark.png");


        //Content

        tableView = new TableView();
        tableView.setStyle(Const.BACKGROUND_STYLE);

        TableColumn<Day, String> column1 = new TableColumn<>("Day");
        column1.setCellValueFactory(e -> new SimpleStringProperty(formatter.format(e.getValue().getDate()) + ""));
        column1.setPrefWidth(256);

        TableColumn<Day, String> column2 = new TableColumn<>("Calorie Consumption");
        column2.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCurrentCalories() + ""));
        column2.setPrefWidth(128);

        TableColumn<Day, String> column3 = new TableColumn<>("Calorie Goal");
        column3.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCalorieGoal() + ""));
        column3.setPrefWidth(128);

        TableColumn<Day, String> column4 = new TableColumn("Goal Status");
        column4.setCellValueFactory(new PropertyValueFactory<>("dayImage"));
        column4.setPrefWidth(128);
        column4.setStyle(Const.CENTER_ALIGNMENT_STYLE);

        TableColumn<Day, String> column5 = new TableColumn<>("View Day");
        column5.setCellValueFactory(new PropertyValueFactory<Day, String>("viewDayButton"));
        column5.setPrefWidth(128);
        column5.setStyle(Const.CENTER_ALIGNMENT_STYLE);

        TableColumn<Day, String> column6 = new TableColumn<>("Make Active");
        column6.setCellValueFactory(new PropertyValueFactory<Day, String>("activeButton"));
        column6.setPrefWidth(128);
        column6.setStyle(Const.CENTER_ALIGNMENT_STYLE);

        TableColumn<Day, String> column7 = new TableColumn<>("Delete Day");
        column7.setCellValueFactory(new PropertyValueFactory<Day, String>("deleteButton"));
        column7.setPrefWidth(128);
        column7.setStyle(Const.CENTER_ALIGNMENT_STYLE);

        tableView.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
        tableView.getItems().addAll(days);
        this.setCenter(tableView);
        weeklyDeletedRecord = new Text("\tRecord Deleted!");
        weeklyDeletedRecord.setStyle(Const.DELETE_RECORD_STYLE);
        weeklyDeletedRecord.setVisible(false);

    }

}
