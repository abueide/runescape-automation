package archbots.nullmage;

import com.runemate.game.api.client.embeddable.EmbeddableUI;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.util.Resources;
import com.runemate.game.api.script.framework.listeners.SkillListener;
import com.runemate.game.api.script.framework.listeners.events.SkillEvent;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class NullMage extends TreeBot implements SkillListener, EmbeddableUI {
    public static int expGained = 0;
    public static boolean lastSpell = false;
    private IsAlchSelected isAlchSelected = new IsAlchSelected();

    private ObjectProperty<Node> botInterfaceProperty;

    public NullMage() {
        setEmbeddableUI(this);
    }

    @Override
    public TreeTask createRootTask() {
        return isAlchSelected;
    }

    @Override
    public void onStart(String... strings) {
        super.onStart(strings);
        getEventDispatcher().addListener(this);
        setLoopDelay(200, 250);
    }

    @Override
    public void onExperienceGained(SkillEvent event) {
        if (event.getSkill().equals(Skill.MAGIC))
            expGained += event.getChange();
    }

    @Override
    public ObjectProperty<? extends Node> botInterfaceProperty() {
        if (botInterfaceProperty == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(new MainController(getPlatform()));
            try {
                Node node = loader.load(Resources.getAsStream("archmage/nullmage/main.fxml"));
                botInterfaceProperty = new SimpleObjectProperty<>(node);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return botInterfaceProperty;
    }
}
