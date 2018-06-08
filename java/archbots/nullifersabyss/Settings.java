package archbots.nullifersabyss;

import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import javafx.util.Pair;

import java.util.ArrayList;

public class Settings {
    //Percentage of health to eat food
    private static int eatPercent = 75;
    //Gets an index up to which pouches can be used based on runecrafting level
    private static int pouchIndex = Math.floorDiv(Skill.RUNECRAFTING.getBaseLevel(), 25);
    private static String[] pouches = new String[]{"Small pouch", "Medium pouch", "Large pouch", "Giant pouch"};
    private static String foodItem = "Jug of wine";
    private static int foodHeal = 11;

//    public static boolean checkReady() {
//        return Inventory.isFull() && Inventory.contains("Pure Essence") &&
//    }

    public static ArrayList<Pair<String, Integer>> getNeededItems() {
        ArrayList<Pair<String, Integer>> itemsNeeded = new ArrayList<>();
        for (int i = 0; i <= pouchIndex; i++) {
            if (!Inventory.contains(pouches[i]))
                itemsNeeded.add(new Pair<>(pouches[i], 1));
        }

        if (Health.getCurrentPercent() < eatPercent) {
            int foodNeeded = Math.round((float) (Health.getMaximum() - Health.getCurrent()) / foodHeal);
            itemsNeeded.add(new Pair<>(foodItem, foodNeeded));
        }

        if (Traversal.getRunEnergy() < 40 && !Traversal.isStaminaEnhanced()) {
//            itemsNeeded.add(new Pair<>("Stamina potion", 1))
        }
        return itemsNeeded;
    }
}
