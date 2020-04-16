package pl.alvion.rpem.rpessentials.rpplayer_dr.stats;

import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;

import java.util.ArrayList;
import java.util.HashMap;

public enum Stats {
    Agility,
    Endurance,
    Intelligence,
    Magic,
    Strength,
    MaxHP,
    AvailableStatPoints,
    Melee(AttributeTypes.Offence),
    AxeHandling(AttributeTypes.Offence),
    SwordHandling(AttributeTypes.Offence),
    ShieldHandling(AttributeTypes.Offence),
    BowShooting(AttributeTypes.Offence),
    Throwing(AttributeTypes.Offence),
    MagicOne(AttributeTypes.Offence),
    MagicTwo(AttributeTypes.Offence),
    MagicThree(AttributeTypes.Offence),
    Crafting(AttributeTypes.Crafts),
    Alchemy(AttributeTypes.Crafts),
    Smiting(AttributeTypes.Crafts),
    Enchanting(AttributeTypes.Crafts),
    Mining(AttributeTypes.Crafts),
    WoodChopping(AttributeTypes.Crafts),
    Farming(AttributeTypes.Crafts),
    Breeding(AttributeTypes.Crafts),
    Stealing(AttributeTypes.Crafts),
    Medicine(AttributeTypes.Crafts),
    Stamina(AttributeTypes.Body),
    Resistance(AttributeTypes.Body),
    Sneaking(AttributeTypes.Body);

    private AttributeTypes type = null;

    Stats(AttributeTypes type) {
        this.type = type;
    }

    Stats() {
    }

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





    public AttributeTypes getType() {
        return type;
    }
}