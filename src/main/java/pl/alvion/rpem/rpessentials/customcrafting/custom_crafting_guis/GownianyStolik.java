package pl.alvion.rpem.rpessentials.customcrafting.custom_crafting_guis;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.customcrafting.CustomCraft;
import pl.alvion.rpem.rpessentials.customcrafting.CustomCraftingGUI;
import pl.alvion.rpem.rpessentials.customcrafting.CustomCraftingTable;
import pl.alvion.rpem.rpessentials.customcrafting.customcrafts.GownoNaPatyku;
import pl.alvion.rpem.rpessentials.generalutils.gui.gui_items.customcrafting.BlankSpace;

public class GownianyStolik extends CustomCraftingGUI {
    public GownianyStolik(Player player) {
        super(player);
    }

    @Override
    public String getTableName() {
        return ChatColor.RED + "" + ChatColor.BOLD + "Stol z gowna";
    }

    @Override
    public CustomCraft[] getCustomCrafts() {
        return new CustomCraft[]{
                new GownoNaPatyku()
        };
    }

    @Override
    public CustomCraftingTable[] getCraftingTables() {
        return null;
    }

    @Override
    public boolean canPlayerOpen() {
        return true;
    }

    @Override
    public void onOpen() {

    }

    @Override
    public BlankSpace blankSpace() {
        return new BlankSpace(Material.PINK_STAINED_GLASS_PANE);
    }
}
