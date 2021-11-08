package daos;

import Models.NutritionItem;

import java.util.ArrayList;

public interface NutritionDAO {
    public void createItem(String typeOfItem, NutritionItem item);
    public ArrayList<NutritionItem > getAllNutritionalItems(String typeOfItem);
    public NutritionItem getItem(String typeOfItem, int id);
    public void updateItem(String typeOfItem, NutritionItem item);
    public void deleteItem(String typeOfItem, NutritionItem item);

}
