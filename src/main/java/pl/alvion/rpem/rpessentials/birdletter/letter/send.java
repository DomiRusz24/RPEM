package pl.alvion.rpem.rpessentials.birdletter.letter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import pl.alvion.rpem.rpessentials.birdletter.Postman;
import pl.alvion.rpem.rpessentials.birdletter.file.BLData;

public class send implements Listener {
    @EventHandler
    public void SaveLetter(AsyncPlayerChatEvent e) {
        if (Postman.n == 2) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            int number = BLData.get().getConfigurationSection(e.getMessage() + ".Lists.").getKeys(false).size() + 1;
            if (BLData.get().getKeys(false).contains(e.getMessage())) {
                if (p.getInventory().getItemInMainHand().getType().equals(Material.WRITABLE_BOOK)) {
                    ItemStack book = p.getInventory().getItemInMainHand();
                    BookMeta bmeta = (BookMeta) book.getItemMeta();
                    if (bmeta.getPageCount() == 1 || bmeta.getPageCount() == 2) {
                        BLData.get().set(e.getMessage() + ".Lists." + number + ".Page1", bmeta.getPage(1));
                        BLData.get().set(e.getMessage() + ".Lists." + number + ".Page2", bmeta.getPage(2));
                        BLData.save();
                        p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&lWysłano."));
                        Postman.n = 0;
                        Postman.StopBirdTimer = true;
                    }else { p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&c&lKartka nie może mieć więcej niż 2 strony.")); Postman.n = 0; Postman.StopBirdTimer = true;}
                }else { p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&c&lNie masz książki w ręce.")); Postman.n = 0; Postman.StopBirdTimer = true;}
            }else { p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&8&lOOC&7]&c&lNie znaleziono gracza.")); Postman.n = 0; Postman.StopBirdTimer = true;}
        }
    }
}