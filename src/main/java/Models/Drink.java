package Models;

public class Drink extends NutritionItem  {

    private int id;


    public Drink(String name, int calories, int portion, int dayId) {
        super(name, calories, portion, dayId);
    }
}
