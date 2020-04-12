package pl.alvion.rpem.rpessentials.rpplayer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.health.PlayerHealth;
import pl.alvion.rpem.rpessentials.rpplayer.attribute.Attribute;
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
    private ArrayList<Attribute> playerAttributes = new ArrayList<>();
    private PlayerHealth playerHealth;

    RPPlayer(Player player) {
        this.player = player;
        conigPath = "Player." + this.player.getDisplayName();
        for(Stats stats : Stats.values()) {
            stats.setStat(this, 0);
        }
        Stats.MaxHP.setStat(this, 2000);
        Stats.AvailableStatPoints.setStat(this, 2);
        RPPlayer.RPPlayers.add(this);
        this.playerHealth = new PlayerHealth(this);
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

    public PlayerHealth getPlayerHealthStatus() {
        return playerHealth;
    }

    public double getCurrentHP() {  //// Oddaje gracza hp w systemie 2000
        return CurrentFractionHP + this.getPlayer().getHealth()*100;
    }

    public ArrayList<Attribute> getPlayerAttributes() {
        return playerAttributes;
    }

    public void addTrait(Traits trait) {
        Traits.addPlayerTrait(this.player, trait, 0,0);
    }

    public void addTrait(Traits trait, int input1) {
        Traits.addPlayerTrait(this.player, trait, input1,0);
    }

    public double getPlayersMedicalChance() {
        double level = 10 - this.getStatLevel(Stats.Intelligence);
        return level / 10;
    }

    public void addTrait(Traits trait, int input1, int input2) {
        Traits.addPlayerTrait(this.player, trait, input1,input2);
    }

    public int getStatLevel(Stats stat) {
        return stat.getStat(this);
    }

    public void setStatLevel(Stats stat, int value) {
        stat.setStat(this, value);
    }

    public ArrayList<Traits> getPlayerTraits() {
        return playerTraits;
    }
}
