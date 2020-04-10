package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public class LeftArm extends PlayerBodyPart {


    public LeftArm(RPPlayer rpPlayer) {
        super(rpPlayer);
    }

    @Override
    public boolean canBleed() {
        return false;
    }

    @Override
    public boolean canBeInfected() {
        return false;
    }

    @Override
    public void onInfect(double value) {

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
    public int BodyPartImportance() {
        return 0;
    }

    @Override
    public ArrayList<BodyPartInjury> incapableInjuries() {
        return null;
    }
}
