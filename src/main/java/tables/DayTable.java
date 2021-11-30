package tables;

import Models.NutritionItem;
import daos.DayDAO;
import database.DBTableValues;
import Models.Day;
import database.Database;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
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
                DBTableValues.DAY_COLUMN_CALORIE_GOAL  + ") VALUES ('" +
                day.getDate() + "','" + day.getCalorieGoal()  +
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
       
       String query = "UPDATE " + DBTableValues.TABLE_DAY +
               " SET " + DBTableValues.DAY_COLUMN_DATE + " = '" +
               day.getDate() + "', " + DBTableValues.DAY_COLUMN_CALORIE_GOAL +
                " = '" + day.getCalorieGoal() + "' WHERE " +
                DBTableValues.DAY_COLUMN_ID + " = " + day.getId();

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Updated Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void deleteDay(int dayId) {
        String query = "DELETE FROM " + DBTableValues.TABLE_DAY +
                " WHERE " + DBTableValues.DAY_COLUMN_ID + " = " + dayId;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Day getRecentDay() {
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String query = "SELECT * FROM " + DBTableValues.TABLE_DAY +
                " ORDER BY " + DBTableValues.DAY_COLUMN_ID + " DESC LIMIT 1";
        try {
            Statement getDay = db.getConnection().createStatement();
            ResultSet data = getDay.executeQuery(query);
            if(data.next()){
                Day day =  new Day(data.getInt(DBTableValues.DAY_COLUMN_ID),
                        data.getDate(DBTableValues.DAY_COLUMN_DATE),
                        data.getInt(DBTableValues.DAY_COLUMN_CALORIE_GOAL));
                return day;
            }
            else {

                String q = "INSERT INTO " + DBTableValues.TABLE_DAY +
                        "(" + DBTableValues.DAY_COLUMN_DATE + ", " +
                        DBTableValues.DAY_COLUMN_CALORIE_GOAL  + ") VALUES ('" +
                        date + "','" + 0 +
                        "')";

                try {
                    Statement dbTwo = db.getConnection().createStatement();
                    dbTwo.getConnection().createStatement().execute(q);
                    String queryTwo = "SELECT * FROM " + DBTableValues.TABLE_DAY +
                            " ORDER BY " + DBTableValues.DAY_COLUMN_ID + " DESC LIMIT 1";
                    System.out.println("Inserted Record");
                    data = getDay.executeQuery(queryTwo);
                    if(data.next()){
                        Day day =  new Day(data.getInt(DBTableValues.DAY_COLUMN_ID),
                                data.getDate(DBTableValues.DAY_COLUMN_DATE),
                                data.getInt(DBTableValues.DAY_COLUMN_CALORIE_GOAL));
                        return day;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

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
