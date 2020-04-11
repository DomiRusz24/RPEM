package pl.alvion.rpem.rpessentials.health.playerPart;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses.*;
import pl.alvion.rpem.rpessentials.health.playerPart.BodyPartInjuriesClass.Scratch;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.Amputable;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public abstract class PlayerBodyPart {

    public static PlayerBodyPart addPlayerBodyPart(RPPlayer rpPlayer, BodyPart part) { // Tworzysz klase z playerem.
        switch (part) {
            case LeftArm:
                return new LeftArm(rpPlayer);
            case RightArm:
                return new RightArm(rpPlayer);
            case LeftLeg:
                return new LeftLeg(rpPlayer);
            case RightLeg:
                return new RightLeg(rpPlayer);
            case LeftHand:
                return new LeftHand(rpPlayer);
            case RightHand:
                return new RightHand(rpPlayer);
            case LeftFoot:
                return new LeftFoot(rpPlayer);
            case RightFoot:
                return new RightFoot(rpPlayer);
            case Chest:
                return new Chest(rpPlayer);
            case Head:
                return new Head(rpPlayer);
            case Neck:
                return new Neck(rpPlayer);
            case LeftEye:
                return new LeftEye(rpPlayer);
            case RightEye:
                return new RightEye(rpPlayer);
        }
        return null;
    }

    private RPPlayer rpPlayer;
    public ArrayList<PlayerBodyInjury> injuries = new ArrayList<>();
    private int bleedIntensity = 0;

    public PlayerBodyPart(RPPlayer rpPlayer) {
        this.rpPlayer = rpPlayer;
        rpPlayer.getPlayerHealthStatus().getPlayerBodyParts().add(this);

    }

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public BodyPart getBodyPart() {
        return bodyPart();
    }

    public boolean increaseBleedIntensity(int value) {
        if (this instanceof BleedableBodyPart) {
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

    private boolean amputated = false;

    public boolean isAmputated() {
        return amputated;
    }

    public boolean amputate() {
        if(this instanceof Amputable) {
            ((Amputable) this).onAmputate();
            amputated = true;
            return true;
        }
        return false;
    }

    public boolean infectPart(double value) {
        if(this instanceof InfectableBodyPart) {
            ((InfectableBodyPart) this).onInfect(value);
        }
        return false;
    }

    public ArrayList<PlayerBodyInjury> getInjuries() {
        return injuries;
    }

    public boolean addInjury(BodyPartInjury injury, int intensity, int input1, int input2) {
        if(incapableInjuries().contains(injury)) {
            return false;
        }
        switch (injury) {
            case Scratch:
                new Scratch(this, intensity);
                break;
            case Scar:

                break;
            case Bruise:

                break;
            case Bleed:

                break;
            case Infection:

                break;
            case Broken:

                break;
            case Amputation:

                break;
            case Wound:

                break;
            case Burn:

                break;
            case Inefficient:

                break;
        }
        return false;
    } // Rozne urazy moga miec dodatkowe inputy
    public boolean addInjury(BodyPartInjury injury, int intensity, int input1) {
        if(incapableInjuries().contains(injury)) {
            return false;
        }
        switch (injury) {
            case Scratch:
                new Scratch(this, intensity);
                break;
            case Scar:

                break;
            case Bruise:

                break;
            case Bleed:

                break;
            case Infection:

                break;
            case Broken:

                break;
            case Amputation:

                break;
            case Wound:

                break;
            case Burn:

                break;
            case Inefficient:

                break;
        }
        return false;
    } // Rozne urazy moga miec dodatkowe inputy
    public boolean addInjury(BodyPartInjury injury, int intensity) {
        if(incapableInjuries().contains(injury)) {
            return false;
        }
        switch (injury) {
            case Scratch:
                new Scratch(this, intensity);
                break;
            case Scar:

                break;
            case Bruise:

                break;
            case Bleed:

                break;
            case Infection:

                break;
            case Broken:

                break;
            case Amputation:

                break;
            case Wound:

                break;
            case Burn:

                break;
            case Inefficient:

                break;
        }
        return false;
    } // Po prostu tworzysz klase z uraza lub cos jeszcze dodatkowo.


    abstract public BodyPart bodyPart(); // Jaka czesc ciala
    abstract public int BodyPartComplexity(); // Trudnosc wyleczenia tego czlonku (1 - 10)
    abstract public ArrayList<BodyPartInjury> incapableInjuries(); // Jakie urazy nie moze dostac.
}
