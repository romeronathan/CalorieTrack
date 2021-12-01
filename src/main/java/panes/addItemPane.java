package panes;

import Models.Day;
import Models.Drink;
import Models.NutritionItem;
import enums.NutritionEnum;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //Content

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final TextField drinkNameTF = new TextField();
        drinkNameTF.setPromptText("Name");
        drinkNameTF.setPrefColumnCount(10);
        drinkNameTF.getText();
        GridPane.setConstraints(drinkNameTF, 0, 0);
        grid.getChildren().add(drinkNameTF);

        final TextField drinkCaloriesTF = new TextField();
        drinkCaloriesTF.setPromptText("Calories");
        GridPane.setConstraints(drinkCaloriesTF, 0, 1);
        grid.getChildren().add(drinkCaloriesTF);

        final TextField drinkServingTF = new TextField();
        drinkServingTF.setPrefColumnCount(15);
        drinkServingTF.setPromptText("Serving");
        GridPane.setConstraints(drinkServingTF, 0, 2);
        grid.getChildren().add(drinkServingTF);
        final ComboBox<String> itemType = new ComboBox<>();

        //TODO use enum values instead of string values
        itemType.getItems().addAll("meal", "drink", "snack");
        GridPane.setConstraints(itemType, 1, 0);
        itemType.setValue("meal");
        grid.getChildren().add(itemType);

        Button submitDrink = new Button("Submit");
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

                drinkNameTF.clear();
                drinkCaloriesTF.clear();
                drinkServingTF.clear();
            }

        });
        GridPane.setConstraints(submitDrink, 1, 1);
        grid.getChildren().add(submitDrink);


        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            drinkNameTF.clear();
            drinkCaloriesTF.clear();
            drinkServingTF.clear();
        });
        GridPane.setConstraints(clear, 1, 2);
        grid.getChildren().add(clear);
        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);

    }
}
