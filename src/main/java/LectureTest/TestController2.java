package LectureTest;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestController2 {

    static final int TIME_PER_TEST = 20;
    static final Color GREEN = Color.rgb(0, 190, 15);
    static final Color DARK_GRAY = Color.rgb(55, 55, 55);
    private TestWindow2 view;
    private int clicks = 0;
    private int[] clickSave = {0, 0};
    private boolean isBig = true;
    private boolean right = true;
    private boolean testIsRunning = true;
    private boolean timerStopped = false;
    private Stage pStage;
    private SimpleIntegerProperty timeElapsed = new SimpleIntegerProperty(0);
    private Timer timer = new Timer();
    private double[] times = {0, 0, 0, 0};

    public TestController2(Stage pStage) {
        this.pStage = pStage;
        this.view = new TestWindow2();
        this.view.start.setOnAction(event -> {
            startStopTest();
        });
        view.left.widthProperty().bind(pStage.widthProperty().divide(4));
        view.right.widthProperty().bind(pStage.widthProperty().divide(4));
    }

    private void startStopTest() {
        view.getChildren().remove(view.titel);
        if (testIsRunning) {
            timerStopped = false;
            testIsRunning = false;
            starTimer();
            right = true;
            view.right.setFill(GREEN);
            view.right.setOnMouseClicked(mouseEvent -> {
                if (right && !timerStopped) {
                    right = false;
                    view.left.setFill(GREEN);
                    view.right.setFill(DARK_GRAY);
                    Platform.runLater(() -> {
                        clicks++;
                    });
                }
            });
            view.left.setOnMouseClicked(mouseEvent -> {
                if (!right && !timerStopped) {
                    right = true;
                    view.right.setFill(GREEN);
                    view.left.setFill(DARK_GRAY);
                    Platform.runLater(() -> {
                        clicks++;
                    });
                }
            });
        } else {
            this.view.time.setText("" +
                    "Anzahl Treffer von Test 1: \t" + clickSave[0] + "\n" +
                    "Anzahl Treffer von Test 2: \t" + clickSave[1] + "\n");
            testIsRunning = true;
            this.view.start.setText("Starte Test 1");
            view.getChildren().add(view.titel);
        }
    }

    private void starTimer() {
        this.timeElapsed.addListener(((observable, oldValue, newValue) -> {

            double sec = TIME_PER_TEST - (newValue.doubleValue() / 1000.0);

            Platform.runLater(() -> {
                double show_sec = sec * 100;
                show_sec = (int) show_sec;
                show_sec /= 100;
                view.time.setText("Zeit verbleibend: \t" + String.format("%.2f", show_sec) + "s\nAnzahl Treffer: \t" + clicks);
            });

            if (sec < 0) {
                stopTimer();
            }
        }));
        this.timer.start();
    }

    private void stopTimer() {
        timerStopped = true;
        this.view.right.setFill(Color.DARKGRAY);
        this.view.left.setFill(Color.DARKGRAY);
        this.timer.interrupt();
        this.timer = new Timer();
        if (isBig) {
            Platform.runLater(() -> this.view.start.setText(">>>> Weiter mit dem 2. Test <<<<"));
            clickSave[0] = clicks;
            clicks = 0;
            timeElapsed.set(0);
            isBig = false;
            view.left.widthProperty().bind(pStage.widthProperty().divide(20));
            view.right.widthProperty().bind(pStage.widthProperty().divide(20));
            testIsRunning = true;
        } else {
            clickSave[1] = clicks;
            clicks = 0;
            timeElapsed.set(0);
            isBig = true;
            testIsRunning = false;
            Platform.runLater(() -> {
                this.view.start.setText("Reset Test");
                view.left.widthProperty().bind(pStage.widthProperty().divide(4));
                view.right.widthProperty().bind(pStage.widthProperty().divide(4));
                this.view.time.setText("" +
                        "Anzahl Treffer von Test 1: \t" + clickSave[0] + "\n" +
                        "Anzahl Treffer von Test 2: \t" + clickSave[1] + "\n");
            });

        }
    }

    public TestWindow2 getView() {
        return view;
    }

    public class Timer extends Thread {

        Timer() {
            setDaemon(true);
        }

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


}
