package nullbots.nullhide.util;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;

import java.util.prefs.Preferences;

public class PrefWrapper {

    public static final String preferenceNode = "nullbots.nullhide";
    public static final Preferences prefs = Preferences.userRoot().node(preferenceNode);

    public static String getLeather() {
        return prefs.get("leather", "Black dragon leather");
    }

    public static void setLeather(final String leather) {
        prefs.put("leather", leather);
    }

    public static String getHide() {
        //TODO: Check/Fix Item Names
        switch (getLeather()) {
            case "Soft leather":
                return "Cowhide";
            case "Hard leather":
                return "Cowhide";
            case "Green dragon leather":
                return "Green dragonhide";
            case "Blue dragon leather":
                return "Blue dragonhide";
            case "Red dragon leather":
                return "Red dragonhide";
            case "Black dragon leather":
                return "Black dragonhide";
            case "Royal dragon leather":
                return "Royal dragonhide";
            default:
                return "unselected";
        }
    }

    public static Area getArea() {
        return new Area.Circular(getCrafterLocation(), 20);
    }

    public static Coordinate getCrafterLocation() {
        String[] coords = prefs.get("crafterLocation", "2445,3084,0").split(",");
        return new Coordinate(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]));
    }

    public static void setCrafterLocation(Coordinate coord) {
        prefs.put("crafterLocation", coord.getX() + "," + coord.getY() + "," + coord.getPlane());
    }

    public static void setResupplyEnabled(boolean enabled) {
        prefs.putBoolean("resupplyEnabled", enabled);
    }

    public static boolean getResupplyEnabled() {
        return prefs.getBoolean("resupplyEnabled", false);
    }

    public static void toggleResupplyEnabled() {
        setResupplyEnabled(!getResupplyEnabled());
    }

    public static void setHidePrice(int price) {
        prefs.putInt("hideprice", price);
    }

    public static int getHidePrice() {
        return prefs.getInt("hideprice", 0);
    }

    public static void setLeatherPrice(int price) {
        prefs.putInt("leatherprice", price);
    }

    public static int getLeatherPrice() {
        return prefs.getInt("leatherprice", 0);
    }

    public static void setMinHides(int hides) {
        prefs.putInt("minhides", hides);
    }

    public static int getMinHides() {
        return prefs.getInt("minhides", 500);
    }

    public static void setMinCoins(int coins) {
        prefs.putInt("mincoins", coins);
    }

    public static int getMincoins() {
        return prefs.getInt("mincoins", 100000);
    }
}
