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
                + DRINK_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DRINK_COLUMN_NAME + " TEXT,"
                + DRINK_COLUMN_CALORIES + " INTEGER,"
                + DRINK_COLUMN_PORTION + " INTEGER,"
                + DRINK_COLUMN_DAYID + " INTEGER"
                + ")";

        public static final String CREATE_TABLE_MEAL = "CREATE TABLE " + TABLE_MEAL + "("
                        + MEAL_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + MEAL_COLUMN_NAME + " TEXT,"
                        + MEAL_COLUMN_CALORIES + " INTEGER,"
                        + MEAL_COLUMN_PORTION + " INTEGER,"
                        + MEAL_COLUMN_DAYID + " INTEGER"
                        + ")";

        public static final String CREATE_TABLE_SNACK = "CREATE TABLE " + TABLE_SNACK + "("
                        + SNACK_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + SNACK_COLUMN_NAME + " TEXT,"
                        + SNACK_COLUMN_CALORIES + " INTEGER,"
                        + SNACK_COLUMN_PORTION + " INTEGER,"
                        + SNACK_COLUMN_DAYID + " INTEGER"
                        + ")";

        public static final String CREATE_TABLE_DAY = "CREATE TABLE " + TABLE_DAY + "("
                        + DAY_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + DAY_COLUMN_DATE + " TEXT,"
                        + DAY_COLUMN_CALORIE_GOAL + " INTEGER"
                        + ")";

  

}
