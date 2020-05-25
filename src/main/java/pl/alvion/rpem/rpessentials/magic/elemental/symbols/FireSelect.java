package pl.alvion.rpem.rpessentials.magic.elemental.symbols;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.*;

import java.util.ArrayList;
import java.util.Arrays;

public class FireSelect extends RuneSymbol {
    @Override
    public void activate(Player player, Location middle) {
        Element.selectElement(player, Element.FIRE);
        ArrayList<ParticleRay> particleRays = RuneTable.getPlayerTable(player).getRays();
        RunePoint[] runePoints = RuneTable.getPlayerTable(player).runePoints;
        for (ParticleRay particleRay : particleRays) {
            particleRay.changeColor(Color.RED);
            particleRay.createRay(1, 20, 0.01);
            Element.playElementSound(player, Element.FIRE, 0.5f, 1, 5, 4);
        }
        for (RunePoint runePoint : runePoints) {
            player.spawnParticle(Particle.REDSTONE, runePoint.location, 0, 0.0001, 1, 1, 1, new Particle.DustOptions(Color.RED, 0.5f));

        }


    }

    @Override
    public ArrayList<Integer> moves() {
        return new ArrayList<>(Arrays.asList(44,29,29,10,10,33,33,46,38,30,30,24,24,32,32,38,31,31));
    }
}
