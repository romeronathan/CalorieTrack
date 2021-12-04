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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import static launch.Main.homeMenu;

public class accountSettingsPane extends BorderPane {

    File accountSettings = new File("Account/account_settings");

    public static String username;
    public static String password;
    public static String serverLocation;
    public static String database;


    public accountSettingsPane() {
        this.setBackground(new Background(new BackgroundFill(Const.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

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

        final TextField usernameTF = new TextField();
        usernameTF.setPromptText("Username");
        usernameTF.setText(username);
        usernameTF.setPrefColumnCount(25);
        GridPane.setConstraints(usernameTF, 0, 0);

        final PasswordField passwordTF = new PasswordField();
        passwordTF.setPromptText("Password");
        passwordTF.setText(password);
        passwordTF.setPrefColumnCount(25);
        GridPane.setConstraints(passwordTF, 0, 1);


        final TextField serverLocationTF = new TextField();
        serverLocationTF.setPromptText("Server Location");
        serverLocationTF.setText(serverLocation);
        serverLocationTF.setPrefColumnCount(25);
        GridPane.setConstraints(serverLocationTF, 0, 2);

        final TextField databaseTF = new TextField();
        databaseTF.setPromptText("Database");
        databaseTF.setText(database);
        databaseTF.setPrefColumnCount(25);
        GridPane.setConstraints(databaseTF, 0, 3);

        Button submit = new Button("Submit");
        submit.setFont(Const.BUTTON_FONT);
        GridPane.setConstraints(submit, 1, 0);
        submit.setOnAction(e -> {
            username = usernameTF.getText();
            password = passwordTF.getText();
            serverLocation = serverLocationTF.getText();
            database = databaseTF.getText();
            //clear the file and write username, password, serverLocation, database
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

            homeMenu();
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
