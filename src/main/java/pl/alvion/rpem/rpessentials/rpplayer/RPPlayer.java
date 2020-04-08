package pl.alvion.rpem.rpessentials.rpplayer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;
import pl.alvion.rpem.rpessentials.rpplayer.traits.Traits;

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
    private Player player;
    protected String conigPath;
    private double CurrentFractionHP;
    private ArrayList<Traits> playerTraits = new ArrayList<>();

    RPPlayer(Player player) {
        this.player = player;
        conigPath = "Player." + this.player.getDisplayName();
        for(Stats stats : Stats.values()) {
            stats.setTrait(this, 0);
        }
        Stats.MaxHP.setTrait(this, 2000);
        Stats.AvailableStatPoints.setTrait(this, 2);
        RPPlayer.RPPlayers.add(this);
    }

    public Player getPlayer() {
        return player;
    }

    public void damage(int hp) { //// Zadaje graczowi dmg w systemie 2000 (1HP = 100)
        double fractionHP = hp % 100;
        player.damage(1);
        player.setHealth(player.getHealth() - (hp - fractionHP));
        this.CurrentFractionHP = this.CurrentFractionHP - fractionHP;
        if(this.CurrentFractionHP < 0) {
            player.setHealth(player.getHealth() - 1);
            this.CurrentFractionHP = Math.abs(this.CurrentFractionHP);
        }
    }


    public double getCurrentHP() {  //// Oddaje gracza hp w systemie 2000
        return CurrentFractionHP + this.getPlayer().getHealth()*100;
    }

    public ArrayList<Traits> getPlayerTraits() {
        return this.playerTraits;
    }

    public void addTrait(Traits trait) {
        Traits.playerTrait(this.player, trait, 0,0);
    }

    public void addTrait(Traits trait, int input1) {
        Traits.playerTrait(this.player, trait, input1,0);
    }

    public void addTrait(Traits trait, int input1, int input2) {
        Traits.playerTrait(this.player, trait, input1,input2);
    }
}
