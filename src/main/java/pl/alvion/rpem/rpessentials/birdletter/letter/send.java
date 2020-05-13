package pl.alvion.rpem.rpessentials.birdletter.letter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import pl.alvion.rpem.rpessentials.birdletter.file.BLData;

public class send implements Listener, CommandExecutor {
    private static int n = 0;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("postman")) {
            if (commandSender.hasPermission("BirdLetterOP")) {
                n = 1;
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&lWciągu 5 sekund wpisz nazwę gracza."));
            }else {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNie masz dostępu do tej komendy."));
            }
        }
        return false;
    }

    @EventHandler
    public void SaveLetter(AsyncPlayerChatEvent e) {
        if (n == 1) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            int number = BLData.get().getConfigurationSection(e.getMessage() + ".Lists.").getKeys(false).size() + 1;
            if (BLData.get().getKeys(false).contains(e.getMessage())) {
                if (p.getInventory().getItemInMainHand().getType().equals(Material.WRITABLE_BOOK)) {
                    ItemStack book = p.getInventory().getItemInMainHand();
                    BookMeta bmeta = (BookMeta) book.getItemMeta();
                    BLData.get().set(e.getMessage() + ".Lists." + number + ".Page1", bmeta.getPage(1));
                    BLData.get().set(e.getMessage() + ".Lists." + number + ".Page2", bmeta.getPage(2));
                    BLData.get().set(e.getMessage() + ".Lists." + number + ".Page3", bmeta.getPage(3));
                    BLData.get().set(e.getMessage() + ".Lists." + number + ".Page4", bmeta.getPage(4));
                    BLData.get().set(e.getMessage() + ".Lists." + number + ".Page5", bmeta.getPage(5));
                    BLData.save();
                    p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&lWysłano."));
                    n = 0;
                }else { p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNie masz książki w ręce.")); n = 0; }
            }
        }
    }
}