package Models;


import enums.NutritionEnum;
import javafx.scene.control.*;
import tables.NutritionTable;
import tabs.dailyTrackerTab;


public class NutritionItem {


    private int id;
    private String name;
    private int calories;
    private int portion;
    private int dayId;
    private String type;
    private Button button;

    public NutritionItem(String name, int calories, int portion, int dayId) {
        this.name = name;
        this.calories = calories;
        this.portion = portion;
        this.dayId = dayId;
        this.button = new Button("Delete");


    }
    public NutritionItem(int id, String name, int calories, int portion, int dayId, String type) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.portion = portion;
        this.dayId = dayId;
        this.type = type;
        this.button = new Button("Delete");
        this.button.setOnAction(e -> {
            new NutritionTable().deleteItem("meal", this);
            dailyTrackerTab tab = dailyTrackerTab.getInstance();
            tab.refresh();
        });

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
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
