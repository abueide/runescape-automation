package nullbots.nullifersabyss.ui.controller;

import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.core.BotPlatform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import nullbots.nullhide.util.PrefWrapper;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

/**
 * Created by Nullifer on 3/5/17.
 */
public class SettingsController extends VBox implements Initializable {
    @FXML
    ComboBox leatherCombo;
    @FXML
    Button crafterLocationButton;
    @FXML
    Text crafterLocationText;

    private BotPlatform platform;

    public SettingsController(BotPlatform platform) {
        this.platform = platform;
    }

    public void initialize(URL location, ResourceBundle resources) {
//        leatherCombo.setItems(FXCollections.observableArrayList("Black dragon leather", "Blue dragon leather"));
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Black dragon leather",
                        "Royal dragon leather",
                        "Blue dragon leather",
                        "Green dragon leather",
                        "Red dragon leather",
                        "Leather",
                        "Hard leather"
                );
        leatherCombo.setItems(options);
        leatherCombo.getSelectionModel().select(0);

        leatherCombo.setOnAction((e) ->
        {
            PrefWrapper.setLeather(leatherCombo.getSelectionModel().getSelectedItem().toString());
            System.out.println("Test");
        });
        crafterLocationButton.setOnAction((e) -> {
            PrefWrapper.setCrafterLocation(getPlayerLocation());
            crafterLocationText.setText(PrefWrapper.getCrafterLocation().toString());
        });

        leatherCombo.getSelectionModel().select(PrefWrapper.getLeather());
        crafterLocationText.setText(PrefWrapper.getCrafterLocation().toString());
        PrefWrapper.setLeather(leatherCombo.getSelectionModel().getSelectedItem().toString());
    }

    private Coordinate getPlayerLocation() {
        final Coordinate[] coordinate = new Coordinate[1];
        try {
            platform.invokeAndWait(() -> coordinate[0] = Players.getLocal().getPosition());
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        return coordinate[0];
    }
}
