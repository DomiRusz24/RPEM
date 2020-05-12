package pl.alvion.rpem.rpessentials.health_dr.playerPart;

import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.health_dr.enums.HealingStages;
import pl.alvion.rpem.rpessentials.health_dr.enums.InfectionStage;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.HealableInjury;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;
import pl.alvion.rpem.rpessentials.rpplayer_dr.stats.Stats;

public abstract class PlayerBodyInjury {
    private PlayerBodyPart bodyPart;
    private RPPlayer rpPlayer;
    private double intensity;
    private double efficiency = 100;
    private PlayerBodyInjury instance = this;

    public PlayerBodyInjury(PlayerBodyPart part, int Intensity) {
        this.bodyPart = part;
        this.rpPlayer = getBodyPart().getRpPlayer();
        this.intensity = Intensity;
        this.bodyPart.getInjuries().add(this);
        run((intensity * 0.1) + (part.BodyPartComplexity() * 0.1) + (efficiency / 100));
    }

    public double getEfficiency() {
        return efficiency;
    }

    public PlayerBodyPart getBodyPart() {
        return bodyPart;
    }

    public double getIntensity() {
        return intensity;
    } // Mnoznik obrazen, czasu trwania itd. (1 - 10)

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

    public void lowerEfficiency(int value) {
        efficiency -= value;
        if (efficiency <= 0 ) {
            efficiency = 0;
            this.bodyPart.getInjuries().remove(this);
        }
    }

    public boolean recoverTime(int ticks, RPPlayer rpPlayer, boolean selfHealed) { // Wyleczenie po playerze
        if(this instanceof HealableInjury && !this.isHealing) {
            isHealing = true;
            efficiency -= 20;
            new BukkitRunnable() {
                @Override
                public void run() {
                    efficiency -= 40;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            efficiency -= 40;
                        }
                    }.runTaskLater(RPEssentials.plugin, (long) (((HealableInjury) instance).regenerationTimeMax() * rpPlayer.getPlayersMedicalChance()) / 10);
                }
            }.runTaskLater(RPEssentials.plugin, (long) (((HealableInjury) this).regenerationTimeMax() * rpPlayer.getPlayersMedicalChance()));
        }
        return false;
    }

    public boolean recoverTime(int ticks) { // Samo wyleczenie po czasie.
        if(this instanceof HealableInjury) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    efficiency -= 20;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            efficiency -= 40;
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    efficiency -= 40;
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
    public void run(double intensity) {
        this.bodyPart.lowerEfficiency((int) Math.round(intensity));
    }

}
