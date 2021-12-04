package tabs;

import javafx.scene.control.Tab;
import panes.dailyTrackerPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Tab Pane for dailyTrackerPane
 */

public class dailyTrackerTab extends Tab {

    private static dailyTrackerTab tab;

    public void refresh(){
        this.setContent(new dailyTrackerPane());
    }
    public dailyTrackerTab() {
        this.setText("Daily Tracker");
        this.setClosable(false);
        this.setContent(new dailyTrackerPane());
    }

    /**
     * @author Devon Divinecz
     * @description Method to add tab to the tabPane
     * @method getInstance
     * @return tab
     */

    public static dailyTrackerTab getInstance() {
        if (tab == null) {
            tab = new dailyTrackerTab();

        }
        return tab;
    }

}
