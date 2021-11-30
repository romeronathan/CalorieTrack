package tabs;

import javafx.scene.control.Tab;
import panes.addDrinkPane;

public class addItemTab extends Tab {

    private static addItemTab tab;

    public addItemTab() {
        this.setText("Add Item");
        this.setClosable(false);
        this.setContent(new addDrinkPane());
    }

    public static addItemTab getInstance() {
        if (tab == null) {
            tab = new addItemTab();
        }
        return tab;
    }
}
