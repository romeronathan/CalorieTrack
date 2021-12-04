package tabs;

import javafx.scene.control.Tab;
import panes.historyPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Tab Pane for weeklyProgressPane
 */

public class historyTab extends Tab {

    private static historyTab tab;

    public historyTab() {
        this.setText("History");
        this.setClosable(false);
        this.setContent(new historyPane());
    }
    public void refresh(){
        this.setContent(new historyPane());
    }

    /**
     * @author Devon Divinecz
     * @description Method to add tab to the tabPane
     * @method getInstance
     * @return tab
     */

    public static historyTab getInstance() {
        if (tab == null) {
            tab = new historyTab();
        }
        return tab;
    }
}
