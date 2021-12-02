package panes;

import Models.Day;
import constants.Const;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import launch.Main;
import scenes.accountSettingsScene;
import scenes.creditsScene;
import tables.DayTable;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class accountSettingsPane extends BorderPane {

    public accountSettingsPane() {
        this.setBackground(new Background(new BackgroundFill(Const.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        MenuBar menu = new MenuBar();

        Menu Menu = new Menu("File");

        MenuItem application = new MenuItem("Application");
        application.setOnAction(e -> {
            Main.homeMenu();
        });

        MenuItem credits = new MenuItem("Credits");
        credits.setOnAction(e -> {
            Main.mainStage.setScene(new creditsScene());
        });

        MenuItem exit = new MenuItem("Exit Application");
        exit.setOnAction(e-> {
            System.exit(0);
        });
        Menu.getItems().addAll(application, credits, exit);

        menu.getMenus().addAll(Menu);
        this.setTop(menu);

        //Content

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final TextField usernameTF = new TextField();
        usernameTF.setPromptText("Username");
        usernameTF.setPrefColumnCount(25);
        GridPane.setConstraints(usernameTF, 0, 0);

        final PasswordField passwordTF = new PasswordField();
        passwordTF.setPromptText("Password");
        passwordTF.setPrefColumnCount(25);
        GridPane.setConstraints(passwordTF, 0, 1);


        final TextField serverLocationTF = new TextField();
        serverLocationTF.setPromptText("Server Location");
        serverLocationTF.setPrefColumnCount(25);
        GridPane.setConstraints(serverLocationTF, 0, 2);

        final TextField databaseTF = new TextField();
        databaseTF.setPromptText("Calories");
        databaseTF.setPrefColumnCount(25);
        GridPane.setConstraints(databaseTF, 0, 3);

        Button submit = new Button("Submit");
        submit.setFont(Const.BUTTON_FONT);
        GridPane.setConstraints(submit, 1, 0);
        submit.setOnAction(e -> {

        });

        Button clear = new Button("Clear");
        clear.setFont(Const.BUTTON_FONT);
        GridPane.setConstraints(clear, 2, 0);
        clear.setOnAction(e -> {
            usernameTF.clear();
            passwordTF.clear();
            serverLocationTF.clear();
            databaseTF.clear();
        });

        grid.getChildren().addAll(usernameTF, passwordTF, serverLocationTF, databaseTF, submit, clear);
        grid.setAlignment(Pos.CENTER);
        this.setCenter(grid);
    }
}
