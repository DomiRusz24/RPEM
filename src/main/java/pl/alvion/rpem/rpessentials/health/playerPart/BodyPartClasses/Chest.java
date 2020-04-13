package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses;

import org.bukkit.attribute.Attribute;
import pl.alvion.rpem.rpessentials.generalutils.generalclasses.TempAttribute;
import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public class Chest extends PlayerBodyPart implements InfectableBodyPart, BleedableBodyPart {

    private TempAttribute slow = new TempAttribute(getPlayer(), Attribute.GENERIC_MOVEMENT_SPEED);
    private TempAttribute attack = new TempAttribute(getPlayer(), Attribute.GENERIC_ATTACK_DAMAGE);
    private TempAttribute health = new TempAttribute(getPlayer(), Attribute.GENERIC_ATTACK_SPEED);

    public Chest(RPPlayer rpPlayer) {
        super(rpPlayer);
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
        slow.attributeAdd(-0.01*strength);
        health.attributeAdd(-2*strength);

    }

    @Override
    public void onInfectStage2(double strength) {
        slow.attributeAdd(-0.10*strength);
        health.attributeAdd(-5*strength);

    }

    @Override
    public void onInfectStage3(double strength) {
        slow.attributeAdd(-0.12*strength);
        health.attributeAdd(-2*strength);
        attack.attributeAdd(-1*strength);

    }

    @Override
    public void onInfectStage4(double strength) {
        getPlayer().damage(9999);

    }

    @Override
    public void removePart() {
        getPlayer().damage(9999);
    }

    @Override
    public BodyPart bodyPart() {
        return BodyPart.Chest;
    }

    @Override
    public int BodyPartComplexity() {
        return 7;
    }

    @Override
    public ArrayList<BodyPartInjury> incapableInjuries() {
        return null;
    }
}
