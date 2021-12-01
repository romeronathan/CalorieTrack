package Models;

public class Drink extends NutritionItem  {




    public Drink(String name, int calories, int portion, int dayId, String type) {
        super(name, calories, portion, dayId, type);
    }
    public Drink(int id,String name, int calories, int portion, int dayId, String type) {
        super(id, name, calories, portion, dayId, type);
    }
}
