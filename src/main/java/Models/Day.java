package Models;

import javafx.scene.control.Button;
import scenes.viewDayScene;
import tables.DayTable;

import java.util.ArrayList;
import java.util.Date;

import static launch.Main.mainStage;

public class Day {
    private int id;
    private Date date;
    private int calorieGoal;
    private int currentCalories;
    private ArrayList<NutritionItem> nutritionItems;
    private Button viewDayButton;


    public ArrayList<NutritionItem> getNutritionItems() {
        return nutritionItems;
    }

    public void setNutritionItems(ArrayList<NutritionItem> nutritionItems) {
        this.nutritionItems = nutritionItems;
    }

    public int getCurrentCalories() {
        return currentCalories;
    }

    public void setCurrentCalories(int currentCalories) {
        this.currentCalories = currentCalories;
    }

    public Day(Date date, int calorieGoal) {
        this.date = date;
        this.calorieGoal = calorieGoal;
        this.viewDayButton = new Button("View Day");
        this.currentCalories = new DayTable().getDaysCurrentCalories(this.getId());
    }
    public Day(int dayId, Date date, int calorieGoal) {
        this.id = dayId;
        this.date = date;
        this.calorieGoal = calorieGoal;
        this.viewDayButton = new Button("View Day");
        this.currentCalories = new DayTable().getDaysCurrentCalories(this.getId());
        viewDayButton.setOnAction(e -> {
            mainStage.setScene(new viewDayScene());
        });
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Button getViewDayButton() {
        return viewDayButton;
    }

    public void setViewDayButton(Button viewDayButton) {
        this.viewDayButton = viewDayButton;
    }
}
