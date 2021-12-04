package tabs;

import javafx.scene.control.Tab;
import panes.dailyTrackerPane;
import panes.weeklyProgressPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Tab Pane for weeklyProgressPane
 */

public class weeklyProgressTab extends Tab {

    private static weeklyProgressTab tab;

    public weeklyProgressTab() {
        this.setText("Weekly Progress");
        this.setClosable(false);
        this.setContent(new weeklyProgressPane());
    }
    public void refresh(){
        this.setContent(new weeklyProgressPane());
    }

    /**
     * @author Devon Divinecz
     * @description Method to add tab to the tabPane
     * @method getInstance
     * @return tab
     */

    public static weeklyProgressTab getInstance() {
        if (tab == null) {
            tab = new weeklyProgressTab();
        }
        return tab;
    }
}
