package pl.alvion.rpem.rpessentials.generalutils.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.customcrafting.CustomCraft;
import pl.alvion.rpem.rpessentials.customcrafting.CustomCraftingGUI;
import pl.alvion.rpem.rpessentials.generalutils.gui.gui_items.customcrafting.BlankSpace;
import pl.alvion.rpem.rpessentials.utils.gui.guis.stats.RandomStats;

import java.util.ArrayList;


public class GUIListener implements Listener {

    static ArrayList<Inventory> lockedInventories = new ArrayList<>();


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (event.getWhoClicked() instanceof Player) {
            boolean itemtakeout = event.getCursor() != null;
            Player player = (Player) event.getWhoClicked();
            InventoryHolder holder = event.getClickedInventory().getHolder();
            if (lockedInventories.contains(event.getClickedInventory())) {
                event.setCancelled(true);
                RandomStats.clickEvent(event);
                return;
            }
            ItemStack item = itemtakeout ? event.getCursor() : event.getCurrentItem();
            ItemMeta meta = item.getItemMeta();

            for (CustomCraftingGUI customCraftingGUI : CustomCraftingGUI.customCraftingGUIs) {
                if (holder == customCraftingGUI) {
                    if(itemtakeout) {
                        if (meta.equals(new BlankSpace().getItem().getItemMeta())) {
                            event.setCancelled(true);
                            return;
                        }
                        if (item.equals(CustomCraft.playerCraft.get(player))) {
                            customCraftingGUI.craftItem();
                        }
                    } else {
                        if(event.getRawSlot() == 22) {
                            event.setCancelled(true);
                            return;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        lockedInventories.remove(event.getInventory());
    }
}
