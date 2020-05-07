package pl.alvion.rpem.rpessentials.magic.elemental.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.server.PluginEnableEvent;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneSymbol;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneTable;

import java.util.HashMap;


public class ElementalListener implements Listener {



    private static HashMap<Player, Runnable> nextInteractEvent = new HashMap<>();
    private static HashMap<Player, Runnable> nextSneakEvent = new HashMap<>();

    @EventHandler
    public void onEnable(PluginEnableEvent event) {
        RuneSymbol.onEnable();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK) )&& player.getName().equals("KarwszPL")) {
            RuneTable.rayTrackPoint(player);
        }
        else if ((event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) && player.getName().equals("KarwszPL")) {
            if (!RuneTable.getPlayerHasTable(player)) {
                new RuneTable(player);
            }
            else {
                RuneTable.compareWithAllSymbols(RuneTable.getPlayerTable(player));
                RuneTable.removePlayersTable(player);
            }
        }
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (nextSneakEvent.get(player) != null) {
            nextSneakEvent.get(player).run();
            nextSneakEvent.put(player, null);
        }
    }

    public static void setNextInteractEvent(Player player, Runnable runnable) {
        nextInteractEvent.put(player, runnable);
    }

    public static void setNextSneakEvent(Player player, Runnable runnable) {
        nextSneakEvent.put(player, runnable);
    }

}
