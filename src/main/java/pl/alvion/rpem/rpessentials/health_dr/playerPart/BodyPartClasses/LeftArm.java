package pl.alvion.rpem.rpessentials.health_dr.playerPart.BodyPartClasses;

import org.bukkit.attribute.Attribute;
import pl.alvion.rpem.rpessentials.health_dr.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health_dr.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.Amputable;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;

import java.util.ArrayList;

public class LeftArm extends PlayerBodyPart implements Amputable, BleedableBodyPart, InfectableBodyPart {
    
    public LeftArm(RPPlayer rpPlayer) {
        super(rpPlayer);
    }

    @Override
    public double amputationSuccessChance() {
        return 0.7;
    }

    @Override
    public double amputationInfectionChance() {
        return 0.2;
    }

    @Override
    public void onAmputate() {
        getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue() /2);
    }

    @Override
    public double bleedSeverity() {
        return 0.3;
    }

    @Override
    public double infectSeverity() {
        return 0.6;
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
