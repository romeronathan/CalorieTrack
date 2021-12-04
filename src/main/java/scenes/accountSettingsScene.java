package scenes;

import constants.Const;
import javafx.scene.Parent;
import javafx.scene.Scene;
import panes.accountSettingsPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Scene for the account settings
 */

public class accountSettingsScene extends Scene {
    public accountSettingsScene() {
        super(new accountSettingsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
