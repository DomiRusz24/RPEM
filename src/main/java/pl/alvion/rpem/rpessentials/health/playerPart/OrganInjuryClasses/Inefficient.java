package pl.alvion.rpem.rpessentials.health.playerPart.OrganInjuryClasses;

import org.bukkit.Material;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerOrgan;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerOrganInjury;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

public class Inefficient extends PlayerOrganInjury {
    public Inefficient(PlayerOrgan part, int Intensity) {
        super(part, Intensity);
    }

    @Override
    public Material getMaterialType() {
        return Material.WOODEN_HOE;
    }


    @Override
    public void run(RPPlayer rpPlayer, int intensity) {

    }

    @Override
    public int regenerationTimeMax() {
        return 0;
    }

    @Override
    public int healingLevelMin() {
        return 0;
    }

    @Override
    public double infectSeverity() {
        return 0;
    }

    @Override
    public double infectChance() {
        return 0;
    }
}
