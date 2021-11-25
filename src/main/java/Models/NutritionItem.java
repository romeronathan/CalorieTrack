package Models;

public class NutritionItem {


    private int id;
    private String name;
    private int calories;
    private int portion;
    private int dayId;

    public NutritionItem(String name, int calories, int portion, int dayId) {
        this.name = name;
        this.calories = calories;
        this.portion = portion;
        this.dayId = dayId;
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
