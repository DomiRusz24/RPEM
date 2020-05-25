package pl.alvion.rpem.rpessentials.birdletter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.alvion.rpem.rpessentials.RPEssentials;

import java.util.ArrayList;

public class Postman implements CommandExecutor, Listener {
    public static int n = 0;
    public static ItemStack sendItem = new ItemStack(Material.BOOK);
    private static Player getPlayer;
    public static Inventory BirdGUI = Bukkit.createInventory(getPlayer, 9, "Nazwa");
    public static boolean StopBirdTimer = false;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("postman")) {
            if (commandSender.hasPermission("BirdLetterOP")) {
                n = 1;
                StopBirdTimer = false;
            }else { commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&c&lNie masz dostępu do tej komendy.")); }
        }
        if (command.getName().equalsIgnoreCase("postmanplayer")) {
            if (n == 1) {
                Player p = (Player) commandSender;
                getPlayer = p;

                meta();
                BirdGUI.setItem(3, sendItem);

                p.openInventory(BirdGUI);
            }else { commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&c&lNie masz dostępu do tej komendy.")); }

        }
        return false;
    }

    public static void meta() {
        ItemMeta im = sendItem.getItemMeta();


        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9====================="));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&6."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&9====================="));

        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bWyślij List"));
        im.setLore(lore);
        sendItem.setItemMeta(im);
    }

    @EventHandler
    public void GUI(InventoryClickEvent e) {
        if (n == 1) {
            Player p = (Player) e.getWhoClicked();
            if (e.getInventory().getType().name().equals(BirdGUI.getType().name())) {
                if (e.getRawSlot() == 3) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&lWpisz nazwę gracza wciągu 5 sekund."));
                    n = 2;
                    Timer();
                }

                if (e.getRawSlot() > 8 && e.getRawSlot() < 45) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.openInventory(BirdGUI);
                }
            }
        }
    }

    public static void Timer() {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(RPEssentials.plugin, new Runnable() {
            @Override
            public void run() {
                n = 0;
                if (StopBirdTimer == false) {
                    getPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&c&lNie wpisano nazwy gracza."));
                }
            }
        }, 5 * 20);
    }
}
