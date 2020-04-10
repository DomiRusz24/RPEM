package pl.alvion.rpem.rpessentials.health.playerPart;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

public abstract class PlayerOrganInjury {
    private PlayerOrgan Organ;
    private RPPlayer rpPlayer;
    private int intensity;

    public PlayerOrganInjury(PlayerOrgan part, int Intensity) {
        this.Organ = part;
        this.rpPlayer = getOrgan().getRpPlayer();
        this.intensity = Intensity;
        this.Organ.getInjuries().add(this);
        run(rpPlayer, intensity * part.OrganImportance());
    }

    public PlayerOrgan getOrgan() {
        return Organ;
    }

    public int getIntensity() {
        return intensity;
    } // Mnoznik obrazen, czasu trwania itd.

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    public boolean infect() {
        if(infectSeverity() != 0) {
            this.Organ.infectOrgan(infectSeverity() * Organ.OrganImportance());
            return true;
        }
        return false;
    }

    abstract public Material getMaterialType(); // Ikonka na GUI
    abstract public void run(RPPlayer rpPlayer, int intensity); // Efekty urazy
    abstract public int regenerationTimeMax(); // Maksymalny czas wyzdrowienia
    abstract public int healingLevelMin(); // Minimalny level leczenia
    public abstract double infectSeverity(); // Ustaw 0 jezeli nie moze infekowac. Sila Skala od 0.1 - 1
    public abstract double infectChance(); // Ustaw 0 jezeli nie moze infekowac. Szansa skala od 0.1 - 10
}
