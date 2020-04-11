package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public class RightEye extends PlayerBodyPart implements InfectableBodyPart {
    public RightEye(RPPlayer rpPlayer) {
        super(rpPlayer);
    }

    @Override
    public double infectSeverity() {
        return 0;
    }

    @Override
    public void onInfect(double strength) {

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
}
