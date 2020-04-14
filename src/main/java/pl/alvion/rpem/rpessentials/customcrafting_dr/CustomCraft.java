package pl.alvion.rpem.rpessentials.customcrafting_dr;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class CustomCraft {
    public static HashMap<Player, ItemStack> playerCraft = new HashMap<>();
    public abstract CustomRecipe[] recipes();
    public abstract ItemStack craftedItem();
}
