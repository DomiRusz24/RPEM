package pl.alvion.rpem.rpessentials.health_dr.playerPart;

import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.health_dr.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health_dr.enums.BodyPartInjury;
import pl.alvion.rpem.rpessentials.health_dr.enums.InfectionStage;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.BodyPartClasses.*;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.BodyPartInjuriesClass.Scratch;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.Amputable;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.BleedableBodyPart;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;

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
    private Player player;
    public ArrayList<PlayerBodyInjury> injuries = new ArrayList<>();
    private double PartEfficiency = 100;
    private int bleedIntensity = 0;

    public PlayerBodyPart(RPPlayer rpPlayer) {
        this.rpPlayer = rpPlayer;
        this.player = rpPlayer.getPlayer();
        rpPlayer.getPlayerHealthStatus().getPlayerBodyParts().add(this);

    }

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public BodyPart getBodyPart() {
        return bodyPart();
    }

    public Player getPlayer() {
        return player;
    }

    public int getBleedIntensity() {
        return bleedIntensity;
    }

    public double getPartEfficiency() {
        return PartEfficiency;
    }

    public boolean increaseBleedIntensity(int value) {
        if (this instanceof BleedableBodyPart && !amputated) {
            bleedIntensity = bleedIntensity + value;
        }
        return false;
    } // dodaj ilosc do krwawienia

    public boolean stopBleeding() {
        if(this instanceof BleedableBodyPart && bleedIntensity != 0) {
            this.bleedIntensity = 0;
            return true;
        }
        return false;
    } // Resetuj krwawienie

    private boolean amputated = false;

    private void removePart() {
        this.PartEfficiency = 0;
        for (PlayerBodyInjury injury : new ArrayList<>(this.injuries)) {
            this.injuries.remove(injury);
        }
    }

    public boolean isAmputated() {
        return amputated;
    }

    public boolean amputate() {
        if(this instanceof Amputable) {
            ((Amputable) this).onAmputate();
            removePart();
            amputated = true;
            return true;
        }
        return false;
    } // Amputuj ta czesc.

    public boolean infectPart(double value, InfectionStage stage) {
        if(this instanceof InfectableBodyPart && !amputated) {
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
    } // Infekuj ta czesc.

    public ArrayList<PlayerBodyInjury> getInjuries() {
        return injuries;
    }

    public void lowerEfficiency(int value) {
        this.PartEfficiency -= value;
        if (PartEfficiency < 0 ) {
            PartEfficiency = 0;
        }
        refreshEfficiency(this.getPartEfficiency());
    }

    public void raiseEfficiency(int value, boolean upgrade) {
        this.PartEfficiency += value;
        if (PartEfficiency > 100 && !upgrade) {
            PartEfficiency = 100;
        }
        refreshEfficiency(this.getPartEfficiency());
    }

    public boolean addInjury(BodyPartInjury injury, int intensity, int input1, int input2) {
        if(incapableInjuries().contains(injury) && !amputated) {
            return false;
        }
        switch (injury) {
            case Scratch:

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
        if(incapableInjuries().contains(injury) && !amputated) {
            return false;
        }
        switch (injury) {
            case Scratch:

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
        if(incapableInjuries().contains(injury) && !amputated) {
            return false;
        }
        switch (injury) {
            case Scratch:

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
    abstract public void refreshEfficiency(double efficiency); // Co to ten czlonek robi.
    abstract public int BodyPartComplexity(); // Trudnosc wyleczenia tego czlonku (1 - 10)
    abstract public ArrayList<BodyPartInjury> incapableInjuries(); // Jakie urazy nie moze dostac.
}
