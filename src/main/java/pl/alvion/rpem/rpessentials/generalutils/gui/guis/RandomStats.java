package pl.alvion.rpem.rpessentials.generalutils.gui.guis;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.generalutils.gui.GUI;

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

    private Random random = new Random();
    private ItemStack[] getRandomStatsItems()
    {
        ItemStack itemStack = new ItemStack(Material.PAPER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "I");
        ArrayList<String> lore = new ArrayList<>();


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
                run();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }
}
