package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.Amputable;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public class LeftArm extends PlayerBodyPart implements Amputable, BleedableBodyPart, InfectableBodyPart {

    public LeftArm(RPPlayer rpPlayer) {
        super(rpPlayer);
    }

    @Override
    public BodyPart bodyPart() {
        return null;
    }

    @Override
    public int BodyPartComplexity() {
        return 0;
    }

    @Override
    public ArrayList<BodyPartInjury> incapableInjuries() {
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

    @Override
    public double amputationSuccessChance() {
        return 0;
    }

    @Override
    public double amputationInfectionChance() {
        return 0;
    }

    @Override
    public void onAmputate() {

    }
}
