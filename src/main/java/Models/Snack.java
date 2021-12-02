package Models;

public class Snack extends NutritionItem {


    public Snack(String name, int calories, int portion, int dayId, String type) {
        super(name, calories, portion, dayId, type);
    }
    public Snack(int id,String name, int calories, int portion, int dayId, String type) {
        super(id, name, calories, portion, dayId, type);
    }
}
