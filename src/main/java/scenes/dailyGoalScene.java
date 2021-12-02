package scenes;

import constants.Const;
import database.DBConst;
import javafx.scene.Scene;
import panes.dailyGoalPane;

public class dailyGoalScene extends Scene {
    public dailyGoalScene() {
        super(new dailyGoalPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
