package tabs;

import javafx.scene.control.Tab;
import panes.dailyGoalPane;
import panes.dailyTrackerPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Tab Pane for dailyGoalPane
 */

public class dailyGoalTab extends Tab {

    private static dailyGoalTab tab;
    public void refresh(){
        this.setContent(new dailyGoalPane());
    }
    public dailyGoalTab() {
        this.setText("Daily Goal");
        this.setClosable(false);
        this.setContent(new dailyGoalPane());
    }

    /**
     * @author Devon Divinecz
     * @description Method to add tab to the tabPane
     * @method getInstance
     * @return tab
     */

    public static dailyGoalTab getInstance() {
        if (tab == null) {
            tab = new dailyGoalTab();
        }
        return tab;
    }
}
