package pl.alvion.rpem.rpessentials.birdletter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.alvion.rpem.rpessentials.birdletter.file.BLData;

public class JoinPlayerEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        //Dodawanie gracza do BLData.
        if (!BLData.get().getKeys(false).equals(p.getName())) {
            BLData.get().createSection(p.getName() + ".Lists");
            BLData.save();
        }
    }
}
