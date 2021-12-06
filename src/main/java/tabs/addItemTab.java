package tabs;

import javafx.scene.control.Tab;
import panes.addItemPane;
import panes.dailyGoalPane;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Tab Pane for addItemPane
 */

public class addItemTab extends Tab {

    private static addItemTab tab;

    public addItemTab() {
        this.setText("Add Item");
        this.setClosable(false);
        this.setContent(new addItemPane());
    }
    public void refresh(){
        this.setContent(new addItemPane());
    }
    /**
     * @author Devon Divinecz
     * @description Method to add tab to the tabPane
     * @method getInstance
     * @return tab
     */

    public static addItemTab getInstance() {
        if (tab == null) {
            tab = new addItemTab();
        }
        return tab;
    }
}
