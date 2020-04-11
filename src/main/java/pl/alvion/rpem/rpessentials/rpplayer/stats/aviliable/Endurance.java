package pl.alvion.rpem.rpessentials.rpplayer.stats.aviliable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stat;
import pl.alvion.rpem.rpessentials.rpplayer.stats.StatName;

public class Endurance extends Stat {
    @Override
    public String name() {
        return ChatColor.DARK_GRAY + "Wytrzymalosc";
    }

    @Override
    public ItemStack guiItem() {
        return new ItemStack(Material.IRON_CHESTPLATE);
    }

    @Override
    public boolean canUpgrade(Player player) {
        return true;
    }

    @Override
    public StatName statName() {
        return StatName.Endurance;
    }
}