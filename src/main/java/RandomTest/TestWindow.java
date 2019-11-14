package RandomTest;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


class TestWindow extends VBox {

    Label time;
    AnchorPane anchorPane;
    JFXButton start;
    private VBox top;
    private HBox bottom;
    private Label titel;

    TestWindow() {
        anchorPane = new AnchorPane();
        anchorPane.setBackground(new Background(new BackgroundFill(Color.rgb(220, 220, 220), null, null)));
        titel = new Label("Fitts law - Test");
        time = new Label("Tutorial\n" +
                "1. Press Start Test\n" +
                "2. Click inside the green Rectangle\n" +
                "3. Click the blue Rectangle ASAP\n" +
                "4. Repeat 4 times\n" +
                "5. Check the end result");
        top = new VBox();
        bottom = new HBox();
        start = new JFXButton("Start test");

        start.setButtonType(JFXButton.ButtonType.RAISED);
        start.setStyle("-fx-text-fill:#1e1e1e;-fx-background-color:#ffffff;-fx-font-size:10px;-fx-padding:5px;");
        this.top.getChildren().addAll(titel, start);
        this.bottom.getChildren().add(time);
        this.top.setAlignment(Pos.CENTER);
        this.bottom.setAlignment(Pos.CENTER);
        VBox.setVgrow(anchorPane, Priority.SOMETIMES);
        this.getChildren().addAll(top, anchorPane, bottom);
    }
}
