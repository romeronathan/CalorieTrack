package panes;

import Models.Day;
import constants.Const;
import database.DBConst;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import launch.Main;
import scenes.accountSettingsScene;
import scenes.creditsScene;
import tables.DayTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import static launch.Main.homeMenu;

/**
 * @author Devon Divinecz
 * @version 1.0
 * @date 12/4/2021
 * @description Pane to edit account settings
 */

public class accountSettingsPane extends BorderPane {

    public static File accountSettings = new File("Account/account_settings");

    public static String username;
    public static String password;
    public static String serverLocation;
    public static String database;


    public accountSettingsPane() {
        this.setStyle(Const.BACKGROUND_STYLE);

        readSettings();

        MenuBar menu = new MenuBar();

        Menu Menu = new Menu("File");

        MenuItem application = new MenuItem("Application");
        application.setOnAction(e -> {
            homeMenu();
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

        Text failedEntry = new Text("Form Incorrectly Filled!");
        failedEntry.setStyle(Const.FAILED_ENTRY_STYLE);
        failedEntry.setVisible(false);
        GridPane.setConstraints(failedEntry, 0, 0);

        final TextField usernameTF = new TextField();
        usernameTF.setPromptText("Username");
        usernameTF.setText(username);
        usernameTF.setPrefColumnCount(25);
        GridPane.setConstraints(usernameTF, 0, 1);

        final PasswordField passwordTF = new PasswordField();
        passwordTF.setPromptText("Password");
        passwordTF.setText(password);
        passwordTF.setPrefColumnCount(25);
        GridPane.setConstraints(passwordTF, 0, 2);


        final TextField serverLocationTF = new TextField();
        serverLocationTF.setPromptText("Server Location");
        serverLocationTF.setText(serverLocation);
        serverLocationTF.setPrefColumnCount(25);
        GridPane.setConstraints(serverLocationTF, 0, 3);

        final TextField databaseTF = new TextField();
        databaseTF.setPromptText("Database");
        databaseTF.setText(database);
        databaseTF.setPrefColumnCount(25);
        GridPane.setConstraints(databaseTF, 0, 4);

        Button submit = new Button("Submit");
        submit.setStyle(Const.BUTTON_STYLE);
        GridPane.setConstraints(submit, 1, 1);
        submit.setOnAction(e -> {
            if(usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty() || serverLocationTF.getText().isEmpty() || databaseTF.getText().isEmpty()) {
                failedEntry.setVisible(true);
                new Timeline(new KeyFrame(Duration.seconds(3), ae -> failedEntry.setVisible(false))).play();
            } else {
                username = usernameTF.getText();
                password = passwordTF.getText();
                serverLocation = serverLocationTF.getText();
                database = databaseTF.getText();

                updateSettings();
                homeMenu();
            }
        });

        Button clear = new Button("Clear");
        clear.setStyle(Const.BUTTON_STYLE);
        GridPane.setConstraints(clear, 1, 2);
        clear.setOnAction(e -> {
            usernameTF.clear();
            passwordTF.clear();
            serverLocationTF.clear();
            databaseTF.clear();
        });

        grid.getChildren().addAll(usernameTF, passwordTF, serverLocationTF, databaseTF, submit, clear, failedEntry);
        grid.setAlignment(Pos.CENTER);
        this.setCenter(grid);
    }

    /**
     * @author Devon Divinecz
     * @description Method to read from account_settings.txt
     * @method returnToWeeklyProgress
     */

    public static void readSettings() {
        try {
            Scanner in = new Scanner(accountSettings);
            username = in.nextLine();
            password = in.nextLine();
            serverLocation = in.nextLine();
            database = in.nextLine();
            System.out.println(username + " " + password + " " + serverLocation + " " + database);
            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @author Devon Divinecz
     * @description Method to write to account_settings.txt
     * @method returnToWeeklyProgress
     */

    public static void updateSettings() {
        try {
            Scanner in = new Scanner(accountSettings);
            in.close();
            accountSettings.delete();
            accountSettings.createNewFile();
            FileWriter fw = new FileWriter(accountSettings);
            fw.write(username + "\n" + password + "\n" + serverLocation + "\n" + database);
            fw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
