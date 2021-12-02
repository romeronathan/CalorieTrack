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

public class weeklyProgressPane extends BorderPane {

    public TableView tableView;

    public weeklyProgressPane() {
        this.setBackground(new Background(new BackgroundFill(Const.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //Content

        tableView = new TableView();
        tableView.setBackground(new Background(new BackgroundFill(Const.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        TableColumn<Day, String> column1 = new TableColumn<>("Day");
        column1.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getDate() + ""));
        column1.setPrefWidth(340);

        TableColumn<Day, String> column2 = new TableColumn<>("Calorie Consumption");
        column2.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCurrentCalories() + ""));
        column2.setPrefWidth(340);

        TableColumn<Day, String> column3 = new TableColumn<>("Calorie Goal");
        column3.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getCalorieGoal() + ""));
        column3.setPrefWidth(340);



        tableView.getColumns().addAll(column1, column2, column3);
        this.setCenter(tableView);

    }

}
