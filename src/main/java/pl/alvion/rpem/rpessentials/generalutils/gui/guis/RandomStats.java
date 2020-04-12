package pl.alvion.rpem.rpessentials.generalutils.gui.guis;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.generalutils.gui.GUI;
import pl.alvion.rpem.rpessentials.rpplayer.stats.aviliable.*;

import java.util.ArrayList;
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
        String name = itemStack.getItemMeta().getDisplayName();
    }



    private Random random = new Random();
    private ItemStack[] getRandomStatsItems() {
        ItemStack[] itemStacks = new ItemStack[3];
        ItemStack itemStack = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Wybierz konfiguracje I");
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
        itemMeta1.setDisplayName(ChatColor.GREEN + "Wybierz konfiguracje II");
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
        itemMeta2.setDisplayName(ChatColor.BLUE + "Wybierz konfiguracje III");
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
                    case 20:
                        t = t *2;
                        break;
                    case 21:
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_EYE_DEATH, 1, 0.5f);
                        return;
                }
                try {
                    Thread.sleep(t * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1, 1);
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
