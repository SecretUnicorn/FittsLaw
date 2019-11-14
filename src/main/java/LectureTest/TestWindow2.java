package LectureTest;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class TestWindow2 extends StackPane {

    Label titel;
    Rectangle left, right;
    private HBox main;
    Label time;
    JFXButton start;

    TestWindow2() {
        start = new JFXButton("Starte Test 1");
        main = new HBox();
        left = new Rectangle();
        right = new Rectangle();
        time = new Label("0s\nTreffer 0");
        titel = new Label("Tutorial\n" +
                "1. Starten Sie den Test\n" +
                "2. Druecken Sie abwechselnd auf die farbige Flaeche fuer 20s\n" +
                "3. Wiederholen Sie das gleiche im zweiten Test\n" +
                "4. Ueberpruefen Sie die Trefferdifferenz zwischen Test 1 und Test 2");
        time.setStyle("-fx-font-size: 24px;");
        start.setButtonType(JFXButton.ButtonType.RAISED);
        StackPane.setMargin(start, new Insets(20, 0, 0, 0));
        start.setStyle("-fx-text-fill:#1e1e1e;-fx-background-color:#ffffff;-fx-font-size:24px;-fx-padding:5px;");
        StackPane.setAlignment(start, Pos.TOP_CENTER);
        StackPane.setAlignment(time, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(titel, Pos.CENTER);

        left.heightProperty().bind(this.heightProperty());
        right.heightProperty().bind(this.heightProperty());
        left.setFill(Color.rgb(60, 60, 60));
        right.setFill(Color.rgb(60, 60, 60));
        left.setWidth(100);
        right.setWidth(100);
        HBox middle = new HBox();
        HBox.setHgrow(middle, Priority.ALWAYS);
        main.getChildren().addAll(left, middle, right);
        this.getChildren().addAll(main, start, time, titel);
    }
}
