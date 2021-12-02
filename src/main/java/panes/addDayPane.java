package panes;

import Models.Day;
import constants.Const;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import launch.Main;
import scenes.*;
import tables.DayTable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;


public class addDayPane extends BorderPane {

    public addDayPane() {
        this.setBackground(new Background(new BackgroundFill(Const.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final TextField yearTF = new TextField();
        yearTF.setPromptText("Year");
        yearTF.setPrefColumnCount(10);
        GridPane.setConstraints(yearTF, 0, 0);

        final TextField monthTF = new TextField();
        monthTF.setPromptText("Month");
        monthTF.setPrefColumnCount(15);
        GridPane.setConstraints(monthTF, 0, 1);


        final TextField dayTF = new TextField();
        dayTF.setPromptText("Day");
        dayTF.setPrefColumnCount(20);
        GridPane.setConstraints(dayTF, 0, 2);

        final TextField calorieTF = new TextField();
        calorieTF.setPromptText("Calories");
        calorieTF.setPrefColumnCount(25);
        GridPane.setConstraints(calorieTF, 0, 3);

        Button submit = new Button("Submit");
        submit.setFont(Const.BUTTON_FONT);
        GridPane.setConstraints(submit, 1, 0);
        submit.setOnAction(e -> {
            if (dayTF.getText().isEmpty()) {
                dayTF.setPromptText("Please enter a day");
            } else {
               try {
                   int year = Integer.parseInt(yearTF.getText());
                   int month = Integer.parseInt(monthTF.getText());
                   int day = Integer.parseInt(dayTF.getText());
                   int calorieGoal = Integer.parseInt(calorieTF.getText());

                   String dateString = year + "-" + month + "-" + day;
                   LocalDate localDate = LocalDate.of(year, month, day);
                   Date date = Date.valueOf(localDate);
                   System.out.println(date);

                   if (year > 9999 || month > 12 || day > 31) {
                       dayTF.clear();
                       monthTF.clear();
                       yearTF.clear();
                       dayTF.setPromptText("Invalid inputs. Please enter a day up to 31.");
                       monthTF.setPromptText("Invalid inputs. Please enter a month up to 12.");
                        yearTF.setPromptText("Invalid inputs. Please enter a day up to 9999.");
                   } else{

                       Day oldDay = new DayTable().getDayByDate(date);
                       if(oldDay != null) {
                           dayTF.clear();
                           monthTF.clear();
                           yearTF.clear();
                           calorieTF.clear();
                           dayTF.setPromptText("Day already made with this date!");
                           monthTF.setPromptText("Day already made with this date!");
                           yearTF.setPromptText("Day already made with this date!");
                           calorieTF.setPromptText("Day already made with this date!");
                       }
                       else {
                           Day newDay = new Day(date, calorieGoal);
                           new DayTable().createDay(newDay);

                          Main.updateDate(newDay);
                       }







                   }


               }
               catch (Exception exception) {

               }
            }
        });

        Button clear = new Button("Clear");
        clear.setFont(Const.BUTTON_FONT);
        GridPane.setConstraints(clear, 2, 0);
        clear.setOnAction(e -> {
            dayTF.clear();
        });

        grid.getChildren().addAll(yearTF, monthTF, dayTF, calorieTF, submit, clear);
        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);
    }

}
