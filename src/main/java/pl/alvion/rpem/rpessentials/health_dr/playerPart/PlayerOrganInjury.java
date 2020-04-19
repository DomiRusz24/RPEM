package pl.alvion.rpem.rpessentials.health_dr.playerPart;

import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.health_dr.enums.HealingStages;
import pl.alvion.rpem.rpessentials.health_dr.enums.InfectionStage;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.HealableInjury;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.InfectableInjury;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;
import pl.alvion.rpem.rpessentials.rpplayer_dr.stats.Stats;

public abstract class PlayerOrganInjury {
    private PlayerOrgan Organ;
    private RPPlayer rpPlayer;
    private double intensity;
    private PlayerOrganInjury instance = this;

    public PlayerOrganInjury(PlayerOrgan part, int Intensity) {
        this.Organ = part;
        this.rpPlayer = getOrgan().getRpPlayer();
        this.intensity = Intensity;
        this.Organ.getInjuries().add(this);
        run(rpPlayer, intensity * part.OrganComplexity() * 0.1);
    }

    public PlayerOrgan getOrgan() {
        return Organ;
    }

    public double getIntensity() {
        return intensity;
    } // Mnoznik obrazen, czasu trwania itd.

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public boolean infect(InfectionStage stage) {
        if(this.Organ instanceof InfectableBodyPart && this instanceof InfectableInjury) {
            this.Organ.infectOrgan(((InfectableInjury) this).infectSeverity() * ((InfectableBodyPart) this.Organ).infectSeverity(), stage);
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

    abstract public Material getMaterialType(); // Ikonka na GUI
    abstract public void run(RPPlayer rpPlayer, double intensity); // Efekty urazy
}
