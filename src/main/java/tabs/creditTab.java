package tabs;

import javafx.scene.control.Tab;
import panes.creditsPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Tab Pane for creditsPane
 */

public class creditTab extends Tab {

    private static creditTab tab;

    public creditTab() {
        this.setText("Credits");
        this.setClosable(false);
        this.setContent(new creditsPane());
    }

    /**
     * @author Devon Divinecz
     * @description Method to add tab to the tabPane
     * @method getInstance
     * @return tab
     */

    public static creditTab getInstance() {
        if (tab == null) {
            tab = new creditTab();
        }
        return tab;
    }
}
