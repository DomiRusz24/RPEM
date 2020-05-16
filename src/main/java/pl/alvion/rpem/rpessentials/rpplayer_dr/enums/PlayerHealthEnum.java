package pl.alvion.rpem.rpessentials.rpplayer_dr.enums;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;

public enum PlayerHealthEnum {
    Pain("Bol", 0),
    Consciousness("Swiadomosc", 1),
    Sight("Wzrok", 2),
    Hearing("Sluch", 3),
    Moving("Ruch", 4),
    Manipulation("Manipulacja", 5),
    Talking("Gadanie", 6),
    Breathing("Oddychanie", 7),
    BloodFiltration("FiltracjaKrwi", 8),
    BloodPumping("PompowanieKrwi", 9),
    Metabolism("Metabolizm", 10);

    private String PolishID;

    private int ID;


    PlayerHealthEnum(String PolishID, int ID) {
        this.PolishID = PolishID;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getPolishID() {
        return PolishID;
    }

    public static PlayerHealthEnum getPlayerHealthByID(int ID) {
        for (PlayerHealthEnum i : PlayerHealthEnum.values()) {
            if (i.getID() == ID) {
                return i;
            }
        }
        return null;
    }

    public int getPlayerEfficiency(RPPlayer RPplayer) {
        String path = "Player." + RPplayer.getPlayer().getName() + ".healthInfo.";
        return RPEssentials.getRPPlayerDataConfig().getInt(path + this.name());
    }

    public int getPlayerEfficiency(Player player) {
        String path = "Player." + player.getName() + ".healthInfo.";
        return RPEssentials.getRPPlayerDataConfig().getInt(path + this.name());
    }

    public void setPlayerEfficiency(RPPlayer RPplayer, int value) {
        String path = "Player." + RPplayer.getPlayer().getName() + ".healthInfo.";
        RPEssentials.getRPPlayerDataConfig().set(path + this.name(), value);
        RPEssentials.saveRPPlayerConfig();
    }

    public void setPlayerEfficiency(Player player, int value) {
        String path = "Player." + player.getName() + ".healthInfo.";
        RPEssentials.getRPPlayerDataConfig().set(path + this.name(), value);
        RPEssentials.saveRPPlayerConfig();
    }

    // Static - maksymalna wartosc

    public void setPlayerStaticEfficiency(RPPlayer RPplayer, int value) {
        String path = "Player." + RPplayer.getPlayer().getName() + ".healthInfo.static";
        RPEssentials.getRPPlayerDataConfig().set(path + this.name(), value);
        RPEssentials.saveRPPlayerConfig();
    }

    public void setPlayerStaticEfficiency(Player player, int value) {
        String path = "Player." + player.getName() + ".healthInfo.static";
        RPEssentials.getRPPlayerDataConfig().set(path + this.name(), value);
        RPEssentials.saveRPPlayerConfig();
    }

    public int getPlayerStaticEfficiency(RPPlayer RPplayer) {
        String path = "Player." + RPplayer.getPlayer().getName() + ".healthInfo.static";
        return RPEssentials.getRPPlayerDataConfig().getInt(path + this.name());
    }
    public int getPlayerStaticEfficiency(Player player) {
        String path = "Player." + player.getName() + ".healthInfo.static";
        return RPEssentials.getRPPlayerDataConfig().getInt(path + this.name());
    }

    public static void refreshPlayerHealth(Player player) {
        for (PlayerHealthEnum info : PlayerHealthEnum.values()) {
            int efficiency = info.getPlayerEfficiency(player);
            if (efficiency > info.getPlayerStaticEfficiency(player)) {
                info.setPlayerEfficiency(player, info.getPlayerStaticEfficiency(player));
            }
            switch (info) {
                case Pain:
                    break;
                case Consciousness:
                    double consciousness = ((PlayerHealthEnum.Pain.getPlayerEfficiency(player) - 0.1) * 4 / 9)
                            * (1 - 0.2 * (1 - PlayerHealthEnum.BloodPumping.getPlayerEfficiency(player) * 0.01))
                            * (1 - 0.2 * (1 - PlayerHealthEnum.Breathing.getPlayerEfficiency(player) * 0.01))
                            * (1 - 0.1 * (1 - PlayerHealthEnum.BloodFiltration.getPlayerEfficiency(player) * 0.01));
                    info.setPlayerEfficiency(player, (int) Math.round(consciousness));
                    if (consciousness < 30) {
                        // zmdlenie
                    } else if (consciousness < 1 ) {
                        // dead
                    }
                    break;
                case Sight:
                    if (efficiency < 1) {
                        // slepota
                    }
                    break;
                case Hearing:
                    if (efficiency < 5) {
                        // gluchy
                    }
                    break;
                case Moving:
                    player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.2 * (efficiency * 0.01));
                    break;
                case Manipulation:
                    player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue((3.0 * (efficiency * 0.01)) + 1.0);
                    break;
                case Talking:
                    if (efficiency < 5) {
                        // niemowa
                    }
                    break;
                case Breathing:
                    if (efficiency < 1) {
                        // dead
                    }
                    break;
                case BloodFiltration:
                    if (efficiency < 20) {
                        // dead
                    }
                    break;
                case BloodPumping:
                    if (efficiency < 10) {
                        // dead
                    }
                    break;
                case Metabolism:
                    if (efficiency < 10) {
                        // nie moze zrec
                    }
                    break;
            }

        }
    }
}
