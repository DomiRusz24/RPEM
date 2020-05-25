package pl.alvion.rpem.rpessentials.customcrafting_dr;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class CraftItem {
    private ItemStack item = new ItemStack(Material.AIR);
    private Material mat = Material.AIR;
    private boolean isItItem = false;
    private boolean isItNothing = false;

    public CraftItem(ItemStack item) {
        this.item = item;
        isItItem = true;
    }
    public CraftItem(Material mat) {
        this.mat = mat;
        isItItem = false;
    }
    public CraftItem() {
        isItNothing = true;
    }

    public ItemStack getItemStack() {
        return item;
    }

    public Material getMat() {
        return mat;
    }

    public boolean isItItem() {
        return isItItem;
    }

    public boolean isItNothing() {
        return isItNothing;
    }
}
