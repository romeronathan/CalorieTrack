package scenes;

import Database.Const;
import javafx.scene.Scene;
import panes.addDrinkPane;

public class addDrinkScene extends Scene {

    public addDrinkScene() {
        super(new addDrinkPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
