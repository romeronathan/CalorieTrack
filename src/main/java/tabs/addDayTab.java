package tabs;

import javafx.scene.control.Tab;
import panes.addDayPane;
import panes.dailyTrackerPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Tab Pane for addDayPane
 */

public class addDayTab extends Tab {

    private static addDayTab tab;

    public addDayTab() {
        this.setText("Add Day");
        this.setClosable(false);
        this.setContent(new addDayPane());
    }

    /**
     * @author Devon Divinecz
     * @description Method to add tab to the tabPane
     * @method getInstance
     * @return tab
     */
    public void refresh(){
        this.setContent(new addDayPane());
    }
    public static addDayTab getInstance() {
        if (tab == null) {
            tab = new addDayTab();
        }
        return tab;
    }

}
