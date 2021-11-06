package DAOS;

import Models.NutritionItem;

import java.util.ArrayList;

public interface NutritionDAO {
    public void createItem(NutritionItem item);
    public ArrayList<NutritionItem > getAllNutritionalItems();
    public NutritionItem getItem(int id);
    public void updateItem(NutritionItem item);
    public void deleteItem(NutritionItem item);

}
