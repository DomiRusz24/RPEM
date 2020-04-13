package pl.alvion.rpem.rpessentials.rpplayer_dr;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class RPPlayerListener implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        for(RPPlayer rpPlayer : RPPlayer.RPPlayers) {
            if(rpPlayer.getPlayer().equals(event.getPlayer())) {
                return;
            }
            RPPlayer.RPPlayers.add(new RPPlayer(event.getPlayer()));
        }
    }
}
