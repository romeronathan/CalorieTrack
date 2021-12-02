package scenes;

import Models.NutritionItem;
import constants.Const;
import database.DBConst;
import javafx.scene.Scene;
import panes.updateItemPane;

public class updateItemScene extends Scene {

    public updateItemScene(NutritionItem item) {
        super(new updateItemPane(item), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
