import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author Nicklas Ahlers
 */
public class Test extends Application {

    /*

    https://github.com/jfoenixadmin/JFoenix

     */

    private Scene mainScene;
    private Stage pStage;
    private TestController testController;
    /*

        Pro Chat dann halt sagen ok sende Nachricht XY an ClientBsp Z
        send(msgXY, getIp(Z), getPort(Z))

     */

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
        this.pStage = primaryStage;
        testController = new TestController(primaryStage);
        mainScene = new Scene(testController.getView(), 800, 800);

        primaryStage.setTitle("MCI - Test");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}