package pl.alvion.rpem.rpessentials.lockandkeys_dr;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Key {

    public static String generateNewKeyID() {
        return UUID.randomUUID().toString().replace("-", "");
    }



    public static ArrayList<Key> keys = new ArrayList<>();
    private String ID;

    public Key(Player player) {
        boolean cantSet = true;
        while (cantSet) {
            this.ID = generateNewKeyID();
            boolean y = true;
            for (Key i : Key.keys) {
                if (i.getID().equals(this.getID())) {
                    y = false;
                }
            }
            if (y) {
                cantSet = false;
            }
        }
        keys.add(this);
        giveKey(player);
    }

    public String getID() {
        return ID;
    }
    public void giveKey(Player player) {
        ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = item.getItemMeta();
        item.setAmount(1);
        meta.setDisplayName(ChatColor.BOLD + "Klucz");
        meta.setLore(Arrays.asList(this.ID));
        item.setItemMeta(meta);
        player.getInventory().addItem(item);
    }

    public static Key getKeyByID(String ID) {
        for (Key key : Key.keys) {
            if (key.getID().equals(ID)) {
                return key;
            }
        }
        return null;
    }
}
