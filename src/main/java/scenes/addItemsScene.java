package scenes;

import Database.Const;
import javafx.scene.Scene;
import panes.addItemsPane;

public class addItemsScene extends Scene {
    public addItemsScene() {
        super(new addItemsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
