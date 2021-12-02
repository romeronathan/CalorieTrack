package scenes;

import constants.Const;
import javafx.scene.Parent;
import javafx.scene.Scene;
import panes.accountSettingsPane;

public class accountSettingsScene extends Scene {
    public accountSettingsScene() {
        super(new accountSettingsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
