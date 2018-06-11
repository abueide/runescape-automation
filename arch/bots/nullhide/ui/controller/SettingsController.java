package arch.bots.nullhide.ui.controller;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.core.BotPlatform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import arch.bots.nullhide.util.PrefWrapper;

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
    @FXML
    Button startbutton;
    @FXML
    TextField sellfield;
    @FXML
    TextField buyfield;
    @FXML
    CheckBox resupplycheck;

    private BotPlatform platform;

    public SettingsController(BotPlatform platform) {
        this.platform = platform;
    }

    public void initialize(URL location, ResourceBundle resources) {
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

        resupplycheck.setOnAction((e) -> {
            PrefWrapper.toggleResupplyEnabled();
            buyfield.setDisable(!PrefWrapper.getResupplyEnabled());
            sellfield.setDisable(!PrefWrapper.getResupplyEnabled());
        });

        buyfield.setDisable(!PrefWrapper.getResupplyEnabled());
        sellfield.setDisable(!PrefWrapper.getResupplyEnabled());
        buyfield.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int newval = Integer.parseInt(newValue);
                PrefWrapper.setHidePrice(newval);
            } catch (NumberFormatException e) {
            }
        });
        sellfield.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int newval = Integer.parseInt(newValue);
                PrefWrapper.setLeatherPrice(newval);
            } catch (NumberFormatException e) {
            }
        });

        startbutton.setOnAction((e) -> {
            platform.invokeLater(() -> {
                platform.invokeLater(() -> Environment.getBot().resume());
            });
        });

        //Resupplying not implemented yet so disable
        resupplycheck.setDisable(true);
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
