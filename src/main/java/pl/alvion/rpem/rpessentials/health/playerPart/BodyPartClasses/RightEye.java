package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;
import pl.alvion.rpem.rpessentials.rpplayer.traits.Traits;

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
    public void onInfectStage1(double strength) {

    }

    @Override
    public void onInfectStage2(double strength) {

    }

    @Override
    public void onInfectStage3(double strength) {
        this.getRpPlayer().addTrait(Traits.Blindness);
    }

    @Override
    public void onInfectStage4(double strength) {
        this.getRpPlayer().addTrait(Traits.AbsenceOfEye);
    }


    @Override
    public BodyPart bodyPart() {
        return BodyPart.RightEye;
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
