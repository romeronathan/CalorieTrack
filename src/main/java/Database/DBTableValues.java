package Database;

public class DBTableValues {


        //Drink name TABLE name TABLE
        public static final String TABLE_DRINK = "coin";
        public static final String DRINK_COLUMN_ID = "id";
        public static final String DRINK_COLUMN_NAME = "name";
        public static final String DRINK_COLUMN_CALORIES = "calories";
        public static final String DRINK_COLUMN_PORTION = "portion";
        public static final String DRINK_COLUMN_DAYID = "dayId";

        //Meal name TABLE
        public static final String TABLE_MEAL = "meal";
        public static final String MEAL_COLUMN_ID = "id";
        public static final String MEAL_COLUMN_NAME = "name";
        public static final String MEAL_COLUMN_CALORIES = "calories";
        public static final String MEAL_COLUMN_PORTION = "portion";
        public static final String MEAL_COLUMN_DAYID = "dayId";

        //Snack name TABLE
        public static final String TABLE_SNACK = "snack";
        public static final String SNACK_COLUMN_ID = "id";
        public static final String SNACK_COLUMN_NAME = "name";
        public static final String SNACK_COLUMN_CALORIES = "calories";
        public static final String SNACK_COLUMN_PORTION = "portion";
        public static final String SNACK_COLUMN_DAYID = "dayId";


        //Day name TABLE
        public static final String TABLE_DAY = "day";
        public static final String DAY_COLUMN_ID = "id";
        public static final String DAY_COLUMN_DATE = "date";
        public static final String DAY_COLUMN_CALORIE_GOAL = "calorieGoal";








        //Table Create Statements
        public static final String CREATE_TABLE_DRINK = "CREATE TABLE " + TABLE_DRINK + "("
                + DRINK_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + DRINK_COLUMN_NAME + " VARCHAR(50),"
                + DRINK_COLUMN_CALORIES + " VARCHAR(15),"
                + DRINK_COLUMN_PORTION + " VARCHAR(15),"
                + DRINK_COLUMN_DAYID + " VARCHAR(15)"
                + ")";

        public static final String CREATE_TABLE_MEAL = "CREATE TABLE " + TABLE_MEAL + "("
                        + MEAL_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                        + MEAL_COLUMN_NAME + " VARCHAR(50),"
                        + MEAL_COLUMN_CALORIES + " VARCHAR(15),"
                        + MEAL_COLUMN_PORTION + " VARCHAR(15),"
                        + MEAL_COLUMN_DAYID + " VARCHAR(15)"
                        + ")";

        public static final String CREATE_TABLE_SNACK = "CREATE TABLE " + TABLE_SNACK + "("
                        + SNACK_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                        + SNACK_COLUMN_NAME + " VARCHAR(50),"
                        + SNACK_COLUMN_CALORIES + " VARCHAR(15),"
                        + SNACK_COLUMN_PORTION + " VARCHAR(15),"
                        + SNACK_COLUMN_DAYID + " VARCHAR(15)"
                        + ")";

        public static final String CREATE_TABLE_DAY = "CREATE TABLE " + TABLE_DAY + "("
                        + DAY_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                        + DAY_COLUMN_DATE + " VARCHAR(50),"
                        + DAY_COLUMN_CALORIE_GOAL + " VARCHAR(15)"
                        + ")";

  

}
