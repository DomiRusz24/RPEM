package pl.alvion.rpem.rpessentials.health_dr.playerPart;

import pl.alvion.rpem.rpessentials.health_dr.enums.InfectionStage;
import pl.alvion.rpem.rpessentials.health_dr.enums.Organ;
import pl.alvion.rpem.rpessentials.health_dr.enums.OrganInjury;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.Amputable;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.OrganClasses.Brain;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.OrganInjuryClasses.Inefficient;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;

import java.util.ArrayList;

public abstract class PlayerOrgan {

    public static PlayerOrgan addPlayerOrgan(RPPlayer rpPlayer, Organ organ) {
        switch (organ) {
            case Brain:

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
    } // Dodaj wartosc do wylewu krwi.

    public boolean stopBleeding() {
        if(this instanceof BleedableBodyPart && bleedIntensity != 0) {
            this.bleedIntensity = 0;
            return true;
        }
        return false;
    } // Zresetuj krew.

    private boolean removed = false;

    public boolean isRemoved() {
        return removed;
    }
    public abstract void removePart();

    public boolean isAmputated() {
        return amputated;
    }

    private boolean amputated = false;

    public boolean amputate() {
        if(this instanceof Amputable) {
            ((Amputable) this).onAmputate();
            amputated = true;
            return true;
        }
        return false;
    } // Amputuj ta czesc.

    public ArrayList<PlayerOrganInjury> getInjuries() {
        return injuries;
    }

    public boolean infectOrgan(double value, InfectionStage stage) {
        if(this instanceof InfectableBodyPart) {
            switch (stage) {
                case Low:
                    ((InfectableBodyPart) this).onInfectStage1(value);
                    break;
                case Medium:
                    ((InfectableBodyPart) this).onInfectStage2(value);
                    break;
                case High:
                    ((InfectableBodyPart) this).onInfectStage3(value);
                    break;
                case Highest:
                    ((InfectableBodyPart) this).onInfectStage4(value);
                    break;
            }
        }
        return false;
    } // Infektuj organ.

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
