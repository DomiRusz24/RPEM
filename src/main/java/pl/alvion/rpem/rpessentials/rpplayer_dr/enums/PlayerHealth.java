package pl.alvion.rpem.rpessentials.rpplayer_dr.enums;

import javafx.print.PageLayout;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;

public enum PlayerHealth {
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


    PlayerHealth(String PolishID, int ID) {
        this.PolishID = PolishID;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getPolishID() {
        return PolishID;
    }

    public static PlayerHealth getPlayerHealthByID(int ID) {
        for (PlayerHealth i : PlayerHealth.values()) {
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

    public static void refreshPlayerHealth(Player player) {
        for (PlayerHealth info : PlayerHealth.values()) {
            int efficiency = info.getPlayerEfficiency(player);
            switch (info) {
                case Pain:
                    break;
                case Consciousness:
                    break;
                case Sight:
                    break;
                case Hearing:
                    break;
                case Moving:
                    player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.2 * (efficiency * 0.01));
                    break;
                case Manipulation:
                    player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue((3.0 * (efficiency * 0.01)) + 1.0);
                    break;
                case Talking:
                    break;
                case Breathing:
                    break;
                case BloodFiltration:
                    break;
                case BloodPumping:
                    break;
                case Metabolism:
                    break;
            }

        }
    }
}
