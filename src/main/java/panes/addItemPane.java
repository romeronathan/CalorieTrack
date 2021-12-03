package panes;

import Models.Day;
import Models.Drink;
import Models.NutritionItem;
import constants.Const;
import enums.NutritionEnum;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import launch.Main;
import scenes.*;
import tables.DayTable;
import tables.NutritionTable;
import tabs.dailyTrackerTab;

public class addItemPane extends BorderPane {

    String drinkName;
    int drinkCalories;
    int drinkServing;
    Day day = Main.activeDay;

    public addItemPane() {
        this.setBackground(new Background(new BackgroundFill(Const.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //Content

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Text successfulEntry = new Text("Successfully added item!");
        successfulEntry.setFill(Const.GREEN);
        successfulEntry.setFont(Const.SUCCESSFUL_ENTRY_FONT);
        successfulEntry.setVisible(false);
        GridPane.setConstraints(successfulEntry, 0, 0);
        grid.getChildren().add(successfulEntry);

        final TextField drinkNameTF = new TextField();
        drinkNameTF.setPromptText("Name");
        drinkNameTF.setFont(Const.TEXT_FONT);
        drinkNameTF.setPrefColumnCount(10);
        drinkNameTF.getText();
        GridPane.setConstraints(drinkNameTF, 0, 1);
        grid.getChildren().add(drinkNameTF);

        final TextField drinkCaloriesTF = new TextField();
        drinkCaloriesTF.setPromptText("Calories");
        drinkCaloriesTF.setFont(Const.TEXT_FONT);
        GridPane.setConstraints(drinkCaloriesTF, 0, 2);
        grid.getChildren().add(drinkCaloriesTF);

        final TextField drinkServingTF = new TextField();
        drinkServingTF.setPrefColumnCount(15);
        drinkServingTF.setPromptText("Serving");
        drinkServingTF.setFont(Const.TEXT_FONT);
        GridPane.setConstraints(drinkServingTF, 0, 3);
        grid.getChildren().add(drinkServingTF);

        final ComboBox<String> itemType = new ComboBox<>();
        itemType.getItems().addAll("meal", "drink", "snack");
        GridPane.setConstraints(itemType, 1, 1);
        itemType.setValue("meal");
        grid.getChildren().add(itemType);

        Button submitDrink = new Button("Submit");
        submitDrink.setFont(Const.BUTTON_FONT);
        submitDrink.setOnAction(e -> {
            if(drinkNameTF.getText().isEmpty() || drinkCaloriesTF.getText().isEmpty() || drinkServingTF.getText().isEmpty()) {
                if(drinkNameTF.getText().isEmpty()) {
                    drinkNameTF.setPromptText("Please Enter a Name");
                }
                if(drinkCaloriesTF.getText().isEmpty()) {
                    drinkCaloriesTF.setPromptText("Please Enter Calories");
                }
                if(drinkServingTF.getText().isEmpty()) {
                    drinkServingTF.setPromptText("Please Enter Serving");
                }
            } else {
                drinkName = drinkNameTF.getText();
                drinkCalories = Integer.parseInt(drinkCaloriesTF.getText());
                drinkServing = Integer.parseInt(drinkServingTF.getText());
                String type = itemType.getValue();
                System.out.println(type);

                //TODO Save drinkName, drinkCalories, drinkServing to database
                NutritionItem item = new NutritionItem(drinkName, drinkCalories, drinkServing, day.getId(), type);

                new NutritionTable().createItem(type,item);

                dailyTrackerTab tab = dailyTrackerTab.getInstance();
                tab.refresh();

                successfulEntry.setVisible(true);
                new Timeline(new KeyFrame(Duration.seconds(1), ae -> successfulEntry.setVisible(false))).play();
                drinkNameTF.clear();
                drinkCaloriesTF.clear();
                drinkServingTF.clear();
            }

        });
        GridPane.setConstraints(submitDrink, 1, 2);
        grid.getChildren().add(submitDrink);


        Button clear = new Button("Clear");
        clear.setFont(Const.BUTTON_FONT);
        clear.setOnAction(e -> {
            drinkNameTF.clear();
            drinkCaloriesTF.clear();
            drinkServingTF.clear();
        });
        GridPane.setConstraints(clear, 1, 3);
        grid.getChildren().add(clear);
        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);

    }
}
