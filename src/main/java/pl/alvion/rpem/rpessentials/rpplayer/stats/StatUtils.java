package pl.alvion.rpem.rpessentials.rpplayer.stats;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class StatUtils {

    public static Stat getStat(Stats statName) {
        for (Stat stat : Stat.stats) {
            if (stat.statName().equals(statName)) return stat;
        }
        return null;
    }

    public static void setStats(Player player, HashMap<Stats, Integer> stats) {
        for (Stats stat : stats.keySet()) {
            stat.setStat(player, stats.get(stat));
        }
    }

}
