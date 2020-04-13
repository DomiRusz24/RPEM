package pl.alvion.rpem.rpessentials.rpplayer_dr.stats;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class Stat {

    public static ArrayList<Stat> stats = new ArrayList<>();
    abstract public String name();
    abstract public ItemStack guiItem();
    abstract public boolean canUpgrade(Player player);
    abstract public Stats statName();
    public void event(Event event){

    };


    public static Stat getStat(Stats statName) {
        for (Stat stat : stats) {
            if (stat.statName().equals(statName)) return stat;
        }
        return null;
    }

}
