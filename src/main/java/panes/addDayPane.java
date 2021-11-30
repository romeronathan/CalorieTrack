package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import launch.Main;
import scenes.*;

public class addDayPane extends BorderPane {

    public addDayPane() {
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final TextField dayTF = new TextField();
        dayTF.setPromptText("Day");
        dayTF.setPrefColumnCount(10);
        GridPane.setConstraints(dayTF, 0, 0);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0);
        submit.setOnAction(e -> {
            if (dayTF.getText().isEmpty()) {
                dayTF.setPromptText("Please enter a day");
            } else {
                //TODO Add day to database
            }
        });

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 2, 0);
        clear.setOnAction(e -> {
            dayTF.clear();
        });

        grid.getChildren().addAll(dayTF, submit, clear);
        grid.setAlignment(Pos.CENTER);

        this.setCenter(grid);
    }

}
