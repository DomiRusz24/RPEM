package pl.alvion.rpem.rpessentials.health.playerPart;

import pl.alvion.rpem.rpessentials.health.enums.Organ;
import pl.alvion.rpem.rpessentials.health.enums.OrganInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.OrganClasses.Brain;
import pl.alvion.rpem.rpessentials.health.playerPart.OrganInjuryClasses.Inefficient;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public abstract class PlayerOrgan {

    public static PlayerOrgan addPlayerOrgan(RPPlayer rpPlayer, Organ organ) {
        switch (organ) {
            case Brain:
                return new Brain(rpPlayer);
            case Heart:

                break;
            case Lungs:

                break;
            case Stomach:

                break;
        }
        return null;
    }

    private RPPlayer rpPlayer;
    public ArrayList<PlayerOrganInjury> injuries = new ArrayList<>();
    private int bleedIntensity = 0;

    public PlayerOrgan(RPPlayer rpPlayer) {
        this.rpPlayer = rpPlayer;
        rpPlayer.getPlayerHealthStatus().getPlayerOrgans().add(this);

    }

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public Organ getOrgan() {
        return Organ();
    }

    public boolean increaseBleedIntensity(int value) {
        if (this instanceof BleedableBodyPart ) {
            bleedIntensity = bleedIntensity + value;
        }
        return false;
    }

    public boolean stopBleeding() {
        if(this instanceof BleedableBodyPart && bleedIntensity != 0) {
            this.bleedIntensity = 0;
            return true;
        }
        return false;
    }

    public ArrayList<PlayerOrganInjury> getInjuries() {
        return injuries;
    }

    public boolean infectOrgan(double value) {
        if(this instanceof InfectableBodyPart) {
            ((InfectableBodyPart) this).onInfect(value);
        }
        return false;
    }

    public boolean addInjury(OrganInjury injury, int intensity, int input1, int input2) {
        if(incapableInjuries().contains(injury)) {
            return false;
        }
        switch (injury) {
            case TotalFailure:
                break;
            case InternalBleed:

                break;
            case RippedOut:

                break;
            case Inefficient:
                new Inefficient(this, intensity);
                break;
        }
        return false;
    } // Rozne urazy moga miec dodatkowe inputy
    public boolean addInjury(OrganInjury injury, int intensity, int input1) {
        if(incapableInjuries().contains(injury)) {
            return false;
        }
        switch (injury) {
            case TotalFailure:

                break;
            case InternalBleed:

                break;
            case RippedOut:

                break;
            case Inefficient:

                break;
        }
        return false;
    } // Rozne urazy moga miec dodatkowe inputy
    public boolean addInjury(OrganInjury injury, int intensity) {
        if(incapableInjuries().contains(injury)) {
            return false;
        }
        switch (injury) {
            case TotalFailure:

                break;
            case InternalBleed:

                break;
            case RippedOut:

                break;
            case Inefficient:

                break;
        }
        return false;
    } // Po prostu tworzysz klase z uraza lub cos jeszcze dodatkowo.

    abstract public Organ Organ(); // Jaki organ.
    abstract public int OrganComplexity(); // Trudnosc wyleczenia tego organu (1 - 10)
    abstract public ArrayList<OrganInjury> incapableInjuries(); // Jakie urazy nie moze dostac.
}
