package pl.alvion.rpem.rpessentials.health.playerPart;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.health.enums.InfectionStage;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableInjury;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

public abstract class PlayerOrganInjury {
    private PlayerOrgan Organ;
    private RPPlayer rpPlayer;
    private double intensity;

    public PlayerOrganInjury(PlayerOrgan part, int Intensity) {
        this.Organ = part;
        this.rpPlayer = getOrgan().getRpPlayer();
        this.intensity = Intensity;
        this.Organ.getInjuries().add(this);
        run(rpPlayer, intensity * part.OrganComplexity() * 0.1);
    }

    public PlayerOrgan getOrgan() {
        return Organ;
    }

    public double getIntensity() {
        return intensity;
    } // Mnoznik obrazen, czasu trwania itd.

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public boolean infect(InfectionStage stage) {
        if(this.Organ instanceof InfectableBodyPart && this instanceof InfectableInjury) {
            this.Organ.infectOrgan(((InfectableInjury) this).infectSeverity() * ((InfectableBodyPart) this.Organ).infectSeverity(), stage);
            return true;
        }
        return false;
    } // Infektuj ta czesc ciala gdzie jest ta uraza.

    abstract public Material getMaterialType(); // Ikonka na GUI
    abstract public void run(RPPlayer rpPlayer, double intensity); // Efekty urazy
    abstract public int regenerationTimeMax(); // Maksymalny czas wyzdrowienia
    abstract public int healingLevelMin(); // Minimalny level leczenia
}
