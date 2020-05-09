package pl.alvion.rpem.rpessentials.utils.names;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Names {
    public static String getPrefix() {
        return ChatColor.BLUE + "" + ChatColor.BOLD + "[" + ChatColor.BLUE + "AlvionRP" + ChatColor.BOLD + "]";
    }

    public static String randomizeGUI() {
        return ChatColor.BLUE + "Losowanie Statystyk";
    }

    public static String getMagicDataPath(Player player) {
        return "Magic." + player.getName() + ".Data";
    }

    public static String getUnlockedSpellsPath(Player player) {
        return getMagicDataPath(player) + ".Spells";
    }
}
