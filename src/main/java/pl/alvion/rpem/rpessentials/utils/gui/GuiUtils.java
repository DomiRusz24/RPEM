package pl.alvion.rpem.rpessentials.utils.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiUtils {

    public static void fillEmptySlots(Inventory inventory, ItemStack itemStack) {
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, itemStack);
            }
        }
    }

    public static ItemStack changeItemName(ItemStack itemStack, String newName) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(newName);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


}
