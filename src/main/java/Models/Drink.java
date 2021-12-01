package Models;

public class Drink extends NutritionItem  {




    public Drink(String name, int calories, int portion, int dayId) {
        super(name, calories, portion, dayId);
    }
    public Drink(int id,String name, int calories, int portion, int dayId, String type) {
        super(id, name, calories, portion, dayId, type);
    }
}
