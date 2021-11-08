package Models;

import java.util.ArrayList;
import java.util.Date;

public class Day {
    private int id;
    private Date date;
    private int calorieGoal;
    private int currentCalories;
    private ArrayList<NutritionItem> nutritionItems;


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
    }
    public Day(int dayId, Date date, int calorieGoal) {
        this.id = dayId;
        this.date = date;
        this.calorieGoal = calorieGoal;
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
}
