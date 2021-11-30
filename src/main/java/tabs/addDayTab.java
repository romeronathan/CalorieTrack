package tabs;

import javafx.scene.control.Tab;
import panes.addDayPane;

public class addDayTab extends Tab {

    private static addDayTab tab;

    public addDayTab() {
        this.setText("Add Day");
        this.setClosable(false);
        this.setContent(new addDayPane());
    }

    public static addDayTab getInstance() {
        if (tab == null) {
            tab = new addDayTab();
        }
        return tab;
    }

}
