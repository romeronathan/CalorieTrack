package scenes;

import constants.Const;
import database.DBConst;
import javafx.scene.Scene;
import panes.creditsPane;

public class creditsScene extends Scene {
    public creditsScene() {
        super(new creditsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
