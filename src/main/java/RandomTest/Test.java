package RandomTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author Nicklas Ahlers
 */
public class Test extends Application {

    private Scene mainScene;
    private TestController testController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        testController = new TestController();
        mainScene = new Scene(testController.getView(), 800, 800);

        primaryStage.setTitle("MCI Fitts Test - Ahlers - Melcher");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

}