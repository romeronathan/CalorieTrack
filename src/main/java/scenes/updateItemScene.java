package scenes;

import Models.NutritionItem;
import constants.Const;
import database.DBConst;
import javafx.scene.Scene;
import panes.updateItemPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Scene for the update item scene
 */

public class updateItemScene extends Scene {

    public updateItemScene(NutritionItem item) {
        super(new updateItemPane(item), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
