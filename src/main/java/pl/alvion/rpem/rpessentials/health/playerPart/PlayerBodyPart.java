package pl.alvion.rpem.rpessentials.health.playerPart;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.BodyPartInjuriesClass.Scratch;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public abstract class PlayerBodyPart {

    private RPPlayer rpPlayer;
    public ArrayList<PlayerBodyInjury> injuries = new ArrayList<>();

    public PlayerBodyPart(RPPlayer rpPlayer) {
        this.rpPlayer = rpPlayer;

    }

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public BodyPart getBodyPart() {
        return bodyPart();
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
    }
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
    }
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
    }

    abstract public BodyPart bodyPart();
    abstract public int BodyPartComplexity();
    abstract public ArrayList<BodyPartInjury> incapableInjuries();
}
