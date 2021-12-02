package scenes;

import constants.Const;
import database.DBConst;
import javafx.scene.Scene;
import panes.weeklyProgressPane;

public class weeklyProgressScene extends Scene {
    public weeklyProgressScene() {
        super(new weeklyProgressPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
