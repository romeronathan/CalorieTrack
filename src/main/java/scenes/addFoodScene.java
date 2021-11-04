package scenes;

import Database.Const;
import javafx.scene.Scene;
import panes.addFoodPane;

public class addFoodScene extends Scene {
    public addFoodScene() {
        super(new addFoodPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
