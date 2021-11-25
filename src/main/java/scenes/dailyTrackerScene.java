package scenes;

import database.DBConst;
import javafx.scene.Scene;
import panes.dailyTrackerPane;

public class dailyTrackerScene extends Scene {
    public dailyTrackerScene() {
        super(new dailyTrackerPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
