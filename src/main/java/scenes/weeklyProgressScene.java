package scenes;

import Database.DBConst;
import javafx.scene.Scene;
import panes.weeklyProgressPane;

public class weeklyProgressScene extends Scene {
    public weeklyProgressScene() {
        super(new weeklyProgressPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
