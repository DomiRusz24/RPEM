package pl.alvion.rpem.rpessentials.rpplayer.stats.aviliable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stat;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;

public class Agility extends Stat {


    @Override
    public String name() {
        return ChatColor.GRAY + "Zrecznosc";
    }

    @Override
    public ItemStack guiItem() {
        return new ItemStack(Material.FEATHER, 1);
    }

    @Override
    public boolean canUpgrade(Player player) {
        return true;
    }

    @Override
    public Stats statName() {
        return Stats.Agility;
    }


}
