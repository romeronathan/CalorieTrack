package Models;

public class Meal extends NutritionItem  {


    public Meal(String name, int calories, int portion, int dayId) {
        super(name, calories, portion, dayId);
    }
    public Meal(){
        super();

    }
}
