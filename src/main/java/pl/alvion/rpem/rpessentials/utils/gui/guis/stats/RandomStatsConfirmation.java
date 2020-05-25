package pl.alvion.rpem.rpessentials.utils.gui.guis.stats;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;
import pl.alvion.rpem.rpessentials.rpplayer.traits.Trait;
import pl.alvion.rpem.rpessentials.utils.gui.GUI;
import pl.alvion.rpem.rpessentials.utils.gui.GuiUtils;
import pl.alvion.rpem.rpessentials.utils.gui.gui_items.Item;
import pl.alvion.rpem.rpessentials.utils.statutils.RandomStatsGuiItemParser;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomStatsConfirmation implements GUI {

    private ItemStack statsItem;
    private ItemStack accept() {
        ItemStack itemStack = new ItemStack(Material.GREEN_WOOL, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Akceptuj");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private ItemStack decline() {
        ItemStack itemStack = new ItemStack(Material.RED_WOOL, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Odrzuc");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public RandomStatsConfirmation(ItemStack itemStack) {
        statsItem = itemStack;
    }

    @Override
    public int size() {
        return 9;
    }

    @Override
    public String name() {
        return ChatColor.GREEN + "Czy jestes pewny?";
    }

    @Override
    public void openAction(Inventory inventory, Player player) {
        inventory.setItem(4, statsItem);
        inventory.setItem(0, accept());
        inventory.setItem(8, decline());
        GuiUtils.fillEmptySlots(inventory, Item.grayPane());
    }


    public static void clickEvent(InventoryClickEvent event) {
        if (event.getCurrentItem() == null || event.getClickedInventory() == null) return;
        RandomStatsConfirmation gui = new RandomStatsConfirmation(null);
        if (!event.getView().getTitle().equals(gui.name())) return;
        ItemStack itemStack = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        if (itemStack.equals(gui.decline())) {
            RandomStats.reopen(player);
            player.playSound(player.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1, 1);
        }
        if (itemStack.equals(gui.accept())) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            HashMap<Stats, Integer> stats = RandomStatsGuiItemParser.itemToStats(event.getInventory().getItem(4));
            ArrayList<Trait> traits = RandomStats.itemToTraits(event.getInventory().getItem(4));
            for (Stats stat : stats.keySet()) {
                stat.setStat(player, stats.get(stat));
            }
            for (Trait trait : traits) {
                trait.addTrait(player);
            }
            RandomStats.setRolledPreviously(player);
            player.closeInventory();
        }

    }

}
