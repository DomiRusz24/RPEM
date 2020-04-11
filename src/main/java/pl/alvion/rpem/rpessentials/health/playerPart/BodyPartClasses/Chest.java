package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public class Chest extends PlayerBodyPart implements InfectableBodyPart, BleedableBodyPart {
    public Chest(RPPlayer rpPlayer) {
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

    }

    @Override
    public void onInfectStage4(double strength) {

    }

    @Override
    public BodyPart bodyPart() {
        return BodyPart.Chest;
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
}
