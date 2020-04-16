package pl.alvion.rpem.rpessentials.utils.gui.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.utils.gui.GUI;
import pl.alvion.rpem.rpessentials.rpplayer_dr.stats.aviliable.*;
import pl.alvion.rpem.rpessentials.utils.gui.GUIListener;
import pl.alvion.rpem.rpessentials.utils.gui.GuiUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomStats implements GUI {

    static HashMap<Player, ItemStack[]> lastOpen = new HashMap<>();


    @Override
    public int size() {
        return 9;
    }

    @Override
    public String name() {
        return ChatColor.BLUE + "Losowanie Statystyk";
    }


    public static void clickEvent(InventoryClickEvent event) {
        GUI gui = new RandomStats();
        if (event.getCurrentItem() == null || event.getClickedInventory() == null) return;
        if (event.getView().getTitle().equalsIgnoreCase(gui.name()));
        Inventory inventory = event.getClickedInventory();
        ItemStack itemStack = event.getCurrentItem();
        if (itemStack.getItemMeta() == null) return;
        String name = itemStack.getItemMeta().getDisplayName();
        Player player = (Player) event.getWhoClicked();
        if (name.equals(iName) || name.equals(iName1) || (name.equals(iName2))) {
            ItemStack[] itemStacks = new ItemStack[3];
            itemStacks[0] = inventory.getItem(2);
            itemStacks[1] = inventory.getItem(4);
            itemStacks[2] = inventory.getItem(6);
            lastOpen.put(player, itemStacks);
            GUI gui1 = new RandomStatsConfirmation(itemStack);
            gui1.open(player);
        }
    }

    private static String iNameP = ChatColor.RED + "I";
    private static String iNameP1 = ChatColor.GREEN + "II";
    private static String iNameP2 = ChatColor.BLUE + "III";
    private static String iName = ChatColor.RED + "Wybierz konfiguracje I";
    private static String iName1 = ChatColor.GREEN + "Wybierz konfiguracje II";
    private static String iName2 = ChatColor.BLUE + "Wybierz konfiguracje III";

    private Random random = new Random();
    private ItemStack[] getRandomStatsItems() {
        ItemStack[] itemStacks = new ItemStack[3];
        ItemStack itemStack = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(iNameP);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(new Agility().name() + ": " + random.nextInt(3));
        lore.add(new Endurance().name() + ": " + random.nextInt(3));
        lore.add(new MaxHP().name() + ": " + random.nextInt(3));
        lore.add(new Strength().name() + ": " + random.nextInt(3));
        lore.add(new Intelligence().name() + ": " + random.nextInt(3));
        lore.add(new Magic().name() + ": " + random.nextInt(3));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        ItemStack itemStack1 = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName(iNameP1);
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add(new Agility().name() + ": " + random.nextInt(3));
        lore1.add(new Endurance().name() + ": " + random.nextInt(3));
        lore1.add(new MaxHP().name() + ": " + random.nextInt(3));
        lore1.add(new Strength().name() + ": " + random.nextInt(3));
        lore1.add(new Intelligence().name() + ": " + random.nextInt(3));
        lore1.add(new Magic().name() + ": " + random.nextInt(3));
        itemMeta1.setLore(lore1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.setDisplayName(iNameP2);
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(new Agility().name() + ": " + random.nextInt(3));
        lore2.add(new Endurance().name() + ": " + random.nextInt(3));
        lore2.add(new MaxHP().name() + ": " + random.nextInt(3));
        lore2.add(new Strength().name() + ": " + random.nextInt(3));
        lore2.add(new Intelligence().name() + ": " + random.nextInt(3));
        lore2.add(new Magic().name() + ": " + random.nextInt(3));
        itemMeta2.setLore(lore2);
        itemStack2.setItemMeta(itemMeta2);

        itemStacks[0] = itemStack;
        itemStacks[1] = itemStack1;
        itemStacks[2] = itemStack2;

        return itemStacks;
    }


    @Override
    public void openAction(Inventory inventory, Player player) {
        startRandomizing(inventory, player);
    }


    public static void openAction(Inventory inventory, ItemStack[] itemStacks) {
        inventory.setItem(2, itemStacks[0]);
        inventory.setItem(4, itemStacks[1]);
        inventory.setItem(6, itemStacks[2]);
    }

    public static void reopen(Player player) {
        GUI gui = new RandomStats();
        Inventory inventory = Bukkit.createInventory(null, gui.size(), gui.name());
        openAction(inventory, lastOpen.get(player));
        GUIListener.lockedInventories.add(inventory);
        player.openInventory(inventory);
    }

    private void startRandomizing(Inventory inventory, Player player) {
        Runnable runnable = new Runnable() {
            int i = 0;
            int t = 1;
            @Override
            public void run() {
                i++;
                switch (i) {
                    case 5:
                    case 10:
                    case 15:
                    case 18:
                        t = t *2;
                        break;
                    case 19:
                        player.playSound(player.getLocation(), Sound.ITEM_BOOK_PUT, 1, 3f);
                        inventory.setItem(2, GuiUtils.changeItemName(inventory.getItem(2), iName));
                        inventory.setItem(4, GuiUtils.changeItemName(inventory.getItem(4), iName1));
                        inventory.setItem(6, GuiUtils.changeItemName(inventory.getItem(6), iName2));
                        return;
                }
                try {
                    Thread.sleep(t * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player.playSound(player.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1, 1);
                ItemStack[] itemStacks = getRandomStatsItems();
                inventory.setItem(2, itemStacks[0]);
                inventory.setItem(4, itemStacks[1]);
                inventory.setItem(6, itemStacks[2]);

                run();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


}
