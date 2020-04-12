package pl.alvion.rpem.rpessentials.generalutils.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import pl.alvion.rpem.rpessentials.generalutils.gui.guis.RandomStats;

import java.util.ArrayList;


public class GUIListener implements Listener {

    static ArrayList<Inventory> lockedInventories = new ArrayList<>();


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (lockedInventories.contains(event.getClickedInventory())) event.setCancelled(true);
        RandomStats.clickEvent(event);

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        lockedInventories.remove(event.getInventory());
    }
}
