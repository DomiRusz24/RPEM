package pl.alvion.rpem.rpessentials.health.playerPart;

import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public abstract class PlayerBodyInjury {
    public static ArrayList<PlayerBodyInjury> PlayerBodyInjuries = new ArrayList<>();
    private PlayerBodyPart bodyPart;
    private RPPlayer rpPlayer;
    private int intensity;

    public PlayerBodyInjury(PlayerBodyPart part, int Intensity) {
        this.bodyPart = part;
        this.rpPlayer = getBodyPart().getRpPlayer();
        this.intensity = Intensity;
        PlayerBodyInjury.PlayerBodyInjuries.add(this);
    }

    public PlayerBodyPart getBodyPart() {
        return bodyPart;
    }

    public int getIntensity() {
        return intensity;
    }

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }

    abstract public ItemStack getIcon();
    abstract public void run(RPPlayer rpPlayer);
    abstract public int regenerationTimeMax();
    abstract public int healingLevelMin();


}
