package scenes;

import database.DBConst;
import javafx.scene.Scene;
import panes.addDayPane;

public class addDayScene extends Scene {
    public addDayScene() {
        super(new addDayPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }

}
