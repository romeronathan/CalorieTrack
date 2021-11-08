package scenes;

import database.DBConst;
import javafx.scene.Scene;
import panes.creditsPane;

public class creditsScene extends Scene {
    public creditsScene() {
        super(new creditsPane(), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
