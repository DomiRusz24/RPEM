package pl.alvion.rpem.rpessentials.health.playerPart;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.health.enums.HealingStages;
import pl.alvion.rpem.rpessentials.health.enums.InfectionStage;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.HealableInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;

import java.util.ArrayList;

public abstract class PlayerBodyInjury {
    private PlayerBodyPart bodyPart;
    private RPPlayer rpPlayer;
    private double intensity;
    private PlayerBodyInjury instance = this;

    public PlayerBodyInjury(PlayerBodyPart part, int Intensity) {
        this.bodyPart = part;
        this.rpPlayer = getBodyPart().getRpPlayer();
        this.intensity = Intensity;
        this.bodyPart.getInjuries().add(this);
        run(rpPlayer, intensity * part.BodyPartComplexity() * 0.1);
    }

    public PlayerBodyPart getBodyPart() {
        return bodyPart;
    }

    public double getIntensity() {
        return intensity;
    } // Mnoznik obrazen, czasu trwania itd.

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public boolean infect(InfectionStage stage) {
        if(this instanceof InfectableBodyPart) {
            this.bodyPart.infectPart(((InfectableBodyPart) this).infectSeverity() * bodyPart.BodyPartComplexity() * 0.1, stage);
            return true;
        }
        return false;
    } // Infektuj ta czesc ciala gdzie jest ta uraza.

    private boolean isHealing = false;

    public boolean isHealing() {
        return isHealing;
    }

    public boolean recoverTime(int ticks, RPPlayer rpPlayer, boolean selfHealed) { // Wyleczenie po playerze
        if(this instanceof HealableInjury && !this.isHealing) {
            isHealing = true;
            ((HealableInjury) this).heal(HealingStages.Start, rpPlayer.getPlayersMedicalChance());
            new BukkitRunnable() {
                @Override
                public void run() {
                    ((HealableInjury) instance).heal(HealingStages.Healed, rpPlayer.getPlayersMedicalChance());
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            ((HealableInjury) instance).healFully();
                        }
                    }.runTaskLater(RPEssentials.plugin, (long) (((HealableInjury) instance).regenerationTimeMax() * rpPlayer.getPlayersMedicalChance()) / 10);
                }
            }.runTaskLater(RPEssentials.plugin, (long) (((HealableInjury) this).regenerationTimeMax() * rpPlayer.getPlayersMedicalChance()));
        }
        return false;
    }

    public boolean recoverTime(int ticks) { // Samo wyleczenie po czasie.
        if(this instanceof HealableInjury && !this.isHealing) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    ((HealableInjury) instance).heal(HealingStages.Start, rpPlayer.getPlayersMedicalChance());
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            ((HealableInjury) instance).heal(HealingStages.Healed, rpPlayer.getPlayersMedicalChance());
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    ((HealableInjury) instance).healFully();
                                }
                            }.runTaskLater(RPEssentials.plugin, (long) (((HealableInjury) instance).regenerationTimeMax() * rpPlayer.getPlayersMedicalChance()) / 10);
                        }
                    }.runTaskLater(RPEssentials.plugin, (long) (((HealableInjury) instance).regenerationTimeMax() * rpPlayer.getPlayersMedicalChance()));
                }
            }.runTaskLater(RPEssentials.plugin, ticks * (11 - rpPlayer.getStatLevel(Stats.Endurance)));
        }
        return false;
    } // Samo wyleczenie

    abstract public Material getMaterial(); // Ikonka na GUI
    abstract public void run(RPPlayer rpPlayer, double intensity); // Efekty urazy

}
