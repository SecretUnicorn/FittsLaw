package application;

import LectureTest.TestController2;
import RandomTest.TestController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene startScene;
    private Scene sceneTest1;
    private Scene sceneTest2;
    private TestController testController;
    private TestController2 testController2;
    private Stage pStage;

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
        pStage = primaryStage;
        startScene = new Scene(new SelectView(this), 800, 800);
        testController = new TestController();
        testController2 = new TestController2(primaryStage);
        sceneTest1 = new Scene(testController.getView(), 800, 800);
        sceneTest2 = new Scene(testController2.getView(), 800, 800);

        primaryStage.setTitle("MCI Fitts Test - Ahlers - Melcher");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    public void switchScenes(int dest) {
        if (dest == 1) {
            pStage.setScene(sceneTest2);
        } else {
            pStage.setScene(sceneTest1);
        }
    }


}
