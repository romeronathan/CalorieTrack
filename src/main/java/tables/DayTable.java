package tables;

import Models.NutritionItem;
import daos.DayDAO;
import database.DBTableValues;
import Models.Day;
import database.Database;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DayTable implements DayDAO {

    Database db = Database.getInstance();

    ArrayList<Day> days = new ArrayList<>();
    /**
     * @param
     * @return days
     *
     */
    @Override
    public ArrayList<Day> getAllDays() {
        String query = "SELECT * FROM " + DBTableValues.TABLE_DAY;
        days = new ArrayList<>();
        try {
            Statement getDays = db.getConnection().createStatement();
            ResultSet data = getDays.executeQuery(query);

            while(data.next()) {
                days.add(
                        new Day(data.getInt(DBTableValues.DAY_COLUMN_ID),
                                data.getDate(DBTableValues.DAY_COLUMN_DATE),
                                data.getInt(DBTableValues.DAY_COLUMN_CALORIE_GOAL))
                );
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return days;
    }
    /**
     * @param id
     * @return day
     *
     */
    @Override
    public Day getDay(int id) {
        String query = "SELECT * FROM " + DBTableValues.TABLE_DAY +
                " WHERE " + DBTableValues.DAY_COLUMN_ID + " = " + id;
        try {
            Statement getDay = db.getConnection().createStatement();
            ResultSet data = getDay.executeQuery(query);
            if(data.next()){
                Day day =  new Day(data.getInt(DBTableValues.DAY_COLUMN_ID),
                        data.getDate(DBTableValues.DAY_COLUMN_DATE),
                        data.getInt(DBTableValues.DAY_COLUMN_CALORIE_GOAL));
                return day;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @param day
     * @return
     *
     */
    @Override
    public void createDay(Day day) {
        String query = "INSERT INTO " + DBTableValues.TABLE_DAY +
                "(" + DBTableValues.DAY_COLUMN_DATE + ", " +
                DBTableValues.DAY_COLUMN_CALORIE_GOAL + ", " + ") VALUES ('" +
                day.getDate() + "','" + day.getCalorieGoal() + "','" +
                "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateDay(Day day) {

    }
    @Override
    public void deleteDay(Day day) {

    }

    @Override
    public Day getRecentDay() {
        String query = "SELECT TOP 1 * FROM " + DBTableValues.TABLE_DAY +
                " ORDER BY" + DBTableValues.DAY_COLUMN_DATE;
        try {
            Statement getDay = db.getConnection().createStatement();
            ResultSet data = getDay.executeQuery(query);
            if(data.next()){
                Day day =  new Day(data.getInt(DBTableValues.DAY_COLUMN_ID),
                        data.getDate(DBTableValues.DAY_COLUMN_DATE),
                        data.getInt(DBTableValues.DAY_COLUMN_CALORIE_GOAL));
                return day;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<NutritionItem> getDayItems(int dayId) {
        return null;
    }

}
