package pl.alvion.rpem.rpessentials.generalutils.gui.gui_items.customcrafting;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlankSpace {

    private ItemStack item;

    public BlankSpace() {
        ItemStack item = new ItemStack(Material.CYAN_STAINED_GLASS, 1);
        item.addEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("");
        meta.setUnbreakable(true);
        this.item = item;
    }
    public BlankSpace(Material material) {
        ItemStack item = new ItemStack(material, 1);
        item.addEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("");
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }
}
