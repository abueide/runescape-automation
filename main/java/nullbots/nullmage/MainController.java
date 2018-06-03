package nullbots.nullmage;

import com.runemate.game.api.hybrid.util.StopWatch;
import com.runemate.game.api.script.framework.core.BotPlatform;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainController implements Initializable {
    @FXML
    private Label timelabel;
    @FXML
    private Label xplabel;
    @FXML
    private Label xphrlabel;

    private StopWatch stopWatch = new StopWatch();


    private BotPlatform botPlatform;

    public MainController(BotPlatform botPlatform) {
        this.botPlatform = botPlatform;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> update());
            }
        }, 0, 1000);
        stopWatch.start();
    }

    private void update() {
        timelabel.setText(stopWatch.getRuntimeAsString());
        xplabel.setText(Integer.toString(NullMage.expGained) + " XP Gained");
        if (stopWatch.getRuntime(TimeUnit.SECONDS) == 0) {
            xphrlabel.setText("0 XP/HR");
        } else {
            xphrlabel.setText(Long.toString(NullMage.expGained / stopWatch.getRuntime(TimeUnit.SECONDS) * 3600) + " XP/HR");
        }
    }
}
