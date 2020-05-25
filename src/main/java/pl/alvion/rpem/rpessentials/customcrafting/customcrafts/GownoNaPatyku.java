package pl.alvion.rpem.rpessentials.customcrafting.customcrafts;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.customcrafting.CustomCraft;
import pl.alvion.rpem.rpessentials.customcrafting.CustomRecipe;
import pl.alvion.rpem.rpessentials.customcrafting.CraftItem;

import java.util.Arrays;

public class GownoNaPatyku extends CustomCraft {
    @Override
    public CustomRecipe[] recipes() {
        CustomRecipe one = new CustomRecipe() {
            @Override
            public CraftItem[] cratingShape() {
                return new CraftItem[]{
                        new CraftItem(Material.PAPER), new CraftItem(Material.PAPER), new CraftItem(Material.PAPER),
                        new CraftItem(),               new CraftItem(Material.STICK), new CraftItem(),
                        new CraftItem(),               new CraftItem(Material.STICK), new CraftItem()
                };
            }
        };

        return new CustomRecipe[]{one};
    }

    @Override
    public ItemStack craftedItem() {
        ItemStack gowno = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = gowno.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Papier na patyku");
        meta.setLore(Arrays.asList("Brakuje gowna na koncu", "Wtedy byloby gowno na patyku"));
        gowno.setItemMeta(meta);
        return gowno;
    }
}
