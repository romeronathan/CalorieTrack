package scenes;

import database.DBConst;
import javafx.scene.Scene;
import panes.addItemPane;

public class addFoodScene extends Scene {
    public addFoodScene() {
        super(new addItemPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
