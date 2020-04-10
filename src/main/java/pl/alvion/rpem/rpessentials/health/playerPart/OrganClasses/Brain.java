package pl.alvion.rpem.rpessentials.health.playerPart.OrganClasses;

import pl.alvion.rpem.rpessentials.health.enums.Organ;
import pl.alvion.rpem.rpessentials.health.enums.OrganInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerOrgan;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public class Brain extends PlayerOrgan {
    public Brain(RPPlayer rpPlayer) {
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
    public Organ Organ() {
        return Organ.Brain;
    }

    @Override
    public int OrganComplexity() {
        return 0;
    }

    @Override
    public int OrganImportance() {
        return 0;
    }

    @Override
    public ArrayList<OrganInjury> incapableInjuries() {
        return null;
    }
}
