package pl.alvion.rpem.rpessentials.utils.gui.guis.stats;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;
import pl.alvion.rpem.rpessentials.rpplayer.stats.aviliable.*;
import pl.alvion.rpem.rpessentials.rpplayer.traits.Trait;
import pl.alvion.rpem.rpessentials.utils.gui.GUI;
import pl.alvion.rpem.rpessentials.utils.gui.GUIListener;
import pl.alvion.rpem.rpessentials.utils.gui.GuiUtils;
import pl.alvion.rpem.rpessentials.utils.gui.gui_items.Item;
import pl.alvion.rpem.rpessentials.utils.names.Names;
import pl.alvion.rpem.rpessentials.utils.statutils.RandomStatsGuiItemParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RandomStats implements GUI {

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
        String invName = event.getView().getTitle();
        Player player = (Player) event.getWhoClicked();
        if ((name.equals(iName) || name.equals(iName1) || (name.equals(iName2))) && invName.equalsIgnoreCase(Names.randomizeGUI())) {
            ArrayList<HashMap<Stats, Integer>> hashMaps = new ArrayList<>(Arrays.asList(RandomStatsGuiItemParser.itemToStats(inventory.getItem(1)), RandomStatsGuiItemParser.itemToStats(inventory.getItem(3)), RandomStatsGuiItemParser.itemToStats(inventory.getItem(5))));
            saveRandomizedStats(player, hashMaps);
            GUI gui1 = new RandomStatsConfirmation(itemStack);
            gui1.open(player);
            player.playSound(player.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1, 1);
        }
    }

    private static String iNameP = ChatColor.RED + "I";
    private static String iNameP1 = ChatColor.GREEN + "II";
    private static String iNameP2 = ChatColor.BLUE + "III";
    private static String iNameP3 = ChatColor.DARK_PURPLE + "IV";
    private static String iName = ChatColor.RED + "Wybierz konfiguracje I";
    private static String iName1 = ChatColor.GREEN + "Wybierz konfiguracje II";
    private static String iName2 = ChatColor.BLUE + "Wybierz konfiguracje III";
    private static String iName3 = ChatColor.DARK_PURPLE + "Wybierz konfiguracje IV";

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
        Trait[] traits = Trait.getRandomTraits(4);
        Trait[] traits1 = Trait.getRandomTraits(4);
        Trait[] traits2 = Trait.getRandomTraits(4);

        lore.add(traits[0].getPolishIndex());
        lore.add(traits[1].getPolishIndex());
        lore.add(traits[2].getPolishIndex());
        lore.add(traits[3].getPolishIndex());
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
        lore1.add(traits1[0].getPolishIndex());
        lore1.add(traits1[1].getPolishIndex());
        lore1.add(traits1[2].getPolishIndex());
        lore1.add(traits1[3].getPolishIndex());
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
        lore2.add(traits2[0].getPolishIndex());
        lore2.add(traits2[1].getPolishIndex());
        lore2.add(traits2[2].getPolishIndex());
        lore2.add(traits2[3].getPolishIndex());
        itemMeta2.setLore(lore2);
        itemStack2.setItemMeta(itemMeta2);

        itemStacks[0] = itemStack;
        itemStacks[1] = itemStack1;
        itemStacks[2] = itemStack2;

        return itemStacks;
    }

    private static ItemStack getDifferentStatsItem() {
        Random random = new Random();
        ItemStack itemStack = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(iName3);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(new Agility().name() + ": " + random.nextInt(3));
        lore.add(new Endurance().name() + ": " + random.nextInt(3));
        lore.add(new MaxHP().name() + ": " + random.nextInt(3));
        lore.add(new Strength().name() + ": " + random.nextInt(3));
        lore.add(new Intelligence().name() + ": " + random.nextInt(3));
        lore.add(new Magic().name() + ": " + random.nextInt(3));
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private static ItemStack getPDifferentStatsItem() {
        ItemStack itemStack = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(iNameP3);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(new Agility().name() + ": " + "?");
        lore.add(new Endurance().name() + ": " + "?");
        lore.add(new MaxHP().name() + ": " + "?");
        lore.add(new Strength().name() + ": " + "?");
        lore.add(new Intelligence().name() + ": " + "?");
        lore.add(new Magic().name() + ": " + "?");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


    @Override
    public void openAction(Inventory inventory, Player player) {
        if (!rolledStatsPreviously(player)) {
            startRandomizing(inventory, player);
        }
        else reopen(player);
    }


    public static void openAction(Inventory inventory, ItemStack[] itemStacks) {
        inventory.setItem(1, itemStacks[0]);
        inventory.setItem(3, itemStacks[1]);
        inventory.setItem(5, itemStacks[2]);
        inventory.setItem(7, getPDifferentStatsItem());
        GuiUtils.fillEmptySlots(inventory, Item.grayPane());
    }


    public static void reopen(Player player) {
        GUI gui = new RandomStats();
        Inventory inventory = Bukkit.createInventory(null, gui.size(), gui.name());
        openAction(inventory, loadPlayerRandomizedStats(player));
        GUIListener.lockedInventories.add(inventory);
        Bukkit.getScheduler().runTaskLater(RPEssentials.plugin, () -> {player.openInventory(inventory);}, 2);
    }

    private void startRandomizing(Inventory inventory, Player player) {
        GuiUtils.fillEmptySlots(inventory, Item.grayPane());
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
                        inventory.setItem(1, GuiUtils.changeItemName(inventory.getItem(1), iName));
                        inventory.setItem(3, GuiUtils.changeItemName(inventory.getItem(3), iName1));
                        inventory.setItem(5, GuiUtils.changeItemName(inventory.getItem(5), iName2));
                        inventory.setItem(7, GuiUtils.changeItemName(inventory.getItem(7), iName3));
                        ArrayList<HashMap<Stats, Integer>> hashMaps = new ArrayList<>(Arrays.asList(RandomStatsGuiItemParser.itemToStats(inventory.getItem(1)), RandomStatsGuiItemParser.itemToStats(inventory.getItem(3)), RandomStatsGuiItemParser.itemToStats(inventory.getItem(5))));
                        ArrayList<ArrayList<Trait>> traits = new ArrayList<>(Arrays.asList(itemToTraits(inventory.getItem(1)), itemToTraits(inventory.getItem(3)), itemToTraits(inventory.getItem(5))));
                        saveRandomizedStats(player, hashMaps);
                        saveRandomizedTraits(player, traits);
                        return;
                }
                try {
                    Thread.sleep(t * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player.playSound(player.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1, 1);
                ItemStack[] itemStacks = getRandomStatsItems();
                inventory.setItem(1, itemStacks[0]);
                inventory.setItem(3, itemStacks[1]);
                inventory.setItem(5, itemStacks[2]);
                inventory.setItem(7, getPDifferentStatsItem());
                run();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void saveRandomizedStats(Player player, ArrayList<HashMap<Stats, Integer>> hashMaps) {
        String path = "SavedRandomizing." + player.getName();
        for (int i = 0; i < hashMaps.size(); i++) {
            for (Stats stats : hashMaps.get(i).keySet()) {
                RPEssentials.RPPlayerDataConfig.set(path + "." + (i + 1) + "." + stats.name(), hashMaps.get(i).get(stats));
            }
        }
        RPEssentials.saveRPPlayerConfig();
    }

    static ArrayList<Trait> itemToTraits(ItemStack itemStack) {
        ArrayList<Trait> traits = new ArrayList<>();
        ArrayList<String> lore = (ArrayList<String>) itemStack.getItemMeta().getLore();
        for (int i = 0; i < 4; i++) {
            traits.add(Trait.getByPolishIndex(lore.get(i + 6)));
        }
        return traits;
    }

    private static void saveRandomizedTraits(Player player, ArrayList<ArrayList<Trait>> arrays) {
        String path = "SavedRandomizing." + player.getName();
        for (int i = 0; i < arrays.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Trait trait : arrays.get(i)) {
                stringBuilder.append(trait.name()).append(",");
            }
            RPEssentials.RPPlayerDataConfig.set(path + "." + (i + 1) + ".Traits", stringBuilder.toString());
        }
        RPEssentials.saveRPPlayerConfig();
    }

    private static ItemStack[] loadPlayerRandomizedStats(Player player) {
        ItemStack[] itemStacks = new ItemStack[4];
        ItemMeta[] itemMetas = new ItemMeta[4];
        String[] strings = {iName, iName1, iName2, iName3};
        for (int i = 0; i < 3; i++) {
            itemStacks[i] = new ItemStack(Material.PAPER, 1);
            itemMetas[i] = itemStacks[i].getItemMeta();
            itemMetas[i].setDisplayName(strings[i]);
            ArrayList<String> strings1 = new ArrayList<>();
            strings1.add(new Agility().name() + ": " + RPEssentials.getRPPlayerDataConfig().get("SavedRandomizing." + player.getName() + "." + (i + 1) + "." + Stats.Agility.name()));
            strings1.add(new Endurance().name() + ": " + RPEssentials.getRPPlayerDataConfig().get("SavedRandomizing." + player.getName() + "." + (i + 1) + "." + Stats.Endurance.name()));
            strings1.add(new MaxHP().name() + ": " + RPEssentials.getRPPlayerDataConfig().get("SavedRandomizing." + player.getName() + "." + (i + 1) + "." + Stats.MaxHP.name()));
            strings1.add(new Strength().name() + ": " + RPEssentials.getRPPlayerDataConfig().get("SavedRandomizing." + player.getName() + "." + (i + 1) + "." + Stats.Strength.name()));
            strings1.add(new Intelligence().name() + ": " + RPEssentials.getRPPlayerDataConfig().get("SavedRandomizing." + player.getName() + "." + (i + 1) + "." + Stats.Intelligence.name()));
            strings1.add(new Magic().name() + ": " + RPEssentials.getRPPlayerDataConfig().get("SavedRandomizing." + player.getName() + "." + (i + 1) + "." + Stats.Magic.name()));
            Trait[] traits = traitsFromString(RPEssentials.getRPPlayerDataConfig().getString("SavedRandomizing." + player.getName() + "." + (i + 1) + ".Traits"));
            strings1.add(traits[0].getPolishIndex());
            strings1.add(traits[1].getPolishIndex());
            strings1.add(traits[2].getPolishIndex());
            strings1.add(traits[3].getPolishIndex());
            itemMetas[i].setLore(strings1);
            itemStacks[i].setItemMeta(itemMetas[i]);
        }
        return itemStacks;
    }


    private static boolean rolledStatsPreviously(Player player) {
        try {
            return (RPEssentials.getRPPlayerDataConfig().getConfigurationSection("SavedRandomizing." + player.getName()) != null);
        } catch (NullPointerException e) {
            return false;
        }

    }

    public static void resetRolledStats(Player player) {
        RPEssentials.getRPPlayerDataConfig().set("SavedRandomizing." + player.getName(), null);
        RPEssentials.saveRPPlayerConfig();
    }

    public static void setRolledPreviously(Player player) {
        RPEssentials.getRPPlayerDataConfig().set("SavedRandomizing." + player.getName() + ".RolledPreviously", true);
        RPEssentials.saveRPPlayerConfig();
    }

    public static boolean rolledPreviously(Player player) {
        if (RPEssentials.getRPPlayerDataConfig().get("SavedRandomizing." + player.getName() + ".RolledPreviously") == null) return false;
        else return RPEssentials.getRPPlayerDataConfig().getBoolean("SavedRandomizing." + player.getName() + ".RolledPreviously");
    }

    private static Trait[] traitsFromString(String s) {
        Trait[] traits = new Trait[4];
        String[] strings = s.split(",");
        for (int i = 0; i < strings.length; i++) {
            traits[i] = Trait.valueOf(strings[i]);
        }
        return traits;
    }

}
