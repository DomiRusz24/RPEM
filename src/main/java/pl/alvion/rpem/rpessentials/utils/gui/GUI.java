package pl.alvion.rpem.rpessentials.utils.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface GUI {

    int size();
    String name();
    default void open(Player player) {
        Inventory inventory = Bukkit.createInventory(null, size(), name());
        openAction(inventory, player);
        GUIListener.lockedInventories.add(inventory);
        player.openInventory(inventory);
    }
    void openAction(Inventory inventory, Player player);

}
