package pl.alvion.rpem.rpessentials.rpplayer.stats;

import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

public enum Stats {
    Agility,
    Endurance,
    Intelligence,
    Magic,
    Strength,
    MaxHP,
    AvailableStatPoints;

    public int getStat(RPPlayer RPplayer) {
        String path = "Player." + RPplayer.getPlayer().getDisplayName() + ".stats.";
        return RPEssentials.getRPPlayerDataConfig().getInt(path + this.name());
    }

    public void setStat(RPPlayer RPplayer, int value) {
        String path = "Player." + RPplayer.getPlayer().getDisplayName() + ".stats.";
        RPEssentials.getRPPlayerDataConfig().set(path + this.name(), value);
    }
}
