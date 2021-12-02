package constants;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Const {

    //Screen Size
    public static final int SCREEN_HEIGHT = 768;
    public static final int SCREEN_WIDTH = 1024;

    //Fonts
    public static final Font CREDIT_FONT = Font.font("Times New Roman",
            FontWeight.NORMAL,
            FontPosture.REGULAR,
            36);

    public static final Font TITLE_FONT = Font.font("Times New Roman",
            FontWeight.BOLD,
            FontPosture.REGULAR,
            36);

    public static final Font TEXT_FONT = Font.font("Times New Roman",
            FontWeight.NORMAL,
            FontPosture.REGULAR,
            14);

    public static final Font BUTTON_FONT = Font.font("Times New Roman",
            FontWeight.NORMAL,
            FontPosture.REGULAR,
            14);

    public static final Font SUCCESSFUL_ENTRY_FONT = Font.font("Times New Roman",
            FontWeight.BOLD,
            FontPosture.REGULAR,
            24);

    //Colors
    public static final Color WHITE = Color.rgb(255, 255, 255);
    public static final Color BLACK = Color.rgb(0, 0, 0);
    public static final Color GRAY = Color.rgb(128, 128, 128);
    public static final Color GREEN = Color.rgb(0, 128, 0);

    //Alignment
    public static final String CENTER_ALIGNMENT = "-fx-alignment: CENTER;";
}
