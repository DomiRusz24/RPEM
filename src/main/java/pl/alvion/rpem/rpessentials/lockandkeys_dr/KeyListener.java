package pl.alvion.rpem.rpessentials.lockandkeys_dr;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KeyListener implements Listener {


    @EventHandler
    public void rightClick(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null && (event.getClickedBlock().getState() instanceof Door || event.getClickedBlock().getState() instanceof TrapDoor)) {
            Player player = event.getPlayer();
            Block block = event.getClickedBlock();
            if (player.getInventory().getItemInMainHand().getType().equals(Material.TRIPWIRE_HOOK)) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getLore() != null) {
                    ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                    for (LockedDoor lockedDoor : LockedDoor.lockedDoors) {
                        if (lockedDoor.getDoor() == block) {
                            if (!lockedDoor.getKey().getID().equals(meta.getLore().get(0))) {
                                event.setCancelled(true);
                                return;
                            }
                            return;
                        }
                    }
                    if (player.isSneaking() && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                        if (Key.getKeyByID(meta.getLore().get(0)) != null) {
                            new LockedDoor(block, Key.getKeyByID(meta.getLore().get(0)));
                        } else if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "" + ChatColor.ITALIC + "Klamko-Usuwacz9000")) {
                            LockedDoor.lockedDoors.removeIf(lockedDoor -> lockedDoor.getDoor() == block);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDestroy(BlockBreakEvent event) {
        if (event.getBlock() instanceof Door || event.getBlock() instanceof TrapDoor) {
            LockedDoor.lockedDoors.removeIf(door -> door.getDoor().equals(event.getBlock()));
        }
    }



}

