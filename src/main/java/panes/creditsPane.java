package panes;

import database.DBConst;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import launch.Main;
import scenes.*;

public class creditsPane extends BorderPane {
    public creditsPane() {
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //Menu
        MenuBar menu = new MenuBar();

        Menu Menu = new Menu("File");

        MenuItem application = new MenuItem("Application");
        application.setOnAction(e -> {
            Main.homeMenu();
        });

        MenuItem exit = new MenuItem("Exit Application");
        exit.setOnAction(e-> {
            System.exit(0);
        });
        Menu.getItems().addAll(application, exit);

        menu.getMenus().addAll(Menu);
        this.setTop(menu);

        //Content


    }
}
