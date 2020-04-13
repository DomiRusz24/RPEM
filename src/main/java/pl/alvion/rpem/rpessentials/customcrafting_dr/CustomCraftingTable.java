package pl.alvion.rpem.rpessentials.customcrafting_dr;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class CustomCraftingTable implements InventoryHolder {

    public abstract String getTableName();

    public abstract CustomCraft[] getCustomCrafts();

    public abstract CustomCraftingTable[] getCraftingTables();

    public abstract boolean canPlayerOpen();

    public abstract void onOpen(Player player);

    private Inventory getInv() {
        Inventory inv = Bukkit.createInventory(this, 45);






        return inv;
    }

    public void openInv(Player player) {
        player.openInventory(getInv());
        onOpen(player);
    }


    @Override
    public Inventory getInventory() {
        return getInv();
    }
}
