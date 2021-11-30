package daos;

import Models.Day;
import Models.NutritionItem;

import java.util.ArrayList;

public interface DayDAO {
    public void createDay(Day day);
    public void updateDay(Day day);
    public void deleteDay(int dayId);
    public Day getRecentDay();
    public ArrayList<Day> getAllDays();
    public Day getDay(int dayID);
    public ArrayList<NutritionItem> getDayItems(int dayId);
    public ArrayList<NutritionItem> getDayMeals(int dayId);
    public ArrayList<NutritionItem> getDayDrinks(int dayId);
    public ArrayList<NutritionItem> getDaySnacks(int dayId);
}
