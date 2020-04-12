package pl.alvion.rpem.rpessentials.rpplayer.stats.aviliable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stat;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;

public class Strength extends Stat {
    @Override
    public String name() {
        return ChatColor.RED + "Sila";
    }

    @Override
    public ItemStack guiItem() {
        return new ItemStack(Material.BLAZE_POWDER, 1);
    }


    @Override
    public boolean canUpgrade(Player player) {
        return true;
    }

    @Override
    public Stats statName() {
        return Stats.Strength;
    }
}
