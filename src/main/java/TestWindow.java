import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class TestWindow extends VBox {

    private VBox top;
    private HBox bottom;
    private Label titel;

    Label time;
    AnchorPane anchorPane;
    JFXButton start;

    public TestWindow(){
        this.anchorPane = new AnchorPane();
        this.anchorPane.setBackground(new Background(new BackgroundFill(Color.rgb(220,220,220), null, null)));
        this.titel = new Label("Fitts law - Test");
        this.time = new Label("Test 1 (near & big): \nTest 2 (far & big): \nTest 3 (near & small): \nTest 4 (far & small): \n    ");
        this.top = new VBox();
        this.bottom = new HBox();
        this.start = new JFXButton("Start test");
        this.top.getChildren().addAll(titel, start);
        this.bottom.getChildren().add(time);
        this.top.setAlignment(Pos.CENTER);
        this.bottom.setAlignment(Pos.CENTER);
        VBox.setVgrow(anchorPane,Priority.SOMETIMES);
        this.getChildren().addAll(top,anchorPane,bottom);
    }
}
