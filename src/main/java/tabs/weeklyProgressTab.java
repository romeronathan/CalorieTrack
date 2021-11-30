package tabs;

import javafx.scene.control.Tab;
import panes.weeklyProgressPane;

public class weeklyProgressTab extends Tab {

    private static weeklyProgressTab tab;

    public weeklyProgressTab() {
        this.setText("Weekly Progress");
        this.setClosable(false);
        this.setContent(new weeklyProgressPane());
    }

    public static weeklyProgressTab getInstance() {
        if (tab == null) {
            tab = new weeklyProgressTab();
        }
        return tab;
    }
}
