package daos;

import Models.NutritionItem;

import java.util.ArrayList;

/**
 * @author Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description
 */

public interface NutritionDAO {
    public void createItem(String typeOfItem, NutritionItem item);
    public ArrayList<NutritionItem > getAllNutritionalItems(String typeOfItem);
    public NutritionItem getItem(String typeOfItem, int id);
    public void updateItem(String typeOfItem, NutritionItem item);
    public void deleteItem(String typeOfItem, NutritionItem item);

}
