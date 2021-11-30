package scenes;

import database.DBConst;
import javafx.scene.Scene;

public class addFoodScene extends Scene {
    public addFoodScene() {
        super(new addFoodPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
