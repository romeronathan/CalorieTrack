package Models;

import java.util.Date;

public class Day {
    private int id;
    private Date date;
    private int calorieGoal;


    public Day(Date date, int calorieGoal) {
        this.date = date;
        this.calorieGoal = calorieGoal;
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
}
