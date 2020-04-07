package pl.alvion.rpem.rpessentials.rpplayer;

import org.bukkit.configuration.file.FileConfiguration;
import pl.alvion.rpem.rpessentials.RPEssentials;

public class Stats {
    private RPPlayer RPplayer;
    private String path;
    private FileConfiguration config = RPEssentials.getRPPlayerDataConfig();

    Stats(RPPlayer RRplayer) {
        this.RPplayer = RRplayer;
        path = "Player." + RPplayer.getPlayer().getDisplayName() + ".stats.";
        config.addDefault(path + "maxhp", 2000);
        config.addDefault(path + "strength", 0);
        config.addDefault(path + "agility", 0);
        config.addDefault(path + "endurance", 0);
        config.addDefault(path + "intelligence", 0);
        config.addDefault(path + "magic", 0);
    }

    public int getAgility() {
        return config.getInt(path + "agility");
    }

    public int getEndurance() {
        return config.getInt(path + "endurance");
    }

    public int getMaxhp() {
        return config.getInt(path + "maxhp");
    }

    public int getIntelligence() {
        return config.getInt(path + "intelligence");
    }

    public int getMagic() {
        return config.getInt(path + "magic");
    }

    public int getStrength() {
        return config.getInt(path + "strength");
    }

    public void setMaxHP(int value) {
        config.set(path + "maxhp", value);
    }

    public void setStrength(int value) {
        config.set(path + "strength", value);
    }

    public void setAgility(int value) {
        config.set(path + "agility", value);
    }

    public void setEndurance(int value) {
        config.set(path + "endurance", value);
    }

    public void setIntelligence(int value) {
        config.set(path + "intelligence", value);
    }

    public void setMagic(int value) {
        config.set(path + "magic", value);
    }

    public RPPlayer getRPplayer() {
        return RPplayer;
    }

}
