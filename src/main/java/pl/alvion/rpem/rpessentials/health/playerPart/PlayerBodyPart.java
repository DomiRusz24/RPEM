package pl.alvion.rpem.rpessentials.health.playerPart;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.BodyPartClasses.LeftArm;
import pl.alvion.rpem.rpessentials.health.playerPart.BodyPartInjuriesClass.Scratch;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public abstract class PlayerBodyPart {

    public static PlayerBodyPart addPlayerBodyPart(RPPlayer rpPlayer, BodyPart part) { // Tworzysz klase z playerem.
        switch (part) {
            case LeftArm:
                return new LeftArm(rpPlayer);
            case RightArm:

                break;
            case LeftLeg:

                break;
            case RightLeg:

                break;
            case LeftHand:

                break;
            case RightHand:

                break;
            case LeftFoot:

                break;
            case RightFoot:

                break;
            case Chest:

                break;
            case Head:

                break;
            case Neck:

                break;
            case LeftEye:

                break;
            case RightEye:

                break;
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
        if (canBleed()) {
            bleedIntensity = bleedIntensity + value;
        }
        return false;
    }

    public boolean stopBleeding() {
        if(canBleed() && bleedIntensity != 0) {
            this.bleedIntensity = 0;
            return true;
        }
        return false;
    }

    public boolean infectPart(double value) {
        if(canBeInfected()) {
            onInfect(value);
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

    abstract public boolean canBleed(); // Czy moze krwawic
    abstract public boolean canBeInfected(); // Czy moze zostaw zainfekowany
    abstract public void onInfect(double value); // Kiedy gracz zostanie zainfekowany
    abstract public BodyPart bodyPart(); // Jaka czesc ciala
    abstract public int BodyPartComplexity(); // Trudnosc wyleczenia tego czlonku (1 - 10)
    abstract public int BodyPartImportance(); // Jak wazny jest ten czlonek (jak bedzie infekcja/uraza to mnozy przez ta liczbe) 0.1 - 1
    abstract public ArrayList<BodyPartInjury> incapableInjuries(); // Jakie urazy nie moze dostac.
}
