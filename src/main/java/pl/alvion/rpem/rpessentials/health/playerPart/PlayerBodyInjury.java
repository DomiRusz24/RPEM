package pl.alvion.rpem.rpessentials.health.playerPart;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public abstract class PlayerBodyInjury {
    private PlayerBodyPart bodyPart;
    private RPPlayer rpPlayer;
    private int intensity;

    public PlayerBodyInjury(PlayerBodyPart part, int Intensity) {
        this.bodyPart = part;
        this.rpPlayer = getBodyPart().getRpPlayer();
        this.intensity = Intensity;
        this.bodyPart.getInjuries().add(this);
        run(rpPlayer, intensity * part.BodyPartImportance());
    }

    public PlayerBodyPart getBodyPart() {
        return bodyPart;
    }

    public int getIntensity() {
        return intensity;
    } // Mnoznik obrazen, czasu trwania itd.

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public boolean infect() {
        if(infectSeverity() != 0) {
            this.bodyPart.infectPart(infectSeverity() * bodyPart.BodyPartImportance());
            return true;
        }
        return false;
    }

    abstract public Material getMaterial(); // Ikonka na GUI
    abstract public void run(RPPlayer rpPlayer, int intensity); // Efekty urazy
    abstract public int regenerationTimeMax(); // Maksymalny czas wyzdrowienia
    abstract public int healingLevelMin(); // Minimalny level leczenia
    public abstract double infectSeverity(); // Ustaw 0 jezeli nie moze infekowac. Sila Skala od 0.1 - 1
    public abstract double infectChance(); // Ustaw 0 jezeli nie moze infekowac. Szansa skala od 0.1 - 10


}
