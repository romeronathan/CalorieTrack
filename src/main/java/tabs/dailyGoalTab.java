package tabs;

import javafx.scene.control.Tab;
import panes.dailyGoalPane;
import panes.dailyTrackerPane;

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

    public static dailyGoalTab getInstance() {
        if (tab == null) {
            tab = new dailyGoalTab();
        }
        return tab;
    }
}
