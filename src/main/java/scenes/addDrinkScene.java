package scenes;

import database.DBConst;
import javafx.scene.Scene;
import panes.addItemPane;

public class addDrinkScene extends Scene {

    public addDrinkScene() {
        super(new addItemPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
