package panes;

import constants.Const;
import database.DBConst;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import launch.Main;
import scenes.*;

public class creditsPane extends BorderPane {
    public creditsPane() {
        this.setStyle(Const.CREDIT_BACKGROUND_STYLE);

        //Menu

        MenuBar menu = new MenuBar();

        Menu Menu = new Menu("File");

        MenuItem application = new MenuItem("Application");
        application.setOnAction(e -> {
            Main.homeMenu();
        });

        MenuItem accountSettings = new MenuItem("Account Settings");
        accountSettings.setOnAction(e -> {
            Main.mainStage.setScene(new accountSettingsScene());
        });

        MenuItem exit = new MenuItem("Exit Application");
        exit.setOnAction(e-> {
            System.exit(0);
        });
        Menu.getItems().addAll(application, accountSettings, exit);

        menu.getMenus().addAll(Menu);
        this.setTop(menu);

        //Content

        //Credit VBox
        VBox creditsBox = new VBox();

        //Credit Text
        Text projectTitle = new Text();
        projectTitle.setText("Calorie Track");
        projectTitle.setTextAlignment(TextAlignment.CENTER);
        projectTitle.setStyle(Const.CREDITS_TEXT_STYLE);

        Text creators = new Text();
        creators.setText("Creators: Devon Divinecz & Nathan Romero");
        creators.setTextAlignment(TextAlignment.CENTER);
        creators.setStyle(Const.CREDITS_TEXT_STYLE);

        Text frontEnd = new Text();
        frontEnd.setText("Front End: Devon Divinecz");
        frontEnd.setTextAlignment(TextAlignment.CENTER);
        frontEnd.setStyle(Const.CREDITS_TEXT_STYLE);

        Text backEnd = new Text();
        backEnd.setText("Back End: Nathan Romero");
        backEnd.setTextAlignment(TextAlignment.CENTER);
        backEnd.setStyle(Const.CREDITS_TEXT_STYLE);

        //Animations

        SequentialTransition creditSequence = new SequentialTransition();
        creditSequence.getChildren().addAll(
                creditScroll(projectTitle),
                creditScroll(creators),
                creditScroll(frontEnd),
                creditScroll(backEnd)
        );
        creditSequence.play();

        //Add to VBox
        creditsBox.getChildren().addAll(projectTitle, creators, frontEnd, backEnd);
        creditsBox.setAlignment(Pos.CENTER);
        this.setCenter(creditsBox);

    }

    public TranslateTransition creditScroll(Node node) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1500), node);
        translateTransition.setFromY(450);
        translateTransition.setToY(0);
        return translateTransition;
    }

}
