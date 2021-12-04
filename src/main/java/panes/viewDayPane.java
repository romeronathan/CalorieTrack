package panes;

import Models.Day;
import Models.NutritionItem;
import constants.Const;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import launch.Main;
import tables.DayTable;

import java.util.ArrayList;

/**
 * @author Devon Divinecz & Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description Pane to view the selected day's nutrition items
 */

public class viewDayPane extends BorderPane {

    public TableView tableView;

    public viewDayPane(Day day) {
        this.setStyle(Const.BACKGROUND_STYLE);
        ArrayList<NutritionItem> items = new DayTable().getDayItems(day.getId());
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Main.returnToWeeklyProgress();
        });
        backButton.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().add(backButton);
        this.setTop(hBox);

        tableView = new TableView();
        tableView.setStyle(Const.BACKGROUND_STYLE);

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

        tableView.getItems().addAll(items);
        this.setCenter(tableView);

    }
}
