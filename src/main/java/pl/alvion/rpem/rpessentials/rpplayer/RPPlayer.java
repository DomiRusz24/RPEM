package pl.alvion.rpem.rpessentials.rpplayer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;

import java.util.ArrayList;

public class RPPlayer {
    public static ArrayList<RPPlayer> RPPlayers = new ArrayList<>();

    public static RPPlayer getRPPlayer(Player player) {
        for(RPPlayer rpPlayer : RPPlayer.RPPlayers) {
            if(rpPlayer.getPlayer().equals(player)) {
                return rpPlayer;
            }
        }
        return null;
    }

    private FileConfiguration config = RPEssentials.getRPPlayerDataConfig();
    public Stats stats;
    public Skills skills;
    private Player player;
    protected String conigPath;
    private int CurrentHP;
    ArrayList<Traits> playerTraits = new ArrayList<>();

    RPPlayer(Player player) {
        this.player = player;
        conigPath = "Player." + this.player.getDisplayName();
        stats = new Stats(this);
        skills = new Skills(this);
        CurrentHP = stats.getMaxhp();
    }

    public Player getPlayer() {
        return player;
    }

    public void damage(int hp, boolean ApplyDamage) {
        this.CurrentHP = CurrentHP - hp;
        if(ApplyDamage && this.CurrentHP % 100 == 0) {
            this.getPlayer().damage(this.getPlayer().getHealth()*100 - this.CurrentHP);
        }
    }

}
