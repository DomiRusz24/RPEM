package pl.alvion.rpem.rpessentials.rpplayer.stats;

import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

public enum StatName {
    Agility,
    Endurance,
    Intelligence,
    Magic,
    Strength,
    MaxHP,
    AvailableStatPoints;

    public int getStat(RPPlayer RPplayer) {
        String path = "Player." + RPplayer.getPlayer().getName() + ".stats.";
        return RPEssentials.getRPPlayerDataConfig().getInt(path + this.name());
    }

    public int getStat(Player player) {
        String path = "Player." + player.getName() + ".stats.";
        return RPEssentials.getRPPlayerDataConfig().getInt(path + this.name());
    }

    public void setStat(RPPlayer RPplayer, int value) {
        String path = "Player." + RPplayer.getPlayer().getName() + ".stats.";
        RPEssentials.getRPPlayerDataConfig().set(path + this.name(), value);
        RPEssentials.saveRPPlayerConfig();
    }

    public void setStat(Player player, int value) {
        String path = "Player." + player.getName() + ".stats.";
        RPEssentials.getRPPlayerDataConfig().set(path + this.name(), value);
        RPEssentials.saveRPPlayerConfig();
    }
}