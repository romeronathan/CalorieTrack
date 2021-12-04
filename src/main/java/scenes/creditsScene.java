package scenes;

import constants.Const;
import database.DBConst;
import javafx.scene.Scene;
import panes.creditsPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Scene for the credits
 */

public class creditsScene extends Scene {
    public creditsScene() {
        super(new creditsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
