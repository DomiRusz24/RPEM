package pl.alvion.rpem.rpessentials.magic.storage;

import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.utils.names.Names;

public class MagicDataStorage {

    public static int[] getUnlockedSpells(Player player) {
        if (RPEssentials.RPPlayerDataConfig.getString(Names.getUnlockedSpellsPath(player)) == null) {
            RPEssentials.RPPlayerDataConfig.set(Names.getUnlockedSpellsPath(player), "-1,");
        }
        String[] strings = RPEssentials.getRPPlayerDataConfig().getString(Names.getUnlockedSpellsPath(player)).split(",");
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    public static String getUnlockedSpellsRaw(Player player) {
        if (RPEssentials.RPPlayerDataConfig.getString(Names.getUnlockedSpellsPath(player)) == null) {
            RPEssentials.RPPlayerDataConfig.set(Names.getUnlockedSpellsPath(player), "-1,");
        }
        return RPEssentials.getRPPlayerDataConfig().getString(Names.getUnlockedSpellsPath(player));
    }



}
