package pl.alvion.rpem.rpessentials.utils.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;
import pl.alvion.rpem.rpessentials.utils.gui.guis.stats.RandomStats;
import pl.alvion.rpem.rpessentials.utils.gui.guis.stats.RandomStatsConfirmation;
import pl.alvion.rpem.rpessentials.utils.names.Names;
import pl.alvion.rpem.rpessentials.utils.statutils.RandomStatsGuiItemParser;

import java.util.ArrayList;
import java.util.HashMap;


public class GUIListener implements Listener {

    public static ArrayList<Inventory> lockedInventories = new ArrayList<>();


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null) return;
        if (lockedInventories.contains(event.getClickedInventory())) {
            event.setCancelled(true);
            RandomStats.clickEvent(event);
            RandomStatsConfirmation.clickEvent(event);
        }
        if (event.getCurrentItem() == null) return;
        if (event.getView().getTitle().equalsIgnoreCase(Names.randomizeGUI())) {
            HashMap<Stats, Integer> statsHashMap = RandomStatsGuiItemParser.itemToStats(event.getCurrentItem());
            if (statsHashMap != null) {
                for (Stats stats : statsHashMap.keySet()) {
                    player.sendMessage(stats.name() + " " + statsHashMap.get(stats));
                }
            }
        }

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        lockedInventories.remove(event.getInventory());
    }


}
