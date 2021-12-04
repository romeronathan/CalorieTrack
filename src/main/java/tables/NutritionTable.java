package tables;

import Models.Day;
import Models.Meal;
import Models.NutritionItem;
import daos.NutritionDAO;
import database.DBTableValues;
import database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description This class is used to create a table of nutrition items
 */

public class NutritionTable implements NutritionDAO {
    Database db = Database.getInstance();

    ArrayList<NutritionItem> items = new ArrayList<>();

    // Generate java doc for createItem function

    /**
     * @author Nathan Romero
     * @description Method to create item in the database
     * @method createItem
     * @param typeOfItem
     * @param item
     */

    @Override
    public void createItem(String typeOfItem, NutritionItem item) {
        String query = "INSERT INTO " + typeOfItem +
                "(" + DBTableValues.NUTRITION_COLUMN_NAME + ", " +
                DBTableValues.NUTRITION_COLUMN_CALORIES + ", " +
                DBTableValues.NUTRITION_COLUMN_PORTION + ", " +
                DBTableValues.NUTRITION_COLUMN_DAYID + ", " +
                DBTableValues.NUTRITION_COLUMN_TYPE + ") VALUES ('" +
              item.getName() + "','"
                + item.getCalories() + "','"
                + item.getPortion() + "','"
                + item.getDayId() + "','"
                + item.getType() +
                "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Nathan Romero
     * @description Method to get all Nutritional Items
     * @method getAllNutritionalItems
     * @param typeOfItem
     * @return items
     */

    @Override
    public ArrayList<NutritionItem> getAllNutritionalItems(String typeOfItem) {
        String query = "SELECT * FROM " + typeOfItem;
        items = new ArrayList<>();
        try {
            Statement getDays = db.getConnection().createStatement();
            ResultSet data = getDays.executeQuery(query);

            while(data.next()) {
                items.add(
                        new NutritionItem(
                                data.getInt(DBTableValues.NUTRITION_COLUMN_ID),
                                data.getString(DBTableValues.NUTRITION_COLUMN_NAME),
                                data.getInt(DBTableValues.NUTRITION_COLUMN_CALORIES),
                                data.getInt(DBTableValues.NUTRITION_COLUMN_PORTION),
                                data.getInt(DBTableValues.NUTRITION_COLUMN_DAYID),
                                data.getString(DBTableValues.NUTRITION_COLUMN_TYPE)
                                        )
                );

            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return items;
    }

    /**
     * @author Nathan Romero
     * @description Method to get item from the database
     * @method getItem
     * @param typeOfItem
     * @param id
     * @return item
     */
    @Override
    public NutritionItem getItem(String typeOfItem, int id) {
        
        String query = "SELECT * FROM " + typeOfItem + " WHERE " + DBTableValues.NUTRITION_COLUMN_ID + " = " + id;
        NutritionItem item = new NutritionItem();
        try {
            Statement getDays = db.getConnection().createStatement();
            ResultSet data = getDays.executeQuery(query);

            while(data.next()) {
                item = new NutritionItem(
                        data.getString(DBTableValues.NUTRITION_COLUMN_NAME),
                        data.getInt(DBTableValues.NUTRITION_COLUMN_CALORIES),
                        data.getInt(DBTableValues.NUTRITION_COLUMN_PORTION),
                        data.getInt(DBTableValues.NUTRITION_COLUMN_DAYID),
                        data.getString(DBTableValues.NUTRITION_COLUMN_TYPE)
                );

            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return item;
        
    }

    /**
     * @author Nathan Romero
     * @description Method to update item in the database
     * @method updateItem
     * @param typeOfItem
     * @param item
     */

    @Override
    public void updateItem(String typeOfItem, NutritionItem item) {

        String query = "UPDATE " + typeOfItem + " SET " +
                DBTableValues.NUTRITION_COLUMN_CALORIES + " = '" + item.getCalories() + "', " +
                DBTableValues.NUTRITION_COLUMN_NAME + " = '" + item.getName() + "', " +
                DBTableValues.NUTRITION_COLUMN_PORTION + " = '" + item.getPortion() + "', " +
                DBTableValues.NUTRITION_COLUMN_DAYID + " = '" + item.getDayId() + "', " +
                DBTableValues.NUTRITION_COLUMN_TYPE + " = '" + item.getType() + "' " +
                "WHERE " + DBTableValues.NUTRITION_COLUMN_ID + " = " + item.getId();
        System.out.println(query);
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Updated Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author Nathan Romero
     * @description Method to delete item from the database
     * @method deleteItem
     * @param typeOfItem
     * @param item
     */

    @Override
    public void deleteItem(String typeOfItem, NutritionItem item) {

        String query = "DELETE FROM " + typeOfItem + " WHERE " + DBTableValues.NUTRITION_COLUMN_ID + " = " + item.getId();
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
