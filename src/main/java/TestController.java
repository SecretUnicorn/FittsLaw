import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

class TestController {

    public class Timer extends Thread {
        @Override
        public void run() {
            while (!this.isInterrupted()) {
                timeElapsed.set(timeElapsed.get() + 1);
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    this.interrupt();
                }
            }
        }
    }

    private Random random;
    private TestWindow view;
    private int test = 0;
    private boolean testIsRunning = true;
    private Rectangle start;
    private Rectangle end;
    private SimpleIntegerProperty timeElapsed = new SimpleIntegerProperty(0);

    private Timer timer = new Timer();

    private double[] times = {0, 0, 0, 0};

    TestController(Stage pState) {
        this.random = new Random(System.currentTimeMillis());
        this.view = new TestWindow();
        this.view.start.setOnAction(event -> {
            startStopTest();
        });

    }

    private void startStopTest() {
        if (testIsRunning) {
            random = new Random(System.currentTimeMillis());
            timeElapsed.set(0);
            start = new Rectangle(100, 100);
            start.setFill(Color.GREEN);
            end = new Rectangle(20 * (test < 2 ? 10 : 1), 20 * (test < 2 ? 10 : 1));
            end.setFill(Color.rgb(43, 170, 255));
            boolean left = random.nextBoolean();
            boolean up = random.nextBoolean();
            int multi = (test == 0 || test == 2 ? 7 : 1) * (test == 2 ? 5 : 1);

            int startX = random.nextInt(30 * multi);
            int startY = random.nextInt(30 * multi);
            this.view.anchorPane.getChildren().add(start);

            double width = this.view.anchorPane.widthProperty().getValue();
            double height = this.view.anchorPane.heightProperty().getValue();
            AnchorPane.setLeftAnchor(start, width/2-50);
            AnchorPane.setRightAnchor(start, width/2-50);
            AnchorPane.setTopAnchor(start, height/2-50);
            AnchorPane.setBottomAnchor(start, height/2-50);

            if (left){
                AnchorPane.setLeftAnchor(end,(double)startX);
            } else {
                AnchorPane.setRightAnchor(end,(double)startX);
            }

            if(up){
                AnchorPane.setTopAnchor(end,(double)startY);
            } else {
                AnchorPane.setBottomAnchor(end,(double)startY);
            }

            start.setOnMouseClicked(event -> {
                this.view.anchorPane.getChildren().remove(start);
                starTimer();
                this.view.anchorPane.getChildren().add(end);
                end.setOnMouseClicked(e -> {
                    stopTimer();
                });
            });


        } else {
            view.time.setText("Test 1 (near & big): \nTest 2 (far & big): \nTest 3 (near & small): \nTest 4 (far & small):");
            view.start.setText("Start 1. Test");
            testIsRunning = true;
            test = 0;
        }
    }

    private void starTimer() {
        this.timeElapsed.addListener(((observable, oldValue, newValue) -> {
            double ms = newValue.doubleValue();
            double sec = newValue.doubleValue() / 1000.0;
            Platform.runLater(() -> {
                view.time.setText("Time elapsed: \t" + ms + "ms\nTime elapsed: \t" + sec + "s");
            });

        }));
        this.timer.start();
    }

    private void stopTimer() {
        this.view.anchorPane.getChildren().remove(end);
        times[test] = this.timeElapsed.getValue();
        this.timer.interrupt();
        this.timer = new Timer();
        test++;
        if (test < 4) {
            this.view.start.setText("Weiter mit dem " + (test+1) + ". Test");
        } else {
            updateTimes();
            this.view.start.setText("Reset Test");
            testIsRunning = false;
        }
    }

    private void updateTimes() {
        view.time.setText("Test 1 (near & big): " + (times[0] != 0 ? times[0]/1000 : "") +
                "s\nTest 2 (far & big): " + (times[1] != 0 ? times[1]/1000 : "") +
                "s\nTest 3 (near & small): " + (times[2] != 0 ? times[2]/1000 : "") +
                "s\nTest 4 (far & small):" + (times[3] != 0 ? times[3]/1000 : "") + "s");
    }

    TestWindow getView() {
        return view;
    }


}
