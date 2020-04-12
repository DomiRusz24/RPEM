package pl.alvion.rpem.rpessentials.rpplayer.stats;

public class StatUtils {

    public static Stat getStat(Stats statName) {
        for (Stat stat : Stat.stats) {
            if (stat.statName().equals(statName)) return stat;
        }
        return null;
    }


}
