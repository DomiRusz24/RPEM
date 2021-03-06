package pl.alvion.rpem.rpessentials.rpplayer.stats.aviliable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stat;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;

public class KnowledgePoints extends Stat {


    public String name() {
        return ChatColor.GREEN + "Punkty Rozwoju";
    }

    @Override
    public ItemStack guiItem() {
        return new ItemStack(Material.WRITABLE_BOOK, 1);
    }

    @Override
    public boolean canUpgrade(Player player) {
        return false;
    }

    @Override
    public Stats statName() {
        return Stats.AvailableStatPoints;
    }
}
