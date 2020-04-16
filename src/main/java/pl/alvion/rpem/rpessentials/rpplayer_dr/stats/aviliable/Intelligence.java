package pl.alvion.rpem.rpessentials.rpplayer_dr.stats.aviliable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer_dr.stats.Stat;
import pl.alvion.rpem.rpessentials.rpplayer_dr.stats.Stats;

public class Intelligence extends Stat {


    @Override
    public String name() {
        return ChatColor.BLUE + "Inteligencja";
    }

    @Override
    public ItemStack guiItem() {
        return new ItemStack(Material.BOOK, 1);
    }

    @Override
    public boolean canUpgrade(Player player) {
        return true;
    }

    @Override
    public Stats statName() {
        return Stats.Intelligence;
    }
}