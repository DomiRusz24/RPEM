package pl.alvion.rpem.rpessentials.health.playerPart.BodyPartInjuriesClass;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.health.playerPart.Interfaces.InfectableInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyInjury;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

public class Scratch extends PlayerBodyInjury implements InfectableInjury {


    public Scratch(PlayerBodyPart part, int Intensity) {
        super(part, Intensity);
    }

    @Override
    public Material getMaterial() {
        return Material.FLINT;
    }

    @Override
    public void run(RPPlayer rpPlayer, double intensity) {

    }


    @Override
    public int regenerationTimeMax() {
        return 0;
    }

    @Override
    public int healingLevelMin() {
        return 0;
    }


    @Override
    public double infectSeverity() {
        return 0;
    }

    @Override
    public double infectChance() {
        return 0;
    }
}
