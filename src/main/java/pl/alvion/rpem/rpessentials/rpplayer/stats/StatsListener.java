package pl.alvion.rpem.rpessentials.rpplayer.stats;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import pl.alvion.rpem.rpessentials.rpplayer.stats.aviliable.*;

public class StatsListener implements Listener {

    @EventHandler
    public void onEnable(PluginEnableEvent event) {
        Stat.stats.add(new Agility());
        Stat.stats.add(new Endurance());
        Stat.stats.add(new Intelligence());
        Stat.stats.add(new Magic());
        Stat.stats.add(new MaxHP());
        Stat.stats.add(new Strength());
        Stat.stats.add(new KnowledgePoints());



    }


}
