package Models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import launch.Main;
import scenes.updateItemScene;
import scenes.viewDayScene;
import tables.DayTable;
import tables.NutritionTable;
import tabs.dailyTrackerTab;


import java.util.ArrayList;
import java.util.Date;

import static launch.Main.mainStage;
import static panes.dailyTrackerPane.deletedRecord;

/**
 * @author Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description
 */

public class Day {
    private int id;
    private Date date;
    private int calorieGoal;
    private int currentCalories;
    private ArrayList<NutritionItem> nutritionItems;
    private Button viewDayButton;
    private ImageView dayImage;
    private Button deleteButton;
    private Button activeButton;

    public ImageView getDayImage() {
        return getImageView();
    }

    public void setDayImage(ImageView dayImage) {
        this.dayImage = dayImage;
    }

    /**
     * @author Nathan Romero
     * @description Method to return an image in the weeklyProgress table
     * @method homeMenu
     * @return view
     */

    public ImageView getImageView() {
        ImageView view = new ImageView();
        if(this.calorieGoal > this.currentCalories) {
            Image img = new Image("file:src/main/java/images/checkmark.png");
            view.setImage(img);
        } else {
            Image img = new Image("file:src/main/java/images/xmark.png");
            view.setImage(img);
        }
        view.setFitHeight(40);
        view.setFitWidth(40);
        return view;

    }


    public ArrayList<NutritionItem> getNutritionItems() {
        return nutritionItems;
    }

    public void setNutritionItems(ArrayList<NutritionItem> nutritionItems) {
        this.nutritionItems = nutritionItems;
    }

    public int getCurrentCalories() {
        return currentCalories;
    }

    public void setCurrentCalories(int currentCalories) {
        this.currentCalories = currentCalories;
    }

    public Day(Date date, int calorieGoal) {
        this.date = date;
        this.calorieGoal = calorieGoal;
        this.viewDayButton = new Button("View Day");
        this.currentCalories = new DayTable().getDaysCurrentCalories(this.getId());
        this.dayImage = getImageView();
    }
    public Day(int dayId, Date date, int calorieGoal) {
        this.id = dayId;
        this.date = date;
        this.calorieGoal = calorieGoal;
        this.viewDayButton = new Button("View Day");
        this.currentCalories = new DayTable().getDaysCurrentCalories(this.getId());
        viewDayButton.setOnAction(e -> {
            mainStage.setScene(new viewDayScene());
        });
        this.dayImage = getImageView();

        this.deleteButton = new Button("Delete");
        this.deleteButton.setOnAction(e -> {
            new DayTable().deleteDay(this.id);
            dailyTrackerTab tab = dailyTrackerTab.getInstance();
            tab.refresh();
            deletedRecord.setVisible(true);
            new Timeline(new KeyFrame(Duration.seconds(1), ae -> deletedRecord.setVisible(false))).play();
        });
        this.activeButton = new Button("Make Active");
        this.activeButton.setOnAction(e -> {
            Main.activeDay = this;
        });
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Button getViewDayButton() {
        return viewDayButton;
    }

    public void setViewDayButton(Button viewDayButton) {
        this.viewDayButton = viewDayButton;
    }
}
