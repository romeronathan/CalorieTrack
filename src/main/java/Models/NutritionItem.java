package Models;


import database.DBConst;
import enums.NutritionEnum;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.util.Duration;
import scenes.updateItemScene;
import tables.NutritionTable;
import tabs.dailyTrackerTab;

import static launch.Main.mainStage;
import static panes.dailyTrackerPane.deletedRecord;

/**
 * @author Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description
 */

public class NutritionItem {


    private int id;
    private String name;
    private int calories;
    private int portion;
    private int dayId;
    private String type;
    private Button deleteButton;
    private Button updateButton;

    public NutritionItem(String name, int calories, int portion, int dayId, String type) {
        this.name = name;
        this.calories = calories;
        this.portion = portion;
        this.dayId = dayId;
        this.type = type;
        this.deleteButton = new Button("Delete");
        this.updateButton = new Button("Update");

    }
    public NutritionItem(int id, String name, int calories, int portion, int dayId, String type) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.portion = portion;
        this.dayId = dayId;
        this.type = type;
        this.deleteButton = new Button("Delete");
        this.deleteButton.setOnAction(e -> {
            new NutritionTable().deleteItem(this.type, this);
            dailyTrackerTab tab = dailyTrackerTab.getInstance();
            tab.refresh();
            deletedRecord.setVisible(true);
            new Timeline(new KeyFrame(Duration.seconds(1), ae -> deletedRecord.setVisible(false))).play();
        });
        this.updateButton = new Button("Update");
        this.updateButton.setOnAction(e -> {
            mainStage.setScene(new updateItemScene(this));
        });
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button button) {
        this.deleteButton = button;
    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button button) {
        this.updateButton = button;
    }

    public NutritionItem() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String itemDescription() {
        return this.name + " has " + this.calories + " for a portion of " + this.portion;
    }
}
