package pl.alvion.rpem.rpessentials.customcrafting_dr;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.generalutils.gui.gui_items.customcrafting.BlankSpace;

import java.util.ArrayList;

public abstract class CustomCraftingGUI implements InventoryHolder {

    private Player player;

    public CustomCraftingGUI(Player player) {
        CustomCraftingGUI.customCraftingGUIs.add(this);
        this.player = player;
    }


    public static ArrayList<CustomCraftingGUI> customCraftingGUIs = new ArrayList<>();

    public abstract String getTableName();

    public abstract CustomCraft[] getCustomCrafts();

    public abstract CustomCraftingTable[] getCraftingTables();

    public abstract boolean canPlayerOpen();

    public abstract void onOpen();

    public abstract BlankSpace blankSpace();

    private int[] emptyspots =
                    {10,  11 , 12 ,
                     18 ,19 , 20 ,
                     26 , 27 , 28};

    private Inventory getInv() {
        Inventory inv = Bukkit.createInventory(this, 45); // 22
        for(int i = 0; i < 44; i++) {
            for(int y : emptyspots) {
                if(i != y || i != 22) {
                    inv.setItem(i, blankSpace().getItem());
                }
            }
        }
        return inv;
    }

    public boolean openInv(boolean debug) {
        if(canPlayerOpen() || debug) {
            player.openInventory(getInv());
            onOpen();
            return true;
        }
        return false;
    }

    public void craftItem() {
        for(int i : emptyspots) {
            getInv().setItem(i, new ItemStack(Material.AIR));
        }
    }

    public void showCraftedItem(ItemStack item) {
        getInv().setItem(22, item);
    }

    public void checkIfCrafted() {
        for(CustomCraft craft : this.getCustomCrafts()) {
            for(CustomRecipe recipe : craft.recipes()) {
                for(int i = 0; i < 9; i++) {
                    boolean canCraft = true;
                    if(recipe.cratingShape()[i].isItItem()) {
                        ItemStack item = recipe.cratingShape()[i].getItemStack();
                        ItemStack item2 = getInv().getItem(this.emptyspots[i]);
                        if(item != item2) {
                            canCraft = false;
                        }
                    } else {
                        Material item = recipe.cratingShape()[i].getMat();
                        Material item2 = getInv().getItem(this.emptyspots[i]).getType();
                        if(item != item2) {
                            canCraft = false;
                        }
                    }
                    if(canCraft) {
                        getInv().setItem(22, craft.craftedItem());
                        CustomCraft.playerCraft.put(player, craft.craftedItem());
                        break;
                    }
                }
            }
        }
    }






    @Override
    public Inventory getInventory() {
        return getInv();
    }
}
