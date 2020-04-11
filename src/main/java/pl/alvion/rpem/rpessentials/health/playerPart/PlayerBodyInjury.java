package pl.alvion.rpem.rpessentials.health.playerPart;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public abstract class PlayerBodyInjury {
    private PlayerBodyPart bodyPart;
    private RPPlayer rpPlayer;
    private double intensity;

    public PlayerBodyInjury(PlayerBodyPart part, int Intensity) {
        this.bodyPart = part;
        this.rpPlayer = getBodyPart().getRpPlayer();
        this.intensity = Intensity;
        this.bodyPart.getInjuries().add(this);
        run(rpPlayer, intensity * part.BodyPartComplexity() * 0.1);
    }

    public PlayerBodyPart getBodyPart() {
        return bodyPart;
    }

    public double getIntensity() {
        return intensity;
    } // Mnoznik obrazen, czasu trwania itd.

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public boolean infect() {
        if(this instanceof InfectableBodyPart) {
            this.bodyPart.infectPart(((InfectableBodyPart) this).infectSeverity() * bodyPart.BodyPartComplexity() * 0.1);
            return true;
        }
        return false;
    }

    abstract public Material getMaterial(); // Ikonka na GUI
    abstract public void run(RPPlayer rpPlayer, double intensity); // Efekty urazy
    abstract public int regenerationTimeMax(); // Maksymalny czas wyzdrowienia
    abstract public int healingLevelMin(); // Minimalny level leczenia


}
