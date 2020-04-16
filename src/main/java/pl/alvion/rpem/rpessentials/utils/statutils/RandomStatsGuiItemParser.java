package pl.alvion.rpem.rpessentials.utils.statutils;


import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer_dr.stats.Stats;

import java.util.HashMap;
import java.util.List;

public class RandomStatsGuiItemParser {

    public static HashMap<Stats, Integer> itemToStats(ItemStack itemStack) {
        HashMap<Stats, Integer> hashMap = new HashMap<>();
        if (itemStack.getItemMeta() == null) return null;
        List<String> lore = itemStack.getItemMeta().getLore();
        if (lore == null) return null;
        hashMap.put(Stats.Agility, Integer.parseInt(lore.get(0).split(": ")[1]));
        hashMap.put(Stats.Endurance, Integer.parseInt(lore.get(1).split(": ")[1]));
        hashMap.put(Stats.MaxHP, Integer.parseInt(lore.get(2).split(": ")[1]));
        hashMap.put(Stats.Strength, Integer.parseInt(lore.get(3).split(": ")[1]));
        hashMap.put(Stats.Intelligence, Integer.parseInt(lore.get(4).split(": ")[1]));
        hashMap.put(Stats.Magic, Integer.parseInt(lore.get(5).split(": ")[1]));
        return hashMap;
    }


}
