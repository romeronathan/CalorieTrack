package panes;

import Models.Day;
import Models.NutritionItem;
import constants.Const;
import database.DBConst;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import launch.Main;
import tables.NutritionTable;
import tabs.dailyTrackerTab;

/**
 * @author Devon Divinecz & Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description Pane to update the selected item in the table
 */

public class updateItemPane extends BorderPane {

    String itemName;
    int itemCalories;
    int itemServing;
    Day day = Main.activeDay;

    public updateItemPane(NutritionItem item) {
        this.setStyle(Const.BACKGROUND_STYLE);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final TextField itemNameTF = new TextField();
        itemNameTF.setText(item.getName());
        itemNameTF.setPrefColumnCount(10);
        itemNameTF.getText();
        GridPane.setConstraints(itemNameTF, 0, 0);
        grid.getChildren().add(itemNameTF);

        final TextField itemCaloriesTF = new TextField();
        itemCaloriesTF.setText(item.getCalories() + "");
        GridPane.setConstraints(itemCaloriesTF, 0, 1);
        grid.getChildren().add(itemCaloriesTF);

        final TextField itemServingTF = new TextField();
        itemServingTF.setPrefColumnCount(15);
        itemServingTF.setText(item.getPortion() + "");
        GridPane.setConstraints(itemServingTF, 0, 2);
        grid.getChildren().add(itemServingTF);

        Button updateItem = new Button("Update");
        updateItem.setOnAction(e -> {
            if(itemNameTF.getText().isEmpty() || itemCaloriesTF.getText().isEmpty() || itemServingTF.getText().isEmpty()) {

            } else {
                item.setName(itemNameTF.getText());
                item.setCalories(Integer.parseInt(itemCaloriesTF.getText()));
                item.setPortion(Integer.parseInt(itemServingTF.getText()));

                new NutritionTable().updateItem(item.getType(), item);

                dailyTrackerTab tab = dailyTrackerTab.getInstance();
                tab.refresh();
            }
           Main.homeMenu();
        });

        GridPane.setConstraints(updateItem, 1, 0);
        grid.getChildren().add(updateItem);

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {
            Main.homeMenu();
        });
        GridPane.setConstraints(cancel, 1, 1);
        grid.getChildren().add(cancel);
        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);
    }
}
