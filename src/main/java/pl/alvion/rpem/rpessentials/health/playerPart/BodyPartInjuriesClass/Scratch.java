package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartInjuriesClass;

import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

public class Scratch extends PlayerBodyInjury {

    public Scratch(PlayerBodyPart part, int intensity) {
        super(part, intensity);
    }


    @Override
    public ItemStack getIcon() {
        return null;
    }

    @Override
    public void run(RPPlayer rpPlayer) {

    }

    @Override
    public int regenerationTimeMax() {
        return 0;
    }

    @Override
    public int healingLevelMin() {
        return 0;
    }
}
