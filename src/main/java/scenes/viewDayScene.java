package scenes;

import constants.Const;
import javafx.scene.Parent;
import javafx.scene.Scene;
import panes.viewDayPane;

public class viewDayScene extends Scene {
    public viewDayScene() {
        super(new viewDayPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
