package scenes;

import Models.NutritionItem;
import database.DBConst;
import javafx.scene.Scene;
import panes.updateItemPane;

public class updateItemScene extends Scene {

    public updateItemScene(NutritionItem item) {
        super(new updateItemPane(item), DBConst.SCREEN_WIDTH, DBConst.SCREEN_HEIGHT);
    }
}
