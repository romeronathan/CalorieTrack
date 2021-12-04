package scenes;

import constants.Const;
import javafx.scene.Parent;
import javafx.scene.Scene;
import panes.viewDayPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Scene for the view day scene
 */

public class viewDayScene extends Scene {
    public viewDayScene() {
        super(new viewDayPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
