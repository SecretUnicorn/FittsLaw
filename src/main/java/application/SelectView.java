package application;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class SelectView extends VBox {
    private Label titel;
    private JFXButton startTest1;
    private JFXButton startTest2;

    public SelectView(Main main) {
        titel = new Label("Tests - Fitts Law");
        startTest1 = new JFXButton("Test 1");
        startTest2 = new JFXButton("Test 2");

        VBox.setMargin(titel, new Insets(00, 0, 50, 0));
        titel.setStyle("-fx-font-size: 40px;");
        startTest1.setButtonType(JFXButton.ButtonType.RAISED);
        VBox.setMargin(startTest1, new Insets(20, 0, 0, 0));
        startTest1.setStyle("-fx-text-fill:#1e1e1e;-fx-background-color:#ffffff;-fx-font-size:24px;-fx-padding:5px;");

        startTest2.setButtonType(JFXButton.ButtonType.RAISED);
        VBox.setMargin(startTest2, new Insets(20, 0, 0, 0));
        startTest2.setStyle("-fx-text-fill:#1e1e1e;-fx-background-color:#ffffff;-fx-font-size:24px;-fx-padding:5px;");

        this.setAlignment(Pos.CENTER);

        startTest1.setOnAction((event) -> {
            main.switchScenes(1);
        });

        startTest2.setOnAction((event) -> {
            main.switchScenes(2);
        });

        this.getChildren().addAll(titel, startTest1, startTest2);

    }
}
