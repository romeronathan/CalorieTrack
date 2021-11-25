package scenes;

import database.DBConst;
import javafx.scene.Scene;
import panes.dailyGoalPane;

public class dailyGoalScene extends Scene {
    public dailyGoalScene() {
        super(new dailyGoalPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
