package scenes;

import database.DBConst;
import javafx.scene.Scene;
import panes.addDrinkPane;

public class addDrinkScene extends Scene {

    public addDrinkScene() {
        super(new addDrinkPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
