package Models;

public class Meal extends NutritionItem  {


    public Meal(String name, int calories, int portion, int dayId, String type) {
        super(name, calories, portion, dayId, type);
    }
    public Meal(){
        super();

    }
    public Meal(int id,String name, int calories, int portion, int dayId, String type) {
        super(id, name, calories, portion, dayId, type);
    }
}
