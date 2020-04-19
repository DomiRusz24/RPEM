package pl.alvion.rpem.rpessentials.health_dr.playerPart;

import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.health_dr.enums.HealingStages;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.HealableInjury;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;
import pl.alvion.rpem.rpessentials.rpplayer_dr.stats.Stats;

public abstract class PlayerDisease {
    private RPPlayer rpPlayer;
    private double intensity;
    private PlayerDisease instance = this;

    public PlayerDisease(RPPlayer rpPlayer, int Intensity) {
        this.rpPlayer = rpPlayer;
        this.intensity = Intensity;
        this.rpPlayer.getPlayerHealthStatus().getInfenctions().add(this);
        run(rpPlayer, intensity);
    }

    public double getIntensity() {
        return intensity;
    } // Mnoznik obrazen, czasu trwania itd.

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    private boolean isHealing = false;

    public boolean isHealing() {
        return isHealing;
    }

    public boolean recoverTime(int ticks, RPPlayer rpPlayer, boolean selfHealed) { // Wyleczenie po playerze
        if (this instanceof HealableInjury && !this.isHealing) {
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
        if (this instanceof HealableInjury && !this.isHealing) {
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

    abstract public Material getMaterialType(); // Ikonka na GUI

    abstract public void run(RPPlayer rpPlayer, double intensity); // Efekty urazy
}
