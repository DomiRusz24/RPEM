package pl.alvion.rpem.rpessentials.utils.statutils;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;
import pl.alvion.rpem.rpessentials.rpplayer.stats.aviliable.*;
import pl.alvion.rpem.rpessentials.rpplayer.traits.Trait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RandomStatsGuiItemParser {

    public static HashMap<Stats, Integer> itemToStats(ItemStack itemStack) {
        HashMap<Stats, Integer> hashMap = new HashMap<>();
        List<String> lore = itemStack.getItemMeta().getLore();
        hashMap.put(Stats.Agility, Integer.parseInt(lore.get(0).split(": ")[1]));
        hashMap.put(Stats.Endurance, Integer.parseInt(lore.get(1).split(": ")[1]));
        hashMap.put(Stats.MaxHP, Integer.parseInt(lore.get(2).split(": ")[1]));
        hashMap.put(Stats.Strength, Integer.parseInt(lore.get(3).split(": ")[1]));
        hashMap.put(Stats.Intelligence, Integer.parseInt(lore.get(4).split(": ")[1]));
        hashMap.put(Stats.Magic, Integer.parseInt(lore.get(5).split(": ")[1]));
        return hashMap;
    }
    public static ArrayList<Trait> itemToTraits(ItemStack itemStack) {
        ArrayList<Trait> traits = new ArrayList<>();
        List<String> lore = itemStack.getItemMeta().getLore();
        for (int i = 6; i < 10; i++) {
            traits.add(Trait.getByPolishIndex(lore.get(i)));
        }
        return traits;
    }

    public static ItemStack statsToItem(HashMap<Stats, Integer> hashMap, String name) {
        ItemStack itemStack = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(new Agility().name() + ": " + hashMap.get(Stats.Agility),
                new Endurance().name() + ": " + hashMap.get(Stats.Endurance),
                new MaxHP().name() + ": " + hashMap.get(Stats.MaxHP),
                new Strength().name() + ": " + hashMap.get(Stats.Strength),
                new Intelligence().name() + ": " + hashMap.get(Stats.Intelligence),
                new Magic().name() + ": " + hashMap.get(Stats.Magic)
        ));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


}
