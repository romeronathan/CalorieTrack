package DAOS;

import Models.Day;
import Models.NutritionItem;

import java.util.ArrayList;

public interface DayDAO {
    public void createDay(Day day);
    public void updateDay(Day day);
    public void deleteDay(Day day);
    public ArrayList<Day> getAllDays();
    public Day getDay(int dayID);
    public ArrayList<NutritionItem> getDayItems(int dayId);
}
