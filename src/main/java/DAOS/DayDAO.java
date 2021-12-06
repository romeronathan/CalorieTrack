package daos;

import Models.Day;
import Models.NutritionItem;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description
 */

public interface DayDAO {
    public int createDay(Day day);
    public void updateDay(Day day);
    public void deleteDay(int dayId);
    public Day getRecentDay();
    public Day getDayByDate(Date date);
    public int getDaysCurrentCalories(int dayId);
    public ArrayList<Day> getAllDays();
    public Day getDay(int dayID);
    public ArrayList<NutritionItem> getDayItems(int dayId);
    public ArrayList<NutritionItem> getDayMeals(int dayId);
    public ArrayList<NutritionItem> getDayDrinks(int dayId);
    public ArrayList<NutritionItem> getDaySnacks(int dayId);
}
