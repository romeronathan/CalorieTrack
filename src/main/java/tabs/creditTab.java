package tabs;

import javafx.scene.control.Tab;
import panes.creditsPane;

public class creditTab extends Tab {

    private static creditTab tab;

    public creditTab() {
        this.setText("Credits");
        this.setClosable(false);
        this.setContent(new creditsPane());
    }

    public static creditTab getInstance() {
        if (tab == null) {
            tab = new creditTab();
        }
        return tab;
    }
}
