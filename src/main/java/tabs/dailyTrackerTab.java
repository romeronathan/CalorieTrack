package tabs;

import javafx.scene.control.Tab;
import panes.dailyTrackerPane;

public class dailyTrackerTab extends Tab {

    private static dailyTrackerTab tab;

    public dailyTrackerTab() {
        this.setText("Daily Tracker");
        this.setClosable(false);
        this.setContent(new dailyTrackerPane());
    }

    public static dailyTrackerTab getInstance() {
        if (tab == null) {
            tab = new dailyTrackerTab();
        }
        return tab;
    }
}
