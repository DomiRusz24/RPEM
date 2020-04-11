package pl.alvion.rpem.rpessentials.health.playerPart.OrganClasses;

import pl.alvion.rpem.rpessentials.health.enums.Organ;
import pl.alvion.rpem.rpessentials.health.enums.OrganInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerOrgan;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public class Brain extends PlayerOrgan implements BleedableBodyPart, InfectableBodyPart {
    public Brain(RPPlayer rpPlayer) {
        super(rpPlayer);
    }


    @Override
    public Organ Organ() {
        return Organ.Brain;
    }

    @Override
    public int OrganComplexity() {
        return 0;
    }


    @Override
    public ArrayList<OrganInjury> incapableInjuries() {
        return null;
    }

    @Override
    public double bleedSeverity() {
        return 0;
    }

    @Override
    public double infectSeverity() {
        return 0;
    }

    @Override
    public void onInfect(double strength) {

    }
}
