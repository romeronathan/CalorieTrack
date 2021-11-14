package tables;

import Models.Day;
import Models.Meal;
import Models.NutritionItem;
import daos.NutritionDAO;
import database.DBTableValues;
import database.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class NutritionTable implements NutritionDAO {
    Database db = Database.getInstance();

    ArrayList<NutritionItem> items = new ArrayList<>();
    Meal meal = new Meal();

    @Override
    public void createItem(String typeOfItem, NutritionItem item) {
        String query = "INSERT INTO " + typeOfItem +
                "(" + DBTableValues.NUTRITION_COLUMN_ID + ", " +
                DBTableValues.NUTRITION_COLUMN_CALORIES + ", " +
                DBTableValues.NUTRITION_COLUMN_NAME + ", " +
                DBTableValues.NUTRITION_COLUMN_PORTION + ", " +") VALUES ('" +
              item.getCalories() + "','" + item.getName() + "','" +
                "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<NutritionItem> getAllNutritionalItems(String typeOfItem) {
        return null;
    }

    @Override
    public NutritionItem getItem(String typeOfItem, int id) {
        return null;
    }

    @Override
    public void updateItem(String typeOfItem, NutritionItem item) {

    }

    @Override
    public void deleteItem(String typeOfItem, NutritionItem item) {

    }
}
