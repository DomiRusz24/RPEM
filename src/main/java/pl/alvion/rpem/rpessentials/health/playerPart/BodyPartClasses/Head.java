package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.Amputable;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;

import java.util.ArrayList;

public class Head extends PlayerBodyPart implements InfectableBodyPart, Amputable, BleedableBodyPart {

    @Override
    public double amputationSuccessChance() {
        return 1;
    }

    @Override
    public double amputationInfectionChance() {
        return 0;
    }

    @Override
    public void onAmputate() {
        getPlayer().damage(9999);

    }

    @Override
    public double bleedSeverity() {
        return 1;
    }

    @Override
    public double infectSeverity() {
        return 1;
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
    public void removePart() {
        getPlayer().damage(9999);
    }

    @Override
    public BodyPart bodyPart() {
        return BodyPart.Head;
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
