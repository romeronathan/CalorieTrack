package scenes;

import Database.Const;
import javafx.scene.Scene;
import panes.dailyTrackerPane;

public class dailyTrackerScene extends Scene {
    public dailyTrackerScene() {
        super(new dailyTrackerPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
