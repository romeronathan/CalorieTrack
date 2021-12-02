package scenes;

import constants.Const;
import database.DBConst;
import javafx.scene.Scene;
import panes.addItemPane;

public class addDrinkScene extends Scene {

    public addDrinkScene() {
        super(new addItemPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
