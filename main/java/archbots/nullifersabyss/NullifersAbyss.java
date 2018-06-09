package archbots.nullifersabyss;

import com.runemate.game.api.client.embeddable.EmbeddableUI;
import com.runemate.game.api.hybrid.util.Resources;
import archapi.treebot.TreeBot;
import archapi.treebot.TreeTask;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class NullifersAbyss extends TreeBot implements EmbeddableUI {
    private Root root = new Root();

    private ObjectProperty<Node> botInterfaceProperty;

    public NullifersAbyss() {
        setLoopDelay(220, 400);
        setEmbeddableUI(this);
        setRootTask(new archbots.nullhide.Root());
    }

    @Override
    public ObjectProperty<? extends Node> botInterfaceProperty() {
        if (botInterfaceProperty == null) {

            FXMLLoader loader = new FXMLLoader();
            //loader.setController(new SettingsController(getPlatform()));
            try {
                Node node = loader.load(Resources.getAsStream("archmage/nullifersabyss/ui/view/main.fxml"));
                botInterfaceProperty = new SimpleObjectProperty<>(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return botInterfaceProperty;
    }
}