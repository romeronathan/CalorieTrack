package scenes;

import constants.Const;
import database.DBConst;
import javafx.scene.Scene;
import panes.addDayPane;

public class addDayScene extends Scene {
    public addDayScene() {
        super(new addDayPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }

}
