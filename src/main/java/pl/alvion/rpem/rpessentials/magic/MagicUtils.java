package pl.alvion.rpem.rpessentials.magic;

import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.magic.storage.MagicDataStorage;
import pl.alvion.rpem.rpessentials.utils.names.Names;

public class MagicUtils {

    public static boolean hasSpellUnlocked(Player player, int spellId) {
        for (int i : MagicDataStorage.getUnlockedSpells(player)) {
            if (i == spellId) return true;
        }
        return false;
    }

    public static void unlockSpell(Player player, int spellId) {
        if (!hasSpellUnlocked(player, spellId)) {
            RPEssentials.RPPlayerDataConfig.set(Names.getUnlockedSpellsPath(player), MagicDataStorage.getUnlockedSpellsRaw(player) + spellId + ",");
            RPEssentials.saveRPPlayerConfig();
        }
    }

    public static void lockSpell(Player player, int spellId) {
        if (hasSpellUnlocked(player, spellId)) {
            RPEssentials.RPPlayerDataConfig.set(Names.getUnlockedSpellsPath(player), MagicDataStorage.getUnlockedSpellsRaw(player).replaceAll(spellId + ",", ""));
            RPEssentials.saveRPPlayerConfig();
        }
    }

}
