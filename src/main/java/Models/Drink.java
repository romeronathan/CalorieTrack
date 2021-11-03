package Models;

public class Drink {

    private int id;
    private String name;
    private int calories;
    private int serving;
    private int dayId;

    public Drink(String name, int calories, int serving, int dayId) {
        this.name = name;
        this.calories = calories;
        this.serving = serving;
        this.dayId = dayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return serving;
    }

    public void setPortion(int portion) {
        this.serving = portion;
    }


    public String drinkDescription() {
        return this.name + " has " + this.calories + " for a portion of " + this.serving;
    }
}
