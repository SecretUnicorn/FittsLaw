package LectureTest;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author Nicklas Ahlers
 */
public class Test2 extends Application {

    private Scene mainScene;
    private TestController2 testController;


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
        testController = new TestController2(primaryStage);
        mainScene = new Scene(testController.getView(), 800, 800);

        primaryStage.setTitle("MCI Fitts Test - Ahlers - Melcher");
        primaryStage.setScene(mainScene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}